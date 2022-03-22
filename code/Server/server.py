import zmq
import time
import json
import WorkoutGenerator
import Preferences
import WorkoutCalendar
import Days
import dataFetcher
import MuscleGroup

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
        if(request[0] == "login"):
            pw = userData[request[1]][0]["passWord"]
            print(pw)
            if (request[2] == pw):
                userData = json.dumps(userData[request[1]][1])
                socket.send_string(userData)
        elif (request[0] == "generateWorkout"):
            alist = request[2].replace("\\","")
            alist = alist.replace("[","")
            alist = alist.replace("]","")
            preferences = Preferences.Preferences(alist, request[1])
            workoutCalendar = WorkoutGenerator.WorkoutGenerator.generateWorkouts(preferences)
            jsonRep = json.dumps(workoutCalendar)
            socket.send_string(jsonRep)
                           
if(__name__ == "__main__"):
   runServer()
