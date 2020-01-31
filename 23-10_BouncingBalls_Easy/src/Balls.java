import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class used to create the GUI for a bouncing ball
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */
public class Balls extends JPanel implements Runnable {
    /**x value of the ball*/
    private int x = 5;
    /**y value of the ball */
    private int y = 5;
    /** x velocity for the ball*/
    private int xvelocity =1;
    /** y velocity for the ball*/
    private int yvelocity = 1;
    /** A boolean value used to keep track of the mouse click */
    private boolean temp =false;

    /**
     * No parameter constructor.
     * Used to create the GUI
     */
    public Balls(){

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(temp) {
                    temp = false;
                }
                else if(!temp){
                temp = true;}

            }
        });
    }

    /**
     * This is used to paint the ball
     * @param g This is the graphics
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillOval(x,y,50,50);
    }

    /** It just calls the repaint()*/
    public void drawing(){
        repaint();
    }

    /** This is method used to keep track of the ball.*/
    @Override
    public void run() {
        try {
            while (true) {
                move();
                drawing();
                Thread.sleep(1);
            }
        }catch (InterruptedException e){
            System.out.println();
        }

    }

    /**
     * This method is used to move the ball.
     */
    public void move() {
        if (temp) {
            if (x >= (getWidth()-50)) {
                xvelocity = -xvelocity;
            }
            if (y >= getHeight()-50) {
                yvelocity = -yvelocity;
            }
            if (x <= 0) {
                xvelocity = -xvelocity;
            }
            if (y <= 0) {
                yvelocity = -yvelocity;
            }
            x += xvelocity;
            y += yvelocity;

        }
    }
}
