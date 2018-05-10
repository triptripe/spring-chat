package clientChat;

/**
 * Created by user on 27.04.2018.
 */

public class Message {

    private Long id;
    private String from;
    private String message;
    
    Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
