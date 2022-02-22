package workout_manager.view;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import workout_manager.Main;

/**
 * Creates a controller fro the login page
 * 
 * @author wtjracer
 * @version Spring 2022
 */
public class LoginController {

    @FXML
    private TextField userNameTextfield;

    @FXML
    private TextField passwordTextfield;

    @FXML
    private Button loginButton;

    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.loginButton.getScene().getWindow();
        Parent parent = FXMLLoader.load(Main.class.getResource(Main.WEEKLY_VIEW_PAGE));
        Scene scene = new Scene(parent);
        stage.setTitle(Main.WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void initialize() {
        this.bindLogin();

    }

    private void bindLogin() {
        this.loginButton.disableProperty().bind(
                this.userNameTextfield.textProperty().isEmpty().or(this.passwordTextfield.textProperty().isEmpty()));
    }

}
