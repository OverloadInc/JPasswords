package over.view.cards;

import over.controller.Controller;
import over.controller.HierarchyController;

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
 * <code>HierarchiesPanel</code> class.
 * @author Overload Inc.
 * @version %I%, %G%
 */
public class HierarchiesPanel extends JPanel {
    private JButton btnDeleteHierarchy;
    private JButton btnHierarchy;
    private JButton btnModifyHierarchy;
    private JPanel existingHierarchiesPanel;
    private JScrollPane existingHierarchiesScroll;
    private JTable existingHierarchiesTable;
    private Box.Filler hierarchiesFiller1;
    private Box.Filler hierarchiesFiller2;
    private Box.Filler hierarchiesFiller3;
    private JPanel hierarchyPanel;
    private JLabel lblHierarchy;
    private JTextField txtHierarchy;
    private List<Component> componentList;
    private Controller controller;

    public HierarchiesPanel() {
        initComponents();
        initController();
    }

    @SuppressWarnings("unchecked")
    public void initComponents() {
        GridBagConstraints gridBagConstraints;

        hierarchiesFiller1 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));
        hierarchyPanel = new JPanel();
        lblHierarchy = new JLabel();
        txtHierarchy = new JTextField();
        btnHierarchy = new JButton();
        hierarchiesFiller2 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));
        existingHierarchiesPanel = new JPanel();
        existingHierarchiesScroll = new JScrollPane();
        existingHierarchiesTable = new JTable();
        btnModifyHierarchy = new JButton();
        btnDeleteHierarchy = new JButton();
        hierarchiesFiller3 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));

        setBackground(new Color(255, 255, 255));
        setBorder(BorderFactory.createTitledBorder(null, "Jerarquías", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        setMinimumSize(new Dimension(800, 600));
        setName("hierarchiesPanel");
        setOpaque(false);
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        hierarchiesFiller1.setName("hierarchiesFiller1");
        add(hierarchiesFiller1);

        hierarchyPanel.setBorder(BorderFactory.createTitledBorder(null, "Agregar jerarquía", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
        hierarchyPanel.setMinimumSize(new Dimension(750, 100));
        hierarchyPanel.setName("hierarchyPanel");
        hierarchyPanel.setOpaque(false);
        hierarchyPanel.setPreferredSize(new Dimension(750, 100));

        lblHierarchy.setHorizontalAlignment(SwingConstants.CENTER);
        lblHierarchy.setText("Nombre");
        lblHierarchy.setName("lblHierarchy");
        hierarchyPanel.add(lblHierarchy);

        txtHierarchy.setName("txtHierarchy");
        txtHierarchy.setPreferredSize(new Dimension(300, 30));
        txtHierarchy.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                txtHierarchyKeyPressed(evt);
            }
        });
        hierarchyPanel.add(txtHierarchy);

        btnHierarchy.setText("Agregar");
        btnHierarchy.setName("btnHierarchy");
        btnHierarchy.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnHierarchyMouseClicked(evt);
            }
        });
        btnHierarchy.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnHierarchyKeyPressed(evt);
            }
        });
        hierarchyPanel.add(btnHierarchy);

        add(hierarchyPanel);

        hierarchiesFiller2.setName("hierarchiesFiller2");
        add(hierarchiesFiller2);

        existingHierarchiesPanel.setBorder(BorderFactory.createTitledBorder(null, "Jerarquías existentes", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
        existingHierarchiesPanel.setMinimumSize(new Dimension(750, 300));
        existingHierarchiesPanel.setName("existingHierarchiesPanel");
        existingHierarchiesPanel.setOpaque(false);
        existingHierarchiesPanel.setPreferredSize(new Dimension(750, 300));
        existingHierarchiesPanel.setLayout(new GridBagLayout());

        existingHierarchiesScroll.setMinimumSize(new Dimension(300, 200));
        existingHierarchiesScroll.setMaximumSize(new Dimension(300, 200));
        existingHierarchiesScroll.setName("existingHierarchiesScroll");
        existingHierarchiesScroll.setPreferredSize(new Dimension(300, 200));

        existingHierarchiesTable.setFillsViewportHeight(true);
        existingHierarchiesTable.setMinimumSize(new Dimension(300, 200));
        existingHierarchiesTable.setName("existingHierarchiesTable");
        existingHierarchiesTable.setPreferredSize(new Dimension(300, 200));
        existingHierarchiesTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                existingHierarchiesTableMouseClicked(evt);
            }
        });
        existingHierarchiesScroll.setViewportView(existingHierarchiesTable);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingHierarchiesPanel.add(existingHierarchiesScroll, gridBagConstraints);

        btnModifyHierarchy.setText("Modificar");
        btnModifyHierarchy.setName("btnModifyHierarchy");
        btnModifyHierarchy.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnModifyHierarchyMouseClicked(evt);
            }
        });
        btnModifyHierarchy.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnModifyHierarchyKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingHierarchiesPanel.add(btnModifyHierarchy, gridBagConstraints);

        btnDeleteHierarchy.setText("Eliminar");
        btnDeleteHierarchy.setName("btnDeleteHierarchy");
        btnDeleteHierarchy.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnDeleteHierarchyMouseClicked(evt);
            }
        });
        btnDeleteHierarchy.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnDeleteHierarchyKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingHierarchiesPanel.add(btnDeleteHierarchy, gridBagConstraints);

        add(existingHierarchiesPanel);

        hierarchiesFiller3.setName("hierarchiesFiller3");
        add(hierarchiesFiller3);
    }

    public void initController() {
        componentList = new ArrayList<>();
        componentList.add(txtHierarchy);
        componentList.add(btnHierarchy);
        componentList.add(btnModifyHierarchy);
        componentList.add(btnDeleteHierarchy);
        componentList.add(existingHierarchiesTable);

        controller = new HierarchyController(componentList);
        ((HierarchyController)controller).refreshExistingHierarchiesTable();
    }

    private void txtHierarchyKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnHierarchyKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnModifyHierarchyKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnDeleteHierarchyKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void existingHierarchiesTableMouseClicked(MouseEvent evt) {
        ((HierarchyController) controller).setHierarchyInformation();
    }

    private void deleteContent() {
        txtHierarchy.setText("");
        txtHierarchy.requestFocusInWindow();
    }

    private void btnHierarchyMouseClicked(MouseEvent evt) {
        ((HierarchyController)controller).addHierarchy();
        ((HierarchyController)controller).refreshExistingHierarchiesTable();
        deleteContent();
    }

    private void btnModifyHierarchyMouseClicked(MouseEvent evt) {
        ((HierarchyController)controller).updateHierarchy();
        ((HierarchyController)controller).refreshExistingHierarchiesTable();
        deleteContent();
    }

    private void btnDeleteHierarchyMouseClicked(MouseEvent evt) {
        ((HierarchyController)controller).deleteHierarchy();
        ((HierarchyController)controller).refreshExistingHierarchiesTable();
        deleteContent();
    }
}