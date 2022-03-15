#*
# * defines the workoutCalendar class
# * 
# * @author group4
# 
class WorkoutCalendar:


    #    *
    #     * constructs a workout calendar object
    #     
    def __init__(self):
        #instance fields found by Java to Python Converter:
        self.__workoutCalendar = None

        self.__workoutCalendar = {}

    #    *
    #     * adds a workout to a specific day
    #     * 
    #     * @param day          the day the workout is scheduled on
    #     * @param workoutToAdd the workout to add
    #     
    def addWorkout(self, day, workoutToAdd):

        self.__workoutCalendar[day] = workoutToAdd


    #    *
    #     * gets the map of days and workouts.
    #     * 
    #     * @return the users calendar
    #     
    def getCalendar(self):
        return self.__workoutCalendar

    #    *
    #     * gets a specified days workout
    #     * 
    #     * @param day the day to get the workout for
    #     * @return the workout scheduled on the day.
    #     
    def getDaysWorkout(self, day):
        return self.__workoutCalendar[day]
