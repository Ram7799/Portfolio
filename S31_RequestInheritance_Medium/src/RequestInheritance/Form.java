package RequestInheritance;

import java.util.HashMap;

/**
 * This is the Form class.
 * @author Ram Sajja
 * @version 1.0, 10/10/2019
 */
public class Form { //doesnt inherit from anything
    /** This is a HaspMap having String and String types.*/
    private HashMap<String,String> Field;

    /**
     * This is a single parameter constructor.
     * @param RandFields This is a HashMap.
     */
    public Form(HashMap RandFields){
        this.Field = RandFields;
    } // its an helper class;to hold the information

    /**
     * This is a getter to get the Field.
     * @return
     */
    public HashMap<String, String> getField() {
        return Field;
    }

    /**
     * This is a setter to set the Field.
     * @param field
     */
    public void setField(HashMap<String, String> field) {
        Field = field;
    }
}
