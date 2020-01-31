package GUIStuff;
import ClientTransactions.IndividualAcct;
import ClientTransactions.Transaction;
import Connections.Client;
import Connections.Packet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Class representing the GUI that shows the user their account page
 */
public class Account {

    private Client client;

    /**
     * Method to set the client that is currently connected
     * @param client currently connected client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    private Button PayButton;

    @FXML
    private Button RequestButton;

    @FXML
    private Button LogoutButton;

    @FXML
    private Button BackButton;

    @FXML
    private Button AccountSettings;

    @FXML
    private ListView<String> publicTrans;

    @FXML
    private ListView<String> Trans;

    @FXML
    private Label HelloUser;


    /**
     * Method to redirect the user to the next GUI when the user presses the account settings button
     * @param actionEvent action event created by the user pressing the account settings button
     * @throws IOException exception for input and output errors
     */
    public void AccountSettingsPressed(javafx.event.ActionEvent actionEvent) throws IOException{
//        Parent Account_page_parent = FXMLLoader.load(getClass().getResource("ChangePass.fxml"));
//        Scene AccountPage_Scene = new Scene(Account_page_parent);
//        Stage app_stage = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
//        app_stage.setScene(AccountPage_Scene);
//        app_stage.show();


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChangePass.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage app_stage = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);


        ChangePass temp = fxmlLoader.<ChangePass>getController();
        temp.setClient(client);

    }

    /**
     * Method to redirect the user to the next GUI when the user presses the log out button
     * @param actionEvent action event created by the user pressing the log out button
     * @throws IOException exception for input and output errors
     */
    public void LogOutButtonPressed(javafx.event.ActionEvent actionEvent) throws IOException {
//        Parent Account_page_parent = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
//        Scene AccountPage_Scene = new Scene(Account_page_parent);
//        Stage app_stage = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
//        app_stage.setScene(AccountPage_Scene);
//        app_stage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage app_stage = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);


        SignIn temp = fxmlLoader.<SignIn>getController();
        temp.setClient(client);


    }

    /**
     * Method to redirect the user to the next GUI when the user presses the back button
     * @param e action event created by the user pressing the back button
     * @throws IOException exception for input and output errors
     */
    public void BackButtonPressed(ActionEvent e) throws IOException {
//        Parent Account_page_parent = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
//        Scene AccountPage_Scene = new Scene(Account_page_parent);
//        Stage app_stage = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();
//        app_stage.setScene(AccountPage_Scene);
//        app_stage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage app_stage = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();
        app_stage.setScene(scene);


        SignIn temp = fxmlLoader.<SignIn>getController();
        temp.setClient(client);



    }

    /**
     * Method to redirect the user to the next GUI when the user presses the pay button
     * @param actionEvent action event created by the user pressing the pay button
     * @throws IOException exception for input and output errors
     */
    public void buttonPressed(ActionEvent actionEvent) throws IOException {
//        Parent Account_page_parent = FXMLLoader.load(getClass().getResource("Pay.fxml"));
//        Scene AccountPage_Scene = new Scene(Account_page_parent);
//        Stage app_stage = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();
//        app_stage.setScene(AccountPage_Scene);
//        app_stage.show();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Pay.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage app_stage = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        Pay temp = fxmlLoader.<Pay>getController();
        temp.setClient (client);
        temp.doShit();
    }

    /**
     * Method to redirect the user to the next GUI when the user presses the request button
     * @param actionEvent action event created by the user pressing the request button
     * @throws IOException exception for input and output errors
     */
    public void RequestButtonPressed(ActionEvent actionEvent) throws IOException {
//        Parent Account_page_parent = FXMLLoader.load(getClass().getResource("Request.fxml"));
//        Scene AccountPage_Scene = new Scene(Account_page_parent);
//        Stage app_stage = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();
//        app_stage.setScene(AccountPage_Scene);
//        app_stage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Request.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage app_stage = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);


        Request temp = fxmlLoader.<Request>getController();
        temp.setClient(client);

    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {}


    public void doshit(){
        Packet account = this.client.getSharedpacket();
        HelloUser.setText("Hello " + account.getContents(IndividualAcct.class).getFirstName());
        ArrayList<String> privateTrans2 = new ArrayList<>();
        ArrayList<String> publicTrans = new ArrayList<>();
        ArrayList<Transaction> temp2 = this.client.getPerson().getTranList();
        for(Transaction c : temp2){
            if(c.isPrivateTran()){
                privateTrans2.add("Sender : " +  c.getSender() +" Receiver :  "+  c.getReceiver() +" Comment :  " + c.getComment() +" Amount : " + c.getAmount());
            }
            else{
                publicTrans.add("Sender :" +  c.getSender() +" Receiver :  "+  c.getReceiver() +" Comment : " + c.getComment() +" Amount : " + c.getAmount());
            }
        }
        Trans.getItems().addAll(privateTrans2);
        this.publicTrans.getItems().addAll(publicTrans);

    }
}
