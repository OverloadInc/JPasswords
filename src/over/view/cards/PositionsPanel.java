package over.view.cards;

import over.controller.Controller;
import over.controller.PositionsController;

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
 * <code>PositionsPanel</code> class.
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
public class PositionsPanel extends JPanel {
    private JButton btnAddPosition;
    private JButton btnDeletePosition;
    private JButton btnModifyPosition;
    private JPanel existingPositionsPanel;
    private JScrollPane existingPositionsScroll;
    private JTable existingPositionsTable;
    private JLabel lblDepartmentName;
    private JLabel lblPositionName;
    private JLabel lblHierarchyName;
    private JComboBox<String> cmbDepartments;
    private JComboBox<String> cmbHierarchies;
    private Box.Filler positionsFiller1;
    private Box.Filler positionsFiller2;
    private Box.Filler positionsFiller3;
    private JTextField txtPositionName;
    private JPanel positionPanel;
    private List<Component> componentList;
    private Controller controller;

    public PositionsPanel() {
        initComponents();
        initController();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        positionsFiller1 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 50));
        positionPanel = new JPanel();
        lblPositionName = new JLabel();
        txtPositionName = new JTextField();
        lblDepartmentName = new JLabel();
        cmbDepartments = new JComboBox<>();
        lblHierarchyName = new JLabel();
        cmbHierarchies = new JComboBox<>();
        btnAddPosition = new JButton();
        positionsFiller2 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 50));
        existingPositionsPanel = new JPanel();
        existingPositionsScroll = new JScrollPane();
        existingPositionsTable = new JTable();
        btnModifyPosition = new JButton();
        btnDeletePosition = new JButton();
        positionsFiller3 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 50));

        setBackground(new Color(255, 255, 255));
        setBorder(BorderFactory.createTitledBorder(null, "Puestos de trabajo", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        setMinimumSize(new Dimension(800, 600));
        setName("positionsPanel");
        setOpaque(false);
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        positionsFiller1.setName("positionsFiller1");
        add(positionsFiller1);

        positionPanel.setBorder(BorderFactory.createTitledBorder("Agregar puesto de trabajo"));
        positionPanel.setMinimumSize(new Dimension(750, 100));
        positionPanel.setName("positionPanel");
        positionPanel.setOpaque(false);
        positionPanel.setPreferredSize(new Dimension(750, 100));
        positionPanel.setLayout(new GridBagLayout());

        lblPositionName.setText("Nombre");
        lblPositionName.setName("lblPositionName");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        positionPanel.add(lblPositionName, gridBagConstraints);

        txtPositionName.setMaximumSize(new Dimension(200, 30));
        txtPositionName.setMinimumSize(new Dimension(200, 30));
        txtPositionName.setName("txtPositionName");
        txtPositionName.setPreferredSize(new Dimension(200, 30));
        txtPositionName.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                txtPositionNameKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        positionPanel.add(txtPositionName, gridBagConstraints);

        lblDepartmentName.setText("Departamento");
        lblDepartmentName.setName("lblDepartmentName");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        positionPanel.add(lblDepartmentName, gridBagConstraints);

        cmbDepartments.setMaximumRowCount(10);
        cmbDepartments.setMaximumSize(new Dimension(200, 30));
        cmbDepartments.setMinimumSize(new Dimension(200, 30));
        cmbDepartments.setName("cmbDepartments");
        cmbDepartments.setPreferredSize(new Dimension(200, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        positionPanel.add(cmbDepartments, gridBagConstraints);

        lblHierarchyName.setText("Jerarquía");
        lblHierarchyName.setName("lblHierarchyName");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        positionPanel.add(lblHierarchyName, gridBagConstraints);

        cmbHierarchies.setMaximumRowCount(10);
        cmbHierarchies.setMaximumSize(new Dimension(200, 30));
        cmbHierarchies.setMinimumSize(new Dimension(200, 30));
        cmbHierarchies.setName("cmbHierarchies");
        cmbHierarchies.setPreferredSize(new Dimension(200, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        positionPanel.add(cmbHierarchies, gridBagConstraints);

        btnAddPosition.setText("Agregar");
        btnAddPosition.setName("btnAddPosition");
        btnAddPosition.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnAddPositionMouseClicked(evt);
            }
        });
        btnAddPosition.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnAddPositionKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        positionPanel.add(btnAddPosition, gridBagConstraints);

        add(positionPanel);

        positionsFiller2.setName("positionsFiller2");
        add(positionsFiller2);

        existingPositionsPanel.setBorder(BorderFactory.createTitledBorder("Puestos de trabajo existentes"));
        existingPositionsPanel.setMinimumSize(new Dimension(750, 350));
        existingPositionsPanel.setName("existingPositionsPanel");
        existingPositionsPanel.setOpaque(false);
        existingPositionsPanel.setPreferredSize(new Dimension(750, 350));
        existingPositionsPanel.setLayout(new GridBagLayout());

        existingPositionsScroll.setMinimumSize(new Dimension(600, 300));
        existingPositionsScroll.setMaximumSize(new Dimension(600, 300));
        existingPositionsScroll.setName("existingPositionsScroll");

        existingPositionsTable.setMaximumSize(new Dimension(600, 300));
        existingPositionsTable.setMinimumSize(new Dimension(600, 300));
        existingPositionsTable.setFillsViewportHeight(true);
        existingPositionsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        existingPositionsTable.setName("existingPositionsTable");
        existingPositionsTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                existingPositionsTableMouseClicked(evt);
            }
        });
        existingPositionsScroll.setViewportView(existingPositionsTable);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingPositionsPanel.add(existingPositionsScroll, gridBagConstraints);

        btnModifyPosition.setText("Modificar");
        btnModifyPosition.setName("btnModifyPosition");
        btnModifyPosition.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnModifyPositionMouseClicked(evt);
            }
        });
        btnModifyPosition.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnModifyPositionKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingPositionsPanel.add(btnModifyPosition, gridBagConstraints);

        btnDeletePosition.setText("Elimina");
        btnDeletePosition.setActionCommand("Eliminar");
        btnDeletePosition.setName("btnDeletePosition");
        btnDeletePosition.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnDeletePositionMouseClicked(evt);
            }
        });
        btnDeletePosition.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnDeletePositionKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingPositionsPanel.add(btnDeletePosition, gridBagConstraints);

        add(existingPositionsPanel);

        positionsFiller3.setName("positionsFiller3");
        add(positionsFiller3);
    }

    public void initController() {
        componentList = new ArrayList<>();
        componentList.add(txtPositionName);
        componentList.add(cmbDepartments);
        componentList.add(cmbHierarchies);
        componentList.add(btnAddPosition);
        componentList.add(existingPositionsTable);

        controller = new PositionsController(componentList);
        ((PositionsController)controller).refreshExistingDepartmentList();
        ((PositionsController)controller).refreshExistingHierarchyList();
        ((PositionsController)controller).refreshExistingPositionsTable();
    }

    private void deleteContent() {
        txtPositionName.setText("");
        txtPositionName.requestFocusInWindow();
    }

    private void txtPositionNameKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void cmbDepartmentsKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void cmbHierarchiesKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnAddPositionKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnModifyPositionKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnDeletePositionKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnAddPositionMouseClicked(MouseEvent evt) {
        ((PositionsController)controller).addPosition();
        ((PositionsController)controller).refreshExistingDepartmentList();
        ((PositionsController)controller).refreshExistingHierarchyList();
        ((PositionsController)controller).refreshExistingPositionsTable();
        deleteContent();
    }

    private void btnModifyPositionMouseClicked(MouseEvent evt) {
        ((PositionsController)controller).updatePosition();
        ((PositionsController)controller).refreshExistingDepartmentList();
        ((PositionsController)controller).refreshExistingHierarchyList();
        ((PositionsController)controller).refreshExistingPositionsTable();
        deleteContent();
    }

    private void btnDeletePositionMouseClicked(MouseEvent evt) {
        ((PositionsController)controller).deletePosition();
        ((PositionsController)controller).refreshExistingDepartmentList();
        ((PositionsController)controller).refreshExistingHierarchyList();
        ((PositionsController)controller).refreshExistingPositionsTable();
        deleteContent();
    }

    private void existingPositionsTableMouseClicked(MouseEvent evt) {
        ((PositionsController)controller).setPositionInformation();
    }
}