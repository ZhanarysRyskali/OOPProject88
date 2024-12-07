package Project88;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
	private ManagerType managerType;
	private List<News> news;

	public Manager() {
		super();
		this.news = new ArrayList<>();
	}

	public void approveStudent(Student student) {
		// Logic for approving a student
	}

	public void addCourse(Course course, Major major, int year) {
		// Logic for adding a course
	}

	public void assignCourseToTeacher(Course course, Teacher teacher) {
		// Logic for assigning a course to a teacher
	}

	public Report generateReport() {
		// Logic for generating a report
		return new Report();
	}

	public List<?> viewInfo(SortingCriteria criteria, String type) {
		// Logic for fetching and sorting info based on criteria
		return new ArrayList<>();
	}

	public void prioritizeNews(String topic) {
		// Logic to prioritize news by topic
	}
}
