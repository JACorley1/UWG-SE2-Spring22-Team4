package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import workout_manager.model.ExerciseAlt;
import workout_manager.model.Workout;

/**
 * tests Workout class
 */
public class TestWorkout {

    @Test
    void testValidConstruction() {
        Workout testWorkout = new Workout();
        assertEquals(testWorkout.getExercises().size(), 0);
    }

    @Test
    void testAddExercise() {
        Workout testWorkout = new Workout();
        ExerciseAlt testExercise = new ExerciseAlt("name", "description", 0, new int[] { 7 });
        testWorkout.addExercise(testExercise);
        assertEquals(testWorkout.getExercises().size(), 1);
    }

    @Test
    void testAddInvalidExercise() {
        Workout testWorkout = new Workout();
        assertThrows(IllegalArgumentException.class, () -> {
            testWorkout.addExercise(null);
        });
    }

}
