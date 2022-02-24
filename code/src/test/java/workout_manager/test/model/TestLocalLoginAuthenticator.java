package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import workout_manager.model.LocalLoginAuthenticator;

public class TestLocalLoginAuthenticator {
    
    @Test
    void testAuthenticatesLoginInfo() {
        LocalLoginAuthenticator verify = new LocalLoginAuthenticator();
        String username = "username";
        String password = "password";

        assertEquals(true, verify.authenticateLoginCredentials(username, password));
    }
    
}
