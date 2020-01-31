package RequestInheritance;

import java.util.HashMap;
import java.util.UUID;

/**
 * This is PostPaymentRequest inherits from PostRequest
 * @author Ram Sajja
 * @version 1.0, 10/10/2019
 */

public class PostPaymentRequest extends PostRequest { //this inherits from postrequest and post request inherits from request
    /** This is an Object of the payment class */
    private Payment RandomPayment;
    /** Used to keep track of number of calls*/
    private static int num5 =0;

    /**
     * This is a three parameter constructor
     * @param randUUID This is of type UUID, to hold the UUID.
     * @param randIP This is of type String, to hold the IP.
     * @param randPayment This is of type Payment, to hold the randPayment.
     */
    public PostPaymentRequest(UUID randUUID, String randIP, Payment randPayment) { // the post request already has a constructor which takes UUID and IP.
        super(randUUID,randIP); // use that for those two variables.
        this.RandomPayment = randPayment;
        num5++;
    }

    /**
     * Used to access the static variable which holds the number of calls.
     * @return
     */
    public static int count(){return num5;} // used to get the count for this class

    /**
     * Overriding the toString from the super class
     * @return A string in the defined manner.
     */
    @Override
    public String toString(){ // calling the supers tostring takes care of my UUID and IP. all i had to add was the payment information

        return super.toString()+"\n" + "Payment Data\n" + "Payment Sender: "+RandomPayment.getName()+"\n"+"Payment amount: $" + RandomPayment.getNext()+"\n"+"Payment receiver: " + RandomPayment.getRanName();
    }
}
