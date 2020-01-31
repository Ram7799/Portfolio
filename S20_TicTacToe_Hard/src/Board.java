/**
 * This is the board class; consists of the Tic Tac Toe board.
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */
public class Board {
    /**
     * Keeps track of the current state of the board
     */
    private char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * Used to print out the board
     */
    public void printBoard() {
        System.out.println("\t\t   |   |   ");
        System.out.println("\t\t  " + board[0] + "| " + board[1] + " | " + board[2]);
        System.out.println("\t\t___|___|___");
        System.out.println("\t\t   |   |   ");
        System.out.println("\t\t  " + board[3] + "| " + board[4] + " | " + board[5]);
        System.out.println("\t\t___|___|___");
        System.out.println("\t\t   |   |   ");
        System.out.println("\t\t  " + board[6] + "| " + board[7] + " | " + board[8]);
        System.out.println("\t\t   |   |   ");
    }

    //to check if the board is full

    /**
     * To check if the board is ful;
     * @return A boolean. true if the board is full,else false.
     */
    public boolean IsBoardFull() {
        for (char c : board) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Used to see if the current state of the board has any win combination
     * @return A boolean. True if there is a win combination,else false.
     */

    public boolean isWin() {
        //To check the Rows
        if (board[0] == board[1] && board[1] == board[2] || board[3] == board[4] && board[4] == board[5] || board[6] == board[7] && board[7] == board[8]) {
            return true;
        }
        //To check the Columns
        else if (board[0] == board[3] && board[3] == board[6] || board[1] == board[4] && board[4] == board[7] || board[2] == board[5] && board[5] == board[8]) {
            return true;
        }
        //Check the diagonals
        else return board[0] == board[4] && board[4] == board[8] || board[2] == board[4] && board[4] == board[6];
    }

    /**
     * Used to validate the move of the player
     * @param choice The choice the player made in the board
     * @param XorO The players Symbol
     * @return A boolean. True if its a valid move, else false.
     */
    public boolean isValidate(int choice, char XorO) {
        if(!IsBoardFull()) {
            if (choice > 0 && choice <= 9) {
                if (Character.isDigit(board[choice - 1])) {
                    board[choice - 1] = XorO;
                    return true;
                }
            }
        }
        return false;
    }



}
