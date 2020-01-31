/**
 * This is the play class. It handles creating players on the chosen mode of the game.
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */
public class Play {
    /**
     * It created the players and the board to play the game on.
     * @param choice The choice of the game mode.
     * @throws InterruptedException Since it uses a thread.
     */
    public void Choose(int choice) throws InterruptedException {
        Player player1;
        Player player2;
        Board Board1 = new Board();
        Board1.printBoard();
        if(choice == 1) {
            player1 = new HumanPlayer('X');
            player2 = new ComputerPlayer('O');
            System.out.println("Player 2, you are "+ player2.getXorO());
            System.out.println("Player 1, you are "+ player1.getXorO());
        }
        else if(choice  == 2){
            player1 = new HumanPlayer('O');
            System.out.println("Player 1, you are "+ player1.getXorO());
            player2 = new HumanPlayer('X');
            System.out.println("Player 2, you are "+ player2.getXorO());

        }
        else {
            player1 = new ComputerPlayer('X');
            System.out.println("player 1. You are " + player1.getXorO());
            player2 = new ComputerPlayer('O');
            System.out.println("Player 2. You are "+ player2.getXorO());
        }
        while(!Board1.isWin() || Board1.IsBoardFull()){
            System.out.println("Player 1 turn");
            player1.makeMove(Board1);
            if(Board1.isWin()){
                System.out.println("Player 1 wins");
                break;
            }
            else if(Board1.IsBoardFull()){
                System.out.println("It's a TIE");
                break;
            }
            System.out.println("Player 2 turn");
            player2.makeMove(Board1);
            if(Board1.isWin()){
                System.out.println("Player 2 Wins");
                break;
            }
            else if(Board1.IsBoardFull()){
                System.out.println("It's a TIE");
                break;
            }
        }
    }
}
