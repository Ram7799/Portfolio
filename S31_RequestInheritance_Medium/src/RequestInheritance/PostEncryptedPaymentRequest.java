package RequestInheritance;

import java.util.UUID;

/**
 * This is the PostEncryptedPaymentRequest inheriting from PostPaymentRequest.
 * @author Ram Sajja
 * @version 1.0, 10/10/2019
 */
public class PostEncryptedPaymentRequest extends PostPaymentRequest { // inherits from post payment request which inherits from Postrequest which inherits from request.
    /** This is of type String to hold the Encryption type*/
    private String RandomEncryption;
    /** This is used to keep track of the number of calls*/
    private static int num4 =0;

    /**
     * This is a four parameter constructor.
     * @param randUUID This is of the type UUID, to hold the UUID.
     * @param randIP This is of type String, to hold the IP.
     * @param randPayment This is of the type Payment, to hold the Payment.
     * @param randEncryptionScheme This is of the type String, to hold the Encryption Scheme.
     */
    public PostEncryptedPaymentRequest(UUID randUUID, String randIP, Payment randPayment, String randEncryptionScheme) {
        super(randUUID,randIP,randPayment); // the  post payment request constructor can take care of the first three variables
        this.RandomEncryption = randEncryptionScheme;
        num4++;
    }

    /**
     * This is a getter used to get the Encryption type.
     * @return A string consisting the Encrption typr
     */
    public String getRandomEncryption() {
        return RandomEncryption;
    }

    /**
     * This is used to access the stack variable which keeps track of the number of calls
     * @return An int with the number of calls.
     */
    public static int count(){return num4;} // used to get the count for this class

    /**
     * Overriding the toString from the super class
     * @return A string in the defined manner.
     */
    @Override
    public String toString(){
        String retString = super.toString(); //the post payment request tostring method takes care of the first three variable. i had to only add the encryption type.
        return retString+"\n" + "This payment was encrypted using: "+ getRandomEncryption();
    }
}
