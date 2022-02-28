package main.RegistrationBoundedContext;

import main.CoursesBoundedContext.Course;
import main.CoursesBoundedContext.PrevCourseDataAccessLayer;
import main.StudentBoundedContext.Student;
import main.StudentBoundedContext.StudentDataAccessLayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class CourseAddDrop {
    /**
     * Handles all course adding (and soon dropping) functionality. Handles checking (holds/instructor permission/prereqs)
     * for whether a student can add a course --> in future iterations, this may be abstracted out.
     */



    public StudentDataAccessLayer studentdb;
    private Student student;
    private Course course;
    private int courseId;


    public CourseAddDrop(Student student, Course course){
        this.student = student;
        this.courseId = course.getID();
        this.course = course;
        try {
            studentdb = new StudentDataAccessLayer(this.student.getID());
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        //initialize course database here
    }

    public RequestResponse addCourse() {
        RequestResponse resp = new RequestResponse();

        resp.setSuccess(true);

        if (hold()){
            resp.addReason("Hold on account");
            resp.setSuccess(false);
        }
        if (!instructorPermission()){
            resp.addReason("Instructor has denied permission");
            resp.setSuccess(false);
        }
        if (!prereqSatisfy()){
            resp.addReason("Prerequisites not satisfied");
            resp.setSuccess(false);
        }

        if(resp.isSuccess()){
            resp.addReason("Course Registration Successful");
            //implement adding course to student in database here
        }

        return resp;
    }

    public RequestResponse dropCourse(){



        return null;
    }






    private boolean hold(){
        return studentdb.getHoldStatus();
    }

    private boolean instructorPermission(){
        //returns true if permission granted or no permission found
        PermissionsDataAccessLayer p = new PermissionsDataAccessLayer(student.getID(),courseId);
        String permission = p.getPermissions();
        return permission.equals("Granted") || permission.equals("PERMISSION NOT FOUND");

    }

    private boolean prereqSatisfy(){
        PrevCourseDataAccessLayer p = new PrevCourseDataAccessLayer(student.getID());
        ArrayList<Integer> prevCourses = p.getPreviousCourses();
        ArrayList<Integer> prerequisites = course.getPrerequisites();

        //first check if there are prereqs, if there aren't then return True
        boolean noPrereq = true;
        for (int i = 0; i < prerequisites.size(); i++) {
            noPrereq = noPrereq && (prerequisites.get(i) == null);
        }
        if (noPrereq){
            return true;
        }

        boolean result = true;

        for (int i = 0; i < prerequisites.size(); i++) {
            boolean innerResult = false;
            if (prerequisites.get(i) == null){ //if not prereq, then skip check
                continue;
            }
            for (int j = 0; j<prevCourses.size(); j++){ //loop over prev courses to see if there's a match
                innerResult = innerResult || (Objects.equals(prevCourses.get(j), prerequisites.get(i)));
            }
            System.out.println(innerResult);
            result = result && innerResult;
        }

        return result;
    }


}
