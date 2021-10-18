package over.model.pojo;

import over.model.sql.db.DBConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

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

    @Override
    public String toString() {
        return this.name;
    }

    public ArrayList<Position> getAllpositions() {
        Hierarchy hierarchy = new Hierarchy();
        Department department = new Department();

        ArrayList<Position> positionList = new ArrayList<>();
        ArrayList<Hierarchy> hierarchyList = hierarchy.getAllHierarchies();
        ArrayList<Department> departmentList = department.getAllDepartments();

        String query = "SELECT * FROM puestos ORDER BY id_puesto ASC;";

        try {
            DBConnection dbConnection = DBConnection.getInstance();
            dbConnection.connect();

            ResultSet resultSet = dbConnection.executeQuery(query);

            while(resultSet.next()) {
                Position position = new Position();

                position.setId(resultSet.getInt("id_puesto"));
                position.setName(resultSet.getString("nombre"));
                position.setHierarchy(hierarchy.getHierarchy(hierarchyList, resultSet.getInt("id_jerarquia")));
                position.setDepartment(department.getDepartment(departmentList, resultSet.getInt("id_departamento")));

                positionList.add(position);
            }

            dbConnection.disconnect();
        }
        catch (Exception e) {
        }

        return positionList;
    }

    public Position getPosition(ArrayList<Position> positions, int id) {
        for(Position position : positions)
            if(position.getId() == id)
                return position;

        return null;
    }
}