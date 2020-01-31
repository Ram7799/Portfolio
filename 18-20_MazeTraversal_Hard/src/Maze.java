/**
 * This class is used to traverse any given maze
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */

public class Maze {

    /** This is a temporary variable used to keep track of recursive calls*/
    private int count=0;

    /**
     * This is a recursive method used to solve the maze.
     * @param given This is a 2d character array with the nodes of the maze
     * @param x  The position x
     * @param y The postition y
     * @throws InterruptedException Used when the Thread stops working for some reason
     */
    public void mazeTraversal(char[][] given, int x, int y) throws InterruptedException {
        count++;
        if(count==1){
            given[x][y] = 'X';
        }
        for (int k = 0; k < 12; k++) {      // used to print out the board and comment this out if you wanna every move and take the thread.sleep
            for (int l = 0; l < 12; l++) {
                System.out.print(given[k][l] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------");
        Thread.sleep(1200);   // to make the code run slower
        System.out.println("I'm Thinking HARD");
        if(isFull(given)){    // checking if the maze is full and yet not found a route
            System.out.println("The maze is Full. Hence Unsolvable");
            return;
        }

        try {
            if (given[x + 1][y] == '.') {    // check one position to the right
                given[x + 1][y] = 'X';
                mazeTraversal(given, x + 1, y);
            } else if (given[x][y + 1] == '.') {  // one to the top
                given[x][y + 1] = 'X';
                mazeTraversal(given, x, y + 1);
            } else if (given[x - 1][y] == '.') {   // one to the left
                given[x - 1][y] = 'X';
                mazeTraversal(given, x - 1, y);
            } else if (given[x][y - 1] == '.') {  // one to the bottom
                given[x][y - 1] = 'X';
                mazeTraversal(given, x, y - 1);
            } else {    // going back if the route takes has a dead end
                given[x][y] = '0';
                if (given[x][y - 1] == 'X') {
                    given[x][y] = '0';
                    mazeTraversal(given, x, y - 1);
                } else if (given[x - 1][y] == 'X') {
                    given[x][y] = '0';
                    mazeTraversal(given, x - 1, y);
                } else if (given[x + 1][y] == 'X') {
                    given[x][y] = '0';
                    mazeTraversal(given, x + 1, y);
                } else if (given[x][y + 1] == 'X') {
                    given[x][y] = '0';
                    mazeTraversal(given, x, y + 1);
                }
            }
        }catch (Exception e){
            System.out.println("You found a route");
            for (int k = 0; k < 12; k++) {      // used to print out the final path taken.
                for (int l = 0; l < 12; l++) {
                    if(given[k][l] == '0') {
                        given[k][l] = '.';
                    }
                    System.out.print(given[k][l] + " ");
                }
                System.out.println();
            }

        }
    }


    /**
     * This method is used to check if the maze is full
     * @param temp This is current position of the maze
     * @return Returns a boolean; if the maze is full or not.
     */
    private boolean isFull(char[][] temp){
        for(int i=0;i<12;i++){
            for(int j=0;j<12;j++){
                if(temp[i][j] == '.'){
                    return false;
                }
            }
        }
        return true;
    }

}
