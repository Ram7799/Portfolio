package GUIStuff;
import Connections.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Class representing the GUI that appears when the user is creating an account and needs to specify which
 * type of account to create (company or individual)
 */
public class Type {

    private Client client;

    /**
     * Method that sets the client that is connected currently
     * @param client current connected client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    private Button BackButton;

    @FXML
    private Button IndividualButton;

    @FXML
    private Button CompanyButton;

    /**
     * Method to redirect the user to the next GUI when the user presses the button to make an individual account
     * @param actionEvent action event created by the user pressing the individual button
     * @throws IOException exception for input and output errors
     */
    public void IndividualButtonPressed(javafx.event.ActionEvent actionEvent) throws IOException{
//        Parent Account_page_parent = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
//        Scene AccountPage_Scene = new Scene(Account_page_parent);
//        Stage app_stage = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
//        app_stage.setScene(AccountPage_Scene);
//        app_stage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateAccount.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage app_stage = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);


        CreateAccount temp = fxmlLoader.<CreateAccount>getController();
        temp.setClient (client);
    }

    /**
     * Method to redirect the user to the next GUI when the user presses the button to make a company account
     * @param actionEvent action event created by the user pressing the company button
     * @throws IOException exception for input and output errors
     */
    public void CompanyButtonPressed(javafx.event.ActionEvent actionEvent) throws IOException{
//        Parent Account_page_parent = FXMLLoader.load(getClass().getResource("CompanyAccount.fxml"));
//        Scene AccountPage_Scene = new Scene(Account_page_parent);
//        Stage app_stage = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
//        app_stage.setScene(AccountPage_Scene);
//        app_stage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CompanyAccount.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage app_stage = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);


        CompanyAccount temp = fxmlLoader. <CompanyAccount>getController();
        temp.setClient(client);
    }

    /**
     * Method to redirect the user to the next GUI when the user presses the back button
     * @param actionEvent action event created by the user pressing the back button
     * @throws IOException exception for input and output errors
     */
    public void BackButtonPressed(javafx.event.ActionEvent actionEvent) throws IOException{
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

}
