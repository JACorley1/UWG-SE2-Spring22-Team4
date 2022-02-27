package workout_manager.viewmodel;

import javafx.beans.property.SimpleListProperty;
import workout_manager.model.Days;
import workout_manager.model.MuscleGroup;
import workout_manager.model.Preferences;
import workout_manager.model.User;
import workout_manager.model.UserSerializer;
import workout_manager.model.Workout;
import workout_manager.model.WorkoutDataFetcher;
import workout_manager.model.WorkoutGenerator;

/**
 * Creates a ModelControllerManager
 * 
 * @author group 4
 */
public class ModelControllerManager {

    private static final String userFilePath = "src/main/java/workout_manager/model/userFile.json";
    private WorkoutGenerator workoutGenerator;
    private User user;
    private Workout currentWorkout;
    private UserSerializer serializer;

    /**
     * Creates a ModelControllerManager class
     * 
     * @precondition none
     * @postcondition none
     * 
     */
    public ModelControllerManager() {
        this.serializer = new UserSerializer(userFilePath);
        this.workoutGenerator = new WorkoutGenerator();
    }

    /**
     * gets the preferences from the user and retunrs it
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return this.user.preferences
     */
    public Preferences getCurrentPreferences() {
        return this.user.getPreferences();
    }

    /**
     * gets the workout for the specified day from the user's workout calender
     * 
     * @param day is the day to get the workout from
     * @return the found workout for the given day
     */
    public Workout getWorkout(String day) {
        for (Days currentDay : Days.values()) {
            if (day.toUpperCase().equals(currentDay.toString())) {
                this.currentWorkout = this.user.getWorkoutCalender().getDaysWorkout(currentDay);
                return this.user.getWorkoutCalender().getDaysWorkout(currentDay);
            }
        }
        return null;
    }

    /**
     * sets the user's preferences with the given information
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param muscles the list of selected muscles to set for the user's preferred
     *                muscles
     * @param days    the list of selected days tos set the user's available days
     */
    public void setUserPrefs(SimpleListProperty<MuscleGroup> muscles, SimpleListProperty<Days> days) {

        this.user.setPreferences(new Preferences(muscles.subList(0, muscles.size()), days.subList(0, days.size())));
        this.generateWorkoutCalendar();

    }

    private void generateWorkoutCalendar() {
        this.user.setWorkoutCalender(this.workoutGenerator.generateWorkouts(this.user.getPreferences()));
    }

    /**
     * sets this.user to the given user
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param user the user to set to
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * gets the current workout and returns it
     * 
     * @precondition none
     * @postcondition none
     * @return this.workout
     */
    public Workout getCurrentWorkout() {
        return this.currentWorkout;
    }

    /**
     * sets the current workout to the given workout
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param workoutToSet is the workout to set to
     */
    public void setCurrentWOrkout(Workout workoutToSet) {
        this.currentWorkout = workoutToSet;
    }

    /**
     * deserializes the user
     * 
     * @precondition none
     * @postcondition none
     * 
     */
    public void deSerialize() {
        this.user = this.serializer.deserialize();
    }

    /**
     * serializes the user
     * 
     * @precondition none
     * @postcondition none
     */
    public void serialize() {
        this.serializer.serialize(this.user);
    }

}
