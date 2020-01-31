package Connections;
import java.io.Serializable;

/**
 * Method to represent a serializable packet of information that can be sent through a connection
 */
public class Packet implements Serializable {
    private final Object contents;
    private final String type;

    /**
     * Constructor to create a packet
     * @param contents object to be sent
     * @param type type of object being sent
     */
    public Packet(final Object contents,String type){
        this.contents = contents;
        this.type = type;
    }

    /**
     *Method to return the contents of a packet
     * @param clazz generic class type
     * @param <T> generic type
     * @return generic type of object
     */
    public <T> T getContents(Class<T> clazz){
        return (T) contents;
    }

    /**
     * Method to get the type of information
     * @return Type of information being sent
     */
    public String getType(){return type;}
}
