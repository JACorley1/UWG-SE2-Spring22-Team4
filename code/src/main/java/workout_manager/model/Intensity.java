package workout_manager.model;

/**
 * Creates a class for intensity enums
 * 
 * @author wtjracer
 * @version Spring 2022
 * 
 */
public enum Intensity {
    BEGINNER(0), INTERMEDIATE(1), ADVANCED(2);

    private final int code;

    Intensity(int code) {
        this.code = code;
    }

    /**
     * returns the int code for the Intensity
     * 
     * @return the int code for the Intensity
     */
    public int getCode() {
        return this.code;
    }

    public Intensity getEnumFromInt(int toGetEnumFrom){
        if (toGetEnumFrom == 0 ){
            return BEGINNER;
        }
        else if (toGetEnumFrom == 1){
            return INTERMEDIATE;
        }
        else {
            return ADVANCED;
        }
    }
}
