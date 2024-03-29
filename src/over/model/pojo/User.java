package over.model.pojo;

import java.sql.ResultSet;
import over.model.sql.db.DBConnection;

/**
 * <code>User</code> class.
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
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
                String query = "SELECT nombre, clave FROM usuarios WHERE nombre = '" + this.name + "' AND clave = '" + this.password + "'";
                
                DBConnection dbConnection = DBConnection.getInstance();
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