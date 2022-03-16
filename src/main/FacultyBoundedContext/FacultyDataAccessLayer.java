package main.FacultyBoundedContext;

import com.mongodb.*;
import main.Modifiable;
import main.Modifier;
import main.db.DataAccessLayer;
import main.db.MongoDBConnection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FacultyDataAccessLayer extends DataAccessLayer implements Modifier {
    /**
     * Provides an abstraction layer to the faculty table in the database
     * If switching databases, update code in this class
     */


    private String[] keyID = new String[1];
    private String tableName = "faculty";
    private String[] keyName = new String[]{"faculty_id"};

    public FacultyDataAccessLayer(int faculty_id){
        super();
        this.keyID[0] = String.valueOf(faculty_id);
    }

    public String getLastName(){
        String[] col = new String[]{"last_name"};
        return getResult(col);
    }

    public String getFirstName(){
        String[] col = new String[]{"first_name"};
        return getResult(col);
    }

    public String getEmail(){
        String[] col = new String[]{"email"};
        return getResult(col);
    }

    private String getResult(String[] col){
        ArrayList<ArrayList<String>> result = super.executeSelectQuery(col,tableName,keyName,keyID);
        if (result.isEmpty() || result.get(0).isEmpty()){
            return "Faculty not found.";
        }
        return result.get(0).get(0);
    }




    @Override
    public boolean createNew(Modifiable faculty) {
        String[] insertColumn = new String[]{"faculty_id", "last_name", "first_name","email"};
        String[] insertValue = faculty.listAttributes();

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        DBObject entry = new BasicDBObject("_id", timestamp)
                .append("operation", "create faculty")
                .append("id", faculty.primaryKey());
        log(entry);

        return super.executeInsertQuery("faculty", insertColumn, insertValue);
    }

    @Override
    public boolean delete(Modifiable faculty) {
        String[] keyName = new String[]{"faculty_id"};
        String[] keyID = new String[]{faculty.primaryKey()};

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        DBObject entry = new BasicDBObject("_id", timestamp)
                .append("operation", "delete faculty")
                .append("id", faculty.primaryKey());
        log(entry);

        return super.executeDeleteQuery("faculty",keyName, keyID);
    }

    @Override
    public boolean update(Modifiable faculty, String[] updateColumn, String[] updateValue){
        String[] keyName = new String[]{"faculty_id"};
        String[] keyID = new String[]{faculty.primaryKey()};

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        DBObject entry = new BasicDBObject("_id", timestamp)
                .append("operation", "modify faculty")
                .append("id", faculty.primaryKey());
        log(entry);

        return super.executeUpdateQuery("faculty",updateColumn, updateValue, keyName, keyID);
    };

    private void log(DBObject entry){
        MongoDBConnection mongodb = MongoDBConnection.getInstance();
        MongoClient mognoconn = mongodb.mongoClient;
        DB database = mognoconn.getDB("REGIE");
        DBCollection collection = database.getCollection("logging");
        collection.insert(entry);
    }
}
