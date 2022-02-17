import java.sql.SQLException;

public class InstructorPermissionHandler extends AddCourseHandler{
    /**
     * finish the check for instructor permission
     */

    private CourseDataAccessLayer coursedb;

    @Override
    public boolean check(int student_id, int course_id) {
        Boolean permissionStatus = false;

        try{
            coursedb = new CourseDataAccessLayer(course_id);
            permissionStatus = coursedb.getInstructorPermissionStatus();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return false;
    }
}
