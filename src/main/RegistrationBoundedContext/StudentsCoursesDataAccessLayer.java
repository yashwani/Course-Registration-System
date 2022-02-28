package main.RegistrationBoundedContext;

import main.db.DataAccessLayer;

import java.util.ArrayList;

public class StudentsCoursesDataAccessLayer extends DataAccessLayer {

    private String tableName = "courses_students";

    public StudentsCoursesDataAccessLayer(){
        super();
    }

    public boolean studentInCourse(int studentID, int courseID){
        String[] columnsSelected = new String[]{"student_status"};
        String[] keyName = new String[]{"course_id", "student_id"};
        String[] keyID = new String[]{String.valueOf(courseID), String.valueOf(studentID)};

        ArrayList<ArrayList<String>> result = super.executeSelectQuery(columnsSelected,tableName,keyName,keyID);

        if (result.isEmpty()){
            return false;
        } else{
            return true;
        }
    }

    public boolean deleteStudentFromCourse(int studentID, int courseID){
        return true;
    }



}
