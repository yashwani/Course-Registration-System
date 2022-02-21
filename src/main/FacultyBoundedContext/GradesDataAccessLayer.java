package main.FacultyBoundedContext;

import main.db.DataAccessLayer;

import java.util.ArrayList;
import java.util.List;


public class GradesDataAccessLayer extends DataAccessLayer {

    private String[] keyID = new String[2];
    private String tableName = "grades";
    private String[] keyName = new String[]{"course_id", "student_id"};

    public GradesDataAccessLayer(int course_id, int student_id){
        super();
        keyID[0] = String.valueOf(course_id);
        keyID[1] = String.valueOf(student_id);
    }

    public boolean updateGrade(String grade){
        if (! isValid(grade)){
            return false;
        }

        String[] updateColumn = new String[]{"grade"};
        String[] updateValue = new String[]{"'" + grade +"'"};

        return super.executeUpdateQuery(tableName, updateColumn, updateValue,keyName, keyID);
    }

    private boolean isValid(String grade){
        List<String> arr = new ArrayList<String>(6);
        arr.add("A");
        arr.add("B");
        arr.add("C");
        arr.add("D");
        arr.add("F");
        arr.add("audit");
        return arr.contains(grade);
    }

}
