package workout_manager.model;

import java.util.ArrayList;
import java.util.List;

/**
 * class that stores the user's selected preferences
 *
 * @author Jordan Wagner
 * @version Spring 2022
 */
public class Preferences {

    private List<Days> availableDays;
    private List<MuscleGroup> musclesSelected;
    private Intensity intensity;

    /**
     * preferences object that contains user selected preferences
     * 
     * @param selectedDays    the days selected by the user
     * @param selectedMuscles the muscles selected by the user
     */
    public Preferences(List<MuscleGroup> selectedMuscles, List<Days> selectedDays, Intensity intensity) {

        this.availableDays = selectedDays;
        this.musclesSelected = selectedMuscles;
        this.intensity = intensity;

    }

    public Preferences() {
        this.availableDays = new ArrayList<Days>();
        this.musclesSelected = new ArrayList<MuscleGroup>();
        this.intensity = null;
    }

    /**
     * gets the intensity preference of the user
     * 
     * @return the intensity
     */
    public Intensity getIntensity() {
        return this.intensity;
    }

    /**
     * gets the list of user selected muscles
     * 
     * @return the list of muscles
     */
    public List<MuscleGroup> getSelectedMuscles() {
        return this.musclesSelected;
    }

    /**
     * gets the user's selected days
     * 
     * @return the array list of selected days
     */
    public List<Days> getSelectedDays() {
        return this.availableDays;

    }

}
