package RequestInheritance;

import java.util.UUID;

/**
 * This is the PostReuqest class which inherits from the Request.
 * @author Ram Sajja
 * @version 1.0, 10/10/2019
 */

public class PostRequest extends Request {  // this directly inherits from request
    /** Used to store the IP*/
    private String RandomIP;
    /** Used to keep track of number of calls*/
    private static int num2 = 0;

    /**
     * A two parameter constructor.
     * @param randUUID This is of the type UUID
     * @param randIP This is of the type String
     */
    public PostRequest(UUID randUUID, String randIP) {
        super(randUUID);
        this.RandomIP = randIP;
        num2++;
    }

    /**
     * This is the getter to get IP
     * @return A string consisting of the IP
     */

    public String getRandomIP() {
        return RandomIP;
    }

    /**
     * This is to access the static variable.
     * @return An int with the count for no of calls.
     */
    public static int count(){
        return num2;
    }  // to get the count for this class

    /**
     * Overriding the toString from the super class
     * @return A string in the defined manner.
     */
    @Override
    public String toString(){
        return super.toString()+ "\n" + "Post request to server with IP address: "+ getRandomIP();  // supers to string method takes care of the UUID, all i had to add was the IP
    }
}
