package Project88;

import java.util.ArrayList;
import java.util.List;

public class ResearchProject {
	private String topic;
	private List<ResearchPaper> publishedPapers;
	private List<Researcher> participants;

	public ResearchProject() {
		this.publishedPapers = new ArrayList<>();
		this.participants = new ArrayList<>();
	}

	public ResearchProject(String topic) {
		this();
		this.topic = topic;
	}

	public void addParticipant(Researcher researcher) {
		participants.add(researcher);
	}

	// Getters and Setters
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<ResearchPaper> getPublishedPapers() {
		return publishedPapers;
	}

	public void setPublishedPapers(List<ResearchPaper> publishedPapers) {
		this.publishedPapers = publishedPapers;
	}

	public List<Researcher> getParticipants() {
		return participants;
	}
}
