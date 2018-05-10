package clientChat;

import lombok.Data;

@Data
public class MessageApp {
    private String content;
    private Long id;
    private String emailSender;


    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String idSender) {
        this.emailSender = idSender;
    }

    public MessageApp() {
    }

    public MessageApp(String content) {
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
