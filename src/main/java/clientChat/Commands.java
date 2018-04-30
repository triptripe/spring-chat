package clientChat;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

/**
 * Created by user on 30.04.2018.
 */
public class Commands {
    // Create a new RestTemplate instance


    public static Long createUser(String name, String email, String password) {
        // The connection URL
        String url = "http://192.168.180.58:8080/add?name=" + name + "&email=" + email + "&password=" + password;
// Add the String message converter
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

// Make the HTTP GET request, marshaling the response to a String
        Long result = restTemplate.getForObject(url, Long.class);

        System.out.println(result);
        return result;
    }

    public static String createEvent(Integer maxPeople, String name, String description, String place) {
        String url = "http://192.168.180.58:8080/createEvent?maxPeople=" + maxPeople +
                "&name=" + name +
                "&description=" + description +
                "&place=" + place;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String s = restTemplate.getForObject(url, String.class);
        System.out.println(s);
        return s;
    }

    public static void makeConnection() {
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        stompClient.setTaskScheduler(new ConcurrentTaskScheduler());
        String urlChat = "ws://192.168.180.58:8080/hello";
        handler2 sessionHandler = new handler2();
        sessionHandler.addListener(new Reciever());
        sessionHandler.addListener(new Sender());
        stompClient.connect(urlChat, sessionHandler);

    }

}
