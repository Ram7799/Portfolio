package GUIStuff;
import Connections.Client;
import Connections.Flag;
import Connections.LoginInfo;
import Connections.Packet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class representing the sign in page when the user first starts the program to log in to an account
 */
public class SignIn implements Initializable {
    private Client client;

    /**
     * Method to set the client that is currently connected
     * @param client current connected client
     */
    public void setClient(Client client){

        this.client = client;
    }

    @FXML
    private TextField UserId;

    @FXML
    private Button SignIn;

    @FXML
    private Button CreateAccount;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label InvalidLabel;

    @FXML
    private TextField StartingBalanceText;

    /**
     * Method to initialize the GUI
     * @param url URL to the resource
     * @param resourceBundle resource information to initialize the GUI
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Method that sends the user ID entered by the user
     * @return the user's user ID
     */
    public String send(){
        return UserId.getText();
    }

    /**
     * Method to redirect the user to the next GUI when the user presses the sign in button
     * @param actionEvent action event created by the user pressing the sign in button
     * @throws IOException exception for input and output errors
     */
    public void SignInButton(javafx.event.ActionEvent actionEvent) throws IOException {
//        Parent Account_page_parent = FXMLLoader.load(getClass().getResource("Account.fxml"));
//        Scene AccountPage_Scene = new Scene(Account_page_parent);
//        Stage app_stage = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
//
//        app_stage.setScene(AccountPage_Scene);
//        app_stage.show();


        //wait until result this flag will be updated when client processes this once processed then can move forward


        //info it will be in the form of a packet
        //then check type
        /// just do if(client.good()) move to account
        //else say bad login in info

        Packet p = new Packet(new LoginInfo(UserId.getText(),passwordField.getText()),"loginInfo");
        client.sendData(p);
        this.client.waitForResponse();

        if(this.client.getSharedpacket().getType().equals("Client")) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Account.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage app_stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            Account temp = fxmlLoader.<Account>getController();
            temp.setClient(client);
            temp.doshit();

        }else{
            //this where you would do the flag
            //Flag f = this.client.getSharedpacket().getContents(Flag.class)
            Flag f = this.client.getSharedpacket().getContents(Flag.class);
            InvalidLabel.setText(f.getFlag());
        }
    }

    /**
     * Method to redirect the user to the next GUI when the user presses the create account button
     * @param actionEvent action event created by the user pressing the create account button
     * @throws IOException exception for input and output errors
     */
    public void CreateAccountButton(javafx.event.ActionEvent actionEvent) throws IOException {
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
        temp.setClient (client);
    }
}