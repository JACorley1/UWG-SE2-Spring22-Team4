package workout_manager.model;

/**
 * Creates a enum for each Muscle groupd for the user to select
 * 
 * @version Spring 2022
 * @author wtjracer
 */
public enum MuscleGroup {
    ARMS("arms", 0), LEGS("legs", 1), BACK("back", 2), ABS("abs", 3), CHEST("chest", 4), SHOULDERS("shoulders", 5),
    CALVES("calves", 6);

    private final String value;
    private final int code;

    MuscleGroup(String value, int code) {
        this.value = value;
        this.code = code;
    }

    

    /**
     * returns the string value of this muscle
     * 
     * @precondition none
     * @postconditino none
     * @return the string value of the enum
     */
    public String valueOf() {
        return this.value;
    }

    /**
     * returns the int code for the muscle
     * 
     * @return the int code for the muscle
     */
    public int getCode() {
        return this.code;
    }

}
