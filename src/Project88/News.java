package Project88;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class News {
	private String title;
	private String content;
	private String topic;
	private List<String> comments;
	private List<News> newsList;
	private boolean pinned;

	public News(String title, String content, String topic) {
		this.title = title;
		this.content = content;
		this.topic = topic;
		this.pinned = "Research".equalsIgnoreCase(topic);
		this.comments = new ArrayList<>();
	}

	public void addComment(String comment) {
		comments.add(comment);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
		this.pinned = "Research".equalsIgnoreCase(topic);
	}

	public boolean isPinned() {
		return pinned;
	}

	private void prioritizeNews() {
		newsList.sort(Comparator.comparing(News::isPinned).reversed());
	}

	public void addNews(News news) {
		newsList.add(news);
		prioritizeNews();
	}

	public void announcePaper(ResearchPaper paper) {
		News announcement = new News(
				"New Research Paper Published!",
				String.format(
						"A new research paper titled '%s' has been published in the journal '%s'.",
						paper.getTitle(),
						paper.getJournal()
				),
				"Research"
		);
		addNews(announcement);
	}

	public List<String> getComments() {
		return new ArrayList<>(comments);
	}

	@Override
	public String toString() {
		return String.format("Title: %s\nTopic: %s\nContent: %s\nComments: %s",
				title, topic, content, comments.isEmpty() ? "No comments yet." : comments);
	}
}
