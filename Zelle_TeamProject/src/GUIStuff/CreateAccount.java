package GUIStuff;
import ClientTransactions.ClientAcct;
import ClientTransactions.IndividualAcct;
import Connections.Client;
import Connections.Flag;
import Connections.Packet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Class representing the GUI to create a new account
 */
public class CreateAccount {
    private Client client;
    @FXML
    private TextField FirstNameText;

    @FXML
    private TextField LastNameText;

    @FXML
    private TextField UserIdText;

    @FXML
    private Button SubmitButton;

    @FXML
    private Label SubmittedLabel;

    @FXML
    private Button BackButton;

    @FXML
    private PasswordField PasswordText;

    @FXML
    private TextField StartingBalanceText;

    @FXML
    private PasswordField ConfirmPasswordText;

    /**
     * Method to redirect the user to the next GUI when the user presses the back button
     * @param actionEvent action event created by the user pressing the back button
     * @throws IOException exception for input and output errors
     */
    public void BackButtonPressed(javafx.event.ActionEvent actionEvent) throws IOException {
//        Parent Account_page_parent = FXMLLoader.load(getClass().getResource("Type.fxml"));
//        Scene AccountPage_Scene = new Scene(Account_page_parent);
//        Stage app_stage = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
//        app_stage.setScene(AccountPage_Scene);
//        app_stage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Type.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage app_stage = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);


        Type temp = fxmlLoader.<Type>getController();
        temp.setClient(client);

    }

    /**
     * Method to redirect the user to the next GUI when the user presses the submit button
     * @param actionEvent action event created by the user pressing the submit button
     * @throws IOException exception for input and output errors
     */
    public void submitButtonPressed(javafx.event.ActionEvent actionEvent) throws IOException
    {
        //TODO need to add the action for telling the server to create a new account
        // match string is {createIndividualAccount}
        // and it would be great to send a packet of info i will do it

        ClientAcct account = new IndividualAcct(FirstNameText.getText(),LastNameText.getText(),UserIdText.getText(), PasswordText.getText(),Double.parseDouble(StartingBalanceText.getText()));
        this.client.sendData(new Packet(account,"createIndividualAccount"));
        SubmittedLabel.setText("Submitted, processing request");
        this.client.waitForResponse();

        //good result is "accountCreated" and person will be sent then
        if(!this.client.getSharedpacket().getType().equals("Flag")){
            SubmittedLabel.setText("Account Created!");
            SubmitButton.setDisable(true);
        }else{
            Flag flag = this.client.getSharedpacket().getContents(Flag.class);
            SubmittedLabel.setText(flag.getFlag());
        }


    }

    /**
     * Method to set the client that is currently connected
     * @param client currently connected client
     */
    public void setClient(Client client) {
        this.client = client;

    }
}
