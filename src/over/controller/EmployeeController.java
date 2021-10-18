package over.controller;

import over.model.pojo.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
        tableModel.setColumnIdentifiers(new Object[]{"Id", "Nombre", "Apellido Paterno", "Apellido Materno", "Título", "Puesto", "Dirección", "Fecha de nacimiento", "Fecha de registro", "Sexo"});

        existingEmployeesTable.setModel(tableModel);

        for(Employee employee : new Employee().getAllEmployees()) {
            tableModel.addRow(
                new Object[]{
                    employee.getId(),
                    employee.getName(),
                    employee.getLastNameF(),
                    employee.getLastNameM(),
                    employee.getTitle(),
                    employee.getPosition(),
                    employee.getAddress(),
                    employee.getBirthdate(),
                    employee.getRegister(),
                    employee.getGender()
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

    public void setEmployeeInformation() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        int id = (int)existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 0);
        String name = existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 1).toString();
        String lastNameF = existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 2).toString();
        String lastNameM = existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 3).toString();
        String title = existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 4).toString();
        String position = existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 5).toString();
        String address = existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 6).toString();
        String birthday = existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 7).toString();
        String register = existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 8).toString();
        String gender = existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 9).toString();

        Date birthdayDate = Date.from(LocalDate.parse(birthday).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Date registerDate = Date.from(LocalDate.parse(register).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        txtEmployee.setText(name);
        txtLastNameF.setText(lastNameF);
        txtLastNameM.setText(lastNameM);
        txtHeading.setText(title);
        txtPosition.setText(position);
        txtAddress.setText(address);
        txtBirthday.setValue(simpleDateFormat.format(birthdayDate));
        txtRegisterDate.setValue(simpleDateFormat.format(registerDate));
        cmbGender.setSelectedIndex(getGender(gender));
    }

    public int getGender(String gender) {
        if(gender.equals("M"))
            return 0;

        return 1;
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