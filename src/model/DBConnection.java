package model;

import java.sql.*;
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
            host = "jdbc:postgresql://localhost/dbBank";
            user = "postgres";
            password = "postgres";
            
            Class.forName("org.postgresql.Driver");
            
            conn = DriverManager.getConnection(host, user, password);
            
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