package workout_manager.viewmodel;

import javafx.beans.property.SimpleListProperty;
import javafx.scene.control.Button;
import workout_manager.model.Days;
import workout_manager.model.MuscleGroup;
import workout_manager.model.Preferences;
import workout_manager.model.User;
import workout_manager.model.WorkoutDataFetcher;
import workout_manager.model.WorkoutGenerator;
import workout_manager.view.DailyDetailsController;
import workout_manager.view.LoginController;
import workout_manager.view.PreferenceController;
import workout_manager.view.WeeklyViewController;

/**
 * Creates a ModelControllerManager
 * 
 * @author group 4
 */
public class ModelControllerManager {

    private DailyDetailsController dailyController;
    private LoginController loginController;
    private PreferenceController prefController;
    private WeeklyViewController weeklyViewcontroller;
    private static WorkoutDataFetcher dataFetcher;
    private WorkoutGenerator workoutGenerator;
    private User user;

    private SimpleListProperty<Days> days;
    private SimpleListProperty<MuscleGroup> muscles;

    /**
     * 
     * 
     * 
     */
    public ModelControllerManager() {
        this.dailyController = new DailyDetailsController();
        this.prefController = new PreferenceController();
        this.weeklyViewcontroller = new WeeklyViewController();
        dataFetcher = new WorkoutDataFetcher();
        this.workoutGenerator = new WorkoutGenerator(dataFetcher);

        this.muscles = new SimpleListProperty<MuscleGroup>();
        this.days = new SimpleListProperty<Days>();

    }

    /**
     * bind prefernces for the user
     * 
     * @precondition none
     * @postcondition none
     */
    public void intitializeBindings() {
        this.muscles.bindBidirectional(this.prefController.getSelectedMuscles());
        this.days.bindBidirectional(this.prefController.getDaysSelected());
        this.muscles.addAll(this.user.getPreferences().getSelectedMuscles());
        this.days.addAll(this.user.getPreferences().getSelectedDays());
    }

    public void setUserPrefs() {
        this.user.setPreferences(
                new Preferences(this.muscles.subList(0, this.muscles.size()), this.days.subList(0, this.days.size())));
    }

    public void setUser(User user) {
        this.user = user;
    }

}
