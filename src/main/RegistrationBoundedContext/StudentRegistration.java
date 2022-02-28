package main.RegistrationBoundedContext;


import main.CoursesBoundedContext.Course;
import main.CoursesBoundedContext.CourseDataAccessLayer;
import main.CoursesBoundedContext.CourseFactory;
import main.StudentBoundedContext.Student;

import java.util.ArrayList;

public class StudentRegistration {
    /**
     * Interface/Facade for students trying to interact with registration bounded context
     */

    public RequestResponse addCourse(Student student, Course course){
        CourseAddDrop courseAddDrop = new CourseAddDrop(student, course);
        courseAddDrop.addCourse();
        return null;
    }

    public RequestResponse dropCourse(Student student, int courseID){
        RequestResponse r = new RequestResponse();

        //check that student is actually taking the course
        StudentsCoursesDataAccessLayer s = new StudentsCoursesDataAccessLayer();
        if (!s.studentInCourse(student.getID(), courseID)){
            r.setSuccess(false);
            r.addReason("Student not enrolled in course;");
            return r;
        }

        //build the course object --> license out to a factory
        CourseFactory cf = new CourseFactory();
        Course course = cf.createCourse(courseID);

        //send the student and course to CourseAddDrop to handle actually adding/dropping the course
        CourseAddDrop courseAddDrop = new CourseAddDrop(student,course);
        r = courseAddDrop.dropCourse();
        return null;
    }

    public RequestResponse dropAllCourses(Student student){
        return null;
    }

    public void browseCourses(){
        CourseDataAccessLayer c = new CourseDataAccessLayer(-1);
        ArrayList<ArrayList<String>> courses = c.selectAllCourses();

        //Print out table showing courses
        int[] width = new int[]{7,30,10,20,24,10,10,10};
        String[] headers = new String[]{"ID", "Name", "Open", "Instructor", "Instructor Permission", "Prereq 1", "Prereq 2", "Prereq 3"};
        for (int i = 0; i < headers.length; i++) {
            System.out.print(headers[i]);
            for (int j = 0; j < width[i] - headers[i].length(); j++) {
                System.out.print(" ");
            }
        }

        System.out.println();

        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < courses.get(i).size(); j++) {
                System.out.print(courses.get(i).get(j));
                int len;
                if (courses.get(i).get(j) == null){
                    len = 4;
                } else {
                    len = courses.get(i).get(j).length();
                }
                for (int k = 0; k < (width[j]-len) ; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }





}
