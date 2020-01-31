package ClientTransactions;
import java.io.Serializable;
/**
 * Class that contains information for each transaction
 */
public class Transaction implements Serializable
{
    //private static ArrayList<Transaction> allTransactions= new ArrayList<>();
    //private static ArrayList<Transaction> publicTra5nsactions = new ArrayList<>();
    private double amount;
    private String comment;
    private String sender;
    private String receiver;
    private boolean privateTran;

    /**
     * Constructor for a new transaction
     * @param amount amount of money being transferred in the transaction
     * @param comment comment user makes for the transaction
     * @param sendID ID for the account sending the money
     * @param recID ID for the account receiving the money
     * @param privateTran whether or not the user wishes the transaction to be public or private
     */
    public Transaction(double amount, String comment, String sendID, String recID, boolean privateTran)
    {
        this.amount = amount;
        this.comment = comment;
        sender = sendID;
        receiver = recID;
        this.privateTran = privateTran;
        //allTransactions.add(this);
        //if(!this.isPrivateTran())
        //{
            //publicTransactions.add(this);
        //}
    }

    /**
     * Method to get the amount of money transferred in the transaction
     * @return Amount of money being transferred
     */
    public double getAmount() { return amount; }

    /**
     * Method to get the comment the user left for the transaction
     * @return String value of the comment made for the transaction
     */
    public String getComment() { return comment; }

    /**
     * Method to get the account that sent the money
     * @return Sender's account
     */
    public String getSender() { return sender; }

    /**
     * Method to get the account that received the money
     * @return Receiver's account
     */
    public String getReceiver() { return receiver; }

    /**
     * Method to determine if the transaction is public or private
     * @return false if it's a public transaction and true if it is private
     */
    public boolean isPrivateTran() { return privateTran; }

   // public static ArrayList<Transaction> getPublicTransactions() { return publicTransactions; }

   // public static ArrayList<Transaction> getAllTransactions() { return allTransactions; }

    /**
     * Method to convert the transaction to a string
     * @return String value of the transaction information
     */
    public String tranToString()
    {
        return sender + " sent " + receiver + " $" + Math.round(amount*100)/100;
    }
}