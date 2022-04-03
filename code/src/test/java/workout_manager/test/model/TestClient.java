package workout_manager.test.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.zeromq.ZContext;
import org.zeromq.ZMQ.Socket;

import workout_manager.model.Client;
import zmq.ZMQ;


public class TestClient {

 
    
    @Test
    void testGetClient() {
        
        Client client = Client.getClient();
        assertEquals(client.getClass(), Client.class);
        client.closeSocket();
    }
    
    @Test
    void testSendRequest() {
        ZContext context = new ZContext();
        Socket socket = context.createSocket(ZMQ.ZMQ_REP);
        socket.bind("tcp://127.0.0.1:5555");
        Client client = Client.getClient();
        client.sendRequest("test");
        String message = socket.recvStr();
        socket.send(message);
        String receive = client.receiveResponse().toString();
        assertEquals(receive, "\"test\"");
        client.closeSocket();
    }


    
}
