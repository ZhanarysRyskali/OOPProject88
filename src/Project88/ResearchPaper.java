package Project88;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ResearchPaper extends ResearchProject {
	private String title;
	private List<String> authors = new ArrayList<>();
	private String journal;
	private int pages;
	private LocalDate datePublished;
	private List<String> citations = new ArrayList<>();
	private String doi;
	private List<User> subscribers = new ArrayList<>();

	public ResearchPaper(String title, String journal, LocalDate datePublished, int pages) {
		this.title = title;
		this.journal = journal;
		this.datePublished = datePublished;
		this.pages = pages;
	}

	public void addCitation(String citation) {
		citations.add(citation);
	}

	public void notifySubscribers() {
		for (User subscriber : subscribers) {
			subscriber.notifySubscription(this);
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String author) {
		authors.add(author);
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public LocalDate getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(LocalDate datePublished) {
		this.datePublished = datePublished;
	}

	public int getCitationsCount() {
		return citations.size();
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public String getCitation(Format f) {
		String formattedAuthors = String.join(", ", authors);
		String formattedDate = datePublished.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		switch (f) {
			case PLAIN_TEXT:
				return String.format("%s. \"%s.\" %s, %s, %d pages, DOI: %s.",
						formattedAuthors, title, journal, formattedDate, pages, doi != null ? doi : "N/A");
			case BIBTEX:
				return String.format("@article{%s,\n  author = {%s},\n  title = {%s},\n  journal = {%s},\n  year = {%s},\n  pages = {%d},\n  doi = {%s}\n}",
						doi != null ? doi : title.replaceAll("\\s+", "_"), formattedAuthors, title, journal, formattedDate.substring(0, 4), pages, doi != null ? doi : "N/A");
			default:
				throw new IllegalArgumentException("Unsupported format: " + f);
		}
	}
}
