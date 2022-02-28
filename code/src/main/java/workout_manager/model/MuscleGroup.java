package workout_manager.model;

/**
 * Creates a enum for each Muscle groupd for the user to select
 * 
 * @version Spring 2022
 * @author wtjracer
 */
public enum MuscleGroup {
    ARMS("arms", 8), LEGS("legs", 9), BACK("back", 12), ABS("abs", 10), CHEST("chest", 11), SHOULDERS("shoulders", 13),
    CALVES("calves", 14);

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
