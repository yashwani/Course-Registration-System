package test.CoursesBoundedContext;

import main.CoursesBoundedContext.PrevCourseDataAccessLayer;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PrevCourseDataAccessLayerTest {

    @Test
    void getPreviousCoursesFor10825() throws SQLException {
        PrevCourseDataAccessLayer db = new PrevCourseDataAccessLayer(10825);
        ArrayList actual = db.getPreviousCourses();
        System.out.println(actual);

        ArrayList expected = new ArrayList();
        expected.add(10001);
        expected.add(10002);


        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i),actual.get(i));
        }


    }

    @Test
    void getPreviousCoursesForNewStudent() throws SQLException {
        PrevCourseDataAccessLayer db = new PrevCourseDataAccessLayer(-1); //student has not taken any courses previously
        ArrayList actual = db.getPreviousCourses();

        ArrayList expected = new ArrayList<Integer>();
        assertEquals(expected, actual);
    }

}