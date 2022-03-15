#*
# * class that stores the user's selected preferences
# *
# * @author Jordan Wagner
# * @version Spring 2022
# 
class Preferences:

    def _initialize_instance_fields(self):
        #instance fields found by Java to Python Converter:
        self.__availableDays = None
        self.__musclesSelected = None



    #    *
    #     * preferences object that contains user selected preferences
    #     * 
    #     * @param selectedDays    the days selected by the user
    #     * @param selectedMuscles the muscles selected by the user
    #     
    def __init__(self, selectedMuscles, selectedDays):
        self._initialize_instance_fields()


        self.__availableDays = selectedDays
        self.__musclesSelected = selectedMuscles

    def __init__(self):
        self._initialize_instance_fields()

        self.__availableDays = []
        self.__musclesSelected = []

    #    *
    #     * gets the list of user selected muscles
    #     * 
    #     * @return the list of muscles
    #     
    def getSelectedMuscles(self):
        return self.__musclesSelected

    #    *
    #     * gets the user's selected days
    #     * 
    #     * @return the array list of selected days
    #     
    def getSelectedDays(self):
        return self.__availableDays
