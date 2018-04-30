package clientChat;

import java.util.Scanner;

/**
 * Created by user on 26.04.2018.
 */
public class Sender implements handler2.SessionListener {
    private handler2 handler;
    private String messageToSend;

    @Override
    public void wasConnected(handler2 handler) {
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
            message.setId(Client.id);
            handler.send(message);
        }
    }
}
