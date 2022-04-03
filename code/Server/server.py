#!/usr/bin/env python3
import zmq
import json
import WorkoutGenerator
import Preferences
import ServerErrorCodes as codes

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
        print("Received request: %s" % message + "\n")
        request = message.split(", ")
        userName = request[1]
        if(request[0] == "login" and (usernameExists(userData, userName))):
            loggedInUser = handleLogin(request, userData, socket)
        elif (request[0] == "generateWorkout"):
            handleGenerate(socket, userData, request, loggedInUser)
        elif (request[0] == "register"):
            if (usernameExists(userData, userName)):
                socket.send_string(codes.ServerErrorCodes.REGISTER_FAILED_USER_EXISTS)
            else:
                formattedUserPrefs = request[2].replace("\\","")
                userData.update({userName: formattedUserPrefs})
                socket.send_string(userData[userName])
        else:
            socket.send_string(codes.ServerErrorCodes.BAD_REQUEST)
            print("ERROR - " + codes.ServerErrorCodes.BAD_REQUEST)

def usernameExists(dict, key):
    if (key in dict):
        return True
      
def handleLogin(request, userData, socket):
    pw = userData[request[1]][0]["passWord"]
    if (request[2] == pw):
        dataToSend = json.dumps(userData[request[1]][1])
        socket.send_string(dataToSend)
    else: 
        socket.send_string(codes.ServerErrorCodes.LOGIN_FAILED)
        print("ERROR - " + codes.ServerErrorCodes.LOGIN_FAILED)
    return request[1]
    
def handleGenerate(socket, userData, request, loggedInUser):

    alist = request[2].replace("\\","")
    alist = alist.replace("[","")
    alist = alist.replace("]","")
    preferences = Preferences.Preferences(alist, request[1], request[3])
    workoutCalendar = WorkoutGenerator.WorkoutGenerator.generateWorkouts(preferences)
    userData[loggedInUser][1]["preferences"]["availableDays"] = preferences.getSelectedDaysStrings()
    userData[loggedInUser][1]["preferences"]["musclesSelected"] = preferences.getSelectedMuscleStrings()
    userData[loggedInUser][1]["preferences"]["intensity"] = preferences.getIntensity()
    newCalendar = {}
    newCalendar["workoutCalendar"] = workoutCalendar
    userData[loggedInUser][1]["workoutCalender"] = newCalendar
    jsonRep = json.dumps(workoutCalendar)
    socket.send_string(jsonRep)  

if(__name__ == "__main__"):
   runServer()
