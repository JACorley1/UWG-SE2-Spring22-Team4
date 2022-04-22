package workout_manager.viewmodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import javafx.beans.property.SimpleListProperty;
import workout_manager.model.Client;
import workout_manager.model.Days;

import workout_manager.model.ExerciseAlt;
import workout_manager.model.Intensity;

import workout_manager.model.MuscleGroup;
import workout_manager.model.Preferences;
import workout_manager.model.Stats;
import workout_manager.model.User;
import workout_manager.model.UserSerializer;
import workout_manager.model.Workout;
import workout_manager.model.WorkoutCalendar;

/**
 * Creates a ModelControllerManager
 * 
 * @author group 4
 */
public class ModelControllerManager {

    private User user;
    private Workout currentWorkout;
    private UserSerializer serializer;

    /**
     * Creates a ModelControllerManager class
     * 
     * @postcondition none
     * 
     */
    public ModelControllerManager() {
        this.serializer = new UserSerializer();
    }

    /**
     * gets the preferences from the user and retunrs it
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return this.user.preferences
     */
    public Preferences getCurrentPreferences() {
        return this.user.getPreferences();
    }

    /**
     * gets the workout for the specified day from the user's workout calender
     * 
     * @param day is the day to get the workout from
     * @return the found workout for the given day
     */
    public Workout getWorkout(String day) {
        for (Days currentDay : Days.values()) {
            if (day.toUpperCase().equals(currentDay.toString())) {
                this.currentWorkout = this.user.getWorkoutCalender().getDaysWorkout(currentDay);
                return this.user.getWorkoutCalender().getDaysWorkout(currentDay);
            }
        }
        return null;
    }

    /**
     * sets the user's preferences with the given information
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param muscles   the list of selected muscles to set for the user's preferred
     *                  muscles
     * @param days      the list of selected days to set the user's available days
     * @param intensity the intensity at which the user wishes to work out
     */
    public void setUserPrefs(SimpleListProperty<MuscleGroup> muscles, SimpleListProperty<Days> days,
            Intensity intensity) {
        this.user.setPreferences(
                new Preferences(muscles.subList(0, muscles.size()), days.subList(0, days.size()), intensity));
        this.generateWorkoutCalendar();
    }

    private void generateWorkoutCalendar() {
        Client client = Client.getClient();
        Gson gson = new GsonBuilder().create();
        String daysJson = gson.toJson(this.user.getPreferences().getSelectedDays());
        String muscleJson = gson.toJson(this.user.getPreferences().getSelectedMuscles());
        String intensityJson = gson.toJson(this.user.getPreferences().getIntensity().getCode());
        client.sendRequest("generateWorkout" + ", " + daysJson + ", " + muscleJson + ", " + intensityJson);
        String response = client.receiveResponse();
        var test = gson.fromJson(response, Map.class);
        WorkoutCalendar calendar = new WorkoutCalendar();
        for (Object day : test.keySet()) {
            Days currentDay = gson.fromJson((String) day, Days.class);
            LinkedTreeMap<String, ArrayList<LinkedTreeMap<String, String>>> list = (LinkedTreeMap<String, ArrayList<LinkedTreeMap<String, String>>>) test
                    .get(day);
            for (ArrayList<LinkedTreeMap<String, String>> current : list.values()) {
                calendar.addWorkout(currentDay, this.createWorkoutFromString(current));
            }

        }
        this.user.setWorkoutCalender(calendar);
        client.closeSocket();
    }

    private Workout createWorkoutFromString(ArrayList<LinkedTreeMap<String, String>> excerciseList) {
        Workout createdWorkout = new Workout();
        Gson gson = new GsonBuilder().create();
        for (LinkedTreeMap<String, String> current : excerciseList) {
            String jsonString = gson.toJson(current);
            ExerciseAlt currentExcercise = gson.fromJson(jsonString, new TypeToken<ExerciseAlt>() {
            }.getType());
            createdWorkout.addExercise(currentExcercise);
        }
        return createdWorkout;
    }

    /**
     * sets this.user to the given user
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param user the user to set to
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * gets the current workout and returns it
     * 
     * @precondition none
     * @postcondition none
     * @return this.workout
     */
    public Workout getCurrentWorkout() {
        return this.currentWorkout;
    }

    /**
     * sets the current workout to the given workout
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param workoutToSet is the workout to set to
     */
    public void setCurrentWOrkout(Workout workoutToSet) {
        this.currentWorkout = workoutToSet;
    }

    /**
     * Adds the specified weight and current date to the user's
     * stats
     * 
     * @param weight the user's weight
     */
    public void addUserWeightEntry(double weight) {
        Date date = new Date();
        this.user.getUserStats().addWeight(date, weight);
    }

    /**
     * Adds the specifed time duration and current date to the user's
     * stats
     * 
     * @param workoutDuration the number of minutes it took the user to
     *                        finish the workout
     */
    public void addUserWorkoutCompletionTimeEntry(double workoutDuration) {
        Date today = new Date();
        double fitnessPoints = this.user.getPreferences().getIntensity().getCode() / workoutDuration;
        this.user.getUserStats().addExerciseCompletiton(today, fitnessPoints);
    }

    /**
     * deserializes the user
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param serializedUser the serialized string representation of a User object
     * 
     */
    public void deSerialize(String serializedUser) {
        this.user = this.serializer.deserialize(serializedUser);
    }

    /**
     * serializes the user
     * 
     * @precondition none
     * @postcondition none
     */
    public void serialize() {
        this.serializer.serialize(this.user);
    }

    public Stats getUserStats() {
        return this.user.getUserStats();
    }
}
