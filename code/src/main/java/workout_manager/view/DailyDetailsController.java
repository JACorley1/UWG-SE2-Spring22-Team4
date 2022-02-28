package workout_manager.view;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import workout_manager.Main;
import workout_manager.model.ExerciseAlt;
import workout_manager.viewmodel.ModelControllerManager;

/**
 * Creates a controller for the daily details page
 * 
 * @author wtjracer
 * @version Spring 2022
 */
public class DailyDetailsController {

    private ModelControllerManager mcm;
    private ObservableList<String> exercises = FXCollections.observableArrayList();
    private static final String WORKOUT_OVERVIEW = "View Full Workout";

    @FXML
    private TextArea workoutTextArea;

    @FXML
    private Label dayLabel;

    @FXML
    private Button backButton;

    @FXML
    private ComboBox<String> exerciseSelector;

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

    private void exercizeSelectorListener() {
        this.exerciseSelector.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            this.setExcersizeDetails(newValue);
        });

    }

    private void setExcersizeDetails(String exerciseName) {
        for (ExerciseAlt currentExcersize : this.mcm.getCurrentWorkout().getExercises()) {
            if (currentExcersize.getName().equals(exerciseName)) {
                this.workoutTextArea.setText(currentExcersize.getDescription());
            }
        }
    }

    @FXML
    void handleExerciseSelection(ActionEvent event) {

    }

    private void showOverView(String dayName) {
        String overViewText = "";
        for (ExerciseAlt currentExercise : this.mcm.getWorkout(dayName).getExercises()) {
            this.exercises.add(currentExercise.getName());
            overViewText += currentExercise.getName() + System.lineSeparator();
        }
        this.workoutTextArea.setText(overViewText);
    }

    @FXML
    void initialize() {
        this.exercizeSelectorListener();
    }

    /**
     * initializes this.mcm to the given mcm
     * and sets the day label to the given string
     * 
     * @precondition none
     * @postcondition none
     * @param mcm         the mcm to be set to
     * @param nameClicked is the name of the day label to be set to
     */
    public void initParams(ModelControllerManager mcm, String nameClicked) {
        this.mcm = mcm;
        this.dayLabel.setText(nameClicked);
        this.exercises.add(WORKOUT_OVERVIEW);
        this.showOverView(nameClicked);
        this.exerciseSelector.setItems(this.exercises);
        this.exerciseSelector.getSelectionModel().select(WORKOUT_OVERVIEW);

    }

}
