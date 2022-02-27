package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import workout_manager.model.Days;
import workout_manager.model.MuscleGroup;
import workout_manager.model.Preferences;
import workout_manager.model.WorkoutCalendar;
import workout_manager.model.WorkoutDataFetcher;
import workout_manager.model.WorkoutGenerator;

/**
 * tests workoutGenerator class
 */
public class TestWorkoutGenerator {

    private static List<Days> selectedDays;
    private static List<MuscleGroup> selectedMuscles;

    @Test
    void testConstruction() {
        WorkoutGenerator testGenerator = new WorkoutGenerator();
        assertEquals(testGenerator.getClass(), WorkoutGenerator.class);
    }

    @Test
    void testGenerateCalendarNoDaysSelected() {
        selectedDays = new ArrayList<Days>();
        selectedMuscles = new ArrayList<MuscleGroup>();
        selectedMuscles.add(MuscleGroup.LEGS);
        Preferences testPref = new Preferences(selectedMuscles, selectedDays);
        WorkoutGenerator testGenerator = new WorkoutGenerator();
        WorkoutCalendar testCal = testGenerator.generateWorkouts(testPref);
        assertAll(
                () -> assertEquals(testCal.getDaysWorkout(Days.FRIDAY).getExercises().get(0).getName(), "Rest Day"),
                () -> assertEquals(testCal.getDaysWorkout(Days.MONDAY).getExercises().get(0).getName(), "Rest Day"),
                () -> assertEquals(testCal.getDaysWorkout(Days.TUESDAY).getExercises().get(0).getName(), "Rest Day"),
                () -> assertEquals(testCal.getDaysWorkout(Days.WEDNESDAY).getExercises().get(0).getName(), "Rest Day"),
                () -> assertEquals(testCal.getDaysWorkout(Days.THURSDAY).getExercises().get(0).getName(), "Rest Day"),
                () -> assertEquals(testCal.getDaysWorkout(Days.SUNDAY).getExercises().get(0).getName(), "Rest Day"),
                () -> assertEquals(testCal.getDaysWorkout(Days.SATURDAY).getExercises().get(0).getName(), "Rest Day"));
    }

    @Test
    void testGenerateCalendarOneDayOneMuscleSelected() {
        selectedDays = new ArrayList<Days>();
        selectedMuscles = new ArrayList<MuscleGroup>();
        selectedDays.add(Days.FRIDAY);
        selectedMuscles.add(MuscleGroup.LEGS);
        Preferences testPref = new Preferences(selectedMuscles, selectedDays);
        WorkoutGenerator testGenerator = new WorkoutGenerator();
        WorkoutCalendar testCal = testGenerator.generateWorkouts(testPref);
        assertEquals(testCal.getDaysWorkout(Days.FRIDAY).getExercises().size(), 1);
    }

    @Test
    void testGenerateCalendarThreeDaysThreeMusclesSelected() {
        selectedDays = new ArrayList<Days>();
        selectedMuscles = new ArrayList<MuscleGroup>();
        selectedDays.add(Days.FRIDAY);
        selectedDays.add(Days.TUESDAY);
        selectedDays.add(Days.SUNDAY);
        selectedMuscles.add(MuscleGroup.ABS);
        selectedMuscles.add(MuscleGroup.LEGS);
        selectedMuscles.add(MuscleGroup.ARMS);
        Preferences testPref = new Preferences(selectedMuscles, selectedDays);
        WorkoutGenerator testGenerator = new WorkoutGenerator();
        WorkoutCalendar testCal = testGenerator.generateWorkouts(testPref);
        assertEquals(testCal.getDaysWorkout(Days.FRIDAY).getExercises().size(), 3);
        assertEquals(testCal.getDaysWorkout(Days.TUESDAY).getExercises().size(), 3);
        assertEquals(testCal.getDaysWorkout(Days.SUNDAY).getExercises().size(), 3);
    }

}
