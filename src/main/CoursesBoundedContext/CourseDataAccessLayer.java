package main.CoursesBoundedContext;
import main.Modifiable;
import main.Modifier;
import main.db.DataAccessLayer;

import java.util.ArrayList;

public class CourseDataAccessLayer extends DataAccessLayer implements Modifier {
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
            if (resultString.get(0).get(i) == null || resultString.get(0).get(i).equals("-1")){ //null and -1 indicate no prerequisite
                continue;
            }
            result.add(Integer.valueOf(resultString.get(0).get(i)));
        }
        return result;
    }

    @Override
    public boolean createNew(Modifiable course) {
        String[] insertColumn = new String[]{"course_id", "course_name", "isOpen", "instructor", "instructor_permission", "prereq1_id", "prereq2_id", "prereq3_id"};
        String[] insertValue = course.listAttributes();

        return super.executeInsertQuery("courses", insertColumn, insertValue);
    }

    @Override
    public boolean delete(Modifiable course) {
        String[] keyName = new String[]{"course_id"};
        String[] keyID = new String[]{course.primaryKey()};

        return super.executeDeleteQuery("courses",keyName, keyID);
    }

    @Override
    public boolean update(Modifiable course, String[] updateColumn, String[] updateValue) {
        String[] keyName = new String[]{"course_id"};
        String[] keyID = new String[]{course.primaryKey()};

        return super.executeUpdateQuery("courses",updateColumn, updateValue, keyName, keyID);
    }
}
