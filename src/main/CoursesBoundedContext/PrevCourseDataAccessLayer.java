package main.CoursesBoundedContext;

import main.db.DataAccessLayer;

import java.sql.SQLException;
import java.util.ArrayList;

public class PrevCourseDataAccessLayer extends DataAccessLayer {
    public PrevCourseDataAccessLayer(int keyID) {
        super("Previous_Courses", "student_id", keyID);
    }

    public ArrayList getPreviousCourses(){
        //get result and convert entries from String to Integer
        ArrayList<String> temp = super.getItemList("course_id");
        return super.stringArrayListToInt(temp);
    }

}
