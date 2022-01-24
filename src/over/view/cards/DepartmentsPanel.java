package over.view.cards;

import over.controller.Controller;
import over.controller.DepartmentController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * <code>DepartmentsPanel</code> class.
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
public class DepartmentsPanel extends JPanel {
    private JButton btnAddDepartment;
    private JButton btnDeleteDepartment;
    private JButton btnModifyDepartment;
    private JPanel departmentPanel;
    private Box.Filler departmentsFiller1;
    private Box.Filler departmentsFiller2;
    private Box.Filler departmentsFiller3;
    private JList<String> existingDepartmentsList;
    private JPanel existingDepartmentsPanel;
    private JScrollPane existingDepartmentsScroll;
    private JLabel lblDepartment;
    private JTextField txtDepartment;
    private List<Component> componentList;
    private Controller controller;

    public DepartmentsPanel() {
        initComponents();
        initController();
    }

    @SuppressWarnings("unchecked")
    public void initComponents() {
        GridBagConstraints gridBagConstraints;

        departmentsFiller1 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));
        departmentPanel = new JPanel();
        lblDepartment = new JLabel();
        txtDepartment = new JTextField();
        btnAddDepartment = new JButton();
        departmentsFiller2 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));
        existingDepartmentsPanel = new JPanel();
        existingDepartmentsScroll = new JScrollPane();
        existingDepartmentsList = new JList<>();
        btnModifyDepartment = new JButton();
        btnDeleteDepartment = new JButton();
        departmentsFiller3 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));

        setBackground(new Color(255, 255, 255));
        setBorder(BorderFactory.createTitledBorder(null, "Departamentos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        setMinimumSize(new Dimension(800, 600));
        setName("departmentsPanel");
        setOpaque(false);
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        departmentsFiller1.setName("departmentsFiller1");
        add(departmentsFiller1);

        departmentPanel.setBorder(BorderFactory.createTitledBorder("Agregar departamento"));
        departmentPanel.setMinimumSize(new Dimension(750, 100));
        departmentPanel.setName("departmentPanel");
        departmentPanel.setOpaque(false);
        departmentPanel.setPreferredSize(new Dimension(750, 100));

        lblDepartment.setText("Nombre");
        lblDepartment.setName("lblDepartment");
        departmentPanel.add(lblDepartment);

        txtDepartment.setMinimumSize(new Dimension(200, 30));
        txtDepartment.setName("txtDepartment");
        txtDepartment.setPreferredSize(new Dimension(200, 30));
        txtDepartment.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                txtDepartmentKeyPressed(evt);
            }
        });
        departmentPanel.add(txtDepartment);

        btnAddDepartment.setText("Agregar");
        btnAddDepartment.setName("btnAddDepartment");
        btnAddDepartment.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnAddDepartmentMouseClicked(evt);
            }
        });
        btnAddDepartment.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnAddDepartmentKeyPressed(evt);
            }
        });
        departmentPanel.add(btnAddDepartment);

        add(departmentPanel);

        departmentsFiller2.setName("departmentsFiller2");
        add(departmentsFiller2);

        existingDepartmentsPanel.setBorder(BorderFactory.createTitledBorder("Departamentos existentes"));
        existingDepartmentsPanel.setMinimumSize(new Dimension(750, 300));
        existingDepartmentsPanel.setName("existingDepartmentsPanel");
        existingDepartmentsPanel.setOpaque(false);
        existingDepartmentsPanel.setPreferredSize(new Dimension(750, 300));
        existingDepartmentsPanel.setLayout(new GridBagLayout());

        existingDepartmentsScroll.setMinimumSize(new Dimension(300, 250));
        existingDepartmentsScroll.setMaximumSize(new Dimension(300, 250));
        existingDepartmentsScroll.setName("existingDepartmentsScroll");
        existingDepartmentsScroll.setPreferredSize(new Dimension(300, 250));

        existingDepartmentsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        existingDepartmentsList.setMaximumSize(new Dimension(300, 250));
        existingDepartmentsList.setMinimumSize(new Dimension(300, 250));
        existingDepartmentsList.setName("existingDepartmentsList");
        existingDepartmentsList.setPreferredSize(new Dimension(300, 250));
        existingDepartmentsList.setVisibleRowCount(10);
        existingDepartmentsList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                existingDepartmentsListMouseClicked(evt);
            }
        });
        existingDepartmentsScroll.setViewportView(existingDepartmentsList);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingDepartmentsPanel.add(existingDepartmentsScroll, gridBagConstraints);

        btnModifyDepartment.setText("Modificar");
        btnModifyDepartment.setName("btnModifyDepartment");
        btnModifyDepartment.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnModifyDepartmentMouseClicked(evt);
            }
        });
        btnModifyDepartment.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnModifyDepartmentKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingDepartmentsPanel.add(btnModifyDepartment, gridBagConstraints);

        btnDeleteDepartment.setText("Eliminar");
        btnDeleteDepartment.setName("btnDeleteDepartment");
        btnDeleteDepartment.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnDeleteDepartmentMouseClicked(evt);
            }
        });
        btnDeleteDepartment.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnDeleteDepartmentKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingDepartmentsPanel.add(btnDeleteDepartment, gridBagConstraints);

        add(existingDepartmentsPanel);

        departmentsFiller3.setName("departmentsFiller3");
        add(departmentsFiller3);
    }

    public void initController() {
        componentList = new ArrayList<>();
        componentList.add(txtDepartment);
        componentList.add(btnAddDepartment);
        componentList.add(btnModifyDepartment);
        componentList.add(btnDeleteDepartment);
        componentList.add(existingDepartmentsList);

        controller = new DepartmentController(componentList);
        ((DepartmentController)controller).refreshExistingDepartmentList();
    }

    private void txtDepartmentKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnAddDepartmentKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnModifyDepartmentKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnDeleteDepartmentKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void existingDepartmentsListMouseClicked(MouseEvent evt) {
        ((DepartmentController)controller).setDepartmentInformation();
    }

    private void btnAddDepartmentMouseClicked(MouseEvent evt) {
        ((DepartmentController)controller).addDepartment();
        ((DepartmentController)controller).refreshExistingDepartmentList();

        txtDepartment.setText("");
        txtDepartment.requestFocusInWindow();
    }

    private void btnModifyDepartmentMouseClicked(MouseEvent evt) {
        ((DepartmentController)controller).updateDepartment();
        ((DepartmentController)controller).refreshExistingDepartmentList();
    }

    private void btnDeleteDepartmentMouseClicked(MouseEvent evt) {
        ((DepartmentController)controller).deleteDepartment();
        ((DepartmentController)controller).refreshExistingDepartmentList();
    }
}