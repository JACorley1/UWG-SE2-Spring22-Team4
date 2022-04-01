#!/usr/bin/env python3
import zmq
import json
import WorkoutGenerator
import Preferences

#*
# * server implementation for the workout manager program
# *
# * @author Jordan Wagner
# * @version Spring 2022
# 
def runServer():
    loggedInUser = ""
    context = zmq.Context()
    socket = context.socket(zmq.REP)
    socket.bind("tcp://127.0.0.1:5555")
    with open('testUserData.json') as json_file:
        userData = json.load(json_file)
    while True:
        #  Wait for next request from client
        print("waiting for message...")
        message = socket.recv_string()
        message = message.replace('"','')
        print("Received request: %s" % message)
        request = message.split(", ")
        if(request[0] == "login"):
            pw = userData[request[1]][0]["passWord"]
            if (request[2] == pw):
                loggedInUser = request[1]
                dataToSend = json.dumps(userData[request[1]][1])
                socket.send_string(dataToSend)
        elif (request[0] == "generateWorkout"):
            alist = request[2].replace("\\","")
            alist = alist.replace("[","")
            alist = alist.replace("]","")
            preferences = Preferences.Preferences(alist, request[1])
            workoutCalendar = WorkoutGenerator.WorkoutGenerator.generateWorkouts(preferences)
            userData[loggedInUser][1]["preferences"] = preferences.getSelectedDaysStrings(), preferences.getSelectedMuscleStrings()
            newCalendar = {}
            newCalendar["workoutCalendar"] = workoutCalendar
            userData[loggedInUser][1]["workoutCalender"] = newCalendar
            print(userData[loggedInUser][1])
            jsonRep = json.dumps(workoutCalendar)
            socket.send_string(jsonRep)
        elif (request[0] == "register"):
            '''todo'''
        else:
            '''error handling'''
            socket.send_string("hello")
                           
if(__name__ == "__main__"):
   runServer()
