package workout_manager.viewmodel;


import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import javafx.beans.property.SimpleListProperty;

import workout_manager.model.Days;
import workout_manager.model.MuscleGroup;
import workout_manager.model.Preferences;
import workout_manager.model.User;
import workout_manager.model.Workout;
import workout_manager.model.WorkoutCalendar;
import workout_manager.model.WorkoutDataFetcher;
import workout_manager.model.WorkoutGenerator;
import workout_manager.view.DailyDetailsController;
import workout_manager.view.LoginController;
import workout_manager.view.PreferenceController;
import workout_manager.view.WeeklyViewController;

/**
 * Creates a ModelControllerManager
 * 
 * @author group 4
 */
public class ModelControllerManager {

    private DailyDetailsController dailyController;
    private LoginController loginController;
    private PreferenceController prefController;
    private WeeklyViewController weeklyViewcontroller;
    private static WorkoutDataFetcher dataFetcher;
    private WorkoutGenerator workoutGenerator;
    private User user;
    private Workout currentWorkout;
 

    /**
     * 
     * 
     * 
     */
    public ModelControllerManager() {
        this.dailyController = new DailyDetailsController();
        this.prefController = new PreferenceController();
        this.weeklyViewcontroller = new WeeklyViewController();
        dataFetcher = new WorkoutDataFetcher();
        this.workoutGenerator = new WorkoutGenerator(dataFetcher);

    }

    public Preferences getCurrentPreferences() {
        return this.user.getPreferences();
    }

    public Workout getWorkout(String day){
        for (Days currentDay : Days.values()) {
            if (day.toUpperCase().equals(currentDay.toString())){
                this.currentWorkout = this.user.getWorkoutCalender().getDaysWorkout(currentDay);
                return this.user.getWorkoutCalender().getDaysWorkout(currentDay);
            }
        }
        return null;
    }

    public void setUserPrefs(SimpleListProperty<MuscleGroup> muscles, SimpleListProperty<Days> days) {
   
        this.user.setPreferences(new Preferences(muscles.subList(0, muscles.size()), days.subList(0, days.size())));
        this.generateWorkoutCalendar();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            gson.toJson(user, new FileWriter("userFile.json"));
        } catch (JsonIOException | IOException e) {

            e.printStackTrace();
        }
        
    }

    private void generateWorkoutCalendar(){
       this.user.setWorkoutCalender(this.workoutGenerator.generateWorkouts(this.user.getPreferences())); 
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Workout getCurrentWorkout(){
        return this.currentWorkout;
    }
    public void setCurrentWOrkout(Workout workoutToSet){
        this.currentWorkout = workoutToSet;
    }

}
