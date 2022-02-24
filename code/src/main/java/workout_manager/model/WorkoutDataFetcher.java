package workout_manager.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

/**
 * Defines the attributes and behavior of the Workout Data fetcher class. This
 * class implements
 * 
 * @author Jordan Wagner
 * @version Spring 2022
 */
public class WorkoutDataFetcher implements DataFetcher {

    private File exerciseDataFile = new File(
            "src/main/java/workout_manager/model/exerciseData.json");
    private ArrayList<ExerciseAlt> exerciseData;
    private static final int NOEQUIPMENT = 7;

    /**
     * creates a workoutDataFetcher containing exercise data
     */
    public WorkoutDataFetcher() {
        this.exerciseData = new ArrayList<ExerciseAlt>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser parser = new JsonParser();
        try {
            JsonElement exerciseInfo = parser.parse(new FileReader(this.exerciseDataFile));
            JsonArray arrayOfExercises = exerciseInfo.getAsJsonArray();
            this.exerciseData = gson.fromJson(arrayOfExercises, new TypeToken<ArrayList<ExerciseAlt>>() {
            }.getType());
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e1) {
            e1.printStackTrace();
        }

    }

    @Override
    public ArrayList<ExerciseAlt> getExercises(int category) {
        ArrayList<ExerciseAlt> exercises = new ArrayList<ExerciseAlt>();
        for (ExerciseAlt currentExercise : this.exerciseData) {
            if (category == currentExercise.getCategory() && currentExercise.getEquipment() == NOEQUIPMENT) {
                exercises.add(currentExercise);
            }
        }
        return exercises;
    }
}
