#*
# * defines the workout class
# * 
# * @author group4
# 
class Workout:


    #    *
    #     * constucts a workout object
    #     
    def __init__(self):
        #instance fields found by Java to Python Converter:
        self.__exercises = None

        self.__exercises = []

    #    *
    #     * adds an exercise to the workout
    #     * 
    #     * @precondition exercise cant be null
    #     * @postcondition exercises.size() == exercises.size +1 @prev
    #     * 
    #     * @param exercise the exercise to add to the workout
    #     
    def addExercise(self, exercise):
        if exercise is None:
            raise IllegalArgumentException("Exercise can't be null")
        self.__exercises.append(exercise)

    #    *
    #     * gets the collection of exercises in the workout
    #     * 
    #     * @return the collection of exercises
    #     
    def getExercises(self):
        return self.__exercises
