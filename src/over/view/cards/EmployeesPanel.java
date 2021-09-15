package over.view.cards;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeesPanel extends JPanel {
    private JButton btnAddEmployee;
    private JButton btnDeleteEmployee;
    private JButton btnModifyEmployee;
    private JComboBox<String> cmbGender;
    private Box.Filler employeeFiller1;
    private Box.Filler employeeFiller2;
    private Box.Filler employeeFiller3;
    private JPanel employeePanel;
    private JPanel existingEmployeesPanel;
    private JScrollPane existingEmployeesScroll;
    private JTable existingEmployeesTable;
    private JLabel lblEmployee;
    private JLabel lblGender;
    private JLabel lblHeading;
    private JLabel lblLastNameF;
    private JLabel lblLastNameM;
    private JLabel lblPosition;
    private JLabel lblBirthday;
    private JLabel lblRegisterDate;
    private JLabel lblAddress;
    private JTextField txtAddress;
    private JFormattedTextField txtBirthday;
    private JTextField txtEmployee;
    private JTextField txtHeading;
    private JTextField txtLastNameF;
    private JTextField txtLastNameM;
    private JTextField txtPosition;
    private JFormattedTextField txtRegisterDate;

    public EmployeesPanel() {
        initComponents();
        initController();
    }

    @SuppressWarnings("unchecked")
    public void initComponents() {
        GridBagConstraints gridBagConstraints;

        employeeFiller1 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));
        employeePanel = new JPanel();
        lblEmployee = new JLabel();
        txtEmployee = new JTextField();
        lblLastNameF = new JLabel();
        txtLastNameF = new JTextField();
        lblLastNameM = new JLabel();
        txtLastNameM = new JTextField();
        lblHeading = new JLabel();
        txtHeading = new JTextField();
        lblPosition = new JLabel();
        txtPosition = new JTextField();
        lblAddress = new JLabel();
        txtAddress = new JTextField();
        lblBirthday = new JLabel();
        txtBirthday = new JFormattedTextField();
        lblRegisterDate = new JLabel();
        txtRegisterDate = new JFormattedTextField();
        lblGender = new JLabel();
        cmbGender = new JComboBox<>();
        btnAddEmployee = new JButton();
        employeeFiller2 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));
        existingEmployeesPanel = new JPanel();
        existingEmployeesScroll = new JScrollPane();
        existingEmployeesTable = new JTable();
        btnModifyEmployee = new JButton();
        btnDeleteEmployee = new JButton();
        employeeFiller3 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));

        setBackground(new Color(255, 255, 255));
        setBorder(BorderFactory.createTitledBorder(null, "Empleados", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        setMinimumSize(new Dimension(800, 600));
        setName("employeesPanel");
        setOpaque(false);
        setPreferredSize(new Dimension(800, 600));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        employeeFiller1.setName("employeeFiller1");
        add(employeeFiller1);

        employeePanel.setBorder(BorderFactory.createTitledBorder("Agregar empleado"));
        employeePanel.setMinimumSize(new Dimension(750, 200));
        employeePanel.setName("employeePanel");
        employeePanel.setOpaque(false);
        employeePanel.setPreferredSize(new Dimension(750, 200));
        employeePanel.setLayout(new GridBagLayout());

        lblEmployee.setText("Nombre");
        lblEmployee.setName("lblEmployee");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(lblEmployee, gridBagConstraints);

        txtEmployee.setMaximumSize(new Dimension(150, 30));
        txtEmployee.setMinimumSize(new Dimension(150, 30));
        txtEmployee.setName("txtEmployee");
        txtEmployee.setPreferredSize(new Dimension(150, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(txtEmployee, gridBagConstraints);

        lblLastNameF.setText("Apellido paterno");
        lblLastNameF.setName("lblLastNameF");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(lblLastNameF, gridBagConstraints);

        txtLastNameF.setMaximumSize(new Dimension(150, 30));
        txtLastNameF.setMinimumSize(new Dimension(150, 30));
        txtLastNameF.setName("txtLastNameF");
        txtLastNameF.setPreferredSize(new Dimension(150, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(txtLastNameF, gridBagConstraints);

        lblLastNameM.setText("Apellido materno");
        lblLastNameM.setName("lblLastNameM");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(lblLastNameM, gridBagConstraints);

        txtLastNameM.setMaximumSize(new Dimension(150, 30));
        txtLastNameM.setMinimumSize(new Dimension(150, 30));
        txtLastNameM.setName("txtLastNameM");
        txtLastNameM.setPreferredSize(new Dimension(150, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(txtLastNameM, gridBagConstraints);

        lblHeading.setText("Título");
        lblHeading.setName("lblHeading");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(lblHeading, gridBagConstraints);

        txtHeading.setMaximumSize(new Dimension(150, 30));
        txtHeading.setMinimumSize(new Dimension(150, 30));
        txtHeading.setName("txtHeading");
        txtHeading.setPreferredSize(new Dimension(150, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(txtHeading, gridBagConstraints);

        lblPosition.setText("Puesto");
        lblPosition.setName("lblPosition");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(lblPosition, gridBagConstraints);

        txtPosition.setMaximumSize(new Dimension(150, 30));
        txtPosition.setMinimumSize(new Dimension(150, 30));
        txtPosition.setName("txtPosition");
        txtPosition.setPreferredSize(new Dimension(150, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(txtPosition, gridBagConstraints);

        lblAddress.setText("Dirección");
        lblAddress.setName("lblAddress");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(lblAddress, gridBagConstraints);

        txtAddress.setMaximumSize(new Dimension(150, 30));
        txtAddress.setMinimumSize(new Dimension(150, 30));
        txtAddress.setName("txtAddress");
        txtAddress.setPreferredSize(new Dimension(150, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(txtAddress, gridBagConstraints);

        lblBirthday.setText("Fecha de nacimiento");
        lblBirthday.setName("lblBirthday");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(lblBirthday, gridBagConstraints);

        txtBirthday.setMaximumSize(new Dimension(150, 30));
        txtBirthday.setMinimumSize(new Dimension(150, 30));
        txtBirthday.setName("txtBirthday");
        txtBirthday.setPreferredSize(new Dimension(150, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(txtBirthday, gridBagConstraints);

        lblRegisterDate.setText("Fecha de registro");
        lblRegisterDate.setName("lblRegisterDate");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(lblRegisterDate, gridBagConstraints);

        txtRegisterDate.setMaximumSize(new Dimension(150, 30));
        txtRegisterDate.setMinimumSize(new Dimension(150, 30));
        txtRegisterDate.setName("txtRegisterDate");
        txtRegisterDate.setPreferredSize(new Dimension(150, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(txtRegisterDate, gridBagConstraints);

        lblGender.setText("Sexo");
        lblGender.setName("lblGender");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(lblGender, gridBagConstraints);

        cmbGender.setMaximumSize(new Dimension(50, 30));
        cmbGender.setMinimumSize(new Dimension(50, 30));
        cmbGender.setName("cmbGender");
        cmbGender.setPreferredSize(new Dimension(50, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(cmbGender, gridBagConstraints);

        btnAddEmployee.setText("Agregar");
        btnAddEmployee.setName("btnAddEmployee");
        btnAddEmployee.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnAddEmployeeMouseClicked(evt);
            }
        });
        btnAddEmployee.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnAddEmployeeKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        employeePanel.add(btnAddEmployee, gridBagConstraints);

        add(employeePanel);

        employeeFiller2.setName("employeeFiller2");
        add(employeeFiller2);

        existingEmployeesPanel.setBorder(BorderFactory.createTitledBorder("Empleados existentes"));
        existingEmployeesPanel.setMinimumSize(new Dimension(750, 250));
        existingEmployeesPanel.setName("existingEmployeesPanel");
        existingEmployeesPanel.setOpaque(false);
        existingEmployeesPanel.setPreferredSize(new Dimension(750, 250));
        existingEmployeesPanel.setLayout(new GridBagLayout());

        existingEmployeesScroll.setMinimumSize(new Dimension(500, 200));
        existingEmployeesScroll.setMaximumSize(new Dimension(500, 200));
        existingEmployeesScroll.setName("existingEmployeesScroll");
        existingEmployeesScroll.setPreferredSize(new Dimension(500, 200));

        existingEmployeesTable.setModel(new DefaultTableModel(new Object[][]{}, new String [] {"Id", "Nombre", "Título", "Puesto", "Dirección", "Fecha de nacimiento", "Fecha de registro", "Sexo"}) {
            Class[] types = new Class[] {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = new boolean[] {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        existingEmployeesTable.setFillsViewportHeight(true);
        existingEmployeesTable.setMaximumSize(new Dimension(500, 200));
        existingEmployeesTable.setMinimumSize(new Dimension(500, 200));
        existingEmployeesTable.setName("existingEmployeesTable");
        existingEmployeesTable.setPreferredSize(new Dimension(500, 200));
        existingEmployeesScroll.setViewportView(existingEmployeesTable);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingEmployeesPanel.add(existingEmployeesScroll, gridBagConstraints);

        btnModifyEmployee.setText("Modificar");
        btnModifyEmployee.setName("btnModifyEmployee");
        btnModifyEmployee.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnModifyEmployeeMouseClicked(evt);
            }
        });
        btnModifyEmployee.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnModifyEmployeeKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingEmployeesPanel.add(btnModifyEmployee, gridBagConstraints);

        btnDeleteEmployee.setText("Eliminar");
        btnDeleteEmployee.setName("btnDeleteEmployee");
        btnDeleteEmployee.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnDeleteEmployeeMouseClicked(evt);
            }
        });
        btnDeleteEmployee.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnDeleteEmployeeKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingEmployeesPanel.add(btnDeleteEmployee, gridBagConstraints);

        add(existingEmployeesPanel);

        employeeFiller3.setName("employeeFiller3");
        add(employeeFiller3);
    }

    public void initController() {

    }

    private void btnAddEmployeeKeyPressed(KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void btnModifyEmployeeKeyPressed(KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void btnDeleteEmployeeKeyPressed(KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void btnAddEmployeeMouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void btnModifyEmployeeMouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void btnDeleteEmployeeMouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
    }
}