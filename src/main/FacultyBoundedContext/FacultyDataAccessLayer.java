package main.FacultyBoundedContext;

import main.Modifiable;
import main.Modifier;
import main.db.DataAccessLayer;

import java.util.ArrayList;

public class FacultyDataAccessLayer extends DataAccessLayer implements Modifier {
    /**
     * Provides an abstraction layer to the faculty table in the database
     * If switching databases, update code in this class
     */


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

    public String getEmail(){
        String[] col = new String[]{"email"};
        return getResult(col);
    }

    private String getResult(String[] col){
        ArrayList<ArrayList<String>> result = super.executeSelectQuery(col,tableName,keyName,keyID);
        if (result.isEmpty() || result.get(0).isEmpty()){
            return "Faculty not found.";
        }
        return result.get(0).get(0);
    }




    @Override
    public boolean createNew(Modifiable faculty) {
        String[] insertColumn = new String[]{"faculty_id", "last_name", "first_name"};
        String[] insertValue = faculty.listAttributes();

        return super.executeInsertQuery("faculty", insertColumn, insertValue);
    }

    @Override
    public boolean delete(Modifiable faculty) {
        String[] keyName = new String[]{"faculty_id"};
        String[] keyID = new String[]{faculty.primaryKey()};

        return super.executeDeleteQuery("faculty",keyName, keyID);
    }

    @Override
    public boolean update(Modifiable faculty, String[] updateColumn, String[] updateValue){
        String[] keyName = new String[]{"faculty_id"};
        String[] keyID = new String[]{faculty.primaryKey()};

        return super.executeUpdateQuery("faculty",updateColumn, updateValue, keyName, keyID);
    };
}
