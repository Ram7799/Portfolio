import java.util.Random;

/**
 * This class is used to create a random number between 1 and a 1000.
 * @author Ram Sajja
 * @version 1.0, 10/8/2019
 */
public class RandomGuessNumber {
    /** the lower bound for creating a random number*/
    private int low = 1;
    /**The upper bound for creating a random number */
    private int high = 1000;
    /** used to return the random number generated*/
    private int result = 0;

    /**
     * This is the constructor. This is used to create the random number every new call.
     */
    public RandomGuessNumber(){
        Random r = new Random();
        result= r.nextInt(high-low) + low;
    }

    /**
     * To access the random value in the GUI
     * @return integer result; which is the random number created.
     */
    public int getResult(){
        return result;
    }

}
