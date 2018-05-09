package clientChat;

import java.util.ArrayList;

/**
 * Created by user on 05.05.2018.
 */public class ListEvents {

    private ArrayList<Event> mListEvent;

    public ListEvents(){

    }

    public ListEvents(ArrayList<Event> listEvent) {
        mListEvent = listEvent;
    }

    public ArrayList<Event> getListEvent() {

        return mListEvent;
    }

    public void setListEvent(ArrayList<Event> listEvent) {
        mListEvent = listEvent;
    }

}