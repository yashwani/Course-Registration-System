package main.CoursesBoundedContext;

import main.db.DataAccessLayer;

import java.util.ArrayList;

public class PrevCourseDataAccessLayer extends DataAccessLayer {
    private String tableName = "Previous_Courses";
    private String[] keyName = new String[]{"student_id"};
    private String[] keyID;


    public PrevCourseDataAccessLayer(int keyID) {
        super();

        this.keyID = new String[]{String.valueOf(keyID)};
    }

    public ArrayList<Integer> getPreviousCourses(){
        //get result and convert entries from String to Integer
        String[] columnsSelected = new String[]{"course_id"};
        ArrayList<ArrayList<String>> resultString = super.executeSelectQuery(columnsSelected,tableName,keyName,keyID);

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < resultString.size(); i++) {
            result.add(Integer.valueOf(resultString.get(i).get(0)));
        }

        return result;

    }

}
