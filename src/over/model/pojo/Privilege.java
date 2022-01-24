package over.model.pojo;

import over.model.sql.db.DBConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * <code>Privilege</code> class.
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
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
            DBConnection dbConnection = DBConnection.getInstance();
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

    public String getPrivilege(User user) {
        String privilege = null;
        String query = "SELECT e.nombre AS \"empleado\", u.nombre AS \"usuario\", p.nombre AS \"privilegio\"\n" +
                "FROM empleados e, usuarios u, privilegios p, empleado_privilegio ep\n" +
                "WHERE e.id_empleado = ep.id_empleado AND ep.id_privilegio = p.id_privilegio AND e.id_empleado = u.id_empleado\n" +
                "AND u.nombre = '" + user.getName() + "'";

        try {
            DBConnection dbConnection = DBConnection.getInstance();
            dbConnection.connect();

            ResultSet resultSet = dbConnection.executeQuery(query);

            while(resultSet.next())
                privilege = resultSet.getString("privilegio");

            dbConnection.disconnect();
        }
        catch (Exception e) {
        }

        return privilege;
    }

    public boolean addPrivilege() {
        boolean result = false;
        String command = "INSERT INTO privilegios (nombre) VALUES ('" + this.name + "');";

        try {
            DBConnection dbConnection = DBConnection.getInstance();
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
            DBConnection dbConnection = DBConnection.getInstance();
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
            DBConnection dbConnection = DBConnection.getInstance();
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