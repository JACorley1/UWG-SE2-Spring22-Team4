package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import workout_manager.model.MuscleGroup;

public class TestMuscleGroup {
    
    @Test
    void testValueOf() {
        MuscleGroup muskuls = MuscleGroup.ABS;
        assertAll(
            () -> assertEquals(MuscleGroup.ABS.name(), muskuls.valueOf().toUpperCase()),
            () -> assertEquals(3, muskuls.getCode())
        );
    }
}
