package over.controller;

import over.model.pojo.Department;
import over.model.pojo.Hierarchy;
import over.model.pojo.Position;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * <code>PositionsController</code> class.
 * @author Overload Inc.
 * @version %I%, %G%
 */
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
        String name = txtPositionName.getText().trim();
        Department department = (Department) cmbDepartments.getSelectedItem();
        Hierarchy hierarchy = (Hierarchy) cmbHierarchies.getSelectedItem();

        if(!name.isEmpty()) {
            Position position = new Position();

            position.setId(0);
            position.setName(name);
            position.setDepartment(department);
            position.setHierarchy(hierarchy);

            position.addPosition();
        }
        else {
            JOptionPane.showMessageDialog(null, "Introduce un nombre válido");
        }
    }

    public void updatePosition() {
        int row = existingPositionsTable.getSelectedRow();

        if(row >= 0) {
            int id = Integer.parseInt(existingPositionsTable.getValueAt(row, 0).toString());
            String name = txtPositionName.getText().trim();
            Department department = (Department) cmbDepartments.getSelectedItem();
            Hierarchy hierarchy = (Hierarchy) cmbHierarchies.getSelectedItem();

            if(!name.isEmpty()) {
                Position position = new Position();

                position.setId(id);
                position.setName(name);
                position.setDepartment(department);
                position.setHierarchy(hierarchy);

                position.updatePosition();
            }
            else {
                JOptionPane.showMessageDialog(null, "Introduce un nombre válido");
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Selecciona un puesto");
    }

    public void deletePosition() {
        int row = existingPositionsTable.getSelectedRow();

        if(row >= 0) {
            int id = Integer.parseInt(existingPositionsTable.getValueAt(row, 0).toString());

            Position position = new Position();
            position.setId(id);

            position.deletePosition();
        }
        else
            JOptionPane.showMessageDialog(null, "Selecciona un puesto");
    }

    public void setPositionInformation() {
        int row = existingPositionsTable.getSelectedRow();

        if(row >= 0) {
            txtPositionName.setText(existingPositionsTable.getValueAt(row, 1).toString());
            cmbDepartments.setSelectedIndex(((Department) existingPositionsTable.getValueAt(row, 2)).getId() - 1);
            cmbHierarchies.setSelectedIndex(((Hierarchy) existingPositionsTable.getValueAt(row, 3)).getId() - 1);
        }
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
                    break;
                case "btnModifyPosition":
                    updatePosition();
                    break;
                case "btnDeletePosition":
                    deletePosition();
                    break;
            }

            refreshExistingPositionsTable();

            txtPositionName.setText("");
            txtPositionName.requestFocusInWindow();
        }
    }
}