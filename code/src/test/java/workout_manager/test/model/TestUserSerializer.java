package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import workout_manager.model.Days;
import workout_manager.model.Intensity;
import workout_manager.model.MuscleGroup;
import workout_manager.model.Preferences;
import workout_manager.model.User;
import workout_manager.model.UserSerializer;

public class TestUserSerializer {
    
    @Test
    void testValidSerializationAndDeserialization() {
        UserSerializer serializer = new UserSerializer();
        User newUser = new User("username", "password");
        newUser.setPreferences(new Preferences(new ArrayList<MuscleGroup>(), new ArrayList<Days>(), Intensity.ADVANCED));
        String result = serializer.serialize(newUser);
        
        System.out.println("serialized - " + result);
        User expected = serializer.deserialize(result);
    
        assertEquals(expected.getUserName(), newUser.getUserName());
    }
}
