package main.RegistrationBoundedContext;

import main.CoursesBoundedContext.Course;
import main.RegistrationBoundedContext.CourseAddDrop;
import main.RegistrationBoundedContext.RequestResponse;
import main.StudentBoundedContext.Student;

public class StudentRegistration {
    /**
     * Interface/Facade for students trying to interact with registration bounded context
     */

    public RequestResponse addCourse(Student student, Course course){
        CourseAddDrop courseAddDrop = new CourseAddDrop(student, course);
        courseAddDrop.addCourse();
        return null;
    }





}
