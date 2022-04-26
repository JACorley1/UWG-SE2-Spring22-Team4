package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

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
        assertAll(
            () -> assertEquals(testWorkout.getExercises().size(), 0),
            () -> assertEquals(testWorkout.getDisplayExercises().size(), 0)
        );
        
    }

    @Test
    void testAddExercise() {
        Workout testWorkout = new Workout();
        ExerciseAlt testExercise = new ExerciseAlt("name", "description", 0, new int[] { 7 }, 30);
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

    @Test
    void testGetFitnessPoints() {
        Workout testWorkout = new Workout();
        ExerciseAlt testExercise = new ExerciseAlt("name", "description", 0, new int[] { 7 }, 30);
        testWorkout.addExercise(testExercise);

        assertEquals(30, testWorkout.getTotalPoints());
    }

    @Test
    void testTransformForDisplay() {
        Workout testWorkout = new Workout();
        ExerciseAlt testExercise1 = new ExerciseAlt("name", "description", 0, new int[] { 7 }, 30);
        ExerciseAlt testExercise2 = new ExerciseAlt("name", "description", 0, new int[] { 7 }, 30);
        testWorkout.addExercise(testExercise1);
        testWorkout.addExercise(testExercise2);

        Map<String, Integer> sets = testWorkout.transformForDisplay();
        assertEquals(sets.get("name"), 2);
    }
}
