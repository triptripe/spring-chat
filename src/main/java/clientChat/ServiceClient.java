package clientChat;


import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.io.IOException;
import java.util.Scanner;

public class ServiceClient {
    public static void main(String[] args) throws IOException {
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        stompClient.setTaskScheduler(new ConcurrentTaskScheduler());

        String urlChat = "ws://172.19.33.133:8080/hello";
        MySessionHandler sessionHandler = new MySessionHandler();
        sessionHandler.addListener(new Reciever());
        sessionHandler.addListener(new Sender());
        stompClient.connect(urlChat, sessionHandler);

        // The connection URL
        String url = "http://172.19.33.133:8080/createEvent?maxPeople=5&name=kek&description=bebeb&place=obshaganew";

// Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

// Add the String message converter
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

// Make the HTTP GET request, marshaling the response to a String
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);

        Scanner scan = new Scanner(System.in);
        scan.nextInt();
        result = restTemplate.getForObject(url, String.class);
        System.out.println(result);



        while (true);
//        new Scanner(System.in).nextLine(); //Don't close immediately.
    }
}
