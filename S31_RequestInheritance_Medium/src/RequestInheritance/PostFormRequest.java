package RequestInheritance;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * This is PostFormRequest which inherits from PostRequest.
 * @author Ram Sajja
 * @version 1.0, 10/10/2019
 */

public class PostFormRequest extends PostRequest { //this inherits from Postreuqest which inherits from Request.
    /** This is an object of Form*/
    private Form RandomForm;
    /** This is to hold the number of calls*/
    private static int num3 =0;

    /**
     * This is a three paramater constructor
     * @param randUUID This is of type UUID, to hold the UUID.
     * @param randIP This is of type String, to hold the IP.
     * @param randForm This is of type Form, to hold the randForm.
     */
    public PostFormRequest(UUID randUUID, String randIP, Form randForm) {
        super(randUUID,randIP); //postrequest has a constructor which takes the UUID and IP
        this.RandomForm = randForm;
        num3++;
    }


    /**
     * This is a getter used to get the Form
     * @return An Object of Form
     */
    public Form getRandomForm() {
        return RandomForm;
    }

    /**
     * This is used to access the static variable which keeps track of the Number of calls.
     * @return An int consisting the number.
     */
    public static int count(){
        return num3;
    } // used to get the count for this class

    /**
     * Overriding the toString from the super class
     * @return A string in the defined manner.
     */
    @Override
    public String toString(){
        String retString = super.toString(); // this takes care of my UUID and IP
        retString+= "\n"+ "Form Data\n"; // i just had to add the extra stuff
        HashMap<String,String> x = getRandomForm().getField();
        for(Map.Entry i: x.entrySet()){
            retString += "Label: " + i.getKey() + "\n" + "Value: " + i.getValue()+ "\n";
        }
        return retString;}
}
