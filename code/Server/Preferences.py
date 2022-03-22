#!/usr/bin/env python3
from matplotlib.style import available
import Days
import MuscleGroup
#*
# * class that stores the user's selected preferences
# *
# * @author Jordan Wagner
# * @version Spring 2022
# 
class Preferences:

    availableDays = []
    selectedMuscles = []
    intensity = 0
    #    *
    #     * preferences object that contains user selected preferences
    #     * 
    #     * @param selectedDays    the days selected by the user
    #     * @param selectedMuscles the muscles selected by the user
    #     
    def __init__(self, selectedMuscles, selectedDays):
        muscles = selectedMuscles.split(',')
        days = selectedDays.split(',')
        for i in range (len(muscles)):
            self.processMuscle(Preferences.processString(muscles[i]))
        for j in range(len(days)):
            self.processDays(Preferences.processString(days[j]))

    def processString(txt):
        specialChars = "][\\" 
        for specialChar in specialChars:
            txt = txt.replace(specialChar, '')
        return txt

    def processMuscle(self,txt):
       self.selectedMuscles.append(MuscleGroup.MuscleGroup.fromString(txt))

    def processDays(self,txt):
        self.availableDays.append(Days.Days.fromString(txt))
    #    *
    #     * gets the list of user selected muscles
    #     * 
    #     * @return the list of muscles
    #     
    def getSelectedMuscles(self):
        return self.selectedMuscles

    #    *
    #     * gets the user's selected days
    #     * 
    #     * @return the array list of selected days
    #     
    def getSelectedDays(self):
        return self.availableDays

    def getIntensity(self):
        return self.intensity
