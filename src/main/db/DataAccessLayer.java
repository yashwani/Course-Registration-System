package main.db;
import java.sql.*;
import java.util.ArrayList;

public class DataAccessLayer {

    public ResultSet res;
    private Connection conn;

    public DataAccessLayer( )  {
            DatabaseConnection db = DatabaseConnection.getInstance();
            conn = db.dbConnection;
    }

    public ArrayList<ArrayList<String>> executeSelectQuery(String[] columnsSelected, String tableName, String[] keyName, String[] keyID){
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        try {
            String stmt = buildSelectStatement(columnsSelected, tableName, keyName, keyID);
            PreparedStatement pst = conn.prepareStatement(stmt);
            res = pst.executeQuery();

            while(res.next()){
                ArrayList<String> row = new ArrayList<>();

                for (int i = 0; i < columnsSelected.length; i++) {
                    row.add(res.getString(columnsSelected[i]));
                }
                result.add(row);
            }

        } catch (SQLException e){
            System.out.println("Error in connecting to database, or SQL Statement execution.");
        }
        return result;

    }


    private String buildSelectStatement(String[] columnsSelected, String tableName, String[] keyName, String[] keyID){
        String stmt = "";

        String selectClause = "SELECT";
        String sep = ",";
        for (int i = 0; i < columnsSelected.length; i++) {
            if (i == columnsSelected.length-1){
                sep = "";
            }
            selectClause = selectClause + " " + columnsSelected[i] + sep;
        }

        String fromClause = "FROM " + tableName;

        String whereClause = "WHERE ";
        sep = " AND ";

        for (int i = 0; i < keyName.length; i++) {
            if (i == keyName.length-1){
                sep = "";
            }
            whereClause = whereClause + keyName[i] + " = " + keyID[i] + sep;

        }

        stmt = selectClause + " " + fromClause + " " + whereClause;

        return stmt;
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



}
