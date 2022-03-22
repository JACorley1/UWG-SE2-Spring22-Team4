package workout_manager.test.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;

import com.google.gson.JsonIOException;

import org.junit.jupiter.api.Test;

import workout_manager.model.User;
import workout_manager.model.UserSerializer;

public class TestUserSerializer {

    private String filePath = "src/test/java/workout_manager/test/model/testUserFile.json";
    
    @Test
    void testShouldNotAllowNullFilepath() {
        assertThrows(IllegalArgumentException.class, () -> new UserSerializer(null));
    }

    @Test
    void testShouldNotAllowEmptyFilepath() {
        assertThrows(IllegalArgumentException.class, () -> new UserSerializer(""));
    }

    @Test
    void testSerialize() {
        UserSerializer serializer = new UserSerializer(this.filePath);
        User user = new User("BillyBob", "12345");

        boolean result = serializer.serialize(user);

        assertTrue(result);
    }

    @Test 
    void testDeserialize() {
        UserSerializer serializer = new UserSerializer(this.filePath);
        User user = new User("BillyBob", "12345");
        
        //User deserialized = serializer.deserialize();

        //assertEquals(user.getUserName(), deserialized.getUserName());
    }

    @Test
    void TestDeserializeErrorCaught() {
        UserSerializer userSerializer = new UserSerializer("bad.txt");

        //assertNull(userSerializer.deserialize());
    }

    @Test
    void testSerializeErrorCaught() {
        UserSerializer userSerializer = new UserSerializer("bad.txt");
        User user = null;

        assertTrue(userSerializer.serialize(user));
    }

}
