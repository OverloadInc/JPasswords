package over.model.pojo;

import java.util.*;

/**
 * <code>Telephone</code> class.
 * @author Overload Inc.
 * @version %I%, %G%
 */
public class Telephone {
    private int id;
    private String number;
    private List<Employee> employees;

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public List<Employee> getEmployees() {
        return employees;
    }   
}