package main;
import java.sql.*;

public class CourseDataAccessLayer extends DataAccessLayer {


    public CourseDataAccessLayer(int keyID) throws SQLException {
        super("courses", "course_id", keyID);
    }

    public Boolean getInstructorPermissionStatus(){
        return super.booleanConverter(super.getItem("instructor_permission"));
    }

}
