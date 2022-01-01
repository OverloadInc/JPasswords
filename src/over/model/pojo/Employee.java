package over.model.pojo;

import over.model.sql.db.DBConnection;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Employee {
    private int id;
    private String name;
    private String lastNameF;
    private String lastNameM;
    private String address;
    private String title;
    private Date birthdate;
    private Date register;
    private char gender;
    private Position position;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastNameF(String lastNameF) {
        this.lastNameF = lastNameF;
    }

    public void setLastNameM(String lastNameM) {
        this.lastNameM = lastNameM;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setRegister(Date register) {
        this.register = register;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastNameF() {
        return lastNameF;
    }

    public String getLastNameM() {
        return lastNameM;
    }

    public String getAddress() {
        return address;
    }

    public String getTitle() {
        return title;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Date getRegister() {
        return register;
    }

    public char getGender() {
        return gender;
    }

    public Position getPosition() {
        return position;
    }

    public ArrayList<Employee> getAllEmployees() {
        Position position = new Position();

        ArrayList<Employee> employeeList = new ArrayList<>();
        ArrayList<Position> positionList = position.getAllpositions();

        String query = "SELECT * FROM empleados ORDER BY id_empleado ASC";

        try {
            DBConnection dbConnection = DBConnection.getInstance();
            dbConnection.connect();

            ResultSet resultSet = dbConnection.executeQuery(query);

            while(resultSet.next()) {
                Employee employee = new Employee();

                employee.setId(resultSet.getInt("id_empleado"));
                employee.setName(resultSet.getString("nombre"));
                employee.setLastNameF(resultSet.getString("apellido_paterno"));
                employee.setLastNameM(resultSet.getString("apellido_materno"));
                employee.setAddress(resultSet.getString("direccion"));
                employee.setTitle(resultSet.getString("titulo"));
                employee.setBirthdate(resultSet.getDate("fecha_nacimiento"));
                employee.setRegister(resultSet.getDate("fecha_registro"));
                employee.setGender(resultSet.getString("sexo").charAt(0));
                employee.setPosition(position.getPosition(positionList, resultSet.getInt("id_puesto")));

                employeeList.add(employee);
            }

            dbConnection.disconnect();
        }
        catch (Exception e) {
        }

        return employeeList;
    }

    public boolean addEmployee() {
        boolean result = false;
        String command = "INSERT INTO empleados (nombre, apellido_paterno, apellido_materno, direccion, titulo, fecha_nacimiento, fecha_registro, sexo, id_puesto) VALUES ('" + this.name + "', '" + this.lastNameF + "', '" + this.lastNameM + "', '" + this.address + "', '" + this.title + "', '" + this.birthdate + "', '" + this.register + "', '" + this.gender + "', " + this.position.getId() +");";

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

    public boolean deleteEmployee() {
        boolean result = false;
        String command = "DELETE FROM empleados WHERE id_empleado = " + this.id + ";";

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

    public boolean updateEmployee() {
        boolean result = false;
        String command = "UPDATE empleados SET nombre = '" + this.name + "', apellido_paterno = '" + this.lastNameF + "', apellido_materno = '" + this.lastNameM + "', direccion = '" + this.address + "', titulo = '" + this.title + "', fecha_nacimiento = '" + this.birthdate + "', fecha_registro = '" + this.register + "', sexo = '" + this.gender + "', id_puesto= " + this.position.getId() + " WHERE id_empleado = " + this.id + ";";

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
}