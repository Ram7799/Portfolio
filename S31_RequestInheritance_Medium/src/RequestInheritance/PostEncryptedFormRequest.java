package RequestInheritance;

import java.util.UUID;

/**
 * This is the PostEncryptedFormRequest inheriting from PostFormRequest
 * @author Ram Sajja
 * @version 1.0, 10/10/2019
 */
public class PostEncryptedFormRequest extends PostFormRequest { // iherits from postformrequest which inherits from post request which inherits from request
    /**This is used to hold the Encryption type. */
    private String RandomEncryption;
    /**This is used to keep track of the number of calls */
    private static int PostFormRequestCount =0;

    /**
     * This is a four parameter constructor.
     * @param randUUID This is of the type UUID, to hold the UUID.
     * @param randIP This is of the type String, to hold the IP.
     * @param randForm This is of the type Form, to hold the randForm.
     * @param randEncryptionScheme This is of the type String, to hold the EncryptionScheme.
     */
    public PostEncryptedFormRequest(UUID randUUID, String randIP, Form randForm, String randEncryptionScheme) {
        super(randUUID,randIP,randForm); // the post form request constructor take care of my first 3 variables.
        this.RandomEncryption = randEncryptionScheme;
        PostFormRequestCount++;
    }

    /**
     * This is a getter to get the Encryption type.
     * @return A string with the encryption type.
     */
    public String getRandomEncryption() {
        return RandomEncryption;
    }

    /**
     * This is used to access the stack variable holding the number of calls.
     * @return An int with the number of calls.
     */
    public static int count(){return PostFormRequestCount;} // to return my count for this class

    /**
     * Overriding the toString from the super class
     * @return A string in the defined manner.
     */
    @Override
    public String toString(){ //super.tostring has a string for all of the required stuff except for the encryption type
        String retString = super.toString()  + "This form was encrypted using: " + getRandomEncryption();
        return retString;

    }
}
