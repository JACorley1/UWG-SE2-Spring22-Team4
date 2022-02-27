package workout_manager.model;

import java.util.ArrayList;
import java.util.List;

/**
 * creates a user class fro the application
 * 
 * @version Spring 2022
 * @author wtjracer
 */
public class User {

    private Preferences preferences;
    private WorkoutCalendar workoutCalender;

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

        this.preferences = new Preferences();
        this.setUserName(userName);
        this.setPassWord(passWord);
        this.workoutCalender = new WorkoutCalendar();

    }

    /**
     * gets the preferences from the user
     * 
     * @precondition none
     * @postcondtion none
     * 
     * @return this preferences
     */
    public Preferences getPreferences() {
        return this.preferences;
    }

    /**
     * Sets the preferences for the user
     * 
     * @precondition none
     * @postcondition this.preferences = preferences
     * 
     * @param preferences
     */
    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    /**
     * Gets the workout calender from the user
     * 
     * @precondition none
     * @postcondition none
     * @return this.workoutCalender
     */
    public WorkoutCalendar getWorkoutCalender() {
        return workoutCalender;
    }

    /**
     * Setss the workout Calender from the user
     * 
     * @precondition none
     * @postcondition none
     * @param workoutCalender is the workout Calnder to set
     */
    public void setWorkoutCalender(WorkoutCalendar workoutCalender) {
        this.workoutCalender = workoutCalender;
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
     * sets the userName for the user.
     * 
     * @preCondtion userName != isEmpty() && userName != null
     * @postCondition getUserName == userName
     * @param userName the username to set for this user
     */
    public void setUserName(String userName) {
        if (userName == null) {
            throw new NullPointerException("userName cannot be null");
        } else if (userName.isEmpty()) {
            throw new IllegalArgumentException("userName cannot be empty");
        } else {
            this.userName = userName;
        }

    }

    /**
     * sets the password for this user
     * 
     * @precondition passWord != isEmpty() && passWord != null
     * @postcondition getPassword == passWord
     * @param passWord the password to set for this user
     */
    public void setPassWord(String passWord) {
        if (passWord == null) {
            throw new NullPointerException("passWord cannot be null");
        } else if (passWord.isEmpty()) {
            throw new IllegalArgumentException("passWord cannot be empty");
        } else {
            this.passWord = passWord;
        }

    }

    /**
     * mvn
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
