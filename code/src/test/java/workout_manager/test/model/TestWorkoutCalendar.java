package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import workout_manager.model.Days;
import workout_manager.model.ExerciseAlt;
import workout_manager.model.Workout;
import workout_manager.model.WorkoutCalendar;

/**
 * tests workout Calendar class
 */
public class TestWorkoutCalendar {

    @Test
    void testValidConstruction() {
        WorkoutCalendar testCalendar = new WorkoutCalendar();
        assertEquals(testCalendar.getCalendar().size(), 0);
    }

    @Test
    void testAddWorkout() {
        WorkoutCalendar testCalendar = new WorkoutCalendar();
        ExerciseAlt testExercise = new ExerciseAlt("test", "test description", 0, new int[] { 7 });
        Workout testWorkout = new Workout();
        testWorkout.addExercise(testExercise);
        testCalendar.addWorkout(Days.MONDAY, testWorkout);
        assertEquals(testCalendar.getDaysWorkout(Days.MONDAY).getExercises().size(), 1);
    }

    @Test
    void testGetWorkoutCalendar() {
        WorkoutCalendar testCalendar = new WorkoutCalendar();
        ExerciseAlt testExercise = new ExerciseAlt("test", "test description", 0, new int[] { 7 });
        ExerciseAlt testExerciseTwo = new ExerciseAlt("test", "test description", 0, new int[] { 7 });
        ExerciseAlt testExerciseThree = new ExerciseAlt("test", "test description", 0, new int[] { 7 });
        Workout testWorkout = new Workout();
        Workout testWorkoutTwo = new Workout();
        Workout testWorkoutThree = new Workout();
        testWorkout.addExercise(testExercise);
        testWorkoutTwo.addExercise(testExerciseTwo);
        testWorkoutThree.addExercise(testExerciseThree);
        testCalendar.addWorkout(Days.MONDAY, testWorkout);
        testCalendar.addWorkout(Days.TUESDAY, testWorkoutTwo);
        testCalendar.addWorkout(Days.WEDNESDAY, testWorkoutThree);
        assertEquals(testCalendar.getCalendar().size(), 3);
    }

}
