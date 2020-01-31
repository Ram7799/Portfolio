package GUIStuff;

import ClientTransactions.Transaction;
import Connections.Client;
import Connections.Packet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class representing the GUI when a payment request is being made
 */
public class Request implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField UserText;

    @FXML
    private TextField AmountText;

    @FXML
    private Button RequestButton;

    @FXML
    private Label REQUESTED;

    @FXML
    private Button BackButton;

    @FXML
    private ListView<String> Trans;

    @FXML
    private TextField CommentText;

    @FXML
    private RadioButton PrivateTransButton;

    private Client client;

    /**
     * Method to redirect the user to the next GUI when the user presses the back button
     * @param actionEvent action event created by the user pressing the back button
     * @throws IOException exception for input and output errors
     */
    public void BackButtonPreessed(javafx.event.ActionEvent actionEvent) throws IOException {
//        Parent Account_page_parent = FXMLLoader.load(getClass().getResource("Account.fxml"));
//        Scene AccountPage_Scene = new Scene(Account_page_parent);
//        Stage app_stage = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
//        app_stage.setScene(AccountPage_Scene);
//        app_stage.show();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Account.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage app_stage = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);


        Account temp = fxmlLoader.<Account>getController();
        temp.setClient(client);
    }

    /**
     * Method that reacts to the request button being pressed and communicates to the user that their request was made successfully
     * @param actionEvent action event created by the user pressing the request button
     */
    public void RequestButtonPressed(javafx.event.ActionEvent actionEvent) throws IOException {

        String requester = this.client.getPerson().getUsername();
        Transaction transaction = new Transaction(Double.parseDouble(AmountText.getText()),CommentText.getText(),UserText.getText(),requester,PrivateTransButton.isSelected());

        Packet packet = new Packet(transaction,"MoneyRequest");
        this.client.sendData(packet);
        this.client.waitForResponse();







        REQUESTED.setText("Requested money" );
        RequestButton.setDisable(true);
    }

    /**
     * Method to set the client that is currently connected
     * @param client current connected client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Method to initialize the GUI
     * @param url URL to the resource
     * @param resourceBundle resource information to initialize the GUI
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] temp  = new String[]{"3","d","34","231","3231","32323","3232","43424","342312"};
        Trans.getItems().addAll(temp);

    }
}
