package Project88;

import java.util.ArrayList;
import java.util.List;


public abstract class Employee extends User {
	private String position;
	private List<Message> receivedMessages;
	private List<Message> sentMessages;
	private static List<Message> messageLog = new ArrayList<>();

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


	public void sendMessage(Employee recipient, String content) {
		if (recipient == null || content == null || content.trim().isEmpty()) {
			System.out.println("Error: Invalid recipient or message content.");
			return;
		}

		Message message = new Message(this, recipient, content);
		messageLog.add(message);
		sentMessages.add(message);
		recipient.receiveMessage(message);

		System.out.println("Message sent successfully from " + getFullName() + " to " + recipient.getFullName());
	}


	public void receiveMessage(Message message) {
		if (message != null) {
			receivedMessages.add(message);
		}
	}


	public List<Message> viewReceivedMessages() {
		return new ArrayList<>(receivedMessages);
	}

	public List<Message> viewSentMessages() {
		return new ArrayList<>(sentMessages);
	}

	public static List<Message> getMessageLog() {
		return new ArrayList<>(messageLog);
	}

	@Override
	public String toString() {
		return "Employee{" +
				"position='" + position + '\'' +
				", receivedMessages=" + receivedMessages.size() +
				", sentMessages=" + sentMessages.size() +
				"} " + super.toString();
	}
}
