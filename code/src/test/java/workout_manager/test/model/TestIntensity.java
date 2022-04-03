package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import workout_manager.model.Intensity;

public class TestIntensity {
    
    @Test
    void testGetCode() {
        Intensity inTents = Intensity.ADVANCED;
        assertEquals(2, inTents.getCode());
    }

    @Test
    void testGetEnumFromInt() {
        Intensity inTents = Intensity.ADVANCED;

        assertAll(
            () -> assertEquals(Intensity.BEGINNER, inTents.getEnumFromInt(0)),
            () -> assertEquals(Intensity.INTERMEDIATE, inTents.getEnumFromInt(1)),
            () -> assertEquals(Intensity.ADVANCED, inTents.getEnumFromInt(2))
        );  
    }
}
