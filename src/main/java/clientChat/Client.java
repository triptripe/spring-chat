package clientChat;

import org.omg.CORBA.COMM_FAILURE;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {


    /**
     * post entity
     */


    public static void main(String[] args) throws IOException {

        Commands.addThings("97", "kuku");

    }
}