package over.model.pojo;

public class Position {

    private int id;
    private String name;
    private Department department;
    private Hierarchy hierarchy;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setHierarchy(Hierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public Hierarchy getHierarchy() {
        return hierarchy;
    } 
}