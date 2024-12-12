package Project88;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Course {
	private String name;
	private LessonType type;
	private List<Teacher> instructors;
	private Language language;
	private List<Student> students;

	public Course() {
		this.instructors = new ArrayList<>();
		this.students = new ArrayList<>();
	}

	public void addInstructor(Teacher teacher) {
		instructors.add(teacher);
	}

	public void registerStudent(Student student) {
		students.add(student);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return new ArrayList<>(students);
	}

	public Set<Teacher> getInstructors() {
		return new HashSet<>(instructors);
	}


}
