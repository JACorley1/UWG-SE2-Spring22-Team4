package workout_manager.model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
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

    /**
     * serialize the given user to the USER path file
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param user the user to serialize
     * @return true if the serializer was successful; false otherwise
     */
    public String serialize(User user) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(user);

    }

    /**
     * deserializes the user
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param serializedUser the serialized form of the user to deserialize
     * 
     * @return User
     */
    public User deserialize(String serializedUser) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            this.user = gson.fromJson(serializedUser, new TypeToken<User>() {
            }.getType());
            Intensity intensityToSet = Intensity.ADVANCED;
            intensityToSet = intensityToSet.getEnumFromInt(this.getIntensityFromString(serializedUser));
            this.user.getPreferences().setIntensity(intensityToSet);
        } catch (JsonIOException | JsonSyntaxException e1) {
            e1.printStackTrace();
        }
        return this.user;
    }

    private int getIntensityFromString(String serializedUser) {
        Pattern intensityPattern = Pattern.compile("\"intensity\": [0-9][0-9]");
        Matcher matcher = intensityPattern.matcher(serializedUser);
        String intensity = "";
        if (matcher.find()) {
            intensity = matcher.group(0);
            String[] intensityString = intensity.split("\"intensity\": ");
            int intensityInt = Integer.parseInt(intensityString[1]);
            return intensityInt;
        } else {
            return 30;
        }
    }
}
