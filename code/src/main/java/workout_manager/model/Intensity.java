package workout_manager.model;

/**
 * Creates a class for intensity enums
 * 
 * @author wtjracer
 * @version Spring 2022
 * 
 */
public enum Intensity {
    BEGINNER(30), INTERMEDIATE(45), ADVANCED(60);

    private final int code;

    Intensity(int code) {
        this.code = code;
    }

    /**
     * returns the int code for the Intensity
     * 
     * @precondition none
     * @postcondition none
     * @return the int code for the Intensity
     */
    public int getCode() {
        return this.code;
    }

    /**
     * gets the enum that has the code value of the given int
     * 
     * @precondition none
     * @postcondition none
     * @param toGetEnumFrom is the int to search for in the intensity enum class
     * @return the enum that has the code value of the given int
     */
    public Intensity getEnumFromInt(int toGetEnumFrom) {
        if (toGetEnumFrom == 30) {
            return BEGINNER;
        } else if (toGetEnumFrom == 45) {
            return INTERMEDIATE;
        } else {
            return ADVANCED;
        }
    }
}
