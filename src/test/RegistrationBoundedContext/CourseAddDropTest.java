package test.RegistrationBoundedContext;

import main.CoursesBoundedContext.Course;
import main.RegistrationBoundedContext.CourseAddDrop;
import main.RegistrationBoundedContext.RequestResponse;
import main.StudentBoundedContext.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseAddDropTest {

    @Test
    void addGusToCloudComputing() {
        Student gus = new Student(10822);
        Course cloudComputing = new Course(10000);
        CourseAddDrop courseAddDrop = new CourseAddDrop(gus, cloudComputing);
        RequestResponse actual = courseAddDrop.addCourse();

        RequestResponse expected = new RequestResponse();
        expected.setSuccess(true);
        expected.addReason("Course Registration Successful");

        System.out.println(expected.getReason());
        System.out.println(actual.getReason());

        assertEquals(expected.isSuccess(), actual.isSuccess());
        assertEquals(expected.getReason(), actual.getReason());
    }

    @Test
    void addCarltonToParallelProgramming(){
        Student carlton = new Student(10824);
        Course parallelProgramming = new Course(10002);
        CourseAddDrop courseAddDrop = new CourseAddDrop(carlton, parallelProgramming);
        RequestResponse actual = courseAddDrop.addCourse();

        RequestResponse expected = new RequestResponse();
        expected.setSuccess(false);
        expected.addReason("Hold on account\nInstructor has denied permission");

        assertEquals(expected.isSuccess(), actual.isSuccess());
        assertEquals(expected.getReason(), actual.getReason());
    }

    @Test
    void addHenryToOOP(){
        Student henry = new Student(10825);
        Course OOP = new Course(10003);
        CourseAddDrop courseAddDrop = new CourseAddDrop(henry, OOP);
        RequestResponse actual = courseAddDrop.addCourse();

        RequestResponse expected = new RequestResponse();
        expected.setSuccess(true);
        expected.addReason("Course Registration Successful");

        assertEquals(expected.isSuccess(), actual.isSuccess());
        assertEquals(expected.getReason(), actual.getReason());
    }

    @Test
    void addHenryToTest(){
        Student henry = new Student(10825);
        Course test = new Course(10005);
        CourseAddDrop courseAddDrop = new CourseAddDrop(henry, test);
        RequestResponse actual = courseAddDrop.addCourse();

        RequestResponse expected = new RequestResponse();
        expected.setSuccess(true);
        expected.addReason("Course Registration Successful");

        assertEquals(expected.getReason(), actual.getReason());
        assertEquals(expected.isSuccess(), actual.isSuccess());

    }


}