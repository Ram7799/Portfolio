package RequestInheritance;

/**
 * This is the Payment class.
 * @author Ram Sajja
 * @version 1.0, 10/10/2019
 */
public class Payment { //doesnt inherit from anything. just a helper class
    /** Variable to hold the name*/
    private String name;
    /** Variable to hold the NextInt*/
    private int Next;
    /** Variable to hold the RandName*/
    private String ranName;

    /**
     * This is a three paramter constructor
     * @param name This is of type String, to hold the name.
     * @param NextInt This is of the type int, to hold the NextInt.
     * @param randName This is of the type String, to hold the randName.
     */

    public Payment(String name,int NextInt,String randName){ //this is helper class for inherited classes which hold the payment information
        this.name=name;
        this.Next = NextInt;
        this.ranName = randName;
    }

    /**
     * This is a getter to get the Name.
     * @return A string
     */
    public String getName() {
        return name;
    }

    /**
     * This is a setter to set the name with the given one.
     * @param name The one to replace with
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is a getter to get the Nextint
     * @return An Integer
     */
    public int getNext() {
        return Next;
    }

    /**
     * This is a setter to set the NextInt
     * @param next The one to replace with
     */
    public void setNext(int next) {
        Next = next;
    }

    /**
     * This is a getter to get the RanName
     * @return A String
     */
    public String getRanName() {
        return ranName;
    }

    /**
     * This is a setter to set the RanName.
     * @param ranName The one to replace with.
     */
    public void setRanName(String ranName) {
        this.ranName = ranName;
    }
}
