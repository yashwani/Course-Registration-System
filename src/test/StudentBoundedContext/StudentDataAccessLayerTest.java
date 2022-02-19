package test.StudentBoundedContext;

import main.StudentBoundedContext.StudentDataAccessLayer;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StudentDataAccessLayerTest {

    @Test
    void getLastName() {
    }

    @Test
    void getFirstName() {
    }

    @Test
    void getEnrollDate() {
    }

    @Test
    void gusHoldStatus() throws SQLException {
        StudentDataAccessLayer db = new StudentDataAccessLayer(10822);
        assertFalse(db.getHoldStatus());
    }
}