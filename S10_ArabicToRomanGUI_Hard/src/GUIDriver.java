import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This is the driver class for my GUI
 * @author Ram Sajja
 * @version 1.0,10/11/2019
 */
public class GUIDriver {
    /**
     * This is used to make the object for GUI
     * @param args Arguments to the main method
     */
    public static void main(String[] args) {
        GUI t = new GUI();
        t.setSize(400,200);
        t.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
