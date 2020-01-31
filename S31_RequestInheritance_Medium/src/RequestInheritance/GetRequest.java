package RequestInheritance;

import java.util.UUID;

/**
 * This is a GetRequest class inheriting from Request.
 * @author Ram Sajja
 * @version 1.0, 10/10/2019
 */
public class GetRequest extends Request { //this directly inherits from Request
    /** This is used to hold the URL*/
    private String RandomURl;
    /**This is used to keep track of the number of calls */
    private static int num1 = 0;

    /**
     * This is a two parameter constructor,
     * @param randUUID This is of type UUID, to hold the UUID.
     * @param randURL This is of type String, to hold the URL.
     */
    public GetRequest(UUID randUUID, String randURL) {
        super(randUUID); // the Request constructor can take of the UUID
        this.RandomURl = randURL;
        num1++;
    }

    /**
     * This is a getter to get the URl.
     * @return A string.
     */

    public String getRandomURl() {
        return RandomURl;
    }


    /**
     * This is used to access the static variable which keeps track with number of calls.
     * @return An integer
     */
    public static int count(){
        return num1;
    }

    /**
     * Overriding the toString from the super class
     * @return A string in the defined manner.
     */
    @Override
    public String toString(){ //Request tostring already has a string with the UUID. just add the URL

        return super.toString()+ "\n" +"Universal Resource Locator (URL): " + getRandomURl();
    }

}
