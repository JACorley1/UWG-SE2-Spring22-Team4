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
    private final String USER = "src/main/java/workout_manager/model/userFile.json";

    /**
     * serialize the given user to the USER path file
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param user the user to serialize
     */
    public void serialize(User user) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter writer = new FileWriter(USER);
            gson.toJson(user, writer);
            writer.flush();
            writer.close();
        } catch (JsonIOException | IOException e) {
            e.printStackTrace();
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
            JsonElement exerciseInfo = parser.parse(
                    new FileReader(USER));
            this.user = gson.fromJson(exerciseInfo, new TypeToken<User>() {
            }.getType());

        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e1) {
            e1.printStackTrace();
        }

        return this.user;
    }

}
