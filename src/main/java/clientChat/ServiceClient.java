package clientChat;


import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

public class ServiceClient {
    public static Long id;

    public static void main(String[] args) {
        System.out.println("print your id, bratan");
        ServiceClient.id = new Scanner(System.in).nextLong();
        Commands.createUser("Вася", "mail@ru", "vadim123");
        Commands.createUser("Мася", "ma2il@ru", "vadim123");
        Commands.createEvent(5, "Туса", "норм", "Москва");
        Commands.makeConnection();

        while(true);
    }
}