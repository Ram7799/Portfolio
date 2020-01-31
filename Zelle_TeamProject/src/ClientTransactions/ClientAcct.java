package ClientTransactions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Abstract class to represent each account with each username, password, balance,
 * unique ID, transaction list, and friend list for each account
 */
public abstract class ClientAcct implements Serializable
{
    private static HashMap<Integer, ClientAcct>  clientList = new HashMap<Integer, ClientAcct>();
    private static int uIdentCount = 0;
    private String username;
    private String password;
    private double balance;
    private int uID;
    private ArrayList<ClientAcct> friendList = new ArrayList<>();
    private ArrayList<Transaction> tranList = new ArrayList<>();

    /**
     * Constructor for each account
     * @param username account username
     * @param password account password
     */
    public ClientAcct(String username, String password,double balance)
    {
        uIdentCount++;
        this.username = username;
        this.password = password;
        this.balance = balance;
        //uID = uIdentCount;
        clientList.put(uID, this);
    }

    /**
     * Method to get an account's username
     * @return String value of the username
     */
    public String getUsername() { return username; }

    /**
     * Method to set an account's username
     * @param username String username that the account holder wants to change their username to
     */
    public void setUsername(String username) { this.username = username; }

    /**
     * Method to get account's password
     * @return String value of password
     */
    public String getPassword() { return password; }

    /**
     * Method to set account's password
     * @param password String password to change the current password to
     */
    public void setPassword(String password) { this.password = password; }

    /**
     * Method to get the account balance
     * @return double value of the account balance
     */
    public double getBalance() { return balance; }

    /**
     * Method to set the account balance
     * @param balance Double balance to set the account's balance to
     */
    public void setBalance(double balance) { this.balance = balance; }

    /**
     * Method to get the accounts unique ID number
     * @return integer value of the account's ID number
     */
    public int getuID() { return uID; }

    /**
     * Method to get the account's friend list
     * @return ArrayList of clients that the current account is "friends" with
     */
    public ArrayList<ClientAcct> getFriendList() { return friendList; }

    /**
     * Method to get the account's transaction list
     * @return ArrayList of transactions that the account has been involved in
     */
    public ArrayList<Transaction> getTranList() { return tranList; }

    /**
     * Method for the account to add a friend to their friend list
     * @param uID unique ID of the account they wish to add to their friend list
     */
    public void addFriend(int uID) { friendList.add(clientList.get(uID)); }

    /**
     * Method to make a payment to another account
     * @param paymentAmt amount of money to pay
     */
    public void makePayment(double paymentAmt) { balance -= paymentAmt;}

    /**
     * Method to receive a payment from another account
     * @param paymentAmt amount of money being received from another account
     */
    public void receivePayment(double paymentAmt) { balance += paymentAmt;}

    /**
     * Method to add a new transaction to the account's transaction list
     * @param newTrans New transaction that the account was a part of
     */
    public void addTransaction(Transaction newTrans) { tranList.add(newTrans); }

    public void clearTransaction(){tranList.clear();}
    /**
     * Method to get the list of all clients
     * @return HashMap containing all registered clients
     */
    public static HashMap<Integer, ClientAcct> getClientList() { return clientList; }

    /**
     * Method to convert the account's information to a string
     * @return String value of the account's data
     */
    public String acctToString()
    {
        return "\nUsername: " + username  + "\nID Number: " + uID + "\nBalance: $" + Math.round(balance*100)/100;
    }

    /**
     * Method to convert the account's friend's data to a string
     * @return String value of the account's friend's information
     */
    public String friendToString()
    {
        return "\nUsername: " + username  + "\nID Number: " + uID;
    }

    /**
     * Method that converts the entire friend list of the account to a string
     * @return String value of the entire friend list
     */
    public String friendListToString()
    {
        String friends = "";
        for(int i = 0; i < this.friendList.size(); i++)
        {
            friends += friendList.get(i).friendToString() + "\n";
        }
        return friends;
    }
}