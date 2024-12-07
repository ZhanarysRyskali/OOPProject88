package Project88;

import java.util.*;
import java.util.stream.Collectors;

public class Manager extends Employee {
	private ManagerType managerType;
	private List<News> news;
	private List<Student> students;
	private List<Teacher> teachers;
	private List<Request> employeeRequests;

	public Manager() {
		super();
		this.news = new ArrayList<>();
		this.students = new ArrayList<>();
		this.teachers = new ArrayList<>();
		this.employeeRequests = new ArrayList<>();
	}

	public List<Teacher> getTeachers() {
		return new ArrayList<>(teachers);
	}

	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}

	public Manager(String fullName, String email, String password, int id, String position, ManagerType managerType) {
		super(fullName, email, password, id, position);
		this.managerType = managerType;
		this.news = new ArrayList<>();
		this.students = new ArrayList<>();
		this.employeeRequests = new ArrayList<>();
	}

	// Approve a student's registration
	public void approveStudent(Student student) {
		if (!students.contains(student)) {
			students.add(student);
			System.out.println("Student " + student.getFullName() + " approved.");
		} else {
			System.out.println("Student " + student.getFullName() + " is already approved.");
		}
	}

	// Add a course for a specific major and year of study
	public void addCourse(Course course, Major major, int year) {
		major.addCourseForYear(course, year);
		System.out.println("Course " + course.getName() + " added for Major: " + major.getName() + ", Year: " + year);
	}

	// Assign a course to a teacher
	public void assignCourseToTeacher(Course course, Teacher teacher) {
		teacher.manageCourse(course);
		System.out.println("Course " + course.getName() + " assigned to Teacher: " + teacher.getFullName());
	}

	// Generate a statistical report on academic performance
	public Report generateReport() {
		Report report = new Report();
		double averageGpa = students.stream()
				.mapToDouble(Student::getGpa)
				.average()
				.orElse(0.0);
		report.setAverageGpa(averageGpa);
		report.setTotalStudents(students.size());
		System.out.println("Report generated: Average GPA = " + averageGpa + ", Total Students = " + students.size());
		return report;
	}

	// View information about students or teachers sorted by the given criteria
	public List<?> viewInfo(SortingCriteria criteria, String type) {
		if ("students".equalsIgnoreCase(type)) {
			return sortStudents(criteria);
		} else if ("teachers".equalsIgnoreCase(type)) {
			return sortTeachers(criteria);
		}
		return new ArrayList<>();
	}

	private List<Student> sortStudents(SortingCriteria criteria) {
		List<Student> sortedStudents = new ArrayList<>(students);
		switch (criteria) {
			case GPA:
				sortedStudents.sort(Comparator.comparingDouble(Student::getGpa).reversed());
				break;
			case NAME:
				sortedStudents.sort(Comparator.comparing(Student::getFullName));
				break;
		}
		return sortedStudents;
	}

	private List<Teacher> sortTeachers(SortingCriteria criteria) {
		List<Teacher> teachers = getTeachers(); // Assume there's a method to fetch teachers
		switch (criteria) {
			case NAME:
				teachers.sort(Comparator.comparing(Teacher::getFullName));
				break;
			case EXPERIENCE:
				teachers.sort(Comparator.comparingInt(Teacher::getYearsOfExperience).reversed());
				break;
		}
		return teachers;
	}

	// Prioritize news by topic
	public void prioritizeNews(String topic) {
		Collections.sort(news, (n1, n2) -> {
			if (n1.getTopic().equalsIgnoreCase(topic) && !n2.getTopic().equalsIgnoreCase(topic)) {
				return -1;
			} else if (!n1.getTopic().equalsIgnoreCase(topic) && n2.getTopic().equalsIgnoreCase(topic)) {
				return 1;
			}
			return 0;
		});
		System.out.println("News prioritized by topic: " + topic);
	}

	// View requests from employees that must be signed by the dean/rector
	public List<Request> viewPendingRequests() {
		return employeeRequests.stream()
				.filter(Request::isPendingApproval)
				.collect(Collectors.toList());
	}

	public void addEmployeeRequest(Request request) {
		employeeRequests.add(request);
		System.out.println("Request added: " + request.getDescription());
	}
}
