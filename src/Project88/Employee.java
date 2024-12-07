package Project88;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee extends User {
	private String position;
	private List<Message> receivedMessages;
	private List<Message> sentMessages;

	public Employee() {
		super();
		this.receivedMessages = new ArrayList<>();
		this.sentMessages = new ArrayList<>();
	}

	public Employee(String fullName, String email, String password, int id, String position) {
		super(fullName, email, password, id);
		this.position = position;
		this.receivedMessages = new ArrayList<>();
		this.sentMessages = new ArrayList<>();
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Message sendMessage(Employee recipient, String content) {
		Message message = new Message(this, recipient, content);
		this.sentMessages.add(message);
		recipient.receiveMessage(message);
		return message;
	}

	public List<Message> viewReceivedMessages() {
		return new ArrayList<>(receivedMessages);
	}

	public List<Message> viewSentMessages() {
		return new ArrayList<>(sentMessages);
	}

	private void receiveMessage(Message message) {
		this.receivedMessages.add(message);
	}
}
