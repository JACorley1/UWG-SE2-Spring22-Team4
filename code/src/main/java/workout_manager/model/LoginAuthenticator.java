package workout_manager.model;

public interface LoginAuthenticator {
    
    boolean authenticateLoginCredentials(String username, String password);
}