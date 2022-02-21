package main.RegistrationBoundedContext;

import main.db.DataAccessLayer;

import java.util.ArrayList;

//TODO: clean up inheritance from DataAccessLayer

public class PermissionsDataAccessLayer extends DataAccessLayer {
    private String tableName = "Course_Permission";
    private String[] keyName = new String[]{"course_id", "student_id"};
    private String[] keyID;

    public PermissionsDataAccessLayer(int studentID, int courseID){
        super();
        keyID = new String[]{String.valueOf(courseID), String.valueOf(studentID)};

    }

    public String getPermissions(){
        String[] columnsSelected = new String[]{"status"};
        ArrayList<ArrayList<String>> result = super.executeSelectQuery(columnsSelected,tableName,keyName,keyID);
        if (result.isEmpty() || result.get(0).isEmpty()){
            return "PERMISSION NOT FOUND";
        }
        return result.get(0).get(0);
    }




}
