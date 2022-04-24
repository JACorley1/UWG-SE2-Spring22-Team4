package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import workout_manager.model.ExerciseAlt;

/**
 * tests exerciseAlt class
 */
public class TestExerciseAlt {

    @Test
    void testValidConstruction() {
        ExerciseAlt testExercise = new ExerciseAlt("name test", "description test", 0, new int[] { 7 }, 30);
        assertAll(
                () -> assertEquals(testExercise.getName(), "name test"),
                () -> assertEquals(testExercise.getDescription(), "description test"),
                () -> assertEquals(testExercise.getCategory(), 0),
                () -> assertEquals(testExercise.getEquipment(), 7),
                () -> assertEquals(testExercise.getIntensity(), 30));
    }

    @Test
    void testInvalidConstructionNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ExerciseAlt(null, "description", 0, new int[] { 7 }, 30);
        });

    }

    @Test
    void testInvalidConstructionNullDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ExerciseAlt("name", null, 0, new int[] { 7 }, 30);
        });

    }

    @Test
    void testInvalidConstructionEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ExerciseAlt("", "description", 0, new int[] { 7 }, 30);
        });

    }

    @Test
    void testInvalidConstructionEmptyDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ExerciseAlt("name", "", 0, new int[] { 7 }, 30);
        });
    }

    @Test
    void testNoEquipmentForExercise() {
        ExerciseAlt testExercise = new ExerciseAlt("name test", "description test", 0, new int[0], 30);
        assertEquals(0, testExercise.getEquipment());
    }

    @Test
    void testNegativeIntensity() {
        assertThrows(IllegalArgumentException.class, () -> new ExerciseAlt("name test", "description test", 0, new int[0], -1));
        
    }
}
