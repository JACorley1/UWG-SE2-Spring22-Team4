package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import workout_manager.model.Preferences;

import org.junit.jupiter.api.Test;

import workout_manager.model.Days;
import workout_manager.model.Intensity;
import workout_manager.model.MuscleGroup;
import workout_manager.model.User;
import workout_manager.model.WorkoutCalendar;

/**
 * test user class
 */
public class TestUser {
    @Test
    void testValidConstruction() {
        User user = new User("Billy West", "Bwest101");
        assertAll(
                () -> assertEquals(user.getUserName(), "Billy West"),
                () -> assertEquals(user.getPassWord(), "Bwest101"));
    }

    @Test
    void testInvalidConstructionNullName() {
        assertThrows(NullPointerException.class, () -> {
            new User(null, "Bwest101");
        });

    }

    @Test
    void testInvalidConstructionNullPassword() {
        assertThrows(NullPointerException.class, () -> {
            new User("Billy West", null);
        });

    }

    @Test
    void testInvalidConstructionEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User("", "Bwest101");
        });

    }

    @Test
    void testInvalidConstructionEmptyPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User("Billy West", "");
        });

    }

    @Test
    void testSetWorkout() {
        User user = new User("Billy West", "Bwest101");
        WorkoutCalendar testWorkout = new WorkoutCalendar();
        user.setWorkoutCalender(testWorkout);
        testWorkout.getCalendar().size();
        assertEquals(0, testWorkout.getCalendar().size());
    }

    @Test
    void testSetPreferences() {
        User user = new User("Billy West", "Bwest101");
        List<MuscleGroup> muscles = new ArrayList<MuscleGroup>();
        List<Days> days = new ArrayList<Days>();
        Intensity intensity = Intensity.ADVANCED;
        Preferences prefs = new Preferences(muscles, days, intensity);
        user.setPreferences(prefs);
        assertEquals(user.getPreferences().getSelectedDays().size(), 0);
        assertEquals(user.getPreferences().getSelectedMuscles().size(), 0);
        assertEquals(user.getPreferences().getIntensity(), Intensity.ADVANCED);
    }

}
