package Connections;
import java.io.Serializable;

/**
 * Class to represent flags that are sent between the client and server to represent errors
 */
public class Flag implements Serializable {
    private String ErrorMessage = "There was a Error";

    /**
     * Method to create a new flag object
     * @param errorMessage error that is causing the flag
     */
    public Flag(String errorMessage){this.ErrorMessage = errorMessage;}

    /**
     * Method to get a flag's error message
     * @return the flag's error message
     */
    public String getFlag(){return this.ErrorMessage;}
}
