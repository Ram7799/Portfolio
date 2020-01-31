import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Used to construct my GUI
 * @author Ram Sajja
 * @version 1.0, 10/10/2019
 */
public class GUI extends JFrame  {
    /** This label is used to show the Arabic numeral next to the text field.*/
    private JLabel label1;
    /** This label is sued to show the ROman numeral next to the text field.*/
    private JLabel label2;
    /** The textfield to input and output Arabic numbers */
    private JTextField Arabic;
    /** The textfield to input and output Roman numbers*/
    private JTextField Roman;
    /** The panel used to build the GUI on*/
    JPanel jp = new JPanel();

    /**
     * No parameter Constructor.
     * Used to build my GUI.
     */
    public GUI(){
        setTitle("GUI for Conversion");
        setVisible(true);
        label1 = new JLabel("Arabic Numeral");
        label2 = new JLabel("Roman Numeral");
        Arabic = new JTextField("",30);
        Roman = new JTextField("",30);
        jp.add(label1);
        jp.add(Arabic);
        jp.add(label2);
        jp.add(Roman);
        Arabic.addKeyListener(new KeyAdapter() {
            /**
             * This method is used to see if there is any keys pressed in the Arabic text box.
             * @param e It is the KeyEvent typing in the Arabic Text box.
             */
            @Override
            public void keyReleased(KeyEvent e) { //keylistener for arabic text box
                String input="";
                input = Arabic.getText() ;
                Conversion l = new Conversion();
                try {  // code in the try, catch block. its doesnt crash
                        Roman.setText((l.ArabictoRoman(input)));
                } catch (Exception o) {
                    Roman.setText("Invalid Input");
                }
            }
        });
        Roman.addKeyListener(new KeyAdapter() {
            /**
             * This method is used to see if there is any keys pressed in the Roman text box.
             * @param e This is the keyEvent typing in the Roman Text box.
             */
            @Override
            public void keyReleased(KeyEvent e) { //keylistener for Roman text field.
                String input="";
                Conversion k = new Conversion();
                String Roma="";
                try{
                    input = Roman.getText();
                    String ret = Integer.toString(k.RomantoArabic(input.toUpperCase()));
                    Roma = k.ArabictoRoman(ret.toUpperCase());
                    if(Roma.equals(input.toUpperCase())) {  // making sure the user follows proper modern roman rules
                        Arabic.setText(Integer.toString(k.RomantoArabic(input.toUpperCase())));
                    }
                    else{Arabic.setText("Invalid Input ");}
                }
                catch (Exception g){Arabic.setText("Invalid Input");}
            }
        });
        add(jp);
    }

}
