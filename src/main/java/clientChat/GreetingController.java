package clientChat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class GreetingController {
  //  private Logger log;


    //при подписке на topic/greetings вызывает метод message
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message gotMessage(Message message) throws Exception {
        System.out.println("Received " + message.getContent());
        return message;
    }
}