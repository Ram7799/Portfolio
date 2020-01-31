package Connections;
import java.io.Serializable;

/**
 * Method representing serializable login information for an account
 */
public class LoginInfo implements Serializable {
    private String userName;
    private String passWord;
    private String passWordChange;
    private boolean changePassWord = false;

    /**
     * Method to set the login information to the user's desired username and password
     * @param userName the account's username
     * @param passWord the account's password
     */
    public LoginInfo(String userName,String passWord){this.userName=userName;this.passWord=passWord;}

    /**
     * Method to set login information when the user is changing their password
     * @param userName Account's username
     * @param passWord Account's old password
     * @param passWordChange Account's new password
     */
    public LoginInfo(String userName,String passWord,String passWordChange){this.userName=userName;this.passWord=passWord;this.passWordChange=passWordChange;this.changePassWord=true;}

    /**
     * Method to get the account password
     * @return the account's password
     */
    public String getPassWord(){return this.passWord;}

    /**
     * Method to get the account username
     * @return the account's username
     */
    public String getUserName(){return this.userName;}

    /**
     * Method to get the account's new password
     * @return the changed password
     */
    public String getPassWordChange(){return this.passWordChange;}

    /**
     * Method to check if the account's password has been changed
     * @return true if the password has been changed for this account, false if it has not
     */
    public boolean isChangePassWord(){return this.changePassWord;}
}