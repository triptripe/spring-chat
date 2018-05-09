package clientChat;

import lombok.Data;

@Data
public class Message {
    private String content;
    private Long id;
    private String emailSender;
    /*private String check = "command ";

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }*/

    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String idSender) {
        this.emailSender = idSender;
    }

    public Message() {
    }

    public Message(String content) {
        this.content = content;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
