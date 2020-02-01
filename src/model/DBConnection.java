package model;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private String host;
    private String user;
    private String password;
    private Connection conn;
        
    public DBConnection() {        
    }
    
    public Connection connect() throws SQLException {
        try{
            System.out.println("Entering try-catch");
            
            host = "jdbc:postgresql://localhost:53498/dbHolywallet";
            user = "postgres";
            password = "admin";
            
            Class.forName("org.postgresql.Driver");
            
            conn = DriverManager.getConnection(host, user, password);
            
            System.out.println("Conn: " + conn);
            
            if(conn != null) {
                System.out.println("Connected to database");
            }
            else {
                System.out.println("Connection failed");
            }
        }
        catch (ClassNotFoundException ex) {        
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
    
    public static void main(String... args) {
        DBConnection db = new DBConnection();
        try {
            db.connect();
        }
        catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}