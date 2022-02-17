package workout_manager.model;

import java.util.ArrayList;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


/**
 * Defines the attributes and behavior of the Workout Generator class. This class implements 
 * Wger's API: https://wger.de/ 
 * 
 * @author Jordan Wagner
 * @version Spriing 2022
 */
public class WorkoutDataFetcher {


    private String host = "https://exercisedb.p.rapidapi.com/exercises/bodyPart/";
    private String host2 = "https://wger.de/api/v2/exercise/?equipment=7&language=2&";
    private String charset = "UTF-8";

    private String x_rapidapi_host = "exercisedb.p.rapidapi.com";
    private String x_rapidapi_key = "2013ceea25mshf31420e0cc35329p12abbcjsn8d122231f339";//Type here your key
    
    //Format query for preventing encoding problems
    

    public ArrayList<ExerciseAlt> getExercises(String category){
        Unirest.config().enableCookieManagement(false);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser parser = new JsonParser();
        ArrayList<ExerciseAlt> exercises = new ArrayList<ExerciseAlt>();
        String query = "category="+category;
       // HttpResponse<JsonNode> response = Unirest.get(host + category)
        //.header("x-rapidapi-host", x_rapidapi_host)
        //.header("x-rapidapi-key", x_rapidapi_key)
        //.asJson();
        HttpResponse<JsonNode> response2 = Unirest.get(host2 + query)
        .asJson();
       // System.out.println(response.getStatus());
        //System.out.println(response.getHeaders().get("Content-Type"));
        //System.out.println(response2.getStatus());
        //System.out.println(response2.getHeaders().get("Content-Type"));
        
        JsonElement queryResults = parser.parse(response2.getBody().toString());
        JsonObject jsonObject = new Gson().fromJson(queryResults, JsonObject.class);
        JsonArray test = jsonObject.get("results").getAsJsonArray();
        for (JsonElement current : test) {
            ExerciseAlt exercise = gson.fromJson(current, ExerciseAlt.class);
            exercises.add(exercise);
        }    
        return exercises;
    }
    
}

