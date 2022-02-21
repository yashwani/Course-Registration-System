package test.FacultyBoundedContext;

import main.FacultyBoundedContext.GradesDataAccessLayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradesDataAccessLayerTest {

    @Test
    void updateGrade1() {
        GradesDataAccessLayer g = new GradesDataAccessLayer(10000, 10821);
        assertTrue(g.updateGrade("B"));
    }

    @Test
    void updateGrade2() {
        GradesDataAccessLayer g = new GradesDataAccessLayer(10000, 10821);
        assertFalse(g.updateGrade("G"));
    }

    @Test
    void updateGradeCourseDNE() {
        GradesDataAccessLayer g = new GradesDataAccessLayer(-1, 10821);
        assertFalse(g.updateGrade("A"));
    }

    @Test
    void updateGradeStudenteDNE() {
        GradesDataAccessLayer g = new GradesDataAccessLayer(10000, -1);
        assertFalse(g.updateGrade("A"));
    }


}