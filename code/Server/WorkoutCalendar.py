#!/usr/bin/env python3

#*
# * defines the workoutCalendar class
# * 
# * @author group4
# 
class WorkoutCalendar:

    workoutCalendar = {}
    
    #    *
    #     * adds a workout to a specific day
    #     * 
    #     * @param day          the day the workout is scheduled on
    #     * @param workoutToAdd the workout to add
    #     
    def addWorkout(self, day, workoutToAdd):

        self.workoutCalendar[day] = workoutToAdd


    #    *
    #     * gets the map of days and workouts.
    #     * 
    #     * @return the users calendar
    #     
    def getCalendar(self):
        return self.workoutCalendar

    #    *
    #     * gets a specified days workout
    #     * 
    #     * @param day the day to get the workout for
    #     * @return the workout scheduled on the day.
    #     
    def getDaysWorkout(self, day):
        return self.workoutCalendar[day.name]
