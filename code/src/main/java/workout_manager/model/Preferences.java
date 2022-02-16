package workout_manager.model;

import java.util.ArrayList;

/**
 * class that stores the user's selected preferences
 */
public class Preferences {

    private ArrayList<Days> availableDays;
    private ArrayList<MuscleGroup> musclesSelected;

    /**
     * preferences object that contains user selected preferences
     * @param selectedDays the days selected by the user
     * @param selectedMuscles the muscles selected by the user
     */
    public Preferences(ArrayList<Days> selectedDays, ArrayLost<MuscleGroup> selectedMuscles){

        this.availableDays = selectedDays;
        this.musclesSelected = selectedMuscles;

    }
    /**
     * gets the list of user selected muscles
     * @return the list of muscles
     */
    public ArrayList<MuscleGroup> getSelectedMuscles(){
        return this.musclesSelected;
    }

    /**
     * gets the user's selected days
     * @return the array list of selected days
     */
    public ArrayList<Days> getSelectedDays(){
        return this.availableDays;

    }
    
}
