package over.controller;

import over.model.pojo.Employee;
import over.model.pojo.Position;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class EmployeeController implements Controller{
    private JTextField txtEmployee;
    private JTextField txtLastNameF;
    private JTextField txtLastNameM;
    private JTextField txtHeading;
    private JComboBox cmbPosition;
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
        cmbPosition = (JComboBox) list.get(4);
        txtAddress = (JTextField) list.get(5);
        txtBirthday = (JFormattedTextField) list.get(6);
        txtRegisterDate = (JFormattedTextField) list.get(7);
        cmbGender = (JComboBox) list.get(8);
        btnAddEmployee = (JButton) list.get(9);
        existingEmployeesTable = (JTable) list.get(10);
    }

    public void addEmployee() {
        try {
            String name = txtEmployee.getText().trim();
            String lastNameF = txtLastNameF.getText().trim();
            String lastNameM = txtLastNameM.getText().trim();
            String heading = txtHeading.getText().trim();
            Position position = (Position) cmbPosition.getSelectedItem();
            String address = txtAddress.getText().trim();
            String birthday = txtBirthday.getValue().toString().trim();
            String register = txtRegisterDate.getValue().toString().trim();
            String gender = cmbGender.getSelectedItem().toString();

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date parsed = format.parse(birthday);
            Date birthdayDate = new Date(parsed.getTime());

            java.util.Date parsed2 = format.parse(register);
            Date registerDate = new Date(parsed2.getTime());

            if(!name.isEmpty() && !lastNameF.isEmpty() && !lastNameM.isEmpty()) {
                Employee employee = new Employee();

                employee.setName(name);
                employee.setLastNameF(lastNameF);
                employee.setLastNameM(lastNameM);
                employee.setTitle(heading);
                employee.setPosition(position);
                employee.setAddress(address);
                employee.setBirthdate(birthdayDate);
                employee.setRegister(registerDate);
                employee.setGender(gender.charAt(0));

                employee.addEmployee();
            }
            else
                JOptionPane.showMessageDialog(null, "Introduce un nombre válido");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee() {
        int row = existingEmployeesTable.getSelectedRow();

        if(row >= 0) {
            int id = (int)existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 0);

            Employee employee = new Employee();
            employee.setId(id);

            employee.deleteEmployee();
        }
        else
            JOptionPane.showMessageDialog(null, "Selecciona un empleado");
    }

    public void updateEmployee() {
        int row = existingEmployeesTable.getSelectedRow();

        if(row >= 0) {
            try {
                int id = Integer.parseInt(existingEmployeesTable.getValueAt(row, 0).toString());
                String name = txtEmployee.getText().trim();
                String lastNameF = txtLastNameF.getText().trim();
                String lastNameM = txtLastNameM.getText().trim();
                String heading = txtHeading.getText().trim();
                Position position = (Position) cmbPosition.getSelectedItem();
                String address = txtAddress.getText().trim();
                String birthday = txtBirthday.getValue().toString().trim();
                String register = txtRegisterDate.getValue().toString().trim();
                String gender = cmbGender.getSelectedItem().toString();

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date parsed = format.parse(birthday);
                Date birthdayDate = new Date(parsed.getTime());

                java.util.Date parsed2 = format.parse(register);
                Date registerDate = new Date(parsed2.getTime());

                if(!name.isEmpty() && !lastNameF.isEmpty() && !lastNameM.isEmpty()) {
                    Employee employee = new Employee();

                    employee.setId(id);
                    employee.setName(name);
                    employee.setLastNameF(lastNameF);
                    employee.setLastNameM(lastNameM);
                    employee.setTitle(heading);
                    employee.setPosition(position);
                    employee.setAddress(address);
                    employee.setBirthdate(birthdayDate);
                    employee.setRegister(registerDate);
                    employee.setGender(gender.charAt(0));

                    employee.updateEmployee();
                }
                else
                    JOptionPane.showMessageDialog(null, "Introduce un nombre válido");
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Selecciona un empleado");
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

    public void refreshExistingPositionsList() {
        cmbPosition.removeAllItems();

        for (Position position : new Position().getAllpositions())
            cmbPosition.addItem(position);
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
        Position position = (Position)existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 5);
        String address = existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 6).toString();
        String birthday = existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 7).toString();
        String register = existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 8).toString();
        String gender = existingEmployeesTable.getValueAt(existingEmployeesTable.getSelectedRow(), 9).toString();

        java.util.Date birthdayDate = Date.from(LocalDate.parse(birthday).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        java.util.Date registerDate = Date.from(LocalDate.parse(register).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        txtEmployee.setText(name);
        txtLastNameF.setText(lastNameF);
        txtLastNameM.setText(lastNameM);
        txtHeading.setText(title);
        cmbPosition.setSelectedIndex(position.getId() - 1);
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
                    break;
                case "btnModifyEmployee":
                    updateEmployee();
                    break;
                case "btnDeleteEmployee":
                    deleteEmployee();
                    break;
            }

            refreshExistingPositionsList();
            refreshExistingGenderList();
            refreshExistingEmployeeTable();

            txtEmployee.setText("");
            txtLastNameF.setText("");
            txtLastNameM.setText("");
            txtHeading.setText("");
            txtAddress.setText("");
            txtBirthday.setText("");
            txtRegisterDate.setText("");
            txtEmployee.requestFocusInWindow();
        }
    }
}