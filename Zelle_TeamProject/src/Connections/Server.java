package Connections;

import ClientTransactions.ClientAcct;
import ClientTransactions.IndividualAcct;
import ClientTransactions.Transaction;

import javax.crypto.Cipher;
import java.sql.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Connections.Server class which will be used to talk to clients and query
 */
public class Server {


    /**
     * Instance variable server is a serverSocket
     */
    private ServerSocket server;
    /**
     * Instance variable executor is a ExecutorService which will handle running all client
     */
    private ExecutorService exector;

    /**
     * Instance variable clientHandlers is an array of clients to manage
     */
    private ClientHandler[] clientHandlers;

    /**
     * Instance variable numberOfHandlers keeps track of the number of active threads
     */
    private int numberOfHandlers = 0;

    private int counter = 0;


    public Server(){
        clientHandlers = new ClientHandler[100];
        exector = Executors.newFixedThreadPool(100);
    }


    public void runServer() {

        try {
            server = new ServerSocket(23557, 100);
            //serverSocket has been created to do stuff
            while (true) { //while server is live handel all clients
                try {
                    clientHandlers[counter] = new ClientHandler();
                    clientHandlers[counter].waitForConnection();
                    numberOfHandlers++;
                    exector.execute(clientHandlers[counter]);
                   // System.out.println("Connected"+clientHandlers[counter].alive);

                }//end try
                catch (EOFException eofException) {
                    //server terminated print out all current info that might not have been saved
                    //to the data bases
                }//end catch
                finally {
                    ++counter;
                } //end finally
            } //end while
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } //end catch
    } // end method runServer


    private class ClientHandler implements Runnable {

        private ObjectOutputStream output; // output stream to client
        private ObjectInputStream input; // input stream from client
        private Socket connection; // connection to client
        private Connection dataBaseConnection;
        private final String DATABASE_URL = "jdbc:mysql://s-l112.engr.uiowa.edu:3306/engr_class007";
        private final String DATABASE_PASSWORD = "1234";
        private final String DATABASE_USERNAME = "engr_class007";
        private boolean alive = false;


