package workout_manager.model;

import java.util.ArrayList;

/**
 * interface to define behavior for interacting with API
 * 
 * @author group4
 */
public interface DataFetcher {

    /**
     * queries the defined third pary API for exercise data that matches the passed
     * in muscle category
     * 
     * @param muscleCategory the muscle category to retrieve exercises for
     * @return a list of the exercises that match the category
     */
    ArrayList<ExerciseAlt> getExercises(int muscleCategory);

}
