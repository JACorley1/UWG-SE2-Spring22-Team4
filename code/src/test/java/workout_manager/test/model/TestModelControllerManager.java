package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleListProperty;
import kong.unirest.Client;
import workout_manager.model.Days;
import workout_manager.model.Intensity;
import workout_manager.model.MuscleGroup;
import workout_manager.model.User;
import workout_manager.model.Workout;
import workout_manager.viewmodel.ModelControllerManager;

public class TestModelControllerManager {

    @Test
    void testVerifyProperConstruction() {
        User user = new User("BillyBob", "12345");
        ModelControllerManager manager = new ModelControllerManager();
        manager.setUser(user);
        manager.serialize();

        assertAll(
                () -> assertEquals(0, manager.getCurrentPreferences().getSelectedDays().size()),
                () -> assertEquals(null, manager.getWorkout("Monday")),
                () -> assertEquals(null, manager.getWorkout("Funday")));
    }

    @Test
    void testSetCurrentWorkout() {
        Workout workout = new Workout();
        ModelControllerManager manager = new ModelControllerManager();

        manager.setCurrentWOrkout(workout);

        assertEquals(0, manager.getCurrentWorkout().getExercises().size());
    }

    // @Test
    // void testSetPrefs() {
    //     ModelControllerManager manager = new ModelControllerManager();
    //     User user = new User("BillyBob", "12345");
    //     manager.setUser(user);
    //     manager.setUserPrefs(new SimpleListProperty<MuscleGroup>(), new SimpleListProperty<Days>(), Intensity.BEGINNER);

    //     assertEquals(0, manager.getCurrentPreferences().getSelectedDays().size());
    // }
}
