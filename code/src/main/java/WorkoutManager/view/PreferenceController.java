package WorkoutManager.view;

import java.util.ArrayList;
import java.util.List;

import WorkoutManager.model.Days;
import WorkoutManager.model.MuscleGroup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
    void handleApplyPrefButton(ActionEvent event) {
        List<Days> selectedDays = this.getDaysSelected();
        List<MuscleGroup> selectedMuscles = this.getSelectedMuscles();
        System.out.println(selectedDays);
        System.out.println(selectedMuscles);

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
    void handleCancelButton(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {

    }

}
