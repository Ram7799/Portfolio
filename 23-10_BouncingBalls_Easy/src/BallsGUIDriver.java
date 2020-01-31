import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This is a driver class and used to create the GUI object.
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */
public class BallsGUIDriver {
    /**
     * This is the main method.
     *  It creates the ExecutorService and assign the ball object to a thread.
     *  Adds jpanel to the jframe.
     * @param args Main method arguments
     */
    public static void main(String[] args) {
        Balls temp = new Balls();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(temp);
        JFrame jf = new JFrame();
        jf.setTitle("Bouncing Balls");
        jf.setSize(450,385);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.add(temp);
        executorService.shutdown();
    }
}
