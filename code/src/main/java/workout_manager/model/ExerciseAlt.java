package workout_manager.model;

/**
 * defines the exercise alt class for deserializing JSONS from the third part
 * API
 * 
 * @author group4
 */
public class ExerciseAlt {

    private String name;
    private String description;
    private int category;
    private int[] equipment;
    private int intensity;

    /**
     * creates an exerciseAlt object
     * 
     * @precondition !name.isEmpty() && description.isEmpty() && name != null &&
     *               description != null
     * @postcondition this.name == name && this.description == description
     * @param name        the name of the excersise
     * @param description the description of the exercise
     * @param category    the muscle category
     * @param equipment   int representation of equipment
     */
    public ExerciseAlt(String name, String description, int category, int[] equipment, int intensity) {
        if (name == null) {
            throw new IllegalArgumentException("name cant be null created");
        }
        if (description == null) {
            throw new IllegalArgumentException("description cant be null created");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("exercise name cant be empty");
        }
        if (description.isEmpty()) {
            throw new IllegalArgumentException("exercise description cant be empty");
        }
        if (intensity < 0) {
            throw new IllegalArgumentException("intensity must be greater than zero");
        }
        this.name = name;
        this.description = description;
        this.category = category;
        this.equipment = equipment;
        this.intensity = intensity;
    }

    /**
     * gets the name of the exercise
     * 
     * @precondition none
     * @postcondition none
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * gets the text description of the exercise
     * 
     * @precondition none
     * @postcondition none
     * @return the description of the exercise
     */
    public String getDescription() {
        return this.description.replaceAll("\\<[^>]*>", "");
    }

    /**
     * returns the int representation of the muscle category defined by the data
     * 
     * @precondition none
     * @postcondition none
     * @return the int representation of the muscle category
     */
    public int getCategory() {
        return this.category;
    }

    /**
     * returns the int representation of the muscle category defined by the data
     * 
     * @precondition none
     * @postcondition none
     * @return the int representation for equipment
     */
    public int getEquipment() {
        if (this.equipment.length > 0) {
            return this.equipment[0];
        } else {
            return 0;
        }

    }

    /**
     * returns the int representation of the exercise intensity
     * 
     * @precondition none
     * @postcondition none
     * @return the int representation for intensity
     */
    public int getIntensity() {
        return this.intensity;
    }

}
