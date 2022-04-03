#!/usr/bin/env python3

from calendar import calendar
import random
import Days
import ExerciseAlt
import dataFetcher



#*
# * defines the workout generator class.
# * 
# * @author group4
# 
class WorkoutGenerator:
    RESTDAY = "Rest Day"
    RESTDESCRIPTION = "Enjoy your Rest"
    RESTCAT = 0
    RESTEQUIP = [0]

    #    *
    #     * generates workouts based on the current users selected preferences
    #     * 
    #     * @param preferences the current users selected preferences.
    #     * @return workoutCalendar the generated calendar
    #     
    def generateWorkouts(preferences):

        exerciseMap = WorkoutGenerator.populateExercises(preferences)
        calendar = {}
        for currentDay in Days.Days:
            if currentDay in preferences.getSelectedDays():
                calendar[currentDay.name] = WorkoutGenerator.createBalancedWorkout(exerciseMap)
            else:
                calendar[currentDay.name] = WorkoutGenerator.addRestDay()
        return calendar

    def addRestDay():
        test = {}
        restDay = []
        restDay.append(ExerciseAlt.ExerciseAlt.defineDetails(WorkoutGenerator.RESTDAY, WorkoutGenerator.RESTDESCRIPTION, WorkoutGenerator.RESTCAT, WorkoutGenerator.RESTEQUIP, 0))
        test["exercises"] = restDay
        return test


    def createBalancedWorkout(exerciseMap):
        test = {}
        workout = []
        for currentGroup in exerciseMap.keys():
            range = len(exerciseMap[currentGroup])
            print(range)
            amountToAdd = 3
            while amountToAdd > 0:
                randomIndex = int((random.random() * range))
                workout.append(exerciseMap[currentGroup][randomIndex])
                amountToAdd -= 1
        test["exercises"] = workout
        return test

    def populateExercises(preferences):
        exerciseMap = {}
        for current in preferences.getSelectedMuscles():
            exerciseMap[current.value] = dataFetcher.dataFetcher.getExercises(current.value, preferences.getIntensity())
        return exerciseMap