package main.RegistrationBoundedContext;

import main.StudentBoundedContext.StudentDataAccessLayer;

import java.sql.SQLException;

public class CourseAddDrop {
    public StudentDataAccessLayer studentdb;

    public CourseAddDrop(int studentId, int courseId){
        try {
            studentdb = new StudentDataAccessLayer(studentId);
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

    private boolean hold(){
//        return true;
        return studentdb.getHoldStatus();
    }

    private boolean instructorPermission(){
        //returns true if instructor permission not required OR instructor permission granted
        //returns false if instructor permission required and not granted

        return true; //TODO
    }

    private boolean prereqSatisfy(){
        return true; //TODO
    }


}
