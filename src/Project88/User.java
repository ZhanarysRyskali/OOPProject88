package Project88;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class User implements Researcher {
	private String fullName;
	private String email;
	private String password;
	private int id;
	private List<UniversityJournal> subscriptions;
	private List<ResearchPaper> papers;
	private List<ResearchProject> projects;

	public User() {
		this.subscriptions = new ArrayList<>();
		this.papers = new ArrayList<>();
		this.projects = new ArrayList<>();
	}

	public User(String fullName, String email, String password, int id) {
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.id = id;
		this.subscriptions = new ArrayList<>();
		this.papers = new ArrayList<>();
		this.projects = new ArrayList<>();
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
			if (journal.getPapers().contains(paper)) {
				System.out.println("Notification: New paper published in " + journal.getName() + ": " + paper.getTitle());
			}
		}
	}

	@Override
	public String getResearchArea() {
		return "General Research";
	}

	@Override
	public List<ResearchProject> getProjects() {
		return new ArrayList<>(projects);
	}

	@Override
	public List<ResearchPaper> getPapers() {
		return new ArrayList<>(papers);
	}

	@Override
	public int calculateHIndex() {
		List<Integer> citations = new ArrayList<>();
		for (ResearchPaper paper : papers) {
			citations.add(paper.getCitations());
		}
		Collections.sort(citations, Collections.reverseOrder());

		int hIndex = 0;
		for (int i = 0; i < citations.size(); i++) {
			if (citations.get(i) >= i + 1) {
				hIndex = i + 1;
			} else {
				break;
			}
		}
		return hIndex;
	}

	@Override
	public void joinProject(ResearchProject project) {
		if (!projects.contains(project)) {
			projects.add(project);
			try {
				project.addParticipant(this);
			} catch (NonResearchException e) {
				System.out.println("Cannot join project: " + e.getMessage());
			}
		}
	}


	@Override
	public void printPapers(Comparator<ResearchPaper> comparator) {
		List<ResearchPaper> sortedPapers = new ArrayList<>(papers);
		sortedPapers.sort(comparator);
		for (ResearchPaper paper : sortedPapers) {
			System.out.println("Title: " + paper.getTitle() + ", Citations: " + paper.getCitations());
		}
	}

	public void addPaper(ResearchPaper paper) {
		if (!papers.contains(paper)) {
			papers.add(paper);
		}
	}

	public void leaveProject(ResearchProject project) {
		if (projects.contains(project)) {
			projects.remove(project);
			project.removeParticipant(this);
		}
	}

	public void publishPaper(ResearchPaper paper, News news) {
		papers.add(paper);
		news.announcePaper(paper);
	}
}
