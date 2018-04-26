package clientChat;

import lombok.Data;

@Data
public class Message {
	private String content;


	public Message() {	}

	public Message(String content, int age) {
		this.content = content;

	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
