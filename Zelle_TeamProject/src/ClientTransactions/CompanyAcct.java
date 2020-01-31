package ClientTransactions;
/**
 * Class that handles company accounts
 * @see ClientAcct
 */
public class CompanyAcct extends ClientAcct
{
    private String companyName;

    /**
     * Constructor for a company account
     * @param companyName name of the company
     * @param username company's chosen username
     * @param password company's chosen password
     */
    public CompanyAcct(String companyName, String username, String password,double balance)
    {
        super(username, password,balance);
        this.companyName = companyName;
    }

    /**
     * Method to get the company's name
     * @return String value of the company name
     */
    public String getCompanyName() { return companyName; }

    /**
     * Method to set the company's name
     * @param companyName Company name to set the account's company name to
     */
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    /**
     * Method to convert the account's information to a string
     * @return String value of the account information
     */
    @Override
    public String acctToString()
    {
        return companyName + "\nUsername: " + this.getUsername() + "\nID Number: " + this.getuID() + "\nBalance: $" + Math.round(this.getBalance()*100)/100;
    }

    /**
     * Method to convert a friend of the account's information to a string
     * @return String value of the friend's account information
     */
    @Override
    public String friendToString()
    {
        return companyName + "\nUsername: " + this.getUsername()  + "\nID Number: " + this.getuID();
    }
}