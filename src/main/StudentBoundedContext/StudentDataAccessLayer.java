package main.StudentBoundedContext;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import main.Modifiable;
import main.Modifier;
import main.db.DataAccessLayer;
import main.db.MongoDBConnection;
import com.mongodb.*;
import main.db.MongoDBConnection;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class StudentDataAccessLayer extends DataAccessLayer implements Modifier {
    /**
     * Provides an abstraction layer to the students table in the database
     * If switching databases, update code in this class
     */
    private String[] keyID = new String[1];
    private String tableName = "students";
    private String[] keyName = new String[]{"student_id"};


    public StudentDataAccessLayer(int keyID) throws SQLException {
        super();
        this.keyID[0] = String.valueOf(keyID);
    }




    public boolean createNew(Modifiable student){
        String[] insertColumn = new String[]{"student_id", "last_name", "first_name", "enroll_date","isHold"};
        String[] insertValue = student.listAttributes();

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        DBObject entry = new BasicDBObject("_id", timestamp)
                .append("operation", "create student")
                .append("id", student.primaryKey());
        log(entry);


        return super.executeInsertQuery("students", insertColumn, insertValue);
    }

    @Override
    public boolean delete(Modifiable student) {
        String[] keyName = new String[]{"student_id"};
        String[] keyID = new String[]{student.primaryKey()};

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        DBObject entry = new BasicDBObject("_id", timestamp)
                .append("operation", "delete student")
                .append("id", student.primaryKey());
        log(entry);

        return super.executeDeleteQuery("students",keyName, keyID);
    }

    @Override
    public boolean update(Modifiable student, String[] updateColumn, String[] updateValue) {
        String[] keyName = new String[]{"student_id"};
        String[] keyID = new String[]{student.primaryKey()};

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        DBObject entry = new BasicDBObject("_id", timestamp)
                .append("operation", "modify student")
                .append("id", student.primaryKey());
        log(entry);

        return super.executeUpdateQuery("students",updateColumn, updateValue, keyName, keyID);
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

    private void log(DBObject entry){
        MongoDBConnection mongodb = MongoDBConnection.getInstance();
        MongoClient mognoconn = mongodb.mongoClient;
        DB database = mognoconn.getDB("REGIE");
        DBCollection collection = database.getCollection("logging");
        collection.insert(entry);
    }


}
