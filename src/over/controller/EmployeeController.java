package over.controller;

import over.model.pojo.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.List;

public class EmployeeController implements Controller{
    private JTextField txtEmployee;
    private JTextField txtLastNameF;
    private JTextField txtLastNameM;
    private JTextField txtHeading;
    private JTextField txtPosition;
    private JTextField txtAddress;
    private JFormattedTextField txtBirthday;
    private JFormattedTextField txtRegisterDate;
    private JComboBox<String> cmbGender;
    private JButton btnAddEmployee;
    private JTable existingEmployeesTable;

    public EmployeeController(List list) {
        txtEmployee = (JTextField) list.get(0);
        txtLastNameF = (JTextField) list.get(1);
        txtLastNameM = (JTextField) list.get(2);
        txtHeading = (JTextField) list.get(3);
        txtPosition = (JTextField) list.get(4);
        txtAddress = (JTextField) list.get(5);
        txtBirthday = (JFormattedTextField) list.get(6);
        txtRegisterDate = (JFormattedTextField) list.get(7);
        cmbGender = (JComboBox) list.get(8);
        btnAddEmployee = (JButton) list.get(9);
        existingEmployeesTable = (JTable) list.get(10);
    }

    public void addEmployee() {

    }

    public void deleteEmployee() {

    }

    public void updateEmployee() {

    }

    public void refreshExistingEmployeeTable() {
        DefaultTableModel tableModel = new DefaultTableModel(0, 0);
        tableModel.setColumnIdentifiers(new String [] {"Id", "Nombre", "Título", "Puesto", "Dirección", "Fecha de nacimiento", "Fecha de registro", "Sexo"});

        existingEmployeesTable.setModel(tableModel);

        for(Employee employee : new Employee().getAllEmployees()) {
            tableModel.addRow(
                new String[]{
                        employee.getId() + "",
                        employee.getName(),
                        employee.getTitle(),
                        employee.getPosition().getId() + "",
                        employee.getAddress(),
                        employee.getBirthdate() + "",
                        employee.getRegister() + "",
                        employee.getGender() + ""
                }
            );
        }
    }

    public void refreshExistingGenderList() {
        cmbGender.removeAllItems();

        cmbGender.addItem("M");
        cmbGender.addItem("F");
    }

    public void initDateFields() throws ParseException {
        txtBirthday.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
        txtRegisterDate.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
    }

    @Override
    public void selectText(String name) {
        switch(name) {
            case "txtEmployee":
                txtEmployee.setSelectionStart(0);
                txtEmployee.setSelectionEnd(txtEmployee.getText().length());
                break;
        }
    }

    @Override
    public void setFocus(KeyEvent evt) {
        String keySource = getKeySource(evt);
        int keyCode = evt.getKeyCode();

        if(keyCode == 37 || keyCode == 39)
            switch(keySource){
                case "txtEmployee":
                    btnAddEmployee.requestFocusInWindow();
                    break;
                case "btnAddEmployee":
                    txtEmployee.requestFocusInWindow();
                    break;
            }
        else if(keyCode == 10) {
            switch(keySource){
                case "btnAddEmployee":
                    addEmployee();
                    refreshExistingGenderList();
                    refreshExistingEmployeeTable();
                    break;
                case "btnModifyEmployee":
                    updateEmployee();
                    refreshExistingGenderList();
                    refreshExistingEmployeeTable();
                    break;
                case "btnDeleteEmployee":
                    deleteEmployee();
                    refreshExistingGenderList();
                    refreshExistingEmployeeTable();
                    break;
            }

            txtEmployee.setText("");
            txtEmployee.requestFocusInWindow();
        }
    }
}