package WorkoutManager.model;

import java.util.ArrayList;
import java.util.List;

/**
 * creates a user class fro the application
 * 
 * @version Spring 2022
 * @author wtjracer
 */
public class User {

    private List<Days> preferredDays;
    private List<MuscleGroup> preferredMuscles;
    private String userName;
    private String passWord;

    /**
     * default constructor just to create a user with no preferences
     * 
     * @preCondtion userName != isEmpty() && userName != null && passWord !=
     *              isEmpty() && passWord != null
     * @postCondition getUserName == userName && getPassword == passWord
     * @param userName the User's userName
     * @param passWord the User's passWord
     */
    public User(String userName, String passWord) {
        this.preferredDays = new ArrayList<Days>();
        this.preferredMuscles = new ArrayList<MuscleGroup>();
        this.setUserName(userName);
        this.setPassWord(passWord);

    }

    /**
     * Gets the prefeerred days from the user
     * 
     * @precondition none
     * @postcondition none
     * @return this.preferredDays
     */
    public List<Days> getPreferredDays() {
        return this.preferredDays;
    }

    /**
     * sets the preferred days for this user
     * 
     * @precondition preferred days != isEmpty()
     * @postcondition none
     * 
     * @param preferredDays
     */
    public void setPreferredDays(List<Days> preferredDays) {
        if (preferredDays.isEmpty()) {
            throw new IllegalArgumentException("preferredDays cannot be empty");
        }
        this.preferredDays = preferredDays;
    }

    /**
     * Gets the prefeerred Muscles from the user
     * 
     * @precondition none
     * @postcondition none
     * @return this.preferredMuscles
     */

    public List<MuscleGroup> getPreferredMuscles() {
        return this.preferredMuscles;
    }

    /**
     * sets the preferred Muscles for this user
     * 
     * @precondition preferredMuscles != isEmpty()
     * @postcondition none
     * 
     * @param preferredMuscles is the selected list of muscles to set for the user
     */
    public void setPreferredMuscles(List<MuscleGroup> preferredMuscles) {
        if (preferredMuscles.isEmpty()) {
            throw new IllegalArgumentException("preferredMuscles cannot be empty");
        }
        this.preferredMuscles = preferredMuscles;
    }

    /**
     * gets the userName from this user
     * 
     * @precondition none
     * @postcondition none
     * @return this user's userName
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * @preCondtion userName != isEmpty() && userName != null
     * @postCondition getUserName == userName
     * @param userName the username to set for this user
     */
    public void setUserName(String userName) {
        if (userName.isEmpty()) {
            throw new IllegalArgumentException("userName cannot be empty");
        }
        if (userName.equals(null)) {
            throw new NullPointerException("userName cannot be null");
        }
        this.userName = userName;
    }

    /**
     * sets the password for this user
     * 
     * @precondition passWord != isEmpty() && passWord != null
     * @postcondition getPassword == passWord
     * @param passWord the password to set for this user
     */
    public void setPassWord(String passWord) {
        if (passWord.isEmpty()) {
            throw new IllegalArgumentException("passWord cannot be empty");
        }
        if (passWord.equals(null)) {
            throw new NullPointerException("passWord cannot be null");
        }
        this.passWord = passWord;
    }

    /**
     * gets the password from this user
     * 
     * @precondition none
     * @postcondition none
     * @return this user's password
     */
    public String getPassWord() {
        return this.passWord;
    }

}
