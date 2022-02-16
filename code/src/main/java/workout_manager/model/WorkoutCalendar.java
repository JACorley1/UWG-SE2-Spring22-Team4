package workout_manager.model;

import java.util.HashMap;
import java.util.Map;

/**
 * defines the workoutCalendar class
 */
public class WorkoutCalendar {

    private Map<Days, Workout> workoutCalendar;

    /**
     * constructs a workout calendar object
     */
    public WorkoutCalendar(){
        this.workoutCalendar = new HashMap<Days, Workout>();
    }

    /**
     * adds a workout to a specific day
     * @param day the day the workout is scheduled on
     * @param workoutToAdd the workout to add
     */
    public addWorkout(Days day, Workout workoutToAdd){

        this.workoutCalendar.put(day, workoutToAdd);

    }

    /**
     * gets the map of days and workouts.
     * @return the users calendar
     */
    public Map<Days, Workout> getCalendar(){
        return this.workoutCalendar;
    }

    /**
     * gets a specified days workout
     * @param day the day to get the workout for
     * @return the workout scheduled on the day.
     */
    public Workout getDaysWorkout(Days day){
        return this.workoutCalendar.get(day);
    }

}
