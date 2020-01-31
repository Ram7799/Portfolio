import java.util.Scanner;

/**
 * This is a driver class for Easter
 * @author Ram Sajja
 * @version 1.0, 10/11/2019
 */
public class EasterDriver {
    /**
     * Used to take the user input.
     * @param args Arguments for the main method.
     */
    public static void main(String[] args) {
        System.out.println("Enter Year : ");
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();
        Easter e = new Easter(year);
    }
}
