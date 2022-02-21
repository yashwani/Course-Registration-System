package main.CoursesBoundedContext;
import main.db.DataAccessLayer;

import java.util.ArrayList;

public class CourseDataAccessLayer extends DataAccessLayer {
    /**
     * Provides an abstraction layer to the courses table in the database
     * If switching databases, update code in this class
     */

    private String tableName = "courses";
    private String[] keyName = new String[]{"course_id"};
    private String[] keyID = new String[1];

    public CourseDataAccessLayer(int keyID) {
        super();

        this.keyID[0] = String.valueOf(keyID);
    }

    public Boolean getInstructorPermissionStatus(){
//        return super.booleanConverter(super.getItem("instructor_permission"));
        return null;
    }

    public ArrayList<Integer> getPrerequisites(){
        String[] columnsSelected = new String[]{"prereq1_id", "prereq2_id", "prereq3_id"};
        ArrayList<ArrayList<String>> resultString = super.executeSelectQuery(columnsSelected, tableName, keyName, keyID);

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < resultString.get(0).size(); i++) {
            if (resultString.get(0).get(i) == null){
                continue;
            }
            result.add(Integer.valueOf(resultString.get(0).get(i)));
        }
        return result;
    }

}
