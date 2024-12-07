package Project88;

import java.util.ArrayList;
import java.util.List;

public class Admin extends Employee {
	private List<String> logFiles;

	public Admin() {
		super();
		this.logFiles = new ArrayList<>();
	}

	public void addUser(User user) {
		// Logic for adding a user
	}

	public void removeUser(String userId) {
		// Logic for removing a user by ID
	}

	public void updateUser(User user) {
		// Logic for updating user details
	}

	public List<String> viewLogs() {
		return new ArrayList<>(logFiles);
	}
}
