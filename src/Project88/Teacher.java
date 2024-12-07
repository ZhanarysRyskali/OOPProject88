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
				courseStudents.add(student);
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
}
