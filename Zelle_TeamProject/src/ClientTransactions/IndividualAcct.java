package ClientTransactions;
/**
 * Class that handles accounts for individuals
 * @see ClientAcct
 */
public class IndividualAcct extends ClientAcct
{
    private String firstName;
    private String lastName;

    /**
     * Constructor to create a new individual account
     * @param firstName first name of the individual
     * @param lastName last name of the individual
     * @param username individual's chosen username
     * @param password individual's chosen password
     */
    public IndividualAcct(String firstName, String lastName, String username, String password,double balance)
    {
        super(username, password,balance);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Method to get the individual's first name
     * @return String value of the first name
     */
    public String getFirstName() { return firstName; }

    /**
     * Method to set the individual's first name
     * @param firstName First name given by user
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /**
     * Method to get the individual's last name
     * @return String value of the last name
     */
    public String getLastName() { return lastName; }

    /**
     * Method to set the individual's last name
     * @param lastName Last name given by user
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * Method to convert the individual account information to a string
     * @return String value of the account information
     */
    @Override
    public String acctToString()
    {
        return firstName + " " + lastName + "\nUsername: " + this.getUsername() + "\nID Number: " + this.getuID() + "\nBalance: $" + Math.round(this.getBalance()*100)/100;
    }

    /**
     * Method to convert a friend of the account's information to a string
     * @return String value of the friend's account information
     */
    @Override
    public String friendToString()
    {
        return firstName + " " + lastName +"\nUsername: " + this.getUsername()  + "\nID Number: " + this.getuID();
    }
}