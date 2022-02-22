package workout_manager.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * defines the workout generator class.
 * 
 * @author group4
 */
public class WorkoutGenerator {
    private Map<MuscleGroup, ArrayList<ExerciseAlt>> exerciseMap;
    private WorkoutCalendar workoutCalendar;
    private WorkoutDataFetcher dataFetcher;

    /**
     * creates a workout generator object.
     */
    public WorkoutGenerator() {
        this.workoutCalendar = new WorkoutCalendar();
        this.exerciseMap = new HashMap<MuscleGroup, ArrayList<ExerciseAlt>>();
        this.dataFetcher = new WorkoutDataFetcher();
    }

    /**
     * generates workouts based on the current users selected preferences
     * 
     * @param preferences the current users selected preferences.
     */
    public void generateWorkouts(Preferences preferences) {

        this.populateExercises(preferences);

        for (Days currentDay : preferences.getSelectedDays()) {
            this.workoutCalendar.addWorkout(currentDay, this.createBalancedWorkout());
        }
    }

    private Workout createBalancedWorkout() {
        Workout workout = new Workout();
        for (MuscleGroup currentGroup : this.exerciseMap.keySet()) {
            int range = this.exerciseMap.get(currentGroup).size();
            int amountToAdd = 3;
            while (amountToAdd > 0) {
                int randomIndex = (int) (Math.random() * range);
                workout.addExercise(this.exerciseMap.get(currentGroup).get(randomIndex));
                amountToAdd--;
            }
        }
        return workout;
    }

    private void populateExercises(Preferences preferences) {
        for (MuscleGroup current : preferences.getSelectedMuscles()) {
            this.exerciseMap.put(current, this.dataFetcher.getExercises(current.valueOf()));
        }
    }

}
