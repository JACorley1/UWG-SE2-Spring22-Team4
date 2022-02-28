package workout_manager.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

/**
 * Creates a User serializer class
 * 
 * @version Spring 2022
 * @author group 4
 * 
 */
public class UserSerializer {
    private User user;
    private String filepath;

    public UserSerializer(String filepath) {
        if (filepath == null){
            throw new IllegalArgumentException("Filepath cannot be null");
        }
        if (filepath.isEmpty()){
            throw new IllegalArgumentException("Filepath cannot be empty");
        }
        this.filepath = filepath;
    }

    /**
     * serialize the given user to the USER path file
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param user the user to serialize
     * @return true if the serializer was successful; false otherwise
     */
    public boolean serialize(User user) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter writer = new FileWriter(this.filepath);
            gson.toJson(user, writer);
            writer.flush();
            writer.close();
            return true;
        } catch (JsonIOException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * deserializes the user
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return User
     */
    public User deserialize() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser parser = new JsonParser();
        
        try {
            FileReader reader = new FileReader(this.filepath);
            JsonElement exerciseInfo = parser.parse(reader);
            this.user = gson.fromJson(exerciseInfo, new TypeToken<User>() {
            }.getType());

        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e1) {
            e1.printStackTrace();
        }

        return this.user;
    }

}
