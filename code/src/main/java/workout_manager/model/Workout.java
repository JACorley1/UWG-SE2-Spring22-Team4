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

}
