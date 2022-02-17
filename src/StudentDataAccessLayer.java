import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.*;

public class StudentDataAccessLayer {
    /**
     * Provides an abstraction layer between the database and the Student class
     * If switching databases, update code in this class
     */
    public ResultSet res;

    public StudentDataAccessLayer(int studentId) throws SQLException {
        DatabaseConnection db = DatabaseConnection.getInstance();
        Connection conn = db.dbConnection;

        String stmt = "SELECT * FROM students WHERE student_id = ?";
        PreparedStatement pst = conn.prepareStatement(stmt);
        pst.setString(1,String.valueOf(studentId));
        res = pst.executeQuery();
        res.next(); //moves cursor to row with data
    }

    public String getLastName(){
        try {
            return res.getString("last_name");
        }
        catch (SQLException e){
            System.out.println("Unable to find last name for student.");
            return null;
        }
    }

    public String getFirstName(){
        try {
            return res.getString("first_name");
        }
        catch (SQLException e){
            System.out.println("Unable to find first name for student.");
            return null;
        }
    }

    public String getEnrollDate(){
        try {
            return res.getString("enroll_date");
        }
        catch (SQLException e){
            System.out.println("Unable to find enrollment date for student.");
            return null;
        }
    }






}
