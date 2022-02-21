package main.AdminBoundedContext;

import main.db.DataAccessLayer;

import java.util.ArrayList;

public class FacultyCourseDataAccessLayer extends DataAccessLayer {
    /**
     * Provides an abstraction layer to the courses_faculty table in the database
     * If switching databases, update code in this class
     */

    private String tableName = "courses_faculty";
    private String[] keyName = new String[]{"course_id", "faculty_id"};
    private String[] keyID;

    public FacultyCourseDataAccessLayer(int faculty_id, int course_id){
        super();
        keyID = new String[]{String.valueOf(course_id), String.valueOf(faculty_id)};
    }

    public boolean isTeachingCourse(){
        String[] columnsSelected = new String[]{"course_id"};
        ArrayList<ArrayList<String>> result = super.executeSelectQuery(columnsSelected,tableName,keyName,keyID);

        if (result.isEmpty()){
            return false;
        } else{
            return true;
        }

    }


}
