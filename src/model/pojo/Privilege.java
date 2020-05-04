package model.pojo;

import model.sql.db.DBConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Privilege {

    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    } 
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Privilege> getAllPrivileges() {
        ArrayList<Privilege> privileges = new ArrayList<>();

        String query = "SELECT * FROM privilegios ORDER BY id_privilegio ASC;";

        try {
            DBConnection dbConnection = new DBConnection();
            dbConnection.connect();

            ResultSet resultSet = dbConnection.executeQuery(query);

            while(resultSet.next()) {
                Privilege privilege = new Privilege();
                privilege.setId(resultSet.getInt("id_privilegio"));
                privilege.setName(resultSet.getString("nombre"));

                privileges.add(privilege);
            }

            dbConnection.disconnect();
        }
        catch (Exception e) {
        }

        return privileges;
    }

    public boolean addPrivilege() {
        boolean result = false;
        String command = "INSERT INTO privilegios (nombre) VALUES ('" + this.name + "');";

        try {
            DBConnection dbConnection = new DBConnection();
            dbConnection.connect();

            result = dbConnection.executeCommand(command);

            dbConnection.disconnect();
        }
        catch(Exception e) {
        }

        return result;
    }

    public boolean updatePrivilege() {
        boolean result = false;
        String command = "UPDATE privilegios SET nombre = '" + this.name + "' WHERE id_privilegio = " + this.id + ";";

        try {
            DBConnection dbConnection = new DBConnection();
            dbConnection.connect();

            result = dbConnection.executeCommand(command);

            dbConnection.disconnect();
        }
        catch (Exception e) {
        }

        return result;
    }

    public boolean deletePrivilege() {
        boolean result = false;
        String command = "DELETE FROM privilegios WHERE id_privilegio = " + this.id + ";";

        try {
            DBConnection dbConnection = new DBConnection();
            dbConnection.connect();

            result = dbConnection.executeCommand(command);

            dbConnection.disconnect();
        }
        catch (Exception e) {
        }

        return result;
    }

    public String toString() {
        return this.name;
    }
}