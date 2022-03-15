import random

#*
# * defines the workout generator class.
# * 
# * @author group4
# 
class WorkoutGenerator:
    __RESTDAY = "Rest Day"
    __RESTDESCRIPTION = "Enjoy your Rest"
    __RESTCAT = 0
    __RESTEQUIP = [0]

    #    *
    #     * creates a workout generator object.
    #     
    def __init__(self):
        #instance fields found by Java to Python Converter:
        self.__dataFetcher = None

        self.__dataFetcher = WorkoutDataFetcher()

    #    *
    #     * generates workouts based on the current users selected preferences
    #     * 
    #     * @param preferences the current users selected preferences.
    #     * @return workoutCalendar the generated calendar
    #     
    def generateWorkouts(self, preferences):

        exerciseMap = self.__populateExercises(preferences)
        workoutCalendar = WorkoutCalendar()

        for currentDay in Days.values():
            if preferences.getSelectedDays().contains(currentDay):
                workoutCalendar.addWorkout(currentDay, self.__createBalancedWorkout(exerciseMap))
            else:
                workoutCalendar.addWorkout(currentDay, self.__addRestDay())

        return workoutCalendar

    def __addRestDay(self):
        restDay = Workout()
        restDay.addExercise(ExerciseAlt(workout_manager.model.WorkoutGenerator.__RESTDAY, workout_manager.model.WorkoutGenerator.__RESTDESCRIPTION, workout_manager.model.WorkoutGenerator.__RESTCAT, workout_manager.model.WorkoutGenerator.__RESTEQUIP))
        return restDay


    def __createBalancedWorkout(self, exerciseMap):
        workout = Workout()
        for currentGroup in exerciseMap.keys():
            range = len(exerciseMap[currentGroup])
            amountToAdd = 1
            while amountToAdd > 0:
                randomIndex = int((random.random() * range))
                workout.addExercise(exerciseMap[currentGroup][randomIndex])
                amountToAdd -= 1
        return workout

    def __populateExercises(self, preferences):
        exerciseMap = {}
        for current in preferences.getSelectedMuscles():
            exerciseMap[current] = self.__dataFetcher.getExercises(current.getCode())
        return exerciseMap
