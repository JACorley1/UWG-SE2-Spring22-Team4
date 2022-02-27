package workout_manager.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import workout_manager.Main;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
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
import workout_manager.viewmodel.ModelControllerManager;

/**
 * Creates a controller for the preferences page
 * 
 * @author wtjracer
 * @version Spring 2022
 * 
 */
public class PreferenceController {

    private SimpleListProperty<Days> selectedDays = new SimpleListProperty<Days>(FXCollections.observableArrayList());
    private SimpleListProperty<MuscleGroup> selectedMuscles = new SimpleListProperty<MuscleGroup>(FXCollections.observableArrayList());

    private ModelControllerManager mcm;

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
        this.mcm.setUserPrefs(this.getSelectedMuscles(), this.getDaysSelected());
        Stage stage = (Stage) this.cancelButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(Main.WEEKLY_VIEW_PAGE));
        Parent parent = loader.load();
        WeeklyViewController wvc = loader.<WeeklyViewController>getController();
        wvc.initParams(this.mcm);
        Scene scene = new Scene(parent);
        stage.setTitle(Main.WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();

    }

    private SimpleListProperty<Days> getDaysSelected() {
        this.selectedDays.clear();
        for (Node node : this.daysGridPane.getChildren()) {
            if (node instanceof CheckBox) {
                CheckBox ckbox = (CheckBox) node;
                if (ckbox.isSelected()) {
                    Days day = Days.valueOf(ckbox.getText().toUpperCase());
                    this.selectedDays.add(day);
                }
            }
        }
        return this.selectedDays;
    }

    private SimpleListProperty<MuscleGroup> getSelectedMuscles() {
        this.selectedMuscles.clear();
        for (Node node : this.muscleGridPane.getChildren()) {
            if (node instanceof CheckBox) {
                CheckBox ckbox = (CheckBox) node;
                if (ckbox.isSelected()) {
                    MuscleGroup muscle = MuscleGroup.valueOf(ckbox.getText().toUpperCase());
                    this.selectedMuscles.add(muscle);
                }
            }
        }
        return this.selectedMuscles;
    }

    @FXML
    void handleCancelButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.cancelButton.getScene().getWindow();
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

    private void displayDays(){
        for (Node node : this.daysGridPane.getChildren()) {
            if (node instanceof CheckBox) {
                CheckBox ckbox = (CheckBox) node;
                Days day = Days.valueOf(ckbox.getText().toUpperCase());
                if (this.mcm.getCurrentPreferences().getSelectedDays().contains(day)) {
                    ckbox.selectedProperty().set(true);
                }
            }
        }
    }

    private void displayMuscles() {
        for (Node node : this.muscleGridPane.getChildren()) {
            if (node instanceof CheckBox) {
                CheckBox ckbox = (CheckBox) node;
                MuscleGroup muscle = MuscleGroup.valueOf(ckbox.getText().toUpperCase());
                if (this.mcm.getCurrentPreferences().getSelectedMuscles().contains(muscle)) {
                    ckbox.selectedProperty().set(true);
                }
            }
        }
    }

    public void initParams(ModelControllerManager mcm) {
        this.mcm = mcm;
        this.displayDays();
        this.displayMuscles();
    }

}
