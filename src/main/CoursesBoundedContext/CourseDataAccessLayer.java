package main.CoursesBoundedContext;
import main.db.DataAccessLayer;

import java.sql.*;
import java.util.ArrayList;

public class CourseDataAccessLayer extends DataAccessLayer {


    public CourseDataAccessLayer(int keyID) {
        super("courses", "course_id", keyID);
    }

    public Boolean getInstructorPermissionStatus(){
        return super.booleanConverter(super.getItem("instructor_permission"));
    }

    public ArrayList<Integer> getPrerequisites(){
        ArrayList<Integer> prerequisites = new ArrayList<>();
        for (int i = 1; i <= Course.MAX_NUM_PREREQ; i++) {
            String temp = super.getItem("prereq" + String.valueOf(i) + "_id");
            if (temp != null){
                prerequisites.add(Integer.parseInt(temp));
            } else{
                prerequisites.add(null);
            }
        }

        return prerequisites;
    }

}
