package over.model.pojo;

import over.model.sql.db.DBConnection;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Employee {
    private int id;
    private String name;
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
        ArrayList<Employee> employeeList = new ArrayList<>();

        String query = "SELECT * FROM empleados;";

        try {
            DBConnection dbConnection = new DBConnection();
            dbConnection.connect();

            ResultSet resultSet = dbConnection.executeQuery(query);

            while(resultSet.next()) {
                Employee employee = new Employee();
                Position position = new Position();

                employee.setName(resultSet.getString("nombre"));
                employee.setAddress(resultSet.getString("direccion"));
                employee.setTitle(resultSet.getString("titulo"));
                employee.setBirthdate(resultSet.getDate("fecha_nacimiento"));
                employee.setRegister(resultSet.getDate("fecha_registro"));
                employee.setGender(resultSet.getString("sexo").charAt(0));
                position.setId(resultSet.getInt("id_puesto"));
                employee.setPosition(position);

                employeeList.add(employee);
            }

            dbConnection.disconnect();
        }
        catch (Exception e) {
        }

        return employeeList;
    }

    public boolean addEmployee() {
        return false;
    }

    public boolean deleteEmployee() {
        return false;
    }

    public boolean updateEmployee() {
        return false;
    }
}