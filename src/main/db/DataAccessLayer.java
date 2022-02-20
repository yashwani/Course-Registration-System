package main.db;
import java.sql.*;
import java.util.ArrayList;

public class DataAccessLayer {

    public ResultSet res;
    public String tableName;

    public DataAccessLayer(String tableName, String keyName, int keyID )  {
        try {
            DatabaseConnection db = DatabaseConnection.getInstance();
            Connection conn = db.dbConnection;

            this.tableName = tableName;

            String stmt = "SELECT * FROM " + tableName + " WHERE " + keyName + " = ?";
            PreparedStatement pst = conn.prepareStatement(stmt);
            pst.setString(1, String.valueOf(keyID));
            res = pst.executeQuery();
            res.next(); //moves cursor to row with data
        } catch(SQLException e){
            System.out.println("Error in connecting to database, or SQL Statement execution.");
        }
    }

    public String getItem(String columnLabel){
        try {
            return res.getString(columnLabel);
        } catch (SQLException e){
            System.out.println("Unable to find " + columnLabel + " for table " + tableName);
            return null;
        }
    }

    public ArrayList getItemList(String columnLabel){
        ArrayList result = new ArrayList();
        try{
            result.add(res.getString(columnLabel));
            while(res.next()){
                result.add(res.getString(columnLabel));
            }
        } catch (SQLException e){
            System.out.println("Unable to find " + columnLabel + " for table " + tableName);
        }

        return result;
    }

    protected boolean booleanConverter(String val){
        /**
         * JDBC driver reads false as "0"
         */

        if (val.equals("0")){
            return false;
        } else if (val.equals("1")){
            return true;
        } else {
            System.out.println("Unrecognized boolean value");
            System.exit(1);
            return false;
        }
    }

    protected ArrayList<Integer> stringArrayListToInt(ArrayList<String> input){
        ArrayList<Integer> output = new ArrayList<>();
        for(String stringValue : input) {
            output.add(Integer.parseInt(stringValue));
        }
        return output;
    }

}
