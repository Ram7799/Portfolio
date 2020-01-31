import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This is the driver class for ColorChooser
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */
public class MyColorChooserDriver {
    /**
     * This is the main method. used to create the object for the GUI and the panel to the frame
     * @param args args Arguments to the Main method.
     */
    public static void main(String[] args) {
        MyColorChooser temp = new MyColorChooser();
        JFrame jf = new JFrame();
        jf.setTitle("Color Chooser");
        jf.setSize(400,400);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.add(temp);
    }
}
