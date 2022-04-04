#!/usr/bin/env python3

import json

'''
Defines the attributes and behavior of the Workout Data fetcher class. This
'''

__author__ = 'Jordan Wagner'
__version__ ='Spring 2022'


class dataFetcher:

    NOEQUIPMENT = 0
    exerciseData = []
    '''
        gets the excersises based on category and intensity
    '''
    def getExercises(category, intensity):
        with open('exerciseData.json', encoding="utf8") as json_file:
            dataFetcher.exerciseData = json.load(json_file)
        exercises = []
        for currentExercise in dataFetcher.exerciseData:
            if category == int(currentExercise["category"]) and int(currentExercise["intensity"]) == intensity and currentExercise["equipment"][0] == dataFetcher.NOEQUIPMENT:

                exercises.append(currentExercise)
        return exercises
