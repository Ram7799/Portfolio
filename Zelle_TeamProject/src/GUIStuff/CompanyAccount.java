package GUIStuff;
import Connections.Client;
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
 * Class that represents the GUI that appears when the user is making a company account
 */
public class CompanyAccount {

    @FXML
    private Button BackButton;

    @FXML
    private TextField CompanyNameText;

    @FXML
    private TextField CompanyIdText;

    @FXML
    private Button SubmittedButton;

    @FXML
    private Label SubmittedLabel;

    @FXML
    private PasswordField PasswordText;

    @FXML
    private PasswordField ConfirmPasswordText;

    private Client client;

    /**
     * Method to redirect the user to the next GUI when the back button is pressed by the user
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
     * Method to redirect the user to the next GUI when the submit button is pressed
     * @param actionEvent action event created by the user pressing the submit button
     */
    public void submitButtonPressed(javafx.event.ActionEvent actionEvent)
    {


        SubmittedLabel.setText("Submitted");
        SubmittedButton.setDisable(true);
    }

    /**
     * Method to set the client that is currently connected
     * @param client current connected client
     */
    public void setClient(Client client) {
        this.client = client;
    }
}
