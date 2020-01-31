import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * This is the input class; used to get input from the user.
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */
public class Input {
    /**
     * Object of the Thanksgiving class.
     */
    private ThanksGiving obj;

    /**
     * A single parameter constructor
     * @param temp Object of Thanksgiving
     */

    public Input(ThanksGiving temp) {
        this.obj = temp;
        try {
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Used to get input of volume and enjoyment of each food item from the user.
     * @throws IOException Because of the input from the user.
     */
    public void print() throws IOException {
        int count = 0;
        while (true) {
            try {
                ThanksGiving east = obj;
                ArrayList<FoodComponents> food = new ArrayList<>();
                System.out.println("Please enter volume and enjoyment... (With no space in the beginning)");
                do {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println(east.getFood(count) + " " + "enter :");
                    String[] split = br.readLine().split(" ");
                    if (split.length > 2) {
                        throw new Exception();
                    }else if(Integer.parseInt(split[0])== 0 || Double.parseDouble(split[1]) == 0) {
                        throw new Exception();
                    }
                    else  {
                        if(Math.signum(Integer.parseInt(split[0]))==-1){
                            throw new Exception();
                        }
                        else if(Math.signum(Double.parseDouble(split[1]))==-1){
                            throw new Exception();
                        }
                    }
                    food.add(new FoodComponents(east.getFood(count), Double.parseDouble(split[1]), Integer.parseInt(split[0])));
                    count++;
                    if (count >= east.getFoodSize()) {
                        break;
                    }
                } while (true);
                System.out.println("Optimal Enjoyment :" + east.OptimalEnjoyment(food));
                break;
            } catch (Exception e) {
                System.out.println("Please input properly");
            }
        }
    }
}
