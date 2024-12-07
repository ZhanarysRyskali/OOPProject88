package Project88;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User {
	private String position;

	public Employee() {
		super();
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Message sendMessage(Employee recipient, String content) {
		Message message = new Message(this, recipient, content);
		return message;
	}

	public List<Message> viewReceivedMessages() {
		// Logic to fetch received messages
		return new ArrayList<>();
	}

	public List<Message> viewSentMessages() {
		// Logic to fetch sent messages
		return new ArrayList<>();
	}
}
