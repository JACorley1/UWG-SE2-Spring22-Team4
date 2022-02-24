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

    /**
     * gets the name of the exercise
     * 
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * gets the text description of the exercise
     * 
     * @return the description of the exercise
     */
    public String getDescription() {
        return this.description.replaceAll("\\<[^>]*>", "");
    }

}
