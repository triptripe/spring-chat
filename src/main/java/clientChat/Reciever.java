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
            OutputStream sout = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(sout);
            out.writeUTF(message.getEmailSender() + " " + message.getContent());
            out.flush();
        } catch (IOException e) {
            //e.printStackTrace();
        }

        System.out.println(message.getContent());
    }

    @Override
    public void wasDisconnected() {

    }


}
