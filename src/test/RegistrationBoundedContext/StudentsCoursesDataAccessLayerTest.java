package test.RegistrationBoundedContext;

import main.RegistrationBoundedContext.StudentsCoursesDataAccessLayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentsCoursesDataAccessLayerTest {

    @Test
    void studentInCourse() {
        StudentsCoursesDataAccessLayer s = new StudentsCoursesDataAccessLayer();
        assertTrue(s.studentInCourse(10821, 10000));

    }

    @Test
    void DNEStudent() {
        StudentsCoursesDataAccessLayer s = new StudentsCoursesDataAccessLayer();
        assertFalse(s.studentInCourse(-1, 10000));
    }

    @Test
    void DNECourse(){
        StudentsCoursesDataAccessLayer s = new StudentsCoursesDataAccessLayer();
        assertFalse(s.studentInCourse(10821, -1));
    }

}