package main.RegistrationBoundedContext;

import main.RegistrationBoundedContext.CourseAddDrop;
import main.RegistrationBoundedContext.RequestResponse;

public class StudentRegistration {
    /**
     * Interface/Facade for students trying to interact with registration bounded context
     */

    public RequestResponse addCourse(int studentId, int courseId){
        CourseAddDrop courseAddDrop = new CourseAddDrop(studentId, courseId);
        courseAddDrop.addCourse();
        return null;
    }





}
