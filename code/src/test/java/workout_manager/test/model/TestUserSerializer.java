package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import workout_manager.model.User;
import workout_manager.model.UserSerializer;

public class TestUserSerializer {
    
    @Test
    void testValidSerializationAndDeserialization() {
        UserSerializer serializer = new UserSerializer();
        String userString = "{\"preferences\": {\"availableDays\": [\"WEDNESDAY\",\"FRIDAY\"],\"musclesSelected\": [],\"intensity\": 0},\"workoutCalender\": {\"workoutCalendar\": {}},\"userName\": \"username\",\"passWord\": \"password\"}";
        User newUser = serializer.deserialize(userString);
        String result = serializer.serialize(newUser);
        
        assertEquals(0, newUser.getWorkoutCalender().getCalendar().size());
        assertEquals('{', result.charAt(0));
    }

    @Test
    void handlesExceptions() {
        UserSerializer serializer = new UserSerializer();
        String userString = "\"preferences\": {\"availableDays\": [\"WEDNESDAY\",\"FRIDAY\"],\"musclesSelected\": [],\"intensity\": 0},\"workoutCalender\": {\"workoutCalendar\": {}},\"userName\": \"username\",\"passWord\": \"password\"}";
        User newUser = serializer.deserialize(userString);

        assertEquals(null, newUser);
    }

    @Test
    void patternHasNoMatches() {
        UserSerializer serializer = new UserSerializer();
        String userString = "{\"preferences\": {\"availableDays\": [\"WEDNESDAY\",\"FRIDAY\"],\"musclesSelected\": []},\"workoutCalender\": {\"workoutCalendar\": {}},\"userName\": \"username\",\"passWord\": \"password\"}";
        User newUser = serializer.deserialize(userString);

        assertEquals(30, newUser.getPreferences().getIntensity().getCode());
    }

    @Test
    void patternMatches() {
        UserSerializer serializer = new UserSerializer();
        String userString = "{\"preferences\": {\"availableDays\": [\"WEDNESDAY\",\"FRIDAY\"],\"musclesSelected\": []},\"workoutCalender\": {\"workoutCalendar\": {}},\"intensity\": 45,\"userName\": \"username\",\"passWord\": \"password\"}";
        User newUser = serializer.deserialize(userString);

        assertEquals(45, newUser.getPreferences().getIntensity().getCode());
    }
}