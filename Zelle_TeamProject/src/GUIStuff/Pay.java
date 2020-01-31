package GUIStuff;
import ClientTransactions.IndividualAcct;
import ClientTransactions.Transaction;
import Connections.Client;
import Connections.Flag;
import Connections.Packet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Class representing the GUI to make a payment
 */
public class Pay  {

    @FXML
    private TextField AmountText;

    @FXML
    private Button PAYButton;

    @FXML
    private Label SENT;

    @FXML
    private Button BackButton;

    @FXML
    private ListView<String> Trans;

    @FXML
    private Label Comment;

    @FXML
    private TextField CommentBox;

    @FXML
    private RadioButton PrivateTrans;

    @FXML
    private TextField sentTo;

    private Client client;

    /**
     * Method that reacts to the user pressing the pay button and communicates to the user that their payment was successful
     * @param actionEvent action even created by the user pressing the pay button
     */
    public void PAY(javafx.event.ActionEvent actionEvent) throws IOException {
        //first we are going to make a transsaction object
        ///then we are going to make packet with payTran match
        //then we are going to send the packet
        //then we are going to wait like bitch
        //then we are going to see what happend
        String sender = this.client.getPerson().getUsername();
        Transaction transaction = new Transaction(Double.parseDouble(AmountText.getText()),CommentBox.getText(),sender,sentTo.getText(),PrivateTrans.isSelected());
        Packet packet = new Packet(transaction,"payTran");
        this.client.sendData(packet);
        this.client.waitForResponse();

        if(this.client.getSharedpacket().getType().equals("Flag")){
            Flag f = this.client.getSharedpacket().getContents(Flag.class);
            SENT.setText(f.getFlag());
        }else{

            SENT.setText("Money sent");
            PAYButton.setDisable(true);

        }

    }

    /**
     * Method to redirect the user to the next GUI when the user presses the back button
     * @param actionEvent action event created by the user pressing the back button
     * @throws IOException exception for input and output errors
     */
    public void BackButtonPressed(javafx.event.ActionEvent actionEvent) throws IOException {
//        System.out.println("ITS working");
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
        temp.setClient(this.client);
        temp.doshit();
    }

    /**
     * Method to set the client that is currently connected
     * @param client currently connected client
     */
    public void setClient(Client client) {
        this.client = client;
    }

//    /**
//     * Method to initialize the GUI
//     * @param url URL to the resource
//     * @param resourceBundle resource information to initialize the GUI
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//    }

    public void doShit(){
        ArrayList<String> privateTrans = new ArrayList<>();
        ArrayList<String> publicTrans = new ArrayList<>();
        ArrayList<Transaction> temp2 = this.client.getPerson().getTranList();
        for(Transaction c : temp2){
            if(c.isPrivateTran()){
                privateTrans.add("Sender :" +  c.getSender() +" Receiver :  "+  c.getReceiver() +" Comment :  " + c.getComment() +" Amount : " + c.getAmount());
            }
            else{
                publicTrans.add("Sender :" +  c.getSender() +" Receiver :  "+  c.getReceiver() +" Comment : " + c.getComment() +" Amount : " + c.getAmount());
            }
        }
        Trans.getItems().addAll(privateTrans);

        //this.client.getSharedpacket().getContents(IndividualAcct.class).getBalance();
    }
}
