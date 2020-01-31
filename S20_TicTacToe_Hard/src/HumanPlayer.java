import java.util.Scanner;

/**
 * This is the Human player. It gets input from the user for every move.
 * This class extends Player.
 */
public class HumanPlayer extends Player {
    /**
     * Its a single parameter constructor.
     * @param option The players symbol
     * @author Ram Sajja
     * @version  1.0/11/21/2019
     */
    public HumanPlayer(char option) {
        super(option);
    }

    /**
     * This is the Human player's overridden makeMove method.
     * It takes input from the user for every move they wanna make
     * @param temp The Board in which the game is taking place
     */
    @Override
    public void makeMove(Board temp){
        while(true) {
            try {
                System.out.println("Please make a move(1-9)");
                Scanner scan = new Scanner(System.in);
                int choice = scan.nextInt();
                if (temp.isValidate(choice, this.getXorO())) {
                    temp.printBoard();
                    return;
                } else {
                    System.out.println("Invalid Input");
                }
            }catch (Exception e){
                System.out.println("Invalid Input");}
        }
    }
}
