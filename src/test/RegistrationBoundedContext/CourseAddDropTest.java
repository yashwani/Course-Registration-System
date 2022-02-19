package test.RegistrationBoundedContext;

import main.RegistrationBoundedContext.CourseAddDrop;
import main.RegistrationBoundedContext.RequestResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseAddDropTest {

    @Test
    void addGusToCloudComputing() {
        CourseAddDrop courseAddDrop = new CourseAddDrop(10822, 10000);
        RequestResponse actual = courseAddDrop.addCourse();

        RequestResponse expected = new RequestResponse();
        expected.setSuccess(true);
        expected.addReason("Course Registration Successful");

        assertEquals(expected.isSuccess(), actual.isSuccess());
        assertEquals(expected.getReason(), actual.getReason());
    }

    @Test
    void addCarltonToParallelProgramming(){
        CourseAddDrop courseAddDrop = new CourseAddDrop(10824, 10002);
        RequestResponse actual = courseAddDrop.addCourse();

        RequestResponse expected = new RequestResponse();
        expected.setSuccess(false);
        expected.addReason("Hold on account");

        assertEquals(expected.isSuccess(), actual.isSuccess());
        assertEquals(expected.getReason(), actual.getReason());
    }
}