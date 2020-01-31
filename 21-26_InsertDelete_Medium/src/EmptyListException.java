/**
 * This class is used to throw an exception if the list is empty
 */
public class EmptyListException extends RuntimeException {
    /** No parameter constructor */
    public EmptyListException() {
        this("List"); // call other EmptyListException constructor
    }

    /** overloaded one parameter constructor; so that it can take in a string */
    public EmptyListException(String name) {
        super(name + " is empty"); // call superclass constructor
    }
} // end class EmptyListException
