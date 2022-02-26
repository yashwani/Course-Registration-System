package test.AdminBoundedContext;

import main.AdminBoundedContext.Admin;
import main.StudentBoundedContext.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @Test
    void createStudent1() {
        Student student = new Student(10829);
        student.setLastName("'Wani'");
        student.setFirstName("'Yash'");

        Admin admin = new Admin();
        assertTrue(admin.create(student));
    }

    void createFaculty1(){

    }

    void createCourse1(){

    }

}