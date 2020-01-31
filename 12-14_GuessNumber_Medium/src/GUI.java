//

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
/**
 * The class GUI is used to construct the GUI. This separates my Logic conversion from constructing the GUI.
 * I'm using the Instance variable for my labels,text field,button and panel.
 * @author Ram Sajja
 * @version 1.0, 10/8/2019
 */
public class GUI extends JFrame {
    /** label 1 used for guiding the user*/
    private JLabel label1;
    /** This is used for input from the user*/
    private JTextField input;
    /** This is used to give the user a chance to play again*/
    private JButton button;
    /**The panel used to construct the GUI */
    private JPanel jp = new JPanel();
    /** This is used for Introduction to the game*/
    private JLabel jl ;
    /**This is used for Introduction to the game */
    private JLabel text;
    /** This object is used to create random number for the GUI */
    private RandomGuessNumber RandoNum = new RandomGuessNumber();
    /** This is used to keep track of the previous guess from the user*/
    private int previousGuess = -1;

    /**
     * This is the Constructor. This is where I build my GUI.
     */
    public GUI(){
        setTitle("Guess-The-Number-Game");
        setVisible(true);
        input = new JTextField("Enter your Guess",30);
        label1 = new JLabel("");
        jl = new JLabel("I have a number between 1 and 1000.can you guess my number?");
        text = new JLabel("Please enter your first guess");
        button = new JButton("Play Again");
        label1.setForeground(Color.BLACK);
        jp.add(jl);
        jp.add(text);
        jp.add(input);
        jp.add(label1);
        jp.add(button);
        System.out.println("Random number: " + RandoNum.getResult());

        input.addActionListener(new ActionListener() {
            /**
             * This is too see if there is any action performed in the input text box
             * @param e this is the action event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int UserInput = Integer.parseInt(input.getText());
                    if(UserInput > 1000 || UserInput<0){
                        input.setText("Invalid Input");
                    }
                    else if (UserInput == RandoNum.getResult()) {
                        label1.setText("CORRECT!");
                        input.setEditable(false);
                        jp.setBackground(Color.CYAN);
                        label1.setForeground(Color.ORANGE.darker().brighter());
                    } else {
                        if (previousGuess != -1) {
                            if (UserInput > previousGuess && UserInput < RandoNum.getResult()) {
                                jp.setBackground(Color.red);
                                label1.setText("Too Low!");
                            } else if (UserInput < previousGuess && UserInput < RandoNum.getResult()) {
                                jp.setBackground(Color.blue);
                                label1.setText("Too Low!");
                            } else if (UserInput > previousGuess && UserInput > RandoNum.getResult()) {
                                jp.setBackground(Color.blue);
                                label1.setText("Too High!");
                            } else if (UserInput < previousGuess && UserInput > RandoNum.getResult()) {
                                jp.setBackground(Color.red);
                                label1.setText("Too High!");
                            }
                        } else {
                            jp.setBackground(Color.WHITE);
                            if (UserInput > RandoNum.getResult()) {
                                label1.setText("Too high!");
                            } else {
                                label1.setText("Too Low!");
                            }
                        }
                    }
                    previousGuess = Integer.parseInt(input.getText());
                }
                catch (Exception error){
                    input.setText("Invalid Input");
                }
            }
        });

        button.addActionListener(new ActionListener() {
            /**
             * This is too if there is any action performed on the button
             * @param e This is the Action event.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                RandoNum = new RandomGuessNumber();
                input.setText("");
                input.setEditable(true);
                jp.setBackground(Color.white);
                previousGuess = -1;
                label1.setText("");
                System.out.println("New Random Number: " + RandoNum.getResult());
            }
        });
        add(jp);
    }


}
