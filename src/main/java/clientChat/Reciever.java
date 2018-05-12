package clientChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by user on 26.04.2018.
 */
public class Reciever implements handler2.SessionListener {

    Socket socket;

    Reciever(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void wasConnected(handler2 handler) {

    }

    @Override
    public void gotMessage(MessageApp message) {
        try {
            if (message == null) {
                System.out.println("null");
                return;
            }

            OutputStream sout = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(sout);
            System.out.println("check");
            String outString;
            if (message.getContent().equals("###")) {
                outString = "2";
            } else
                outString = "1" + " " + message.getEmailSender() + " " + message.getDate() + " " + message.getContent() + " ";
            System.out.println(outString);
            out.writeUTF(outString);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  System.out.println(message.getContent());
    }

    @Override
    public void wasDisconnected() {

    }


}
