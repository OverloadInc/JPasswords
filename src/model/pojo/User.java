package model.pojo;

import java.sql.ResultSet;
import model.sql.db.DBConnection;

public class User {
    
    private String name;
    private String password;
    
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }
    
    public boolean find() throws Exception {
        boolean result = false;
        
        try {
            if(name.isEmpty())
                throw new Exception("User name cannot be empty");                        
            else {
                String query = "select nombre, clave from usuarios where nombre = '" + this.name + "' and clave = '" + this.password + "'";
                
                DBConnection dbConnection = new DBConnection();
                dbConnection.connect();
                
                ResultSet resultSet = dbConnection.executeQuery(query);
                result = resultSet.next();
                
                dbConnection.disconnect();
            }
        }
        catch(Exception e) {            
        }
        
        return result;
    }
}