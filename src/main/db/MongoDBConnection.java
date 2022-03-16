package main.db;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import com.mongodb.*;

public class MongoDBConnection {
    /**
     * Responsibility: A singleton class that creates a mongodb database connection
     */
    private static MongoDBConnection instance;
    public MongoClient mongoClient;

    private MongoDBConnection(){
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        }
        catch (MongoException e) {
            System.err.println("Mongo exception: " + e.getMessage());
            System.exit(1);
        }
    }

    public static MongoDBConnection getInstance(){
        if (instance == null){
            instance = new MongoDBConnection();
        }
        return instance;
    }

}
