package test.RegistrationBoundedContext;

import main.RegistrationBoundedContext.PermissionsDataAccessLayer;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PermissionsDataAccessLayerTest {



    @Test
    void getPermissionsForStudentCoursePair1() throws SQLException {
        PermissionsDataAccessLayer db = new PermissionsDataAccessLayer(10825,10002 );
        String actual = db.getPermissions();
        String expected = "GRANTED";
        System.out.println(actual);
        assertTrue(actual.equals(expected));
    }

    @Test
    void getPermissionsForStudentCoursePair2() throws SQLException {
        PermissionsDataAccessLayer db = new PermissionsDataAccessLayer(10825, 10004);
        String actual = db.getPermissions();
        String expected = "DENIED";
        assertTrue(actual.equals(expected));
    }

    @Test
    void getPermissionsForUnenteredStudent() throws SQLException {
        PermissionsDataAccessLayer db = new PermissionsDataAccessLayer(-1, 10004);
        String actual = db.getPermissions();
        String expected = "PERMISSION NOT FOUND";
        assertTrue(actual.equals(expected));
    }



}