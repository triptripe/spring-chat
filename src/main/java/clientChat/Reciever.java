package clientChat;

/**
 * Created by user on 26.04.2018.
 */
public class Reciever implements MySessionHandler.SessionListener{

    @Override
    public void wasConnected(MySessionHandler handler) {
        System.out.println("connected");
    }

    @Override
    public void gotMessage(Greeting greeting) {
        System.out.println(greeting.getContent());
    }

    @Override
    public void wasDisconnected() {

    }


}
