package workout_manager.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import workout_manager.Main;
import javafx.beans.property.SimpleListProperty;
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

    private SimpleListProperty<Days> selectedDays = new SimpleListProperty<Days>();
    private SimpleListProperty<MuscleGroup> selectedMuscles = new SimpleListProperty<MuscleGroup>();

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
        this.mcm.setUserPrefs();
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

    public SimpleListProperty<Days> getDaysSelected() {
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

    public SimpleListProperty<MuscleGroup> getSelectedMuscles() {
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

    public Button getPrefButton() {
        return this.applyPrefButton;
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

    public void initParams(ModelControllerManager mcm) {
        this.mcm = mcm;
    }

}
