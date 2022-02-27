package test.AdminBoundedContext;

import main.AdminBoundedContext.Admin;
import main.AdminBoundedContext.Create;
import main.CoursesBoundedContext.Course;
import main.FacultyBoundedContext.Faculty;
import main.StudentBoundedContext.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @Test
    void updateFaculty() {
        Faculty faculty = new Faculty(20001);
        Admin admin = new Admin();

        String[] updateColumn = new String[]{"first_name"};
        String[] updateValue = new String[]{"'Jimbo'"};

        assertTrue(admin.modify(faculty, updateColumn, updateValue));

    }

    @Test
    void updateCoursePrereq1() {
        Course course = new Course(10004);
        Admin admin = new Admin();

        String[] updateColumn = new String[]{"prereq3_id"};
        String[] updateValue = new String[]{"999"};

        assertTrue(admin.modify(course, updateColumn, updateValue));

    }

    @Test
    void updateStudent1() {
        Student student = new Student(10828);
        Admin admin = new Admin();

        String[] updateColumn = new String[]{"isHold"};
        String[] updateValue = new String[]{"1"};

        assertTrue(admin.modify(student, updateColumn, updateValue));

    }



    @Test
    void createDeleteStudent1() {
        Student student = new Student(10829);
        student.setLastName("'Wani'");
        student.setFirstName("'Yash'");

        Admin admin = new Admin();
        assertTrue(admin.create(student));

        Student student2 = new Student(10829);
        Admin admin2 = new Admin();
        assertTrue(admin.delete(student2));
    }



    @Test
    void createDeleteFaculty1() {
        Faculty faculty = new Faculty(20002);
        faculty.setLastName("'Wan'");
        faculty.setFirstName("'Raj'");

        Admin admin = new Admin();
        assertTrue(admin.create(faculty));


        Faculty faculty2 = new Faculty(20002);
        Admin admin2 = new Admin();
        assertTrue(admin.delete(faculty2));
    }



    @Test
    void createcourse1() {
        Course course = new Course(10005);
        course.setCourse_name("'TestCourse'");
        course.setIsOpen(1);
        course.setInstructor("'Test Instructor'");
        course.setInstructor_permission(0);


        Admin admin = new Admin();
        assertTrue(admin.create(course));

        Course course2 = new Course(10005);
        Admin admin2 = new Admin();
        assertTrue(admin.delete(course2));
    }



    @Test
    void deleteStudentDNE(){
        Student student = new Student(-1);
        Admin admin = new Admin();
        assertFalse(admin.delete(student));
    }



    @Test
    void deleteFacultyDNE(){
        Faculty faculty = new Faculty(-1);
        Admin admin = new Admin();
        assertFalse(admin.delete(faculty));
    }


    @Test
    void deleteCourseDNE(){
        Course course = new Course(-1);
        Admin admin = new Admin();
        assertFalse(admin.delete(course));
    }





}