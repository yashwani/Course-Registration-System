package test.AdminBoundedContext;

import main.AdminBoundedContext.FacultyCourseDataAccessLayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacultyCourseDataAccessLayerTest {

    @Test
    void isTeachingCourse() {
        FacultyCourseDataAccessLayer f = new FacultyCourseDataAccessLayer(20000, 10000);
        assertTrue(f.isTeachingCourse());
    }


    @Test
    void isNotTeachingCourse() {
        FacultyCourseDataAccessLayer f = new FacultyCourseDataAccessLayer(20000, -1);
        assertFalse(f.isTeachingCourse());
    }
}