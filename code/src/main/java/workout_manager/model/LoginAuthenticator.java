package workout_manager.model;
/**
 * loginAuthenticator interface
 * @author group4
 */
public interface LoginAuthenticator {

    /**
     * authenticats user login credentials
     * @param username the users inputted username
     * @param password the users inputted password
     * @return true if authenticated false otherwise
     */
    boolean authenticateLoginCredentials(String username, String password);
}