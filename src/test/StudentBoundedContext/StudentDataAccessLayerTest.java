package test.StudentBoundedContext;

import main.StudentBoundedContext.StudentDataAccessLayer;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StudentDataAccessLayerTest {

    @Test
    void getLastName() throws SQLException {
        StudentDataAccessLayer db = new StudentDataAccessLayer(10822);
        String actual = db.getLastName();
        String expected = "Guster";
        assertEquals(expected, actual);
    }

    @Test
    void gusHoldStatus() throws SQLException {
        StudentDataAccessLayer db = new StudentDataAccessLayer(10822);
        assertFalse(db.getHoldStatus());
    }

    @Test
    void gusGhostStatus() throws SQLException {
        StudentDataAccessLayer db = new StudentDataAccessLayer(-1);
        String actual = db.getLastName();
        String expected = "Student not found.";
        assertEquals(expected, actual);
    }
}