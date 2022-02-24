package workout_manager.model;

/**
 * local login authenticator class
 * 
 * @author group4
 */
public class LocalLoginAuthenticator implements LoginAuthenticator {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public boolean authenticateLoginCredentials(String username, String password) {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }
        if (username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        if (password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        return username.matches(USERNAME) && password.matches(PASSWORD);
    }
}
