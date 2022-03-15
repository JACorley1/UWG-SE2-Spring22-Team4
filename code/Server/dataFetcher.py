from com.google.gson import Gson
from com.google.gson import GsonBuilder
from com.google.gson import JsonArray
from com.google.gson import JsonElement
from com.google.gson import JsonIOException
from com.google.gson import JsonParser
from com.google.gson import JsonSyntaxException
from com.google.gson.reflect import TypeToken

#*
# * Defines the attributes and behavior of the Workout Data fetcher class. This
# * class implements
# * 
# * @author Jordan Wagner
# * @version Spring 2022
# 
class WorkoutDataFetcher(DataFetcher):

    __NOEQUIPMENT = 7

    #    *
    #     * creates a workoutDataFetcher containing exercise data
    #     
    def __init__(self):
        #instance fields found by Java to Python Converter:
        self.__exerciseDataFile = java.io.File("src/main/java/workout_manager/model/exerciseData.json")
        self.__exerciseData = None

        self.__exerciseData = []
        gson = (com.google.gson.GsonBuilder()).setPrettyPrinting().create()
        parser = com.google.gson.JsonParser()
        try:
            exerciseInfo = parser.parse(java.io.FileReader(self.__exerciseDataFile))
            arrayOfExercises = exerciseInfo.getAsJsonArray()
            self.__exerciseData = gson.fromJson(arrayOfExercises, (TypeTokenAnonymousInnerClass(self)).getType())
        except (JsonIOException, JsonSyntaxException, java.io.FileNotFoundException as e1):
            e1.printStackTrace()


    class TypeTokenAnonymousInnerClass(com.google.gson.reflect.TypeToken):

        def __init__(self, outerInstance):
            self.__outerInstance = outerInstance


    def getExercises(self, category):
        exercises = []
        for currentExercise in self.__exerciseData:
            if category == currentExercise.getCategory() and currentExercise.getEquipment() == workout_manager.model.WorkoutDataFetcher.__NOEQUIPMENT:
                exercises.append(currentExercise)
        return exercises
