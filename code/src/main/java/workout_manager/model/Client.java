package workout_manager.model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

public class Client {

    private final String HOST = "tcp://127.0.0.1:5555";
    private final Socket socket;
    private static Client client = null;

    private Client() {
        Context context = ZMQ.context(10);
        this.socket = context.socket(ZMQ.REQ);
        this.socket.connect(HOST);
    }

    public static Client getClient(){
        client = new Client();
        return client;
    }


    public void sendRequest(String request) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String requestToSend = gson.toJson(request);
        this.socket.send((requestToSend));
    }

    public String receiveResponse(){
        String response = this.socket.recvStr();
        return response;

    }

}
