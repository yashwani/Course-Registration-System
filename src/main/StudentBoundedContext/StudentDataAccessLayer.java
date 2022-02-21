package main.StudentBoundedContext;
import main.db.DataAccessLayer;

import java.sql.*;
import java.util.ArrayList;

public class StudentDataAccessLayer extends DataAccessLayer {
    /**
     * Provides an abstraction layer between the database and the Student class
     * If switching databases, update code in this class
     */
    private String[] keyID = new String[1];
    private String tableName = "students";
    private String[] keyName = new String[]{"student_id"};


    public StudentDataAccessLayer(int keyID) throws SQLException {
        super();
        this.keyID[0] = String.valueOf(keyID);
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















//    public ResultSet res;
//
//    public StudentDataAccessLayer(int studentId) throws SQLException {
//        DatabaseConnection db = DatabaseConnection.getInstance();
//        Connection conn = db.dbConnection;
//
//        String stmt = "SELECT * FROM students WHERE student_id = ?";
//        PreparedStatement pst = conn.prepareStatement(stmt);
//        pst.setString(1,String.valueOf(studentId));
//        res = pst.executeQuery();
//        res.next(); //moves cursor to row with data
//    }
//
//    public String getLastName(){
//        try {
//            return res.getString("last_name");
//        }
//        catch (SQLException e){
//            System.out.println("Unable to find last name for student.");
//            return null;
//        }
//    }
//
//    public String getFirstName(){
//        try {
//            return res.getString("first_name");
//        }
//        catch (SQLException e){
//            System.out.println("Unable to find first name for student.");
//            return null;
//        }
//    }
//
//    public String getEnrollDate(){
//        try {
//            return res.getString("enroll_date");
//        }
//        catch (SQLException e){
//            System.out.println("Unable to find enrollment date for student.");
//            return null;
//        }
//    }
//
//    public boolean getHoldStatus(){
//        try {
//            return res.getBoolean("isHold");
//        }
//        catch (SQLException e){
//            System.out.println("Unable to find enrollment date for student.");
//            System.exit(1);
//            return false;
//        }
//    }






}
