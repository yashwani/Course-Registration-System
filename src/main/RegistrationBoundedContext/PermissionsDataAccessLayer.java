package main.RegistrationBoundedContext;

import main.db.DataAccessLayer;

import java.sql.SQLException;
import java.util.ArrayList;

//TODO: clean up inheritance from DataAccessLayer

public class PermissionsDataAccessLayer extends DataAccessLayer {
    private int courseID;

    public PermissionsDataAccessLayer(int studentID, int courseID) {
        super("Course_Permission", "student_id", studentID);

        this.courseID = courseID;
    }

    public String getPermissions(){
        return getItem(courseID);
    }

    public String getItem(int course_id){
        ArrayList<Integer> course_id_list = new ArrayList();
        ArrayList<String> status_list = new ArrayList();
        try{
            course_id_list.add(Integer.parseInt(res.getString("course_id")));
            status_list.add(res.getString("status"));
            while(res.next()){
                course_id_list.add(Integer.parseInt(res.getString("course_id")));
                status_list.add(res.getString("status"));
            }
        } catch (SQLException e){
            System.out.println("Unable to find entries for table " + tableName);
        }


        //find the index of the course and get the permission for that index
        int index = -1;
        for (int i = 0; i < course_id_list.size(); i++) {
            if (course_id_list.get(i).equals(course_id)){
                index = i;
                return status_list.get(index);
            }
        }

        return "PERMISSION NOT FOUND";


    }


}
