package Project88;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Student extends User {
	private List<Course> courses = new ArrayList<>();
	private Map<Course, Double> marks;
	private Transcript transcript;
	private boolean isResearcher;
	private List<ResearchPaper> researchPapers = new ArrayList<>();

	public List<Course> viewCourses() {
		return courses;
	}

	public void registerForCourse(Course course) {
		courses.add(course);
	}

	public Map<Course, Double> viewMarks() {
		return marks;
	}

	public Transcript viewTranscript() {
		return transcript;
	}

	public void rateTeacher(Teacher teacher, int rating) {
		// Rating logic
	}
}
