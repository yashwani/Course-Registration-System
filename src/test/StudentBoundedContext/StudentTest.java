package test.StudentBoundedContext;

import main.StudentBoundedContext.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

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
}