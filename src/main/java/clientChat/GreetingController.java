package clientChat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class GreetingController {
  //  private Logger log;


    //при подписке на topic/greetings вызывает метод greeting
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        System.out.println("Received hello: " + message.getAge() + message.getName());
        return new Greeting("Hello, " + message.getAge() + "!");
    }
}