package over.model.pojo;

import java.util.*;

/**
 * <code>Email</code> class.
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
public class Email {
    private int id;
    private String email;
    private String password;
    private List<Employee> employees;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Employee> getEmployees() {
        return employees;
    }       
}