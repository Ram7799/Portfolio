import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the ThanksGiving class. Used to calculate the optimal enjoyment.
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */
public class ThanksGiving {
    /**Consists of all the food names */
    private String[] food;
    /**Capacity of the stomach */
    private int capacity;

    /**
     * Used to get food at particular index.
     * @param i Its the index.
     * @return A string consisting the name of food at that particular index.
     */
    public String getFood(int i) {
        return food[i];
    }


    /**
     * Used to get the size of food items.
     * @return An interger with the size of food items.
     */
    public int getFoodSize(){
        return food.length;
    }

    /**
     * A two parameter constructor.
     * @param food An array of strings consisting of food names
     * @param capacity Stomach capacity
     */
    public ThanksGiving(String[] food, int capacity){
        this.food = food;
        this.capacity = capacity;
    }


    /**
     * This method is used to calculate optimal enjoyment on the given food items and their volume and enjoyment.
     * @param input An arrayList consisting of FoodComponents Objects.
     * @return An double, which is the optimal enjoyment.
     */
    public double OptimalEnjoyment(ArrayList<FoodComponents> input){
        ArrayList<String> names = new ArrayList<>();
        int MaxWeight =0;
        double OptimalEnjoy =0.0;
        Collections.sort(input);
        int count =input.size()-1;
        while(MaxWeight <= capacity){
            if(MaxWeight== capacity){
                break;
            }
            else if(count<0){
                break;
            }
            else if(capacity -MaxWeight < input.get(count).getVolume()){
                count--;
            }
            else{
                MaxWeight+= input.get(count).getVolume();
                OptimalEnjoy += input.get(count).getEnjoyment();
                names.add(input.get(count).getFoodname());
            }
        }
        Set<String> set = new HashSet<String>(names);
        System.out.println("You would need to eat : ");
        if(set.size() == 0){
            System.out.println("Nothing. Your capacity is smaller than everything");
        }
        else {
            for (String s : set) {
                System.out.println(s + " : " + Collections.frequency(names, s));
            }
        }

        return OptimalEnjoy;
    }

}
