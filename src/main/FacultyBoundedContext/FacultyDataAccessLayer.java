package main.FacultyBoundedContext;

import main.db.DataAccessLayer;

import java.util.ArrayList;

public class FacultyDataAccessLayer extends DataAccessLayer {


    private String[] keyID = new String[1];
    private String tableName = "faculty";
    private String[] keyName = new String[]{"faculty_id"};

    public FacultyDataAccessLayer(int faculty_id){
        super();
        this.keyID[0] = String.valueOf(faculty_id);
    }

    public String getLastName(){
        String[] col = new String[]{"last_name"};
        return getResult(col);
    }

    public String getFirstName(){
        String[] col = new String[]{"first_name"};
        return getResult(col);
    }

    private String getResult(String[] col){
        ArrayList<ArrayList<String>> result = super.executeSelectQuery(col,tableName,keyName,keyID);
        if (result.isEmpty() || result.get(0).isEmpty()){
            return "Faculty not found.";
        }
        return result.get(0).get(0);
    }




}
