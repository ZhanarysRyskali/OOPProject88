import Project88.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the University Management System!");

        System.out.println("Please choose your preferred language:");
        for (Language lang : Language.values()) {
            System.out.println(lang.ordinal() + 1 + ". " + lang);
        }
        int languageChoice = scanner.nextInt();
        Language chosenLanguage = Language.values()[languageChoice - 1];
        System.out.println("You have chosen: " + chosenLanguage);

        Admin admin = Admin.getInstance();
        Teacher teacher = new Teacher("John Doe", "john.doe@university.com", "password", 2, "Professor", true, TeacherStatus.PROFESSOR, 10);
        Student student = new Student("Jane Smith", "jane.smith@university.com", "password", 3, 3.8, Faculty.SITE);
        Manager manager = new Manager("Mark Manager", "mark.manager@university.com", "password", 4, "Dean", ManagerType.DEANMANAGER);
        Course course = new Course("Computer Science", LessonType.LECTURE, chosenLanguage, CourseType.MAJOR, Faculty.SITE);

        admin.addUser(teacher);
        admin.addUser(student);
        admin.addUser(manager);
        System.out.println("Admin has added users: " + admin.getUsers());

        System.out.println("Admin has removed a user. Current users: " + admin.getUsers());

        manager.approveStudent(student);
        manager.addCourse(course, new Major("Software Engineering", List.of()), 2024);
        manager.assignCourseToTeacher(course, teacher);
        Report report = manager.generateReport();
        System.out.println(report);

        student.enrollCourse(course);
        teacher.students.add(student);

        teacher.putMarks(student, course, 95);
        student.rateTeacher(teacher, 5);
        teacher.setHIndex(3.0);

        student.enrollCourse(course);
        try {
            student.assignSupervisor(teacher);
            System.out.println("Student's supervisor: " + student.getSupervisor());
        } catch (InvalidSupervisorException e) {
            System.out.println("Error assigning supervisor: " + e.getMessage());
            System.out.println("Student's supervisor: " + student.getSupervisor());
        }

        News news = new News("Research Findings", "New AI techniques developed.", "Research");
        news.addComment("Great work!");
        System.out.println(news);

        TechSupporter techSupporter = new TechSupporter();
        Order order1 = new Order(1, "Fix projector", Status.PENDING);
        techSupporter.addOrder(order1);
        techSupporter.acceptOrder(order1);
        List<Order> acceptedOrders = techSupporter.viewOrder(Status.ACCEPTED);
        System.out.println("Accepted Orders: " + acceptedOrders);

        scanner.close();
    }
}
