/**
 * This class is used to create objects of food items. which consist of Name of the food, enjoyment, volume, and Ratio
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */
public class FoodComponents implements Comparable {
    /** Name of the food*/
    private String foodname;
    /**Enjoyment from the food */
    private double enjoyment;
    /**Volume of the food */
    private int volume;
    /**Enjoyment to volume ratio */
    private double Ratio;

    /**
     * A three parameter constructor.
     * @param name Name of the food
     * @param enjoy Enjoyment from the food
     * @param vol Volume of the food
     */
    public FoodComponents(String name,double enjoy,int vol){
        this.enjoyment=enjoy;
        this.foodname = name;
        this.volume= vol;
        this.Ratio = enjoy/vol;
    }

    /**
     * Used to get the name of the food
     * @return A string consisting of the food name
     */
    public String getFoodname() {
        return foodname;
    }

    /**
     * Used to get the enjoyment of the food
     * @return A double consisting of enjoyment of the food.
     */
    public double getEnjoyment() {
        return enjoyment;
    }

    /**
     * used to get the volume of the food
     * @return An int consisting of volume of food.
     */
    public int getVolume() {
        return volume;
    }

    /**
     * An overridden compareTo method, which compares the ratios of the food objects. used to sort the Food objects by Ratio
     * @param o An object which this is beaing compared to
     * @return An int if its strue or not.
     */
    @Override
    public int compareTo(Object o)
    {
        return Double.compare(this.Ratio, ((FoodComponents) o).Ratio);
    }
}
