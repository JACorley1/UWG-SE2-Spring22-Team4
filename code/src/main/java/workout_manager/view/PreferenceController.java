package workout_manager.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import workout_manager.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import workout_manager.model.Days;
import workout_manager.model.MuscleGroup;

/**
 * Creates a controller for the preferences page
 * 
 * @precondition none
 * @postcondition none
 * @author wtjracer
 * @version Spring 2022
 * 
 */
public class PreferenceController {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private GridPane daysGridPane;

    @FXML
    private GridPane muscleGridPane;

    @FXML
    private Button applyPrefButton;

    @FXML
    private Button cancelButton;

    @FXML
    void handleApplyPrefButton(ActionEvent event) throws IOException {
        List<Days> selectedDays = this.getDaysSelected();
        List<MuscleGroup> selectedMuscles = this.getSelectedMuscles();

        Stage stage = (Stage) this.cancelButton.getScene().getWindow();
        Parent parent = FXMLLoader.load(Main.class.getResource(Main.WEEKLY_VIEW_PAGE));
        Scene scene = new Scene(parent);
        stage.setTitle(Main.WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();

    }

    private List<Days> getDaysSelected() {
        List<Days> selectedDays = new ArrayList<Days>();
        for (Node node : this.daysGridPane.getChildren()) {
            if (node instanceof CheckBox) {
                CheckBox ckbox = (CheckBox) node;
                if (ckbox.isSelected()) {
                    Days day = Days.valueOf(ckbox.getText().toUpperCase());
                    selectedDays.add(day);
                }

            }
        }
        return selectedDays;
    }

    private List<MuscleGroup> getSelectedMuscles() {
        List<MuscleGroup> selectedMuscles = new ArrayList<MuscleGroup>();
        for (Node node : this.muscleGridPane.getChildren()) {
            if (node instanceof CheckBox) {
                CheckBox ckbox = (CheckBox) node;
                if (ckbox.isSelected()) {
                    MuscleGroup muscle = MuscleGroup.valueOf(ckbox.getText().toUpperCase());
                    selectedMuscles.add(muscle);
                }
            }
        }
        return selectedMuscles;
    }

    @FXML
    void handleCancelButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.cancelButton.getScene().getWindow();
        Parent parent = FXMLLoader.load(Main.class.getResource(Main.WEEKLY_VIEW_PAGE));
        Scene scene = new Scene(parent);
        stage.setTitle(Main.WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {

    }

}
