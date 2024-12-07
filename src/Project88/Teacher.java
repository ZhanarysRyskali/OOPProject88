package Project88;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Teacher extends Employee {
	private List<Course> courses;
	private List<Student> students;
	private boolean isProfessor;
	private TeacherStatus status;
	private UrgencyLevel level;
	private int yearsOfExperience;
	private Map<Student, Integer> ratings;

	public Teacher() {
		super();
		this.courses = new ArrayList<>();
		this.students = new ArrayList<>();
		this.yearsOfExperience = 0;
		this.ratings = new HashMap<>();
	}

	public Teacher(String fullName, String email, String password, int id, String position, boolean isProfessor, TeacherStatus status, int yearsOfExperience) {
		super(fullName, email, password, id, position);
		this.courses = new ArrayList<>();
		this.students = new ArrayList<>();
		this.isProfessor = isProfessor;
		this.status = status;
		this.yearsOfExperience = yearsOfExperience;
		this.ratings = new HashMap<>();
	}

	public List<Course> getAssignedCourses() {
		return new ArrayList<>(courses);
	}

	public List<Course> viewCourses() {
		return new ArrayList<>(courses);
	}

	public void manageCourse(Course course) {
		if (!courses.contains(course)) {
			courses.add(course);
			System.out.println("Course " + course.getName() + " managed by teacher.");
		} else {
			System.out.println("Course " + course.getName() + " is already managed by the teacher.");
		}
	}

	public void putMarks(Student student, Course course, double mark) {
		if (students.contains(student) && courses.contains(course)) {
			student.setMark(course, mark);
			System.out.println("Mark " + mark + " assigned to student " + student.getName() + " for course " + course.getName() + ".");
		} else {
			System.out.println("Student or course not found.");
		}
	}

	public void sendComplaint(String complaint, Student student, UrgencyLevel level) {
		if (students.contains(student)) {
			this.level = level;
			System.out.println("Complaint sent: " + complaint + " with urgency level " + level + " for student " + student.getName() + ".");
		} else {
			System.out.println("Student not found.");
		}
	}

	public List<Student> viewStudents(Course course) {
		List<Student> courseStudents = new ArrayList<>();
		for (Student student : students) {
			if (student.viewCourses().contains(course)) {
				courseStudents.add(student);
			}
		}
		return courseStudents;
	}

	public boolean isProfessor() {
		return isProfessor;
	}

	public void setProfessor(boolean isProfessor) {
		this.isProfessor = isProfessor;
	}

	public TeacherStatus getStatus() {
		return status;
	}

	public void setStatus(TeacherStatus status) {
		this.status = status;
	}

	public UrgencyLevel getLevel() {
		return level;
	}

	public void setLevel(UrgencyLevel level) {
		this.level = level;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public void addRating(Student student, int rating) {
		ratings.put(student, rating);
		System.out.println("Received rating " + rating + " from student " + student.getName() + ".");
	}

	public double calculateAverageRating() {
		return ratings.values().stream().mapToInt(Integer::intValue).average().orElse(0.0);
	}
}
