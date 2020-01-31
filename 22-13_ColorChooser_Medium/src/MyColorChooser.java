import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used to create a GUI; so that the user can choose the red,blue and green colors.
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */
public class MyColorChooser extends JPanel {
    /** It is a textfield to take input of blue color or out put the sliders value*/
    private JTextField Bluetext;
    /** It is a textfield to take input of Red color or out put the sliders value*/
    private JTextField Redtext;
    /** It is a textfield to take input of Green color or out put the sliders value*/
    private JTextField Greentext;
    /** It is a slider to take input of blue color or change the slider to the value inputted in the textfield*/
    private JSlider Blueslide;
    /** It is a slider to take input of Red color or change the slider to the value inputted in the textfield*/
    private JSlider Redslide;
    /** It is a slider to take input of Green color or change the slider to the value inputted in the textfield*/
    private JSlider Greenslide;
    /** It is a Label to show the user which is the textfield for blue color*/
    private JLabel blueLabel;
    /** It is a label for slider to show the user which is the slider for blue color*/
    private JLabel blueLabelSlider;
    /** It is a Label to show the user which is the textfield for Red color*/
    private JLabel redLabel;
    /** It is a label for slider to show the user which is the slider for Red color*/
    private JLabel redLabelSlider;
    /** It is a Label to show the user which is the textfield for green color*/
    private JLabel greenlabel;
    /** It is a label for slider to show the user which is the slider for green color*/
    private JLabel greenlabelSlider;
    /** This is used to keep track of present Red Number */
    private int RedNumber = 0;
    /**This is used to keep track of present blue number */
    private int BlueNumber = 0;
    /**This is used to keep track of the present Green number */
    private int GreenNumber = 0;
    /** No parameter Constructor; This is where I build the GUI*/
    public MyColorChooser(){
        blueLabel = new JLabel("Blue color");
        blueLabelSlider = new JLabel("Blue color Slider");
        redLabel = new JLabel("Red color");
        redLabelSlider = new JLabel("Red Color Slider");
        greenlabel = new JLabel("Green Color");
        greenlabelSlider = new JLabel( "Green color Slider");
        Redslide = new JSlider(0,255,1);
        Greenslide = new JSlider(0,255,1);
        Blueslide = new JSlider(0,255,1);
        Bluetext = new JTextField(String.valueOf(Blueslide.getValue()),30);
        Redtext = new JTextField(String.valueOf(Redslide.getValue()),30);
        Greentext = new JTextField(String.valueOf(Greenslide.getValue()),30);
        add(blueLabel);
        add(Bluetext);
        add(redLabel);
        add(Redtext);
        add(greenlabel);
        add(Greentext);
        add(blueLabelSlider);
        add(Blueslide);
        add(redLabelSlider);
        add(Redslide);
        add(greenlabelSlider);
        add(Greenslide);

            Blueslide.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    BlueNumber = Blueslide.getValue();
                    Bluetext.setText(String.valueOf(Blueslide.getValue()));
                    drawing();
                }
            });
            Redslide.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    RedNumber = Redslide.getValue();
                    Redtext.setText(String.valueOf(Redslide.getValue()));
                    drawing();
                }
            });
            Greenslide.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    GreenNumber = Greenslide.getValue();
                    Greentext.setText(String.valueOf(Greenslide.getValue()));
                    drawing();
                }
            });
            Redtext.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        RedNumber = Integer.parseInt(Redtext.getText());
                        if (RedNumber > 255 || RedNumber < 0) {
                            Redslide.setValue(1);
                            Redtext.setText("Invalid Input. Updated Red color Number to 1");
                            RedNumber = 1;
                        }
                        Redslide.setValue(RedNumber);
                        drawing();
                    }catch (Exception l){
                        Redslide.setValue(1);
                        Redtext.setText("Invalid Input. Updated Red color Number to 1");
                        drawing();
                    }
                }
            });
            Bluetext.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        BlueNumber = Integer.parseInt(Bluetext.getText());
                        if (BlueNumber > 255 || BlueNumber < 0) {
                            Blueslide.setValue(1);
                            Bluetext.setText("Invalid Input. updated Blue color number to 1");
                            BlueNumber = 1;
                        }
                        Blueslide.setValue(BlueNumber);
                        drawing();
                    }catch (Exception p){
                        Blueslide.setValue(1);
                        Bluetext.setText("Invalid Input. updated Blue color number to 1");
                        drawing();
                    }
                }
            });
            Greentext.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        GreenNumber = Integer.parseInt(Greentext.getText());
                        if (GreenNumber > 255 || GreenNumber < 0) {
                            Greenslide.setValue(1);
                            Greentext.setText("Invalid Input. updated green color number to 1.");
                            GreenNumber = 1;
                        }
                        Greenslide.setValue(GreenNumber);
                        drawing();
                    }catch (Exception o){
                        Greenslide.setValue(1);
                        Greentext.setText("Invalid Input. Updated green color number to 1.");}
                        drawing();
                }
            });

    }

    /**This method is used to call the repaint() method */
    public void drawing(){
        repaint();
    }

    /**This is used to paint the rectangle with the present Red Number, Green Number, Blue Number */
    public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(new Color(RedNumber, GreenNumber, BlueNumber));
            g.fillRect(5, 200, 150, 100);
    }

}
