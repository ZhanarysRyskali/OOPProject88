
package Project88;

import java.util.Comparator;
import java.util.List;

public interface Researcher {

	List<ResearchProject> getProjects();

	List<ResearchPaper> getPapers();


	void joinProject(ResearchProject project);

	void printPapers(Comparator<ResearchPaper> comparator);

	public void publishPaper(ResearchPaper paper, News news);

	double getHIndex();
}
