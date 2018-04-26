package clientChat;


import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

@Slf4j
public class MysessionHandler extends StompSessionHandlerAdapter {
    private StompSession session;
    private SessionConnectedListener listener;

    public MysessionHandler(SessionConnectedListener listener) {
        this.listener = listener;
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        session.subscribe("/topic/greetings", this);
        session.send("/app/hello", new HelloMessage("Privet", 22));
        // session.disconnect();
        // log.info("New session: {}", );
        System.out.println("New session: " + session.getSessionId());

        this.session = session;
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        exception.printStackTrace();
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return Greeting.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println("Received: " + ((Greeting) payload).getContent());
    }

    public void send() {
        if (session != null){
            session.send("/app/hello", new HelloMessage("Test", -20));
//            session.disconnect();
        }
    }

    interface SessionConnectedListener{
        void sessionConnected(MysessionHandler handler);
    }
}