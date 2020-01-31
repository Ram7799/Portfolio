package Connections;

/**
 * Class to run the server to communicate between the client and the database
 */
public class TestSERVER {

    public static void main(String args[]){
        Server testServer = new Server();
        testServer.runServer();
    }
}
