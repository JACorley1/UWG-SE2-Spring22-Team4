package workout_manager.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class WorkoutGenerator {
    //private WorkoutCalendar workoutCalendar;
    private Map<MuscleGroup, ArrayList<ExerciseAlt>> exerciseMap;
    private ArrayList<MuscleGroup> upperBody;
    private ArrayList<MuscleGroup> lowerBody;
    private ArrayList<MuscleGroup> core;
    private DataFetcher fetcher;

    public WorkoutGenerator() {
       // this.workoutCalendar = new WorkoutCalendar();
        this.exerciseMap = new HashMap<MuscleGroup, ArrayList<ExerciseAlt>>();
    }

    public void generateWorkouts(Preferences preferences) {
        WorkoutDataFetcher dataFetcher = new WorkoutDataFetcher();
        this.populateExercises(preferences);

        for (Days currentDay : preferences.getSelectedDays()) {
          //  this.workoutCalendar.addWorkout(currentDay, createBalancedWorkout());
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
            this.exerciseMap.put(current, this.fetcher.getExercises(current.valueOf()));
        }
    }

}
