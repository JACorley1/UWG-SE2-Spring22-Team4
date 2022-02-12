package view;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import model.Days;
import model.MuscleGroup;

public class PreferenceController {

    @FXML
    private GridPane daysGridPane;

    @FXML
    private CheckBox mondayCheckBox;

    @FXML
    private CheckBox tuesdayCheckbox;

    @FXML
    private CheckBox wednesdayCheckbox;

    @FXML
    private CheckBox thursdayCheckbox;

    @FXML
    private CheckBox fridayCheckbox;

    @FXML
    private CheckBox saturdayCheckbox;

    @FXML
    private CheckBox sundayCheckbox;

    @FXML
    private GridPane muscleGridPane;

    @FXML
    private CheckBox armsCheckBox;

    @FXML
    private CheckBox legsCheckbox;

    @FXML
    private CheckBox backCheckbox;

    @FXML
    private CheckBox coreCheckbox;

    @FXML
    private CheckBox stretchCheckbox;

    @FXML
    private Button applyPrefButton;

    @FXML
    void handleApplyPrefButton(ActionEvent event) {
        List<Days> selectedDays = this.getDaysSelected();
        System.out.println(selectedDays);
        List<MuscleGroup> selectedMuscles = this.getSelectedMuscles();
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
    void initialize() {

    }

}
