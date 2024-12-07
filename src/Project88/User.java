package Project88;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class User implements Researcher {
	private String fullName;
	private String email;
	private String password;
	private int id;
	private List<UniversityJournal> subscriptions;

	public User() {
		this.subscriptions = new ArrayList<>();
	}

	public User(String fullName, String email, String password, int id) {
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.id = id;
		this.subscriptions = new ArrayList<>();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<UniversityJournal> getSubscriptions() {
		return new ArrayList<>(subscriptions);
	}

	public void setSubscriptions(List<UniversityJournal> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public void subscribe(UniversityJournal journal) {
		if (!subscriptions.contains(journal)) {
			subscriptions.add(journal);
		}
	}

	public void unsubscribe(UniversityJournal journal) {
		subscriptions.remove(journal);
	}

	public void notifySubscription(ResearchPaper paper) {
		for (UniversityJournal journal : subscriptions) {
			// Notify logic here
		}
	}

	@Override
	public String getResearchArea() {
		return "General Research";
	}

	@Override
	public List<ResearchProject> getProjects() {
		return new ArrayList<>();
	}

	@Override
	public List<ResearchPaper> getPapers() {
		return new ArrayList<>();
	}

	@Override
	public int calculateHIndex() {
		return 0; // Dummy value
	}

	@Override
	public void joinProject(ResearchProject project) {
		// Logic to join a project
	}



	@Override
	public void printPapers(Comparator<ResearchPaper> comparator) {
		// Logic to print papers sorted by comparator
	}
}
