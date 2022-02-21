package workout_manager.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import workout_manager.Main;

public class DailyDetailsController {

    @FXML
    private TextArea workoutTextArea;

    @FXML
    private Label dayLabel;

    @FXML
    private Button backButton;

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.backButton.getScene().getWindow();
        Parent parent = FXMLLoader.load(Main.class.getResource(Main.WEEKLY_VIEW_PAGE));
        Scene scene = new Scene(parent);
        stage.setTitle(Main.WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();

    }

}
