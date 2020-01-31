package RequestInheritance;

import java.util.UUID;

/**
 * This is the Request class
 * @author Ram Sajja
 * @version 1.0, 10/10/2019
 */

public class Request {  // the super class, all the other classes are inherited from this
    /** This varaiable holds the Randon UUID*/
    private UUID RandomUUID;
    /** This static variable is used to keep track of the count of calls to Request*/
    private static int num = 0;

    /**
     * This is a single parameter constructor.
     * @param randUUID This is of the type UUID
     */
    public Request(UUID randUUID) {
        this.RandomUUID = randUUID;
        num++;
    }

    /**
     * This is the getter to get the UUID
     * @return The UUID of the present request Object
     */

    public UUID getRandomUUID() {
        return RandomUUID;
    }

    /**
     * This is the setter to set the UUID
     * @param randomUUID set the UUID of the present object with the given one
     */
    public void setRandomUUID(UUID randomUUID) {
        RandomUUID = randomUUID;
    }

    /**
     * This is used to access the static variable count
     * @return An static int
     */
    public static int count(){
        return num;
    } // used to get the count for this particular class.

    /**
     * Overriding the toString from the super class
     * @return A string in the defined manner.
     */
    @Override
    public String toString(){
        return   super.toString() + "\n"+ "UUID: "  + getRandomUUID() ;    }   // this is to print the information in the defined manner

}
