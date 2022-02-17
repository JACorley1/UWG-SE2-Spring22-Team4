package workout_manager.model;

import java.util.ArrayList;
/**
 * interface to define behavior for interacting with API
 */
public interface DataFetcher {

    /**
     * queries the defined third pary API for exercise data that matches the passed in muscle category
     * @param muscleCategory the muscle category to retrieve exercises for
     * @return a list of the exercises that match the category
     */
    public ArrayList<ExerciseAlt> getExercises(String muscleCategory);
    
}
