package test.RegistrationBoundedContext;

import main.CoursesBoundedContext.Course;
import main.RegistrationBoundedContext.StudentsCoursesDataAccessLayer;
import main.StudentBoundedContext.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentsCoursesDataAccessLayerTest {

    @Test
    void deleteStudentFromCourse(){
        StudentsCoursesDataAccessLayer s = new StudentsCoursesDataAccessLayer();
        assertTrue(s.deleteStudentFromCourse(new Student(19999), new Course(10001)));
    }

    @Test
    void deleteStudentFromCourseDNE(){
        StudentsCoursesDataAccessLayer s = new StudentsCoursesDataAccessLayer();
        assertFalse(s.deleteStudentFromCourse(new Student(-1), new Course(-1)));
    }

    @Test
    void getCoursesForStudent(){
        StudentsCoursesDataAccessLayer s = new StudentsCoursesDataAccessLayer();
        ArrayList<ArrayList<String>> actual = s.getCoursesForStudent(new Student(10824));
        System.out.println(actual);
        assertTrue(actual.size() == 4);
    }

    @Test
    void getCoursesForStudentDNE(){
        StudentsCoursesDataAccessLayer s = new StudentsCoursesDataAccessLayer();
        ArrayList<ArrayList<String>> actual = s.getCoursesForStudent(new Student(-1));
        assertTrue(actual.size() == 0);
    }

//    @Test
//    void studentInCourse() {
//        StudentsCoursesDataAccessLayer s = new StudentsCoursesDataAccessLayer();
//        assertTrue(s.studentInCourse(10821, 10000));
//
//    }
//
//    @Test
//    void DNEStudent() {
//        StudentsCoursesDataAccessLayer s = new StudentsCoursesDataAccessLayer();
//        assertFalse(s.studentInCourse(-1, 10000));
//    }
//
//    @Test
//    void DNECourse(){
//        StudentsCoursesDataAccessLayer s = new StudentsCoursesDataAccessLayer();
//        assertFalse(s.studentInCourse(10821, -1));
//    }

}