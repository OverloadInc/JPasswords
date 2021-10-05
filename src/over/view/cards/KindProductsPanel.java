package over.view.cards;

import over.controller.Controller;
import over.controller.ProductKindController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class KindProductsPanel extends JPanel {
    private Box.Filler productsFiller1;
    private Box.Filler productsFiller2;
    private Box.Filler productsFiller3;
    private JPanel kindProductPanel;
    private JLabel lblKindProduct;
    private JTextField txtKindProduct;
    private JButton btnAddKindProduct;
    private JPanel existingKindProductsPanel;
    private JScrollPane existingKindProductsScroll;
    private JList<String> existingKindProductsList;
    private JButton btnModifyKindProduct;
    private JButton btnDeleteKindProduct;
    private List<Component> componentList;
    private Controller controller;

    public KindProductsPanel() {
        initComponents();
        initController();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        setBackground(new Color(255, 255, 255));
        setBorder(BorderFactory.createTitledBorder(null, "Tipos de productos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        setMinimumSize(new Dimension(800, 600));
        setName("kindProductsPanel");
        setOpaque(false);
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        productsFiller1 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));
        kindProductPanel = new JPanel();
        lblKindProduct = new JLabel();
        txtKindProduct = new JTextField();
        btnAddKindProduct = new JButton();
        productsFiller2 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));
        existingKindProductsPanel = new JPanel();
        existingKindProductsScroll = new JScrollPane();
        existingKindProductsList = new JList<>();
        btnModifyKindProduct = new JButton();
        btnDeleteKindProduct = new JButton();
        productsFiller3 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));
        productsFiller1.setName("productsFiller1");
        add(productsFiller1);

        kindProductPanel.setBorder(BorderFactory.createTitledBorder("Agregar tipo de producto"));
        kindProductPanel.setMinimumSize(new Dimension(750, 100));
        kindProductPanel.setName("kindProductPanel");
        kindProductPanel.setOpaque(false);
        kindProductPanel.setPreferredSize(new Dimension(750, 100));

        lblKindProduct.setText("Nombre");
        lblKindProduct.setName("lblKindProduct");
        kindProductPanel.add(lblKindProduct);

        txtKindProduct.setMinimumSize(new Dimension(200, 30));
        txtKindProduct.setName("txtKindProduct");
        txtKindProduct.setPreferredSize(new Dimension(200, 30));
        txtKindProduct.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                txtKindProductKeyPressed(evt);
            }
        });
        kindProductPanel.add(txtKindProduct);

        btnAddKindProduct.setText("Agregar");
        btnAddKindProduct.setName("btnAddKindProduct");
        btnAddKindProduct.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnAddKindProductMouseClicked(evt);
            }
        });
        btnAddKindProduct.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnAddKindProductKeyPressed(evt);
            }
        });
        kindProductPanel.add(btnAddKindProduct);

        add(kindProductPanel);

        productsFiller2.setName("productsFiller2");
        add(productsFiller2);

        existingKindProductsPanel.setBorder(BorderFactory.createTitledBorder("Tipos de productos existentes"));
        existingKindProductsPanel.setMinimumSize(new Dimension(750, 300));
        existingKindProductsPanel.setName("existingKindProductsPanel");
        existingKindProductsPanel.setOpaque(false);
        existingKindProductsPanel.setPreferredSize(new Dimension(750, 300));
        existingKindProductsPanel.setLayout(new GridBagLayout());

        existingKindProductsScroll.setMinimumSize(new Dimension(300, 200));
        existingKindProductsScroll.setMaximumSize(new Dimension(300, 200));
        existingKindProductsScroll.setPreferredSize(new Dimension(300, 200));
        existingKindProductsScroll.setName("existingKindProductsScroll");

        existingKindProductsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        existingKindProductsList.setMaximumSize(new Dimension(300, 200));
        existingKindProductsList.setMinimumSize(new Dimension(300, 200));
        existingKindProductsList.setName("existingKindProductsList");
        existingKindProductsList.setPreferredSize(new Dimension(300, 200));
        existingKindProductsList.setVisibleRowCount(10);
        existingKindProductsScroll.setViewportView(existingKindProductsList);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingKindProductsPanel.add(existingKindProductsScroll, gridBagConstraints);

        btnModifyKindProduct.setText("Modificar");
        btnModifyKindProduct.setName("btnModifyKindProduct");
        btnModifyKindProduct.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnModifyKindProductMouseClicked(evt);
            }
        });
        btnModifyKindProduct.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnModifyKindProductKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingKindProductsPanel.add(btnModifyKindProduct, gridBagConstraints);

        btnDeleteKindProduct.setText("Eliminar");
        btnDeleteKindProduct.setName("btnDeleteKindProduct");
        btnDeleteKindProduct.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnDeleteKindProductMouseClicked(evt);
            }
        });
        btnDeleteKindProduct.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnDeleteKindProductKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingKindProductsPanel.add(btnDeleteKindProduct, gridBagConstraints);

        add(existingKindProductsPanel);

        productsFiller3.setName("productsFiller3");
        add(productsFiller3);
    }

    private void initController() {
        componentList = new ArrayList<>();
        componentList.add(txtKindProduct);
        componentList.add(btnAddKindProduct);
        componentList.add(existingKindProductsList);

        controller = new ProductKindController(componentList);
        ((ProductKindController)controller).refreshExistingKindProductsList();
    }

    private void txtKindProductKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnAddKindProductKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnDeleteKindProductKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnModifyKindProductKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void btnAddKindProductMouseClicked(MouseEvent evt) {
        ((ProductKindController)controller).addKindOfProduct();
        ((ProductKindController)controller).refreshExistingKindProductsList();

        txtKindProduct.setText("");
        txtKindProduct.requestFocusInWindow();
    }

    private void btnModifyKindProductMouseClicked(MouseEvent evt) {
        ((ProductKindController)controller).updateKindOfProduct();
        ((ProductKindController)controller).refreshExistingKindProductsList();
    }

    private void btnDeleteKindProductMouseClicked(MouseEvent evt) {
        ((ProductKindController)controller).deleteKindOfProduct();
        ((ProductKindController)controller).refreshExistingKindProductsList();
    }
}