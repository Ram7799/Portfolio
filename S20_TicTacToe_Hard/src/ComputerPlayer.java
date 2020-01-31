import java.util.Random;

/**
 * This is the computer player. This is all automatic.
 * It extends the Player
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */

public class ComputerPlayer extends Player {
    /**
     * This is a single parameter constructor.
     * @param option The players symbol.
     */
        public ComputerPlayer(char option) {
            super(option);
        }

    /**
     * This is the computer overridden makeMove.
     * @param temp The Board in which the game is taking place
     * @throws InterruptedException This used a thread to slow down the process.
     */
    @Override
        public void makeMove(Board temp) throws InterruptedException {
            Thread.sleep(1200);
            Random rand = new Random();
            while(true){
                int i = rand.nextInt(9) +1;
                if(temp.isValidate(i,this.getXorO())){
                    System.out.println( "\u001B[33m"+ "Computer Chose : " + i  + "\u001B[0m");
                    break;
                }
            }
            temp.printBoard();
        }
    }
