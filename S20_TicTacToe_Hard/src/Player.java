/**
 * An Abstract class of player.
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */
public abstract class Player {
    /**
     * Players symbol
     */
   private final char XorO ;

    /**
     * used to get the players symbol
     * @return
     */
    public char getXorO() {
        return XorO;
    }

    /**
     * Initialzing the objects symbol with the given symbol.
     * @param option
     */
    public Player(char option)
    {
        XorO = option;
    }

    /**
     * Skeleton of makeMove method.
     * @param temp Object of the board
     * @throws InterruptedException Since we are using a thread.
     */
    public void makeMove(Board temp) throws InterruptedException {

    }
}
