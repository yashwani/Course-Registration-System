import java.sql.*;

public class CourseDataAccessLayer {
    public ResultSet res;

    public CourseDataAccessLayer(int courseId) throws SQLException {
        DatabaseConnection db = DatabaseConnection.getInstance();
        Connection conn = db.dbConnection;

        String stmt = "SELECT * FROM students WHERE course_id = ?";
        PreparedStatement pst = conn.prepareStatement(stmt);
        pst.setString(1,String.valueOf(courseId));
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

}
