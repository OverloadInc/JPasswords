package over.model.pojo;

import java.sql.Date;

public class Employee {

    private int id;
    private String name;
    private String address;
    private String title;
    private Date birthdate;
    private Date register;
    private char gender;
    private Department department;
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

    public void setDepartment(Department department) {
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public Position getPosition() {
        return position;
    }  
}