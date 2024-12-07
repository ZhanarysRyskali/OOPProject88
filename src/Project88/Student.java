
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

	private double gpa;

	public Student(String fullName, String email, String password, int id, double gpa) {
		super(fullName, email, password, id);
		this.gpa = gpa;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

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
		if (rating < 1 || rating > 5) {
			System.out.println("Rating must be between 1 and 5.");
			return;
		}

		teacher.getRating();
		System.out.println("You rated teacher " + teacher.getFullName() + " with " + rating + " stars.");
	}
	public void setMark(Course course, double mark) {
		if (marks != null) {
			marks.put(course, mark);
			System.out.println("Mark " + mark + " set for course " + course.getName() + ".");
		} else {
			System.out.println("Marks map is not initialized.");
		}
	}

	public String getName() {
		return getFullName();
	}

}
