package GUIStuff;

import Connections.Client;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Class that runs the GUIs and creates a client connection to communicate the information entered into the GUI to the server
 */
public class Main extends Application {
    private Client client;

    /**
     * Method to get the client connection
     * @return client connection
     */
    public Client getClient() {
        return client;
    }

    /**
     * Method to launch the JavaFX
     * @param args arguments to be launched
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Method to start the JavaFX GUI system
     * @param primaryStage primary stage of the JavaFX GUI
     * @throws IOException exception for input and output errors
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        client = new Client("localhost");
        client.runClient();

        SignIn temp = fxmlLoader.<SignIn>getController();
        temp.setClient (client);
    }
}
