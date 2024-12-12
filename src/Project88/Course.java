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
	private CourseType courseType;

	public Course(String name, LessonType type, Language language, CourseType courseType) {
		this.instructors = new ArrayList<>();
		this.students = new ArrayList<>();
		this.name = name;
		this.type = type;
		this.language = language;
		this.courseType = courseType;
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
