package workout_manager.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * defines the workout class
 * 
 * @author group4
 */
public class Workout {

    private ArrayList<ExerciseAlt> exercises;
    private ArrayList<ExerciseAlt> exercisesForDisplay;
    private int totalPoints;

    /**
     * constucts a workout object
     */
    public Workout() {
        this.exercises = new ArrayList<ExerciseAlt>();
        this.exercisesForDisplay = new ArrayList<ExerciseAlt>();
    }

    /**
     * adds an exercise to the workout
     * 
     * @precondition exercise cant be null
     * @postcondition exercises.size() == exercises.size +1 @prev
     * 
     * @param exercise the exercise to add to the workout
     */
    public void addExercise(ExerciseAlt exercise) {
        if (exercise == null) {
            throw new IllegalArgumentException("Exercise can't be null");
        }
        this.exercises.add(exercise);
    }

    /**
     * gets the collection of exercises in the workout
     * 
     * @precondition none
     * @postcondition none
     * @return the collection of exercises
     */
    public ArrayList<ExerciseAlt> getExercises() {
        return this.exercises;
    }

    /**
     * gets the manipulated exercise list free of duplicates
     * @return the manipulated list
     */
    public ArrayList<ExerciseAlt> getDisplayExercises() {
        return this.exercisesForDisplay;
    }

   /**
     * gets the total points in the workout
     * @return the total fitness points
     */
    public int getTotalPoints(){
        this.totalPoints = 0;
        for (ExerciseAlt current: this.exercises) {
            this.totalPoints += current.getIntensity();
        }
        return this.totalPoints;
    }

    /**
     * transforms the collection of exercises to remove duplicates and determine sets.
     * @return the map of exercise names and set numbers
     */
    public Map<String, Integer> transformForDisplay() {
        this.exercisesForDisplay.clear();
        this.exercisesForDisplay.addAll(this.exercises);
        Map<String, Integer> setsDetermined = new HashMap<String, Integer>();
        ArrayList<ExerciseAlt> toRemove = new ArrayList<ExerciseAlt>();
        for (ExerciseAlt currentExercise : this.exercises) {
            setsDetermined.merge(currentExercise.getName(), 1, Integer::sum);
            if (setsDetermined.get(currentExercise.getName()) > 1) {
                toRemove.add(currentExercise);
            }
        }
        this.exercisesForDisplay.removeAll(toRemove);

        return setsDetermined;
    }

}
