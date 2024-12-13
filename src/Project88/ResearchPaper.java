
package Project88;

import java.text.Format;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResearchPaper extends ResearchProject {
	private String title;
	private List<String> authors = new ArrayList<>();
	private String journal;
	private int pages;
	private LocalDate datePublished;
	private int citations;
	private String doi;
	private List<User> subscribers = new ArrayList<>();

	public ResearchPaper(String title, String journal, LocalDate datePublished, int pages) {
		this.title = title;
		this.journal = journal;
		this.datePublished = datePublished;
		this.pages = pages;
	}

	public String getCitation(Format format) {
		if (format == null) {
			return title;
		} else {
			return format.format(title);
		}
	}

	public void addCitation() {
		citations++;
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

	public int getCitations() {
		return citations;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public int getPages() {
		return pages;
	}

	public static Comparator<ResearchPaper> byDatePublished() {
		return Comparator.comparing(ResearchPaper::getDatePublished);
	}

	public static Comparator<ResearchPaper> byCitations() {
		return Comparator.comparingInt(ResearchPaper::getCitations).reversed();
	}

	public static Comparator<ResearchPaper> byArticleLength() {
		return Comparator.comparingInt(ResearchPaper::getPages);
	}
	
	public static void printPapers(List<ResearchPaper> papers, Comparator<ResearchPaper> comparator) {
		papers.sort(comparator);
		for (ResearchPaper paper : papers) {
			System.out.println(
					"Title: " + paper.getTitle() +
							", Journal: " + paper.getJournal() +
							", Date Published: " + paper.getDatePublished() +
							", Pages: " + paper.getPages() +
							", Citations: " + paper.getCitations()
			);
		}
	}

	public static List<ResearchPaper> collectPapers(List<Researcher> researchers) {
		List<ResearchPaper> allPapers = new ArrayList<>();
		for (Researcher researcher : researchers) {
			allPapers.addAll(researcher.getPapers());
		}
		return allPapers;
	}
}
