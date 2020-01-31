import java.util.Scanner;

/**
 * This is the driver class for the whole game.
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */

public class PlayDriver {
    /**
     * It prints out options so that the user can choose a game mode.
     * @param args Arguments to the Main method.
     */
    public static void main(String[] args) {
        while(true) {
            try {
                System.out.println("Please choose the mode of play(just type in the number)");
                System.out.println("1. One Human vs One computer");
                System.out.println("2. Two Human Players");
                System.out.println("3. Two Computer Players");
                Scanner scan = new Scanner(System.in);
                int choice = scan.nextInt();
                while (true) {
                    if (choice == 1 || choice == 2 || choice == 3) {
                        break;
                    } else {
                        System.out.println("Please choose the mode of play(just type in the number)");
                        System.out.println("1. One Human vs One computer");
                        System.out.println("2. Two Human Players");
                        System.out.println("3. Two Computer Players");
                        scan = new Scanner(System.in);
                        choice = scan.nextInt();
                    }
                }
                Play Game = new Play();
                Game.Choose(choice);
                break;

            }catch (Exception e){
                System.out.println("Please choose between 1,2,3");
            }
        }
    }
}
