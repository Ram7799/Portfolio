package Connections;
import ClientTransactions.ClientAcct;
import ClientTransactions.CompanyAcct;
import ClientTransactions.IndividualAcct;
import ClientTransactions.Transaction;
import GUIStuff.*;
import javafx.application.Application;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Class to handle the client side of the socket connection between a client and the server
 */
public class Client {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Packet Sharedpacket;
    private String serverURL;
    private Socket client;
    public boolean loopGaurd = false;
    private ClientAcct person;
    private ArrayList<Transaction> list;

    /**
     * Method to get the shared packet of information
     * @return packet of information being sent
     */
    public Packet getSharedpacket(){return this.Sharedpacket;}

    public ClientAcct getPerson(){return person;}

    /**
     * Method to set the server's URL to be able to make the connection to the server
     * @param host server URL to connect to
     * @throws IOException exception for input/output errors
     */
    public Client(String host) throws IOException {
        serverURL = host;
        //Application.launch(Main.class); //launches the application
    }

    /**
     * Method to run the client's connection to the server by connecting and receiving information from the server
     */
    public void runClient(){
        //first try to connect to the server

        try{
            //connect to server
            connectToServer();
            getStreams();
           // processConnection();
            //processConnection()
        } catch (EOFException eofExeception){
            ///do something
        }  catch (IOException ioException){
            ioException.printStackTrace();
        } finally {
            //closeConnection();
        }

    }

    /**
     * Method to connect to the server through a socket connection
     * @throws IOException exception for input/output errors
     */
    private void connectToServer()throws IOException{
        client = new Socket(InetAddress.getByName(serverURL),23557);
    }

    /**
     * Method to assign the input and output streams
     * @throws IOException exception for input/output errors
     */
    private void getStreams() throws IOException{
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush();
        input = new ObjectInputStream(client.getInputStream());
    }

    /**
     * Method to process the connection and send data back and forth to the server
     * @throws IOException exception for input/output errors
     */
    private void processConnection() throws IOException{
        boolean Terminate = false;
        Packet information;

            try {//try to read the information from the server
                 information= (Packet) input.readObject();
                //figure out what the information is and update information accord
                //like this
                if(information.getType().equals("Terminate")) {
                    Terminate = true;
                }else if(information.getType().equals("IndividualAcct")) {
                    //Transaction t = information.getContents(Transaction.class);
                    //do stuff with this information like sql query
                    Sharedpacket = information;
                    loopGaurd = true;
                    //tell the gui that i got something
                    //then send the info back
                }else if(information.getType().equals("CompanyAccount")){ //will read the contents of this
                    ClientAcct c = information.getContents(CompanyAcct.class);
                }


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
         /// this needs to terminate if they


    }


    /**
     * Method to receive packet of information from the server
     * @throws IOException exception for input/output errors
     */
    public void waitForResponse() throws IOException{
        boolean Terminate = false;
        do {
                try {
                    Packet information = (Packet) input.readObject();
                    if(information.getType().equals("loginInfo")){
                        person = information.getContents(IndividualAcct.class);
                        Sharedpacket = new Packet(information.getContents(IndividualAcct.class),"Client");
                        Terminate = true;
                    }else if (information.getType().equals("Flag")){
                        Sharedpacket = new Packet(information.getContents(Flag.class),"Flag");
                        Terminate = true;
                    }else if (information.getType().equals("accountCreated")){
                       // person = information.getContents(ClientAcct.class);
                        //no need to return the contents because they will need to sign in again
                        Sharedpacket = new Packet(information.getContents(Flag.class),"NotFlag");
                        Terminate = true;
                    }else if (information.getType().equals("MoneySent")){
                        Sharedpacket = new Packet(information.getContents(IndividualAcct.class),"AnythingElse");
                        person = information.getContents(IndividualAcct.class);
                        Terminate = true;
                    }else if (information.getType().equals("MoneyRequest")){
                        Sharedpacket = new Packet(information.getContents(IndividualAcct.class),"AnythingElse");
                        person = information.getContents(IndividualAcct.class);
                        Terminate = true;
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
        }while (!Terminate);
    }

    /**
     * Method to close the input and output connections between the client and the server
     */
    private void closeConnection(){
        try {
            output.close();
            input.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to send data from the client to the server
     * @param p packet of information to send
     */
    public void sendData(Packet p){
        try {
            output.writeObject(p);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // info from gui
}
