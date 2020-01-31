package GUIStuff;
import Connections.Client;
import Connections.LoginInfo;
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
import java.io.IOException;

/**
 * Class representing the GUI to change the user's account password
 */
public class ChangePass {

    @FXML
    private Button BackButton;

    @FXML
    private PasswordField OldPasswordText;

    @FXML
    private PasswordField NewPasswordText;

    @FXML
    private PasswordField ConfirmNewPasswordText;

    @FXML
    private Button SubmitButton;

    @FXML
    private Label SubmittedLabel;

    private Client client;

    /**
     * Method that reacts to the user submitting their password change and alerts the user that they successfully changed their password
     * @param actionEvent action event created by the user pressing the submit buttong
     */
    public void Submitted(javafx.event.ActionEvent actionEvent) throws IOException {
       // (actionEvent.getSource())
        Packet pay = new Packet(new LoginInfo(this.client.getPerson().getUsername(),OldPasswordText.getText(),NewPasswordText.getText()),"loginInfo");
        if(NewPasswordText.getText().equals(ConfirmNewPasswordText.getText())) {
            this.client.sendData(pay);
            this.client.waitForResponse();
            SubmittedLabel.setText("Password Changed");
            SubmitButton.setDisable(true);
        } else{
            SubmittedLabel.setText("Make sure you type in the Password right for both the fields.");
        }
    }

    /**
     * Method to redirect the user to the next GUI when the user presses the back button
     * @param actionEvent action event created by the user pressing hte back button
     * @throws IOException exception for input and output errors
     */
    public void BackButtonPressed(javafx.event.ActionEvent actionEvent) throws IOException {
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
        temp.doshit();

    }

    /**
     * Method to set the client that is currently connected
     * @param client current connected client
     */
    public void setClient(Client client) {
        this.client = client;
    }
}
