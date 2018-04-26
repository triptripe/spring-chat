package clientChat;

import java.util.Scanner;

/**
 * Created by user on 26.04.2018.
 */
public class Sender implements MySessionHandler.SessionListener {
    private MySessionHandler handler;
    private String messageToSend;

    @Override
    public void wasConnected(MySessionHandler handler) {
        this.handler = handler;
        System.out.println("connected");
        new Thread(this::sendMessage).start();
    }

    @Override
    public void gotMessage(Message message) {

    }

    @Override
    public void wasDisconnected() {
        System.out.println("disconnected");
    }

    void sendMessage() {
        Scanner scan = new Scanner(System.in);
        Message message = null;
        while (handler.isConnected()) {
            message = new Message(scan.nextLine());
            handler.send(message);
        }
    }
}
