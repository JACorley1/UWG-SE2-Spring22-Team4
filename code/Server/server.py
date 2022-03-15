import zmq
import time
import json

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
        print(request[0])
        print(request[1])
        print(request[2])
        if(request[0] == "login"):
            pw = userData[request[1]][3]["passWord"]
            if (request[2] == pw):
                userData = json.dumps(userData[request[1]])
                socket.send_string(userData)
                
                
        time.sleep(1)
        print("nope!")
        socket.send_string("failed")
if(__name__ == "__main__"):
   runServer()
