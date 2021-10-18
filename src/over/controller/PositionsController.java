package over.controller;

import over.model.pojo.Department;
import over.model.pojo.Hierarchy;
import over.model.pojo.Position;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.util.List;

public class PositionsController implements Controller {
    private JTextField txtPositionName;
    private JComboBox cmbDepartments;
    private JComboBox cmbHierarchies;
    private JButton btnAddPosition;
    private JTable existingPositionsTable;

    public PositionsController(List components) {
        txtPositionName = (JTextField) components.get(0);
        cmbDepartments = (JComboBox) components.get(1);
        cmbHierarchies = (JComboBox) components.get(2);
        btnAddPosition = (JButton) components.get(3);
        existingPositionsTable = (JTable) components.get(4);
    }

    public void addPosition() {

    }

    public void updatePosition() {

    }

    public void deletePosition() {

    }

    public void setPositionInformation() {

    }

    public void refreshExistingPositionsTable() {
        DefaultTableModel tableModel = new DefaultTableModel(0, 0);
        tableModel.setColumnIdentifiers(new Object[]{"Id", "Nombre", "Departamento", "Jerarquía"});

        existingPositionsTable.setModel(tableModel);

        for(Position position : new Position().getAllpositions())
            tableModel.addRow(new Object[]{position.getId(), position.getName(), position.getDepartment(), position.getHierarchy()});
    }

    public void refreshExistingDepartmentList() {
        cmbDepartments.removeAllItems();

        for (Department department : new Department().getAllDepartments())
            cmbDepartments.addItem(department);
    }

    public void refreshExistingHierarchyList() {
        cmbHierarchies.removeAllItems();

        for (Hierarchy hierarchy : new Hierarchy().getAllHierarchies())
            cmbHierarchies.addItem(hierarchy);
    }

    @Override
    public void selectText(String name) {
        switch(name) {
            case "txtPositionName" :
                txtPositionName.setSelectionStart(0);
                txtPositionName.setSelectionEnd(txtPositionName.getText().length());
                break;
        }
    }

    @Override
    public void setFocus(KeyEvent evt) {
        String keySource = getKeySource(evt);
        int keyCode = evt.getKeyCode();

        if(keyCode == 37 || keyCode == 39)
            switch(keySource){
                case "txtPositionName":
                    btnAddPosition.requestFocusInWindow();
                    break;
                case "btnAddPosition":
                    txtPositionName.requestFocusInWindow();
                    selectText("txtPositionName");
                    break;

            }
        else if(keyCode == 10) {
            switch(keySource){
                case "btnAddPosition":
                    addPosition();
                    refreshExistingPositionsTable();
                    break;
                case "btnModifyPosition":
                    updatePosition();
                    refreshExistingPositionsTable();
                    break;
                case "btnDeletePosition":
                    deletePosition();
                    refreshExistingPositionsTable();
                    break;
            }

            txtPositionName.setText("");
            txtPositionName.requestFocusInWindow();
        }
    }
}