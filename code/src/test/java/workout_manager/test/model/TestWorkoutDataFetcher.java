package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import workout_manager.model.WorkoutDataFetcher;
/**
 * tests workoutDataFetcher class
 */
public class TestWorkoutDataFetcher {

    @Test
    void testConstruction() {
        WorkoutDataFetcher testFetcher = new WorkoutDataFetcher();
        assertEquals(testFetcher.getExercises(8).size(), 4);
    }

}
