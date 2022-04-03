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
        userName = request[1]
        if((request[0] == "login") and (usernameExists(userData, userName))):
            pw = userData[request[1]][0]["passWord"]
            print(pw)
            if (request[2] == pw):
                userData = json.dumps(userData[request[1]][1])
                socket.send_string(userData)
            else: 
                socket.send_string(codes.ServerErrorCodes.LOGIN_FAILED)
                print("ERROR - " + codes.ServerErrorCodes.LOGIN_FAILED)
        elif (request[0] == "generateWorkout"):
            alist = request[2].replace("\\","")
            alist = alist.replace("[","")
            alist = alist.replace("]","")
            preferences = Preferences.Preferences(alist, request[1])
            workoutCalendar = WorkoutGenerator.WorkoutGenerator.generateWorkouts(preferences)
            jsonRep = json.dumps(workoutCalendar)
            socket.send_string(jsonRep)
        elif (request[0] == "register"):
            newUser = request[1]
            newPassword = request[2]
            if (usernameExists(userData, newUser)):
                socket.send_string(codes.ServerErrorCodes.REGISTER_FAILED_USER_EXISTS)
            else:
                userData[newUser] = "[{'passWord': '" + newPassword + "'}, {'preferences': {'availableDays': [], 'musclesSelected': []}, 'workoutCalender': {}, 'userName': '" + newUser + "', 'passWord': '" + newPassword + "'}]}"
                socket.send_string(userData[newUser])
        else:
            socket.send_string(codes.ServerErrorCodes.BAD_REQUEST)
            print("ERROR - " + codes.ServerErrorCodes.BAD_REQUEST)

def usernameExists(dict, key):
    if (key in dict):
        return True

if(__name__ == "__main__"):
   runServer()
