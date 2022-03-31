package workout_manager.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import workout_manager.Main;
import workout_manager.model.Client;
import workout_manager.model.LocalLoginAuthenticator;
import workout_manager.viewmodel.ModelControllerManager;

/**
 * Creates a controller fro the login page
 * 
 * @author wtjracer
 * @version Spring 2022
 */
public class LoginController {
    private LocalLoginAuthenticator loginAuthenticator;
    private ModelControllerManager mcm;

    @FXML
    private TextField userNameTextfield;

    @FXML
    private TextField passwordTextfield;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private Label errorLabel;

    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        boolean authenticated = this.loginAuthenticator.authenticateLoginCredentials(this.userNameTextfield.getText(),
                this.passwordTextfield.getText());
        Client client = Client.getClient();
        String request = "login, " + this.userNameTextfield.getText() + ", " + this.passwordTextfield.getText();
        client.sendRequest(request);
        String response = client.receiveResponse();
        this.mcm.deSerialize(response);

        if (authenticated) {
            //this.mcm.deSerialize();
            this.errorLabel.setVisible(false);
            Stage stage = (Stage) this.loginButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(Main.WEEKLY_VIEW_PAGE));
            Parent parent = loader.load();
            WeeklyViewController wvc = loader.<WeeklyViewController>getController();
            wvc.initParams(this.mcm);
            Scene scene = new Scene(parent);
            stage.setTitle(Main.WINDOW_TITLE);
            stage.setScene(scene);
            stage.show();
        } else {
            this.errorLabel.setVisible(true);
            this.errorLabel.setText("Username or Password Not found");
        }

    }

    @FXML 
    void handleRegisterUser(ActionEvent event) {
        
    }

    @FXML
    void initialize() {
        this.loginAuthenticator = new LocalLoginAuthenticator();
        this.bindLoginButtonVisibility();
        this.bindRegisterButtonVisibility();
    }

    private void bindLoginButtonVisibility() {
        this.loginButton.disableProperty().bind(
                this.userNameTextfield.textProperty().isEmpty().or(this.passwordTextfield.textProperty().isEmpty()));
    }

    private void bindRegisterButtonVisibility() {
        this.registerButton.disableProperty().bind(
                this.userNameTextfield.textProperty().isEmpty().or(this.passwordTextfield.textProperty().isEmpty()));
    }

    /**
     * initializes this.mcm to the given mcm
     * 
     * @precondition none
     * @postcondition none
     * @param mcm the mcm to be set to
     */
    public void initParams(ModelControllerManager mcm) {
        this.mcm = mcm;
    }

}
