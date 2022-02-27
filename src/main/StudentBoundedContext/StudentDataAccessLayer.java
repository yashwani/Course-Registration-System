package main.StudentBoundedContext;
import main.Modifiable;
import main.Modifier;
import main.db.DataAccessLayer;

import java.sql.*;
import java.util.ArrayList;

public class StudentDataAccessLayer extends DataAccessLayer implements Modifier {
    /**
     * Provides an abstraction layer to the students table in the database
     * If switching databases, update code in this class
     */
    private String[] keyID = new String[1];
    private String tableName = "students";
    private String[] keyName = new String[]{"student_id"};


    public StudentDataAccessLayer(int keyID) throws SQLException {
        super();
        this.keyID[0] = String.valueOf(keyID);
    }

    public boolean createNew(Modifiable student){
        String[] insertColumn = new String[]{"student_id", "last_name", "first_name", "enroll_date","isHold"};
        String[] insertValue = student.listAttributes();

        return super.executeInsertQuery("students", insertColumn, insertValue);
    }

    public String getLastName(){
        String[] col = new String[]{"last_name"};
        return getResult(col);
    }

    public String getFirstName(){
        String[] col = new String[]{"first_name"};
        return getResult(col);
    }

    public String getEnrollDate(){
        String[] col = new String[]{"enroll_date"};
        return getResult(col);
    }

    public Boolean getHoldStatus(){

        String[] col = new String[]{"isHold"};

        String res = getResult(col);
        if (res.equals("Student not found.")){
            return false;
        }

        return super.booleanConverter(res);
    }



    private String getResult(String[] col){
        ArrayList<ArrayList<String>> result = super.executeSelectQuery(col,tableName,keyName,keyID);
        if (result.isEmpty() || result.get(0).isEmpty()){
            return "Student not found.";
        }
        return result.get(0).get(0);
    }


}
