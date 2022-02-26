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
import workout_manager.viewmodel.ModelControllerManager;

/**
 * Creates a controller for the daily details page
 * 
 * @author wtjracer
 * @version Spring 2022
 */
public class DailyDetailsController {
    private ModelControllerManager mcm;

    @FXML
    private TextArea workoutTextArea;

    @FXML
    private Label dayLabel;

    @FXML
    private Button backButton;

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(Main.WEEKLY_VIEW_PAGE));
        Parent parent = loader.load();
        WeeklyViewController wvc = loader.<WeeklyViewController>getController();
        wvc.initParams(this.mcm);
        Scene scene = new Scene(parent);
        stage.setTitle(Main.WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void initialize() {
    }

    public void initParams(ModelControllerManager mcm) {
        this.mcm = mcm;
    }

}
