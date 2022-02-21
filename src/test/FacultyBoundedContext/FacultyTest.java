package test.FacultyBoundedContext;

import main.FacultyBoundedContext.Faculty;
import main.StudentBoundedContext.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacultyTest {

    @Test
    void testAssignGrade1() {
        Faculty x = new Faculty(20000);
        assertEquals("Successfully assigned grade",x.assignGrade(10000,10821,"A"));
    }

    @Test
    void testAssignGrade2() {
        Faculty x = new Faculty(20000);
        assertEquals("Course and/or student invalid",x.assignGrade(-1,10821,"A"));
    }

    @Test
    void testAssignGrade3() {
        Faculty x = new Faculty(20000);
        assertEquals("Course and/or student invalid",x.assignGrade(10000,-1,"A"));
    }

    @Test
    void testAssignGrade4() {
        Faculty x = new Faculty(20000);
        assertEquals("Course and/or student invalid",x.assignGrade(-1,-1,"A"));
    }

    @Test
    void testAssignGrade5() {
        Faculty x = new Faculty(20000);
        assertEquals("Invalid grade type entered",x.assignGrade(-1,-1,"E"));
    }




    @Test
    void testFirstName() {
        Faculty x = new Faculty(20000);
        assertEquals("Billy",x.getFirstName());
    }

    @Test
    void testBadFacultyId() {
        Faculty x = new Faculty(-1);
        assertEquals("Faculty not found.",x.getFirstName());
    }
}