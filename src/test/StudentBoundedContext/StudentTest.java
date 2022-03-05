package test.StudentBoundedContext;

import main.RegistrationBoundedContext.RequestResponse;
import main.StudentBoundedContext.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void dropCourse(){
        Student x = new Student(19999);
        String actual = x.dropCourse(10001);
        String expected = "Successfully dropped course.\n";
        assertEquals(expected, actual);
    }

    @Test
    void browseCourses(){
        Student x = new Student(10824);
        x.browseCourses();
    }

    @Test
    void testCarltonFirstName() {
        Student x = new Student(10824);
        assertEquals("Carlton",x.getFirstNameDB());
    }

    @Test
    void testBadStudentId() {
        Student x = new Student(10000);
        assertEquals("Student not found.",x.getFirstNameDB());
    }

    @Test
    void dropAllCourses() {
        //test by adding courses for student 10824 and then dropping. Hard to test otherwise.
        Student x = new Student(10824);
        String r = x.dropAllCourses();
        System.out.println(r);
    }

    @Test
    void dropAllCoursesDNe() {
        //test by adding courses for student 10824 and then dropping. Hard to test otherwise.
        Student x = new Student(10824);
        String r = x.dropAllCourses();
        System.out.println(r);
    }



}