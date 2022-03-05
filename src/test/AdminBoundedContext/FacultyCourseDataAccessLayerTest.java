package test.AdminBoundedContext;

import main.AdminBoundedContext.FacultyCourseDataAccessLayer;
import main.CoursesBoundedContext.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacultyCourseDataAccessLayerTest {


    @Test
    void whoIsInstructor(){
        FacultyCourseDataAccessLayer f = new FacultyCourseDataAccessLayer();
        assertEquals(f.courseInstructor(new Course(10002)), 20001);
    }

    @Test
    void isTeachingCourse() {
        FacultyCourseDataAccessLayer f = new FacultyCourseDataAccessLayer();
        assertTrue(f.isTeachingCourse(20000, 10000));
    }


    @Test
    void isNotTeachingCourse() {
        FacultyCourseDataAccessLayer f = new FacultyCourseDataAccessLayer();
        assertFalse(f.isTeachingCourse(20000, -1));
    }

    @Test
    void facultyDNE() {
        FacultyCourseDataAccessLayer f = new FacultyCourseDataAccessLayer();
        assertFalse(f.isTeachingCourse(-1, 10000));
    }

}