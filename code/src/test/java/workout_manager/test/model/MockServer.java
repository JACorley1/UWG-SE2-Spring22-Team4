package workout_manager.test.model;



import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.Request;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import workout_manager.model.Client;



public class MockServer {

    private ClientAndServer mockServer;

    @BeforeClass
    public void startServer() {
        ClientAndServer.startClientAndServer(5555);
    }
 
    @AfterClass 
    public void stopServer() { 
        mockServer.stop();
    }
    private void createExpectationForInvalidAuth() {
        new MockServerClient("localhost", 5555)
    .when(
        request()
            .withMethod("POST")
            .withPath("/login")
            .withBody("{username: 'username', password: 'password'}")
    )
    .respond(
        ( response())
            .withStatusCode(302)
            .withCookie(
                "sessionId", "2By8LOhBmaW5nZXJwcmludCIlMDAzMW"
            )
            .withHeader(
                "Location", "https://www.mock-server.com"
            )
    );
    }

    private HttpResponse response() {
        return null;
    }

    private HttpRequest request() {
        return null;
    }
}
