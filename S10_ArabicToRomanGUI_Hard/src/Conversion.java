import java.util.Arrays;

/**
 * This class is used to convert from arabic to roman and the other way.
 * @author Ram Sajja
 * @version 1.0,10/11/2019
 */
public class Conversion  {
    /**
     * A staic variable with ints of basic conversison of roman numbers and their corner cases
     */
    private static int[]   numbers = { 1000,  900,  500,  400,  100,   90,50,   40,   10,    9,    5,    4,    1 };
    /**
     * A static variable to hold the strings of roman variables.
     */
    public static String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC","L",  "XL",  "X",  "IX", "V",  "IV", "I" };

    /**
     * An enum variable used to convert from arabic to roman.
     */
    private enum Roman {
        /** The variable holding value of 100*/C(100),/** The variable holding value of 400*/ CD(400), /** The variable holding value of 900*/CM(900), /** The variable holding value of 500*/D(500), /** The variable holding value of 1*/I(1),/** The variable holding value of 4*/ IV(4), /** The variable holding value of 9*/IX(9),/** The variable holding value of 50*/ L(50), /** The variable holding value of 1000*/M(1000), /** The variable holding value of 5*/V(5),/** The variable holding value of 10*/ X(10), /** The variable holding value of 90*/XC(90),/** The variable holding value of 40*/ XL(40);
        /** The variable to hold the Arabic value of Roman character.*/
        int value;

        Roman(int value) {
            this.value = value;                                // got help with creating the enum variables from the slides and stack overflow
        }
        public int toInt() {
            return value;
        }
    }

    /**
     * This method is used to convert from Arabic to Roman.
     * @param value A string of Arabic numbers to be converted to Roman.
     * @return A string of Roman number.
     */

    public String ArabictoRoman(String value){ //going backwards help doing it easily.
        String ret = "";
        int num = Integer.parseInt(value);
        for(int i =0;i<numbers.length;i++){ //goes through all of numbers array
            while(num >= numbers[i]){ // makes sure if the given value is grater than the present element in numbers
                ret += letters[i]; //adding that corresponding element from letters to the ret string
                num -= numbers[i]; // subtracting the value given to the value added to the ret string.
            }
        }
        return ret;
    }


    /**
     * This method is used to convert from Roman to Arabic.
     * @param str A string of Roman numbers to be converted to Arabic.
     * @return It returns an int; which is in Arabic format.
     */
    public int RomantoArabic(String str){
        try {
            int sum = 0;
            String temp;
            String[] letter = str.split("");
            int count = 0;
            for (int i = 0; i < letter.length - 1; i++) {
                if (Roman.valueOf(letter[i]).toInt() < Roman.valueOf(letter[i + 1]).toInt()) { //if the next element is larger than the present one
                    temp = letter[i] + letter[i + 1];
                    sum += Roman.valueOf(temp).toInt();
                    i++; //increasing the value of i by 2
                    count += 2;
                } else {
                    sum += Roman.valueOf(letter[i]).toInt(); // base case if its normal
                    count++;

                }
            }
            if (count != letter.length) {
                sum += Roman.valueOf(letter[count]).toInt();
            }
            return sum;
        }
        catch(Exception e){return 0;}

        }
    }



