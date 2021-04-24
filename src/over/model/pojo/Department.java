package over.model.pojo;

import over.model.sql.db.DBConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Department {

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

    public ArrayList<Department> getAllDepartments() {
        ArrayList<Department> departments = new ArrayList<>();

        String query = "SELECT * FROM departamentos ORDER BY id_departamento ASC;";

        try {
            DBConnection dbConnection = new DBConnection();
            dbConnection.connect();

            ResultSet resultSet = dbConnection.executeQuery(query);

            while(resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt("id_departamento"));
                department.setName(resultSet.getString("nombre"));

                departments.add(department);
            }

            dbConnection.disconnect();
        }
        catch (Exception e) {
        }

        return departments;
    }

    public boolean addDepartment() {
        boolean result = false;
        String command = "INSERT INTO departamentos (nombre) VALUES ('" + this.name + "');";

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

    public boolean updateDepartment() {
        boolean result = false;
        String command = "UPDATE departamentos SET nombre = '" + this.name + "' WHERE id_departamento = " + this.id + ";";

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

    public boolean deleteDepartment() {
        boolean result = false;
        String command = "DELETE FROM departamentos WHERE id_departamento = " + this.id + ";";

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