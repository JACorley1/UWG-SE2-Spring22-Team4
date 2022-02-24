package workout_manager.model;

/**
 * Creates a enum for each Muscle groupd for the user to select
 * 
 * @version Spring 2022
 * @author wtjracer
 */
public enum MuscleGroup {
    ARMS("arms"), LEGS("legs"), BACK("back"), ABS("abs"), CHEST("chest"), SHOULDERS("shoulders"), CALVES("calves");

    private final String value;

    MuscleGroup(String value) {
        this.value = value;
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

}
