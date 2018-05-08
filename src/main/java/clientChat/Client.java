package clientChat;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class Client {


    /**
     * post entity
     */

    public static String IP = "192.168.180.58:8008";
    public static void main(String[] args) {
        System.out.println(Commands.getEvents().get(0).getImage().length);
    }
}