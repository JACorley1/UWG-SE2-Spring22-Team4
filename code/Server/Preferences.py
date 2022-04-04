#!/usr/bin/env python3
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
    def __init__(self, selectedMuscles, selectedDays, intensity):
        self.intensity = intensity
        self.availableDays = []
        self.selectedMuscles = []
        muscles = selectedMuscles.split(',')
        days = selectedDays.split(',')
        for i in range (len(muscles)):
            self.processMuscle(Preferences.processString(muscles[i]))
        for j in range(len(days)):
            self.processDays(Preferences.processString(days[j]))
        

    
    #    *
    #     * processes the string
    #     * 
    #     * @return the processed string
    #   
    def processString(txt):
        specialChars = "][\\" 
        for specialChar in specialChars:
            txt = txt.replace(specialChar, '')
        return txt


    #    *
    #     * processed the muscles
    #     * 
    #     * param - txt the muscle string
    #     * sets the muscles from string
    #   
    def processMuscle(self,txt):
       self.selectedMuscles.append(MuscleGroup.MuscleGroup.fromString(txt))


    #    *
    #     * processes the day
    #     * param - txt the days string
    #     * sets the days
    #     *
    def processDays(self,txt):
        self.availableDays.append(Days.Days.fromString(txt))

    #    *
    #     * gets the intensity
    #     * 
    #     * @return the intensity
    #   
    def getIntensity(self):
        return self.intensity
    #    *
    #     * gets the list of user selected muscles
    #     * 
    #     * @return the list of muscles
    #     
    def getSelectedMuscles(self):
        return self.selectedMuscles

    def getSelectedMuscleStrings(self):
        muscles = {}
        muscleStrings = []
        for muscle in self.selectedMuscles:
            muscleStrings.append(MuscleGroup.MuscleGroup.toString(muscle))
        muscles["musclesSelected"] = muscleStrings
        return muscleStrings

    #    *
    #     * gets the user's selected days
    #     * 
    #     * @return the array list of selected days
    #     
    def getSelectedDays(self):
       return self.availableDays


    #    *
    #     * gets the selected days as a string
    #     * 
    #     * @return the string of selected days
    #   
    def getSelectedDaysStrings(self):
        days = {}
        dayStrings = []
        for day in self.availableDays:
            dayStrings.append(Days.Days.toString(day))
        days["availableDays"] = dayStrings
        return dayStrings

    def getIntensity(self):
        return int(self.intensity)
