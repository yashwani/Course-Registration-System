package main;
import java.sql.SQLException;

public class HoldHandler extends AddCourseHandler{
    /**
     * checks for holds against the student database
     */


    private StudentDataAccessLayer studentdb;
    @Override
    public boolean check(int student_id, int course_id) {
        Boolean holdStatus = true;

        try{
         studentdb = new StudentDataAccessLayer(student_id);
         holdStatus = studentdb.getHoldStatus();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        if (holdStatus){
            return false;
        } else{
            return checkNext(student_id, course_id);
        }


    }
}
