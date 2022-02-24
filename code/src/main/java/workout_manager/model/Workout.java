package workout_manager.model;

import java.util.ArrayList;

/**
 * defines the workout class
 * 
 * @author group4
 */
public class Workout {

    private ArrayList<ExerciseAlt> exercises;

    /**
     * constucts a workout object
     */
    public Workout() {
        this.exercises = new ArrayList<ExerciseAlt>();
    }

    /**
     * adds an exercise to the workout
     * 
     * @param exercise the exercise to add to the workout
     */
    public void addExercise(ExerciseAlt exercise) {
        this.exercises.add(exercise);
    }

    /**
     * gets the exercise from the workout
     * 
     * @param indexOfExercise the index of the exercise needed
     * @return the exercise object
     */
    public ExerciseAlt getExercise(int indexOfExercise) {
        return this.exercises.get(indexOfExercise);

    }
}
