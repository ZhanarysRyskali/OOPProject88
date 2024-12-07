package Project88;

import java.time.LocalDate;

public class Message {
	private User sender;
	private User receiver;
	private String content;
	private LocalDate timeStamp;
	private boolean isRead;

	public Message(User sender, User receiver, String content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.timeStamp = LocalDate.now();
		this.isRead = false;
	}

	public void sendMessage() {
		// Logic for sending the message
	}

	public void markAsRead() {
		this.isRead = true;
	}

	public String getContent() {
		return content;
	}

	public User getSenderInfo() {
		return sender;
	}
}
