package Project88;

import java.util.Comparator;
import java.util.List;

public interface Researcher {
	String getResearchArea();

	List<ResearchProject> getProjects();

	List<ResearchPaper> getPapers();

	int calculateHIndex();

	void joinProject(ResearchProject project);

	void printPapers(Comparator<ResearchPaper> comparator);

	public void publishPaper(ResearchPaper paper, News news);
}
