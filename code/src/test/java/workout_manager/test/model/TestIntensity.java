package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import workout_manager.model.Intensity;

public class TestIntensity {
    
    @Test
    void testGetCode() {
        Intensity inTents = Intensity.ADVANCED;
        assertEquals(60, inTents.getCode());
    }

    @Test
    void testGetEnumFromInt() {
        Intensity inTents = Intensity.ADVANCED;

        assertAll(
            () -> assertEquals(Intensity.BEGINNER, inTents.getEnumFromInt(30)),
            () -> assertEquals(Intensity.INTERMEDIATE, inTents.getEnumFromInt(45)),
            () -> assertEquals(Intensity.ADVANCED, inTents.getEnumFromInt(60))
        );  
    }
}
