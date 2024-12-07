package Project88;

import java.util.ArrayList;
import java.util.List;

public class News {
	private String title;
	private String content;
	private String topic;
	private List<String> comments;

	public News() {
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
	}

	public List<String> getComments() {
		return new ArrayList<>(comments);
	}
}
