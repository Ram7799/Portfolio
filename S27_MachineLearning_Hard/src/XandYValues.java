/**
 * This class is used to store the x and y values of the data points and clusters.
 * This is used to assign the data point to an owner cluster.
 * @author Ram Sajja
 * @version 1.0,10/11/2019
 */
public class XandYValues {
    /** This variable stores the X-coordinate*/
    private double X = 0;
    /** This variable stores the Y-Coordinate*/
    private double Y =0;
    /** This variable stores the Owner Cluster value*/
    private int Owner_Cluster = 0;

    /**
     * A two-parameter Constructor which takes the X and Y coordinates.
     * @param x Its the X-coordinate
     * @param y Its the Y-coordinate
     */
    XandYValues(double x,double y){
        this.X=x;
        this.Y=y;
    }

    /**
     * A getter to get the Y-coordinate
     * @return A double;which is the Y-coordinate.
     */
    public double getY() {
        return Y;
    }

    /**
     * A getter to get the X-coordinate
     * @return A double; which is the X-coordinate
     */
    public double getX() {
        return X;
    }

    /**
     * A setter which sets the Y-coordinate
     * @param y which is the value you set the Y-coordinate to.
     */
    public void setY(double y) {
        Y = y;
    }

    /**
     * A setter which sets the X-coordinate
     * @param x which is the value you set the X-coordinate to.
     */
    public void setX(double x) {
        X = x;
    }

    /**
     * A getter to get the Owner Cluster for the given data point
     * @return An Int, which is the owner cluster.
     */
    public int getOwner_Cluster() {
        return Owner_Cluster;
    }

    /**
     * A setter to set the owner cluster for the given data point.
     * @param owner_Cluster To change the present owner cluster to the given one
     */
    public void setOwner_Cluster(int owner_Cluster) {
        Owner_Cluster = owner_Cluster;
    }




}
