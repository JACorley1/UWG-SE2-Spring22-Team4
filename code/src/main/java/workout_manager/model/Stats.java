package workout_manager.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * class that stores the user's stats
 *
 * @author Jordan Wagner
 * @version Spring 2022
 */
public class Stats {
    
    private Map<String, Double> weightOverTime;
    private Map<String, Double> workoutCompletion;
    private Map<String, Integer> fitnessPointsOverTime;



    /**
     * Creates a stat object that contains user stats
     * 
     * @param weightMap the map of weight over time
     * @param workoutTimeMap the map of completion times and dates
     * @param fitnessPointsMap the map of points gained and dates
     */
    public Stats(Map<String,Double> weightMap, Map<String,Double> workoutTimeMap, Map<String, Integer> fitnessPointsMap) {
        this.weightOverTime = weightMap;
        this.workoutCompletion = workoutTimeMap;
        this.fitnessPointsOverTime = fitnessPointsMap;
    }

    /**
     * Stats object that contains user Stats
     * 
     * @precondition none
     * @postcondition none
     */
    public Stats() {
        this.weightOverTime = new HashMap<String, Double>();
        this.workoutCompletion = new HashMap<String, Double>();
        this.fitnessPointsOverTime = new HashMap<String, Integer>();
       
    }

    /**
     * adds a weight stat for a given day
     * @param dateToAdd the day to add the weight for
     * @param currentWeight the measured weight
     */
    public void addWeight(Date dateToAdd, double currentWeight) {
        this.weightOverTime.put(this.formatDate(dateToAdd), currentWeight);
    }

    private String formatDate(Date dateToFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(dateToFormat);
    }
    /**
     * adds time to complete workout to a given data
     * @param dateToAdd the day to add the completion time for
     * @param completionTime the days workouts completion time
     */
    public void addExerciseCompletiton(Date dateToAdd, double completionTime) {
        this.workoutCompletion.put(this.formatDate(dateToAdd), completionTime);
    }

    /**
     * adds fitness points gained for a day
     * @param dateToAdd the day of the fitness point gain
     * @param pointsToAdd the amount of points gained
     */
    public void addFitnessPoints(Date dateToAdd, int pointsToAdd) {
        this.fitnessPointsOverTime.put(this.formatDate(dateToAdd), pointsToAdd);
    }

    /**
     * gets the weight over time stats
     * @return the map of weight and dates
     */
    public Map<String, Double> getWeightOverTime() {
        return this.weightOverTime;
    }

    /**
     * Gets the workout completion times and dates
     * @return the map of the workout completion times and dates
     */
    public Map<String, Double> getWorkoutCompletionOverTime() {
        return this.workoutCompletion;
    }

    /**
     * gets the fitness points gained over time
     * @return the map of fitness points and dates
     */
    public Map<String, Integer> getFitnessPointsOverTime() {
        return this.fitnessPointsOverTime;
    }

    /**
     * gets the users total fitness points gained
     * @return int showing the total fitness points gained
     */
    public int totalFitnessPointsGained() {
        int sumOfPoints = 0;
        for (Integer currentPoints : this.fitnessPointsOverTime.values()) {
            sumOfPoints += currentPoints;
        }
        return sumOfPoints;
    }

    /**
     * gets the average workout completiton time
     * @return the average workout completition time in minutes
     */
    public double getAverageWorkoutTime() {
        double average = 0;
        for (Double completionTime: this.workoutCompletion.values()) {
            average += completionTime;
        }
        return average / this.workoutCompletion.size();
    }


}
