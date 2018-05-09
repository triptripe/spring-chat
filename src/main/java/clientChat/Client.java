package clientChat;

import org.omg.CORBA.COMM_FAILURE;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class Client {


    /**
     * post entity
     */

    public static String IP = "192.168.1.61:8008";

    public static void main(String[] args) {
        byte[] b = {'1'};
    Commands.makeConnection();


    }
}