        @Override
        public void run() {
            //first thing i should do is connect to the data base
            try {
                //SELECT columnName FROM yourTable WHERE CONTAINS (columnName, ‘yourSubstring’);
                dataBaseConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);


                try {
                    alive = true;
                    try {
                        getStreams();
                        processConnection();
                        numberOfHandlers--;
                    } catch (EOFException eofException) {
                        ///do something
                    } finally {
                        //close the connection
                    } //end catch
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * Function {@code waitForConnection()} waits for a connection to arrive
         *
         * @throws IOException idk why this is here tbh
         */
        private void waitForConnection() throws IOException {
            connection = server.accept(); /// allows server to accept connection
            System.out.println("Connected server thread");
        }

        /**
         * @throws IOException
         */
        private void getStreams() throws IOException {
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();

            input = new ObjectInputStream(connection.getInputStream());

        } //ends getStreams


        private void processConnection() throws IOException {
            boolean Terminate = false;
            Packet information;
            do{
                try {
                    information = (Packet) input.readObject();
                    //check the type some way of know if there needs to be a query
                    try {
                        //figure out what the request is first thing to check would be if they are logging on
                        if(information.getType().equals("Terminate")){
                            Terminate = true;
                        }else if(information.getType().equals("loginInfo")){
                            LoginInfo loginInfo = information.getContents(LoginInfo.class);
//                            Statement statement = dataBaseConnection.createStatement();
//                            ResultSet re = statement.executeQuery("SELECT * FROM `userAccounts`");
//                            while(re.next()){System.out.println(re.getString("userName")+re.getString("passWord"));}
//                           // LoginInfo loginInfo = information.getContents(LoginInfo.class);
                            //TODO see if it is a change password request
                            if(!loginInfo.isChangePassWord()) {
                                ///query for matching login info
                                String loginMatch = "SELECT userName FROM userDataBase where userName=?";
                                PreparedStatement loginMatchPS = dataBaseConnection.prepareStatement(loginMatch);
                                loginMatchPS.setString(1, loginInfo.getUserName()); ///should give the the username
                                ResultSet loginUserSet = loginMatchPS.executeQuery();
                                //update the data base


                                if (loginUserSet.next()) {
                                    //The User exists now check the password
                                    String passWordMatch = "SELECT userName,passWord FROM userDataBase where userName=? and passWord=?";
                                    PreparedStatement loginMatchUserPass = dataBaseConnection.prepareStatement(passWordMatch);
                                    loginMatchUserPass.setString(1, loginInfo.getUserName());
                                    loginMatchUserPass.setString(2, loginInfo.getPassWord());
                                    ResultSet loginUserPassSet = loginMatchUserPass.executeQuery();
                                    String userName = "";
                                    String passWord = "";
                                    String firstName = "";
                                    String lastName = "";
                                    String companyName = "";
                                    double balance = 0.0;
                                    if (loginUserPassSet.next()) {
                                        userName = loginUserPassSet.getString("userName");
                                        passWord = loginUserPassSet.getString("passWord");
                                    }
                                    if (userName.equals(loginInfo.getUserName()) && passWord.equals(loginInfo.getPassWord())) {
                                        System.out.println("UserName and password matches");
//                                        userName = "";
//                                        passWord = "";
                                        //TODO this is where i need to querey the data base for the account info
                                        String clientAcctQ = "SELECT userName,firstName,lastName,companyName,balance FROM userDataBase where userName=?";
                                        PreparedStatement clientStatement = dataBaseConnection.prepareStatement(clientAcctQ);
                                        clientStatement.setString(1,loginInfo.getUserName());
                                        ResultSet resultSet = clientStatement.executeQuery();
                                        String tran = "SELECT * FROM TransactionTable";
                                        PreparedStatement alltransFirst = dataBaseConnection.prepareStatement(tran);
                                        if(resultSet.next()){
                                            firstName = resultSet.getString("firstName");
                                            lastName = resultSet.getString("lastName");
                                            companyName = resultSet.getString("companyName");
                                            balance = resultSet.getDouble("balance");
                                        }
                                        IndividualAcct clientAcct = new IndividualAcct(firstName,lastName,userName,passWord,balance);
                                        clientAcct.clearTransaction();
                                        ResultSet allTranResultFirst = alltransFirst.executeQuery();
                                        while(allTranResultFirst.next()){
                                            clientAcct.addTransaction(new Transaction(allTranResultFirst.getDouble("amount"), allTranResultFirst.getString("comment"), allTranResultFirst.getString("sender"), allTranResultFirst.getString("receiver"), allTranResultFirst.getBoolean("visibility")));
                                        }
                                        Packet packet = new Packet(clientAcct,"loginInfo");
                                        sendData(packet);
                                        //sendData(clientPack);
                                        //query account information
                                    } else {
                                        System.out.println("Password incorrect");
                                        System.out.println(userName);
                                        System.out.println(passWord);
                                        Packet FlagPacket = new Packet(new Flag("Password or Username incorrect"), "Flag");
                                        sendData(FlagPacket);
                                        //TODO send packet containing issue flag PassWord is incorrect
                                    }
                                } else {
                                    System.out.println("User name does not match");
                                    //TODO Send packet containing issue flag UserName or PassWord is incorrect
                                    Packet FlagPacket = new Packet(new Flag("No account"), "Flag");
                                    sendData(FlagPacket);
                                }
                            }else{

                                String updatePassWordQuery = "UPDATE userDataBase SET passWord=? WHERE userName=?";
                                PreparedStatement updatePassPS = dataBaseConnection.prepareStatement(updatePassWordQuery);
                                updatePassPS.setString(1,loginInfo.getPassWordChange());
                                updatePassPS.setString(2,loginInfo.getUserName());
                                updatePassPS.executeUpdate();

                                String clientAcctQd = "SELECT userName,firstName,lastName,companyName,balance FROM userDataBase where userName=?";
                                PreparedStatement clientStatementd = dataBaseConnection.prepareStatement(clientAcctQd);
                                clientStatementd.setString(1,loginInfo.getUserName());
                                ResultSet resultSetd = clientStatementd.executeQuery();
                                String firstName1="";String lastName1="";String companyName1="";double balance1=0.0;
                                if(resultSetd.next()){
                                    firstName1 = resultSetd.getString("firstName");
                                    lastName1 = resultSetd.getString("lastName");
                                    companyName1 = resultSetd.getString("companyName");
                                    balance1 = resultSetd.getDouble("balance");
                                }
                                IndividualAcct clientAcct = new IndividualAcct(firstName1,lastName1,loginInfo.getUserName(),loginInfo.getPassWordChange(),balance1);
                                Packet packet = new Packet(clientAcct,"loginInfo");





                            }

                            // the mysql insert statement
//                            String query = " insert into userAccounts (userID, userName,passWord,balance)"
//                                    + " values (?, ?, ?, ?)";
//
//                            // create the mysql insert preparedstatement
//                            PreparedStatement preparedStmt = dataBaseConnection.prepareStatement(query);
//                            preparedStmt.setInt (1,2 );
//                            preparedStmt.setString (2, loginInfo.getUserName());
//                            preparedStmt.setString   (3, loginInfo.getPassWord());
//                            preparedStmt.setDouble(4, 0);
//
//                            preparedStmt.execute();
                        }else if(information.getType().equals("createIndividualAccount")){
                            //make IndividualAccount
                            IndividualAcct account = information.getContents(IndividualAcct.class);
                            //TODO things to check for
                            //userName is different and unique... well that all ig

                            String userNameMatch = "SELECT userName FROM userDataBase where userName=?";
                            PreparedStatement loginMatch = dataBaseConnection.prepareStatement(userNameMatch);
                            loginMatch.setString(1,account.getUsername());
                            ResultSet resultSet = loginMatch.executeQuery();

                            if(resultSet.next()){
                                System.out.println("UserName taken");
                                //this means the username is already in the data base send flag
                                Flag flag = new Flag("UserName Already taken");
                                Packet packet = new Packet(flag,"Flag");
                                sendData(packet);//sent info to client to do stuff with it
                            }else{
                                // the mysql insert statement
                            String query = " insert into userDataBase (userName,passWord,firstName,lastName,companyName,balance)"
                                    + " values ( ?, ?, ?, ?, ?, ?)";

                            // create the mysql insert preparedstatement
                            PreparedStatement preparedStmt = dataBaseConnection.prepareStatement(query);
                            preparedStmt.setString(1,account.getUsername());
                            preparedStmt.setString (2, account.getPassword());
                            preparedStmt.setString  (3, account.getFirstName());
                            preparedStmt.setString(4,account.getLastName());
                            preparedStmt.setString(5,"NULL");
                            preparedStmt.setDouble(6, account.getBalance());

                            preparedStmt.execute();
                            Packet newPacket = new Packet(null,"accountCreated");
                            sendData(newPacket);
                            }


                            //send a flag or client created accountCreated

                        } else if(information.getType().equals("payTran")){
                            //this is the user wants to pay someone
                            Transaction transaction = information.getContents(Transaction.class);
                            String personSendingTo = transaction.getReceiver();
                            String personSending = transaction.getSender();
                            String userNameMatch = "SELECT userName FROM userDataBase where userName=?";
                            PreparedStatement loginMatch = dataBaseConnection.prepareStatement(userNameMatch);
                            loginMatch.setString(1,personSendingTo);
                            ResultSet resultSet = loginMatch.executeQuery();

                            //if that person exists then i want to update the data base
                            if(!resultSet.next()){ // if that person doesn't exist flag
                                Flag flag = new Flag("Person with userName: "+personSendingTo+" does not exist");
                                Packet packet = new Packet(flag,"Flag");
                                sendData(packet);
                            }else{
                                //now query the sender
                                String senderInfoQuery = "SELECT userName,balance FROM userDataBase where userName=?";
                                PreparedStatement senderInfoPS = dataBaseConnection.prepareStatement(senderInfoQuery);
                                senderInfoPS.setString(1,personSending);
                                ResultSet personSenderResultSet = senderInfoPS.executeQuery();
                                if(personSenderResultSet.next()){
                                    double balance = personSenderResultSet.getDouble("balance");
                                    if(transaction.getAmount()>balance){//not enough money
                                        Flag flag = new Flag("Insufficient funds");
                                        Packet packet = new Packet(flag,"Flag");
                                        sendData(packet);
                                    }else{ //money can be payed because person exist and person has sufficent money
                                        double newbalance = balance - transaction.getAmount();
                                        String updateBalanceQuery = "UPDATE userDataBase SET balance=? WHERE userName=?";
                                        PreparedStatement updateBalancePS = dataBaseConnection.prepareStatement(updateBalanceQuery);
                                        updateBalancePS.setDouble(1,newbalance);
                                        updateBalancePS.setString(2,transaction.getSender());
                                        updateBalancePS.executeUpdate();
                                        //now give the money to the other person
                                        String updateBalanceQuery1 = "UPDATE userDataBase SET balance = balance + ? WHERE userName=?";
                                        PreparedStatement updateBalancePS1 = dataBaseConnection.prepareStatement(updateBalanceQuery1);
                                        updateBalancePS1.setDouble(1,transaction.getAmount());
                                        updateBalancePS1.setString(2,transaction.getReceiver());
                                        updateBalancePS1.executeUpdate();

                                        String clientAcctQ1 = "SELECT userName,firstName,lastName,companyName,balance FROM userDataBase where userName=?";
                                        PreparedStatement clientStatement = dataBaseConnection.prepareStatement(clientAcctQ1);
                                        clientStatement.setString(1,personSending);
                                        ResultSet person = clientStatement.executeQuery();
                                        String transactionInsert = " insert into TransactionTable (amount ,comment ,sender ,receiver ,visibility)"
                                                + " values ( ?, ?, ?, ?, ?)";
                                        PreparedStatement addToTransaction = dataBaseConnection.prepareStatement(transactionInsert);

                                        addToTransaction.setDouble(1,transaction.getAmount());
                                        addToTransaction.setString(2,transaction.getComment());
                                        addToTransaction.setString(3,transaction.getSender());
                                        addToTransaction.setString(4,transaction.getReceiver());
                                        addToTransaction.setBoolean(5,transaction.isPrivateTran());
                                        addToTransaction.execute();
                                        ///quere transaction databasep
                                        String tran = "SELECT * FROM TransactionTable";
                                        PreparedStatement alltrans = dataBaseConnection.prepareStatement(tran);
                                        String firstName="";String lastName="";String companyName="";String passWord="";double b=0.0;

                                        if(person.next()) {
                                            firstName = person.getString("firstName");
                                            lastName = person.getString("lastName");
                                            companyName = person.getString("companyName");
                                            passWord = "";
                                            b =person.getDouble("balance");
                                        }
                                        //need to go through the alltrans data base






                                        IndividualAcct client = new IndividualAcct(firstName,lastName,companyName,passWord,b);
                                        client.clearTransaction();
                                        ResultSet allTranResult = alltrans.executeQuery();

                                        while(allTranResult.next()){
                                            client.addTransaction(new Transaction(allTranResult.getDouble("amount"), allTranResult.getString("comment"), allTranResult.getString("sender"), allTranResult.getString("receiver"), allTranResult.getBoolean("visibility")));
                                        }
                                        Packet packet = new Packet(client, "MoneySent");
                                        sendData(packet);


                                    }
                                }

                            }


                        } else if (information.getType().equals("MoneyRequest")){
                        }
                       /// Statement statement = dataBaseConnection.createStatement();
                       /// ResultSet resultSet = statement.executeQuery("SELECT * FROM userAccounts");

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


                } catch (ClassNotFoundException e) {
                    e.printStackTrace(); // class was not found
                }

            }while(!Terminate); //terminate when connection terminates
        }//end method proecssConnection


        private void closeConnection(){
            alive = false;

            //terminate output and input streams

            try {
                output.close();
                input.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendData(Packet data){
            try {
                output.writeObject(data);
                output.flush();
            }catch (IOException ioException){
                ///do something
            }


        }


    }
}
