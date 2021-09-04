package over.controller;

import over.model.pojo.Department;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class DepartmentController implements Controller {
    JTextField txtDepartment;
    JButton btnAddDepartment, btnModifyDepartment, btnDeleteDepartment;
    JList existingDepartmentsList;

    public DepartmentController(List components) {
        txtDepartment = (JTextField)components.get(0);
        btnAddDepartment = (JButton)components.get(1);
        btnModifyDepartment = (JButton)components.get(2);
        btnDeleteDepartment = (JButton)components.get(3);
        existingDepartmentsList = (JList)components.get(4);
    }

    public void addDepartment() {
        String departmentName = txtDepartment.getText().trim();

        if(!departmentName.isEmpty()) {
            Department department = new Department();
            department.setId(0);
            department.setName(departmentName);

            department.addDepartment();
        }
        else
            JOptionPane.showMessageDialog(null, "Introduce un nombre válido");
    }

    public void updateDepartment() {
        Department department = (Department) existingDepartmentsList.getSelectedValue();

        if(department != null) {
            String newDepartmentName = JOptionPane.showInputDialog("Introduce el nombre de departamento deseado");

            if(!newDepartmentName.isEmpty()) {
                department.setName(newDepartmentName);

                department.updateDepartment();
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Selecciona un departamento");
    }

    public void deleteDepartment() {
        Department department = (Department) existingDepartmentsList.getSelectedValue();

        if(department != null)
            department.deleteDepartment();
        else
            JOptionPane.showMessageDialog(null, "Selecciona un departamento");
    }

    public void refreshExistingDepartmentList() {
        DefaultListModel nameListModel = new DefaultListModel();

        for(Department current : new Department().getAllDepartments())
            nameListModel.addElement(current);

        existingDepartmentsList.setModel(nameListModel);
    }

    @Override
    public void selectText(String name) {
        switch(name) {
            case "txtDepartment" :
                txtDepartment.setSelectionStart(0);
                txtDepartment.setSelectionEnd(txtDepartment.getText().length());
                break;
        }
    }

    @Override
    public void setFocus(KeyEvent evt) {
        String keySource = getKeySource(evt);
        int keyCode = evt.getKeyCode();

        if(keyCode == 37 || keyCode == 39)
            switch(keySource){
                case "txtDepartment":
                    btnAddDepartment.requestFocusInWindow();
                    break;
                case "btnAddDepartment":
                    txtDepartment.requestFocusInWindow();
                    selectText("txtDepartment");
                    break;
            }
        else if(keyCode == 10) {
            switch(keySource){
                case "btnAddDepartment":
                    addDepartment();
                    refreshExistingDepartmentList();
                    txtDepartment.setText("");
                    txtDepartment.requestFocusInWindow();
                    break;
            }
        }
    }
}