package main.db;
import java.sql.*;
import java.util.logging.Level;

public class DatabaseConnection {
    /**
     * Responsibility: A singleton class that creates a database instance
     */
    private static DatabaseConnection instance;
    public Connection dbConnection;

    private DatabaseConnection(){
        try {
            java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.OFF);
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/REGIE", "root", "");
        }
        catch (SQLException e) {
            System.err.println("SQL exception: " + e.getMessage());
            System.exit(1);
        }
    }

    public static DatabaseConnection getInstance(){
        if (instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }

}
