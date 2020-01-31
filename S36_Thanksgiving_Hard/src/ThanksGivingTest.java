import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the JUNIT test cases for the given tests in the assignment.
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */
class ThanksGivingTest {
    /** Test 1 which is the same one as first test from assignment*/
    @Test
    public void OptimalEnjoyment1(){
        ThanksGiving Test  = new ThanksGiving(new String[]{"Turkey", "Pie", "Potatoes", "Gravy", "stuffing","Cranberries","Casserole"},20);
        ArrayList<FoodComponents> temp = new ArrayList<>(Arrays.asList(new FoodComponents("Turkey",4,3),new FoodComponents("Pie",2,2),new FoodComponents("Potatoes",5,4),new FoodComponents("Gravy",10,10),new FoodComponents("Stuffing",3,2),new FoodComponents("Cranberries",5,7), new FoodComponents("Casserole",17,12)));
        assertEquals(30,Test.OptimalEnjoyment(temp));
    }

    /** Test 2 which is the same one as second test from assignment*/
    @Test
    public void OptimalEnjoyment2(){
        ThanksGiving Test  = new ThanksGiving(new String[]{"Turkey", "Pie", "Potatoes", "Gravy", "stuffing","Cranberries","Casserole"},41);
        ArrayList<FoodComponents> temp = new ArrayList<>(Arrays.asList(new FoodComponents("Turkey",4,3),new FoodComponents("Pie",2,2),new FoodComponents("Potatoes",5,4),new FoodComponents("Gravy",1,1),new FoodComponents("Stuffing",3,2),new FoodComponents("Cranberries",14,10), new FoodComponents("Casserole",24,15)));
        assertEquals(64,Test.OptimalEnjoyment(temp));
    }
    /** Test 3 which is the same one as third test from assignment*/
    @Test
    public void OptimalEnjoyment3(){
        ThanksGiving Test  = new ThanksGiving(new String[]{"Turkey", "Pie", "Potatoes", "Gravy", "stuffing","Cranberries","Casserole"},7);
        ArrayList<FoodComponents> temp = new ArrayList<>(Arrays.asList(new FoodComponents("Turkey",5,3),new FoodComponents("Pie",12,4),new FoodComponents("Potatoes",1,1),new FoodComponents("Gravy",5,2),new FoodComponents("Stuffing",1,1),new FoodComponents("Cranberries",2,2), new FoodComponents("Casserole",3,3)));
        assertEquals(18,Test.OptimalEnjoyment(temp));
    }
    /** Test 4 which is the same one as fourth test from assignment*/
    @Test
    public void OptimalEnjoyment4(){
        ThanksGiving Test  = new ThanksGiving(new String[]{"Turkey", "Pie", "Potatoes", "Gravy", "stuffing","Cranberries","Casserole"},9);
        ArrayList<FoodComponents> temp = new ArrayList<>(Arrays.asList(new FoodComponents("Turkey",6,3),new FoodComponents("Pie",9,4),new FoodComponents("Potatoes",0.5,1),new FoodComponents("Gravy",4,2),new FoodComponents("Stuffing",1,1),new FoodComponents("Cranberries",2,2), new FoodComponents("Casserole",3,3)));
        assertEquals(19,Test.OptimalEnjoyment(temp));
    }
    /** Test 5 which is the same one as fifth test from assignment*/
    @Test
    public void OptimalEnjoyment5(){
        ThanksGiving Test  = new ThanksGiving(new String[]{"Turkey", "Pie", "Potatoes", "Gravy", "stuffing","Cranberries","Casserole"},5);
        ArrayList<FoodComponents> temp = new ArrayList<>(Arrays.asList(new FoodComponents("Turkey",7,6),new FoodComponents("Pie",8,7),new FoodComponents("Potatoes",9,8),new FoodComponents("Gravy",10,9),new FoodComponents("Stuffing",11,10),new FoodComponents("Cranberries",12,11), new FoodComponents("Casserole",13,12)));
        assertEquals(0,Test.OptimalEnjoyment(temp));
    }

}