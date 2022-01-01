package over.view.cards;

import over.controller.Controller;
import over.controller.PrivilegeController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PrivilegesPanel extends JPanel {
    private JCheckBox accessesCheck;
    private JButton btnAddPrivilege;
    private JButton btnDeletePrivilege;
    private JButton btnModifyPrivilege;
    private JCheckBox credentialsCheck;
    private JCheckBox departmentsCheck;
    private JCheckBox employeesCheck;
    private JList<String> existingPrivilegesList;
    private JPanel existingPrivilegesPanel;
    private JScrollPane existingPrivilegesScroll;
    private JCheckBox hierarchiesCheck;
    private JCheckBox kindProductsCheck;
    private JLabel lblPrivilege;
    private JPanel privilegePanel;
    private JCheckBox privilegesCheck;
    private Box.Filler privilegesFiller1;
    private Box.Filler privilegesFiller2;
    private Box.Filler privilegesFiller3;
    private JCheckBox productsCheck;
    private JTextField txtPrivilege;
    private List<Component> componentList;
    private Controller controller;

    public PrivilegesPanel() {
        initComponents();
        initController();
    }

    @SuppressWarnings("unchecked")
    public void initComponents() {
        GridBagConstraints gridBagConstraints;

        privilegesFiller1 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));
        privilegePanel = new JPanel();
        lblPrivilege = new JLabel();
        txtPrivilege = new JTextField();
        btnAddPrivilege = new JButton();
        privilegesFiller2 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));
        existingPrivilegesPanel = new JPanel();
        existingPrivilegesScroll = new JScrollPane();
        existingPrivilegesList = new JList<>();
        btnModifyPrivilege = new JButton();
        btnDeletePrivilege = new JButton();
        kindProductsCheck = new JCheckBox();
        departmentsCheck = new JCheckBox();
        productsCheck = new JCheckBox();
        employeesCheck = new JCheckBox();
        hierarchiesCheck = new JCheckBox();
        privilegesCheck = new JCheckBox();
        credentialsCheck = new JCheckBox();
        accessesCheck = new JCheckBox();
        privilegesFiller3 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));

        setBackground(new Color(255, 255, 255));
        setBorder(BorderFactory.createTitledBorder(null, "Privilegios", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        setMinimumSize(new Dimension(800, 600));
        setName("privilegesPanel");
        setOpaque(false);
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        privilegesFiller1.setName("privilegesFiller1");
        add(privilegesFiller1);

        privilegePanel.setBorder(BorderFactory.createTitledBorder(null, "Agregar privilegio", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
        privilegePanel.setMinimumSize(new Dimension(750, 100));
        privilegePanel.setName("privilegePanel");
        privilegePanel.setOpaque(false);
        privilegePanel.setPreferredSize(new Dimension(750, 100));

        lblPrivilege.setText("Nombre");
        lblPrivilege.setName("lblPrivilege");
        privilegePanel.add(lblPrivilege);

        txtPrivilege.setMinimumSize(new Dimension(300, 30));
        txtPrivilege.setName("txtPrivilege");
        txtPrivilege.setPreferredSize(new Dimension(300, 30));
        txtPrivilege.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                txtPrivilegeKeyPressed(evt);
            }
        });
        privilegePanel.add(txtPrivilege);

        btnAddPrivilege.setText("Agregar");
        btnAddPrivilege.setName("btnAddPrivilege");
        btnAddPrivilege.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnAddPrivilegeMouseClicked(evt);
            }
        });
        btnAddPrivilege.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnAddPrivilegeKeyPressed(evt);
            }
        });
        privilegePanel.add(btnAddPrivilege);

        add(privilegePanel);

        privilegesFiller2.setName("privilegesFiller2");
        add(privilegesFiller2);

        existingPrivilegesPanel.setBorder(BorderFactory.createTitledBorder(null, "Privilegios existentes", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
        existingPrivilegesPanel.setMinimumSize(new Dimension(750, 300));
        existingPrivilegesPanel.setName("existingPrivilegesPanel");
        existingPrivilegesPanel.setOpaque(false);
        existingPrivilegesPanel.setPreferredSize(new Dimension(750, 300));
        existingPrivilegesPanel.setLayout(new GridBagLayout());

        existingPrivilegesScroll.setMinimumSize(new Dimension(300, 200));
        existingPrivilegesScroll.setMaximumSize(new Dimension(300, 200));
        existingPrivilegesScroll.setName("existingPrivilegesScroll");
        existingPrivilegesScroll.setPreferredSize(new Dimension(300, 200));

        existingPrivilegesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        existingPrivilegesList.setName("existingPrivilegesList");
        existingPrivilegesList.setMinimumSize(new Dimension(300, 200));
        existingPrivilegesList.setPreferredSize(new Dimension(300, 200));
        existingPrivilegesScroll.setViewportView(existingPrivilegesList);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        existingPrivilegesPanel.add(existingPrivilegesScroll, gridBagConstraints);

        btnModifyPrivilege.setText("Modificar");
        btnModifyPrivilege.setName("btnModifyPrivilege");
        btnModifyPrivilege.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnModifyPrivilegeMouseClicked(evt);
            }
        });
        btnModifyPrivilege.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnModifyPrivilegeKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingPrivilegesPanel.add(btnModifyPrivilege, gridBagConstraints);

        btnDeletePrivilege.setText("Eliminar");
        btnDeletePrivilege.setName("btnDeletePrivilege");
        btnDeletePrivilege.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnDeletePrivilegeMouseClicked(evt);
            }
        });
        btnDeletePrivilege.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnDeletePrivilegeKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingPrivilegesPanel.add(btnDeletePrivilege, gridBagConstraints);

        kindProductsCheck.setText("Tipos de productos");
        kindProductsCheck.setName("kindProductsCheck");
        kindProductsCheck.setOpaque(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingPrivilegesPanel.add(kindProductsCheck, gridBagConstraints);

        departmentsCheck.setText("Departamentos");
        departmentsCheck.setName("departmentsCheck");
        departmentsCheck.setOpaque(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingPrivilegesPanel.add(departmentsCheck, gridBagConstraints);

        productsCheck.setText("Productos");
        productsCheck.setName("productsCheck");
        productsCheck.setOpaque(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingPrivilegesPanel.add(productsCheck, gridBagConstraints);

        employeesCheck.setText("Empleados");
        employeesCheck.setName("employeesCheck");
        employeesCheck.setOpaque(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingPrivilegesPanel.add(employeesCheck, gridBagConstraints);

        hierarchiesCheck.setText("Jerarquías");
        hierarchiesCheck.setName("hierarchiesCheck");
        hierarchiesCheck.setOpaque(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingPrivilegesPanel.add(hierarchiesCheck, gridBagConstraints);

        privilegesCheck.setText("Privilegios");
        privilegesCheck.setName("privilegesCheck");
        privilegesCheck.setOpaque(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingPrivilegesPanel.add(privilegesCheck, gridBagConstraints);

        credentialsCheck.setText("Credenciales");
        credentialsCheck.setName("credentialsCheck");
        credentialsCheck.setOpaque(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingPrivilegesPanel.add(credentialsCheck, gridBagConstraints);

        accessesCheck.setText("Accesos");
        accessesCheck.setName("accessesCheck");
        accessesCheck.setOpaque(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingPrivilegesPanel.add(accessesCheck, gridBagConstraints);

        add(existingPrivilegesPanel);

        privilegesFiller3.setName("privilegesFiller3");
        add(privilegesFiller3);
    }

    public void initController() {
        componentList = new ArrayList<>();
        componentList.add(txtPrivilege);
        componentList.add(btnAddPrivilege);
        componentList.add(btnModifyPrivilege);
        componentList.add(btnDeletePrivilege);
        componentList.add(existingPrivilegesList);

        controller = new PrivilegeController(componentList);
        ((PrivilegeController)controller).refreshExistingPrivilegeList();
    }

    private void deleteContent() {
        txtPrivilege.setText("");
        txtPrivilege.requestFocusInWindow();
    }

    private void txtPrivilegeKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnAddPrivilegeKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnModifyPrivilegeKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnDeletePrivilegeKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnAddPrivilegeMouseClicked(MouseEvent evt) {
        ((PrivilegeController)controller).addPrivilege();
        ((PrivilegeController)controller).refreshExistingPrivilegeList();
        deleteContent();
    }

    private void btnModifyPrivilegeMouseClicked(MouseEvent evt) {
        ((PrivilegeController)controller).updatePrivilege();
        ((PrivilegeController)controller).refreshExistingPrivilegeList();
        deleteContent();
    }

    private void btnDeletePrivilegeMouseClicked(MouseEvent evt) {
        ((PrivilegeController)controller).deletePrivilege();
        ((PrivilegeController)controller).refreshExistingPrivilegeList();
        deleteContent();
    }
}