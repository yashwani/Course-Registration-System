package test.RegistrationBoundedContext;

import main.CoursesBoundedContext.Course;
import main.RegistrationBoundedContext.RequestResponse;
import main.RegistrationBoundedContext.StudentRegistration;
import main.StudentBoundedContext.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegistrationTest {

    @Test
    void addCourse() {
    }

    @Test
    void dropCourse() {
        StudentRegistration sr = new StudentRegistration();
        RequestResponse actual = sr.dropCourse(new Student(19999), 10001);
        assertTrue(actual.isSuccess());
    }

    @Test
    void dropCourseDNE() {
        StudentRegistration sr = new StudentRegistration();
        RequestResponse actual = sr.dropCourse(new Student(-1), -1);
        assertFalse(actual.isSuccess());
    }

    @Test
    void dropAllCourses() {
        StudentRegistration sr = new StudentRegistration();
        RequestResponse r = sr.dropAllCourses(new Student(10821));
        System.out.println(r.getReason());
        assertTrue(r.isSuccess());
    }

    @Test
    void browseCourses() {
    }
}