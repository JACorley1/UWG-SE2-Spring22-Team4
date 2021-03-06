package workout_manager.view;

import java.io.IOException;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
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

    @FXML
    private TextArea workoutTextArea;

    @FXML
    private Label dayLabel;

    @FXML
    private Button backButton;

    @FXML
    private Accordion detailsAccordion;

    @FXML
    private Button enterWeightButton;

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField workoutDurationTextField;

    @FXML
    private Button completedWorkoutButton;

    @FXML
    private Label userInputErrorLabel;

    @FXML
    void handleCompletedWorkoutButton(ActionEvent event) {
        this.userInputErrorLabel.setVisible(false);
        try {
            double duration = Double.valueOf(this.workoutDurationTextField.getText());
            this.mcm.addUserWorkoutCompletionTimeEntry(duration, this.dayLabel.getText());
        } catch (Exception exc) {
            this.userInputErrorLabel.setVisible(true);
        } finally {
            this.workoutDurationTextField.setText("");  
        }       
    }

    @FXML
    void handleEnterWeightButton(ActionEvent event) {
        this.userInputErrorLabel.setVisible(false);
        try {
            double weight = Double.parseDouble(this.weightTextField.getText());
            this.mcm.addUserWeightEntry(weight, this.dayLabel.getText());    
        } catch (Exception exc) {
            this.userInputErrorLabel.setVisible(true);
        } finally {
            this.weightTextField.setText("");    
        }
    }

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

    private void setExerciseDetails() {
        this.detailsAccordion.getPanes().clear();
        Map<String, Integer> setsDetermined = this.mcm.getWorkout(this.dayLabel.getText()).transformForDisplay();
        for (ExerciseAlt currentExcercise : this.mcm.getWorkout(this.dayLabel.getText()).getDisplayExercises()) {
            TextArea workoutDetailsArea = new TextArea();
            workoutDetailsArea.setText(currentExcercise.getDescription());
            workoutDetailsArea.setWrapText(true);
            workoutDetailsArea.setMinHeight(110);
            TitledPane newPane;
            if (setsDetermined.get(currentExcercise.getName()) > 1) {
                newPane = new TitledPane(
                        setsDetermined.get(currentExcercise.getName()) + " sets of:\n" + currentExcercise.getName() + "s",
                        workoutDetailsArea);
            } else if (!currentExcercise.getName().equals("Rest Day")) {
                newPane = new TitledPane(
                        setsDetermined.get(currentExcercise.getName()) + " set of:\n " + currentExcercise.getName(),
                        workoutDetailsArea);
            } else {
                newPane = new TitledPane(currentExcercise.getName(), workoutDetailsArea);
            }
            this.detailsAccordion.getPanes().add(newPane);
        }
        
    }

    private void bindButtonVisibility() {
        this.completedWorkoutButton.disableProperty().bind(this.workoutDurationTextField.textProperty().isEmpty());
        this.enterWeightButton.disableProperty().bind(this.weightTextField.textProperty().isEmpty());
    }

    @FXML
    void initialize() {
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
        this.setExerciseDetails();
        this.bindButtonVisibility();
        this.userInputErrorLabel.setVisible(false);
    }
}
