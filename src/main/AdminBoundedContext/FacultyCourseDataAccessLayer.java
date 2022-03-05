package main.AdminBoundedContext;

import main.CoursesBoundedContext.Course;
import main.db.DataAccessLayer;

import java.util.ArrayList;

public class FacultyCourseDataAccessLayer extends DataAccessLayer {
    /**
     * Provides an abstraction layer to the courses_faculty table in the database
     * If switching databases, update code in this class
     */

    private String tableName = "courses_faculty";
    private String[] keyName;
    private String[] keyID;

    public FacultyCourseDataAccessLayer(){
        super();

    }

    public boolean isTeachingCourse(int faculty_id, int course_id){
        keyID = new String[]{String.valueOf(course_id), String.valueOf(faculty_id)};
        keyName = new String[]{"course_id", "faculty_id"};
        String[] columnsSelected = new String[]{"course_id"};
        ArrayList<ArrayList<String>> result = super.executeSelectQuery(columnsSelected,tableName,keyName,keyID);

        if (result.isEmpty()){
            return false;
        } else{
            return true;
        }
    }

    public int courseInstructor(Course course){
        String[] columnsSelected = new String[]{"faculty_id"};
        keyName = new String[]{"course_id"};
        keyID = new String[]{String.valueOf(course.getID())};
        ArrayList<ArrayList<String>> result = super.executeSelectQuery(columnsSelected,tableName,keyName,keyID);

        return Integer.valueOf(result.get(0).get(0));

    }


}
