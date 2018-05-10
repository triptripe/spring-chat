package clientChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by user on 26.04.2018.
 */
public class Sender implements handler2.SessionListener {
    private handler2 handler;
    private String messageToSend;
    private Long subscribeID;
    public Socket socket;

    Sender(Socket socket, long l) {
        this.socket = socket;
        this.subscribeID = l;
    }

    @Override
    public void wasConnected(handler2 handler) {
        this.handler = handler;
        System.out.println("connected");
        new Thread(this::sendMessage).start();

    }

    @Override
    public void gotMessage(MessageApp message) {

    }

    @Override
    public void wasDisconnected() {
        System.out.println("disconnected");
    }

    void sendMessage() {


        try {

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            out.writeUTF("success");
            out.flush();
            String line = null;
            MessageApp message = null;
            while (handler.isConnected()) {
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                //message.setIdSender(Long.valueOf(line.split(" ")[0]));
                String email = line.split(" ")[0];
                message = new MessageApp(line.substring(email.length() + 1));
                message.setId(subscribeID);
                message.setEmailSender(email);
                //message.setCheck("chat ");
                handler.send(message);
            }
        } catch (Exception ex) {
            System.out.println("Disconnected");
        }
    }
}
