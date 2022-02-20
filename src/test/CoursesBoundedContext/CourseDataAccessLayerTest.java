package test.CoursesBoundedContext;

import main.CoursesBoundedContext.CourseDataAccessLayer;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseDataAccessLayerTest {

    @Test
    void getInstructorPermissionStatus() {
    }

    @Test
    void getPrerequisitesForCourse10003() throws SQLException {
        CourseDataAccessLayer c = new CourseDataAccessLayer(10003);
        ArrayList<Integer> actual = c.getPrerequisites();
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(10001);
        expected.add(null);
        expected.add(10002);

        assertTrue(actual.size() == expected.size());

        for (int i = 0; i < actual.size(); i++) {
            assertEquals(actual.get(i),expected.get(i));
        }
    }

    @Test
    void getPrerequisitesForCourse10002() throws SQLException {
        CourseDataAccessLayer c = new CourseDataAccessLayer(10002);
        ArrayList<Integer> actual = c.getPrerequisites();
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(null);
        expected.add(null);
        expected.add(null);

        assertTrue(actual.size() == expected.size());

        for (int i = 0; i < actual.size(); i++) {
            assertEquals(actual.get(i),expected.get(i));
        }
    }


}