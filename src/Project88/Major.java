package Project88;

import java.util.List;

public class Major {
    private String name;
    private List<Course> courses;

    public Major(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
