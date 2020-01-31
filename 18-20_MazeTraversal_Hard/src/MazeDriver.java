/**
 * This is a Driver class; to run the Maze.
 * @author Ram Sajja
 * @version  1.0/11/21/2019
 */
public class MazeDriver {
    /**
     * It creates the maze given in the textbook; and used as an example
     * @param args Main Method arguments
     * @throws InterruptedException Useful when using a thread
     */
    public static void main(String[] args) throws InterruptedException {
        char[][] maze = new char[12][12];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                maze[i][j] = '#';
            }
        }
        maze[1][1] = maze[1][2] = maze[1][3] = maze[1][5] = maze[1][6] = maze[1][7] = maze[1][8] = maze[1][9] = maze[1][10] = '.';
        maze[2][0] = maze[2][1] = maze[2][3] = maze[2][5] = maze[2][10] = '.';
        maze[3][3] = maze[3][5] = maze[3][6] = maze[3][7] = maze[3][8] = maze[3][10] = '.';
        maze[4][1] = maze[4][2] = maze[4][3] = maze[4][4] = maze[4][8] = maze[4][10] = maze[4][11] = '.';
        maze[5][4] = maze[5][6] = maze[5][8] = maze[5][10] = '.';
        maze[6][1] = maze[6][2] = maze[6][4] = maze[6][6] = maze[6][8] = maze[6][10] = '.';
        maze[7][2] = maze[7][4] = maze[7][6] = maze[7][8] = maze[7][2] = maze[7][10] = '.';
        maze[8][1] = maze[8][2] = maze[8][3] = maze[8][4] = maze[8][5] = maze[8][6] = maze[8][7] = maze[8][8] = maze[8][10] = '.';
        maze[9][6] = maze[9][10] = '.';
        maze[10][1] = maze[10][2] = maze[10][3] = maze[10][4] = maze[10][5] = maze[10][6] = maze[10][8] = maze[10][9] = maze[10][10] = '.';
        Maze Test = new Maze();
        Test.mazeTraversal(maze,2,0);

    }
}
