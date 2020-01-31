import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the JUNIT tests for linked list
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */
class ListTest {
    /**Creating a new list */
    List Test = new List();
    /** This is the first test to test the addAtposition*/
    @Test
    public void LinkedListTest1(){
        Test.addAtPosition(4,0);
        System.out.println("After adding element at 0");
        Test.print();
        Test.insertAtBack(5);
        System.out.println("After inserting at back");
        Test.print();
        Test.addAtPosition(8,1);
        System.out.println("After inserting at 1");
        Test.print();
        assertEquals(8,Test.get(1));
    }

    /** This is the second test to test the addAtposition*/
    @Test
    public void LinkedListTest2(){
        Test.addAtPosition(4,0);
        Test.insertAtBack(5);
        System.out.println("after inserting at 0 and back");
        Test.print();
        Test.addAtPosition(8,1);
        Test.insertAtFront(16);
        Test.addAtPosition(77,3);
        System.out.println("After adding at 1,front and 3");
        Test.print();
        assertEquals(77,Test.get(3));
        assertEquals(8,Test.get(2));
    }
    /** This is the third test to test the addAtposition*/
    @Test
    public void LinkedListTest3(){
        Test.addAtPosition(15,0);
        Test.addAtPosition(23,0);
        Test.addAtPosition(35,1);
        System.out.println("After adding at 0,0,1");
        Test.print();
        assertEquals(35,Test.get(1));
    }
    /** This is the fourth test to test the addAtposition*/
    @Test
    public void LinkedListTest4(){
        Test.addAtPosition(3,0);
        Test.addAtPosition(23,1);
        Test.addAtPosition(45,0);
        Test.insertAtBack(69);
        Test.addAtPosition(77,4);
        System.out.println("After adding at 0,1,0,Back,4");
        Test.print();
        assertEquals(77,Test.get(4));
    }
    /** This is the fifth test to test the addAtposition*/
    @Test
    public void LinkedListTest5(){
        Test.addAtPosition(15,0);
        Test.insertAtFront(24);
        Test.insertAtFront(23);
        Test.addAtPosition(37,2);
        System.out.println("After adding at 0,Front,Front,2");
        Test.print();
        assertEquals(37,Test.get(2));
    }
    /** This is the sixth test to test the addAtposition and removeFromPosition*/
    @Test
    public void LinkedListTest6(){
        Test.addAtPosition(2,0);
        Test.addAtPosition(23,1);
        Test.addAtPosition(45,2);
        System.out.println("Before Removing");
        Test.print();
        Test.removeFromPostiton(1);
        System.out.println("After Removed element at position 1");
        Test.print();
        assertEquals(45,Test.get(1));
    }
    /** This is the seventh test to test the addAtposition and removeFromPosition*/
    @Test
    public void LinkedListTest7(){
        Test.addAtPosition(5,0);
        Test.addAtPosition(68,1);
        Test.addAtPosition(24,2);
        System.out.println("Before Removing");
        Test.print();
        Test.removeFromPostiton(1);
        System.out.println("After Removed element at position 1");
        Test.print();
        assertEquals(24,Test.get(1));
        Test.removeFromPostiton(0);
        System.out.println("After removing element at 0");
        assertEquals(24,Test.get(0));
    }

    /** This is the eighth test to test the addAtposition and removeFromPosition*/

    @Test
    public void LinkedListTest8(){
        Test.addAtPosition(15,0);
        Test.insertAtFront(2);
        Test.insertAtBack(45);
        Test.insertAtFront(57);
        Test.addAtPosition(67,2);
        Test.print();
        assertEquals(15,Test.removeFromPostiton(3));
        System.out.println("After removing from postion 3");
        Test.print();
    }
    /** This is the ninth test to test the addAtposition and removeFromPosition*/

    @Test
    public void LinkedListTest9(){
        Test.addAtPosition(15,0);
        Test.insertAtFront(2);
        Test.insertAtBack(45);
        Test.insertAtFront(57);
        Test.addAtPosition(67,2);
        assertEquals(45,Test.removeFromPostiton(4));
        System.out.println("After removing from the back");
        Test.print();
    }
    /** This is the eleventh test to test the addAtposition and removeFromPosition*/

    @Test
    public void LinkedListTest10(){
        Test.addAtPosition(15,0);
        Test.insertAtFront(2);
        Test.insertAtBack(45);
        Test.insertAtFront(57);
        Test.addAtPosition(67,2);
        Test.print();
        Test.removeFromPostiton(0);
        System.out.println("after removing from 0");
        Test.print();
        assertEquals(2,Test.get(0));
    }

    /** This is the twelfth test to test the addAtposition and removeFromPosition*/
    @Test
    public void LinkedListTest11() {
        Test.insertAtFront(24);
        Test.addAtPosition(77,0);
        Test.addAtPosition(900,1);
        Test.print();
        Test.removeFromPostiton(2);
        System.out.println("After removing from position 2");
        Test.print();
        Test.addAtPosition(87,2);
        System.out.println("Adding at postion 2");
        Test.print();
        assertEquals(87,Test.get(2));
    }
    /** This is the thirteenth test to test the addAtposition and removeFromPosition*/

    @Test
    public void LinkedListTest12(){
        Test.insertAtFront(24);
        Test.addAtPosition(77,0);
        Test.insertAtFront(57);
        Test.addAtPosition(67,2);
        Test.insertAtFront(2);
        Test.insertAtBack(45);
        System.out.println("List after adding at front,0,front,2,front,back");
        Test.print();
        Test.removeFromPostiton(3);
        System.out.println("List after removing element at position 3");
        Test.print();

        assertEquals(24,Test.get(3));
    }


}