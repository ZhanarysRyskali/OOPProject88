package Project88;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Supervisor implements Researcher {
    private int hIndex;
    private String researchArea;
    private List<ResearchProject> projects = new ArrayList<>();
    private List<ResearchPaper> papers = new ArrayList<>();

    public Supervisor(int hIndex, String researchArea) {
        this.hIndex = hIndex;
        this.researchArea = researchArea;
    }

    @Override
    public String getResearchArea() {
        return researchArea;
    }

    @Override
    public List<ResearchProject> getProjects() {
        return projects;
    }

    @Override
    public List<ResearchPaper> getPapers() {
        return papers;
    }

    @Override
    public int calculateHIndex() {
        return hIndex;
    }

    @Override
    public void joinProject(ResearchProject project) {
        projects.add(project);
    }

    @Override
    public void printPapers(Comparator<ResearchPaper> comparator) {
        papers.sort(comparator);
        for (ResearchPaper paper : papers) {
            System.out.println(paper.getTitle());
        }
    }
}
