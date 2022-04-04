package workout_manager.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

/**
 * singleton client for workout manager program.
 * 
 * @author Jordan Wagner
 * @version Spring 2022
 */
public class Client {

    private final String HOST = "tcp://127.0.0.1:5555";
    private final Socket socket;
    private static Client client = null;

    private Client() {
        Context context = ZMQ.context(10);
        this.socket = context.socket(ZMQ.REQ);
        this.socket.setReceiveTimeOut(5000);
        this.socket.connect(HOST);
    }

    /**
     * gets the client for the system to connect to the server
     * 
     * @precondition none
     * @postcondition none
     * @return the client
     */
    public static Client getClient() {
        client = new Client();
        return client;
    }

    /**
     * sends a request to the server from the client
     * 
     * @precondition none
     * @postcondition none
     * @param request the request in json string form being sent
     */
    public void sendRequest(String request) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String requestToSend = gson.toJson(request);
        this.socket.send((requestToSend));
    }

    /**
     * recieves the response from the client.
     * 
     * @precondition none
     * @postcondition none
     * @return the response as a string.
     */
    public String receiveResponse() {
        String response = this.socket.recvStr();
        return response;
    }

    /**
     * closes the socket
     * 
     * @precondition none
     * @postcondition none
     */
    public void closeSocket() {
        this.socket.close();
    }

}
