package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import workout_manager.model.Days;
import workout_manager.model.Intensity;
import workout_manager.model.MuscleGroup;
import workout_manager.model.Preferences;

/**
 * test the preference class
 * 
 * 
 */
public class TestPreferences {

    @Test
    void testValidConstruction() {
        List<MuscleGroup> muscles = new ArrayList<MuscleGroup>();
        muscles.add(MuscleGroup.ABS);
        muscles.add(MuscleGroup.LEGS);
        List<Days> days = new ArrayList<Days>();
        days.add(Days.MONDAY);
        days.add(Days.THURSDAY);
        Preferences pref = new Preferences(muscles, days, Intensity.INTERMEDIATE);

        assertAll(
                () -> assertEquals(pref.getIntensity(), Intensity.INTERMEDIATE),
                () -> assertEquals(pref.getSelectedDays(), days),
                () -> assertEquals(pref.getSelectedMuscles(), muscles));
    }

    @Test
    void testSetIntensity() {
        List<MuscleGroup> muscles = new ArrayList<MuscleGroup>();
        muscles.add(MuscleGroup.ABS);
        muscles.add(MuscleGroup.LEGS);
        List<Days> days = new ArrayList<Days>();
        days.add(Days.MONDAY);
        days.add(Days.THURSDAY);
        Preferences pref = new Preferences();
        pref.setIntensity(Intensity.ADVANCED);

        assertEquals(pref.getIntensity(), Intensity.ADVANCED);
    }

}
