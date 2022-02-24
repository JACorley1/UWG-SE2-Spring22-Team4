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
    private WorkoutDataFetcher dataFetcher;
    private static final String RESTDAY = "Rest Day";
    private static final String RESTDESCRIPTION = "Enjoy your Rest";
    private static final int RESTCAT = 0;
    private static final int[] RESTEQUIP = new int[] { 0 };

    /**
     * creates a workout generator object.
     */
    public WorkoutGenerator(WorkoutDataFetcher dataFetcher) {
        this.dataFetcher = dataFetcher;
    }

    /**
     * generates workouts based on the current users selected preferences
     * 
     * @param preferences the current users selected preferences.
     * @return workoutCalendar the generated calendar
     */
    public WorkoutCalendar generateWorkouts(Preferences preferences) {

        Map<MuscleGroup, ArrayList<ExerciseAlt>> exerciseMap = this.populateExercises(preferences);
        WorkoutCalendar workoutCalendar = new WorkoutCalendar();

        for (Days currentDay : Days.values()) {
            if (preferences.getSelectedDays().contains(currentDay)) {
                workoutCalendar.addWorkout(currentDay, this.createBalancedWorkout(exerciseMap));
            } else {
                workoutCalendar.addWorkout(currentDay, this.addRestDay());
            }

        }
        return workoutCalendar;
    }

    private Workout addRestDay() {
        Workout restDay = new Workout();
        restDay.addExercise(new ExerciseAlt(RESTDAY, RESTDESCRIPTION, RESTCAT, RESTEQUIP));
        return restDay;

    }

    private Workout createBalancedWorkout(Map<MuscleGroup, ArrayList<ExerciseAlt>> exerciseMap) {
        Workout workout = new Workout();
        for (MuscleGroup currentGroup : exerciseMap.keySet()) {
            int range = exerciseMap.get(currentGroup).size();
            int amountToAdd = 3;
            while (amountToAdd > 0) {
                int randomIndex = (int) (Math.random() * range);
                workout.addExercise(exerciseMap.get(currentGroup).get(randomIndex));
                amountToAdd--;
            }
        }
        return workout;
    }

    private Map<MuscleGroup, ArrayList<ExerciseAlt>> populateExercises(Preferences preferences) {
        Map<MuscleGroup, ArrayList<ExerciseAlt>> exerciseMap = new HashMap<MuscleGroup, ArrayList<ExerciseAlt>>();
        for (MuscleGroup current : preferences.getSelectedMuscles()) {
            exerciseMap.put(current, this.dataFetcher.getExercises(current.getCode()));
        }
        return exerciseMap;
    }

}
