package model.pojo;

import model.sql.db.DBConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Hierarchy {

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

    public ArrayList<Hierarchy> getAllHierarchies() {
        ArrayList<Hierarchy> hierarchyList = new ArrayList<>();

        String query = "SELECT * FROM jerarquias ORDER BY id_jerarquia ASC;";

        try {
            DBConnection dbConnection = new DBConnection();
            dbConnection.connect();

            ResultSet resultSet = dbConnection.executeQuery(query);

            while(resultSet.next()) {
                Hierarchy hierarchy = new Hierarchy();
                hierarchy.setId(resultSet.getInt("id_jerarquia"));
                hierarchy.setName(resultSet.getString("nombre"));

                hierarchyList.add(hierarchy);
            }

            dbConnection.disconnect();
        }
        catch (Exception e) {
        }

        return hierarchyList;
    }

    public boolean addHierarchy() {
        boolean result = false;
        String command = "INSERT INTO jerarquias (nombre) VALUES ('" + this.name + "');";

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

    public boolean updateHierarchy() {
        boolean result = false;
        String command = "UPDATE jerarquias SET nombre = '" + this.name + "' WHERE id_jerarquia = " + this.id + ";";

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

    public boolean deleteHierarchy() {
        boolean result = false;
        String command = "DELETE FROM jerarquias WHERE id_jerarquia = " + this.id + ";";

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
}