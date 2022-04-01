package workout_manager.viewmodel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
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
import workout_manager.model.User;
import workout_manager.model.UserSerializer;
import workout_manager.model.Workout;
import workout_manager.model.WorkoutCalendar;
import workout_manager.model.WorkoutGenerator;

/**
 * Creates a ModelControllerManager
 * 
 * @author group 4
 */
public class ModelControllerManager {

    private String userFilePath;
    private User user;
    private Workout currentWorkout;
    private UserSerializer serializer;

    /**
     * Creates a ModelControllerManager class
     * 
     * @precondition filepath != null && !filepath.isEmpty()
     * @postcondition none
     * 
     * @param filepath the filepath
     */
    public ModelControllerManager(String filepath) {
        if (filepath == null) {
            throw new IllegalArgumentException("Filepath cannot be null");
        }
        if (filepath.isEmpty()) {
            throw new IllegalArgumentException("Filepath cannot be empty");
        }
        this.userFilePath = filepath;
        this.serializer = new UserSerializer(this.userFilePath);
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
     * @param muscles the list of selected muscles to set for the user's preferred
     *                muscles
     * @param days    the list of selected days tos set the user's available days
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
        System.out.print(response);
        var test = gson.fromJson(response, Map.class);
        WorkoutCalendar calendar = new WorkoutCalendar();
        for (Object day: test.keySet()){
            Days currentDay = gson.fromJson((String) day, Days.class);
            LinkedTreeMap<String, ArrayList<LinkedTreeMap<String, String>>> list = (LinkedTreeMap<String,ArrayList<LinkedTreeMap<String, String>>>) test.get(day);
            for (ArrayList<LinkedTreeMap<String, String>> current : list.values()) {
                System.out.println(this.createWorkoutFromString(current));
                calendar.addWorkout(currentDay, this.createWorkoutFromString(current));

            }
            
        }
        this.user.setWorkoutCalender(calendar);
    }

    private Workout createWorkoutFromString(ArrayList<LinkedTreeMap<String, String>> excerciseList){
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
     * deserializes the user
     * 
     * @precondition none
     * @postcondition none
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

}
