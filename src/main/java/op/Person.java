package op;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by user on 21.04.2018.
 */
public class Person {
    public static void main(String[] args) throws IOException {
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
    }
}
