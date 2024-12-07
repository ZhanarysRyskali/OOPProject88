package Project88;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Employee {
	private List<Course> courses = new ArrayList<>();
	private List<Student> students = new ArrayList<>();
	private boolean isProfessor;
	private TeacherStatus status;
	private UrgencyLevel level;

	public List<Course> viewCourses() {
		return courses;
	}

	public void manageCourse(Course course) {
		courses.add(course);
	}

	public void putMarks(Student student, Course course, double mark) {
		// Logic to assign marks
	}

	public void sendComplaint(String complaint, Student student, UrgencyLevel level) {
		// Complaint logic
	}

	public List<Student> viewStudents(Course course) {
		return students;
	}
}
