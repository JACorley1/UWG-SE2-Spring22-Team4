package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import workout_manager.model.LocalLoginAuthenticator;

public class TestLocalLoginAuthenticator {
    
    @Test
    void testShouldNotAllowNullUsername() {
        LocalLoginAuthenticator verify = new LocalLoginAuthenticator();
        assertThrows(IllegalArgumentException.class, () -> verify.authenticateLoginCredentials(null, "password"));
    }

    @Test
    void testShouldNotAllowEmptyUsername() {
        LocalLoginAuthenticator verify = new LocalLoginAuthenticator();
        assertThrows(IllegalArgumentException.class, () -> verify.authenticateLoginCredentials("", "password"));
    }

    @Test
    void testShouldNotAllowNullPassword() {
        LocalLoginAuthenticator verify = new LocalLoginAuthenticator();
        assertThrows(IllegalArgumentException.class, () -> verify.authenticateLoginCredentials("username", null));
    }

    @Test
    void testShouldNotAllowEmptyPassword() {
        LocalLoginAuthenticator verify = new LocalLoginAuthenticator();
        assertThrows(IllegalArgumentException.class, () -> verify.authenticateLoginCredentials("username", ""));
    }

    @Test
    void testAuthenticatesLoginInfo() {
        LocalLoginAuthenticator verify = new LocalLoginAuthenticator();
        String username = "username";
        String password = "password";

        assertEquals(true, verify.authenticateLoginCredentials(username, password));
    }

    @Test
    void testDoesNotAuthenticateInvalidCredentials() {
        LocalLoginAuthenticator verify = new LocalLoginAuthenticator();
        assertEquals(false, verify.authenticateLoginCredentials("Toby", "Keith"));
    }

    @Test
    void testDoesNotAuthenticateValidUsernameWithInvalidPassword() {
        LocalLoginAuthenticator verify = new LocalLoginAuthenticator();
        assertEquals(false, verify.authenticateLoginCredentials("username", "BigDaddy56"));
    }

    @Test
    void testDoesNotAuthenticateInvalidUsernameWithValidPassword() {
        LocalLoginAuthenticator verify = new LocalLoginAuthenticator();
        assertEquals(false, verify.authenticateLoginCredentials("Bobby", "password"));
    }
    
}
