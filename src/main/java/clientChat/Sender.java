package clientChat;

import java.util.Scanner;

/**
 * Created by user on 26.04.2018.
 */
public class Sender implements MySessionHandler.SessionListener {
    MySessionHandler handler;

    @Override
    public void wasConnected(MySessionHandler handler) {
        this.handler = handler;
        System.out.println("connected");
        new Thread(this::sendMessage).start();
    }

    @Override
    public void gotMessage(Greeting message) {

    }

    @Override
    public void wasDisconnected() {
        System.out.println("disconnected");
    }

    void sendMessage() {
        Scanner scan = new Scanner(System.in);
        HelloMessage helloMessage = null;
        while (handler.isConnected()) {
            helloMessage = new HelloMessage(scan.nextLine(), -1);
            handler.send(helloMessage);
        }
    }
}
