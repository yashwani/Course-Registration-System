
import java.sql.*;

public class DataAccessLayer {

    public ResultSet res;
    public String tableName;

    public DataAccessLayer(String tableName, String keyName, int keyID ) throws SQLException {
        DatabaseConnection db = DatabaseConnection.getInstance();
        Connection conn = db.dbConnection;

        this.tableName = tableName;

        String stmt = "SELECT * FROM " + tableName + " WHERE " + keyName + " = ?";
        PreparedStatement pst = conn.prepareStatement(stmt);
        pst.setString(1,String.valueOf(keyID));
        System.out.println(pst);
        res = pst.executeQuery();
        res.next(); //moves cursor to row with data
    }

    public String getItem(String columnLabel){
        try {
            return res.getString(columnLabel);
        }
        catch (SQLException e){
            System.out.println("Unable to find " + columnLabel + " for table " + tableName);
            return null;
        }
    }

}
