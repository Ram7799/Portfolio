
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This is the Driver class for my GUI
 * @author Ram Sajja
 * @version 1.0,10/11/2019
 */
public class GUIDriver {
    /**
     * This is where i create the GUI object
     * @param args Arguments for the main method
     */
    public static void main(String[] args) {
        GUI t = new GUI();
        t.setSize(400,150);
        t.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

