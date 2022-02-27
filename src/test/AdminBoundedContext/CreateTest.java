package test.AdminBoundedContext;

import main.AdminBoundedContext.Admin;
import main.AdminBoundedContext.Create;
import main.CoursesBoundedContext.Course;
import main.FacultyBoundedContext.Faculty;
import main.StudentBoundedContext.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateTest {

    @Test
    void createStudent1() {
        Student student = new Student(10829);
        student.setLastName("'Wani'");
        student.setFirstName("'Yash'");

        Create create = new Create(student);
        create.execute();
    }

    @Test
    void createFaculty1() {
        Faculty faculty = new Faculty(20002);
        faculty.setLastName("'Wan'");
        faculty.setFirstName("'Raj'");

        Create create = new Create(faculty);
        create.execute();
    }

    @Test
    void createcourse1() {
        Course course = new Course(10005);
        course.setCourse_name("'TestCourse'");
        course.setIsOpen(1);
        course.setInstructor("'Test Instructor'");
        course.setInstructor_permission(0);


        Create create = new Create(course);
        create.execute();
    }
}