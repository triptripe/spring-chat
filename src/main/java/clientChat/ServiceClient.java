package clientChat;


import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

public class ServiceClient {
    public static void main(String[] args) {
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        stompClient.setTaskScheduler(new ConcurrentTaskScheduler());

        String url = "ws://192.168.180.58:8080/hello";
        MySessionHandler sessionHandler = new MySessionHandler();
        sessionHandler.addListener(new Reciever());
        sessionHandler.addListener(new Sender());
        stompClient.connect(url, sessionHandler);

        while (true);
//        new Scanner(System.in).nextLine(); //Don't close immediately.
    }
}
