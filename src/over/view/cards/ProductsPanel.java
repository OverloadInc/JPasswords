package over.view.cards;

import over.controller.Controller;
import over.controller.ProductController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ProductsPanel extends JPanel {
    private JButton btnAddProduct;
    private JButton btnDeleteProduct;
    private JButton btnModifyProduct;
    private JLabel lblKind;
    private JLabel lblProduct;
    private JComboBox<String> cmbKindProduct;
    private Box.Filler productFiller1;
    private Box.Filler productFiller2;
    private Box.Filler productFiller3;
    private JPanel productPanel;
    private JTextField txtProduct;
    private JPanel existingProductsPanel;
    private JScrollPane existingProductsScroll;
    private JTable existingProductsTable;
    private List<Component> componentList;
    private Controller controller;

    public ProductsPanel() {
        initComponents();
        initController();
    }

    @SuppressWarnings("unchecked")
    public void initComponents() {
        GridBagConstraints gridBagConstraints;

        productFiller1 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));
        productPanel = new JPanel();
        lblProduct = new JLabel();
        txtProduct = new JTextField();
        lblKind = new JLabel();
        cmbKindProduct = new JComboBox<>();
        btnAddProduct = new JButton();
        productFiller2 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));
        existingProductsPanel = new JPanel();
        existingProductsScroll = new JScrollPane();
        existingProductsTable = new JTable();
        btnModifyProduct = new JButton();
        btnDeleteProduct = new JButton();
        productFiller3 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 50), new Dimension(0, 32767));

        setBackground(new Color(255, 255, 255));
        setBorder(BorderFactory.createTitledBorder(null, "Productos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        setMinimumSize(new Dimension(800, 600));
        setName("productsPanel");
        setOpaque(false);
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        productFiller1.setName("productFiller1");
        add(productFiller1);

        productPanel.setBorder(BorderFactory.createTitledBorder("Agregar producto"));
        productPanel.setMinimumSize(new Dimension(750, 100));
        productPanel.setName("productPanel");
        productPanel.setOpaque(false);
        productPanel.setPreferredSize(new Dimension(750, 100));

        lblProduct.setText("Nombre");
        lblProduct.setName("lblProduct");
        productPanel.add(lblProduct);

        txtProduct.setMinimumSize(new Dimension(200, 30));
        txtProduct.setName("txtProduct");
        txtProduct.setPreferredSize(new Dimension(200, 30));
        productPanel.add(txtProduct);

        lblKind.setText("Tipo de producto");
        lblKind.setName("lblKind");
        productPanel.add(lblKind);

        cmbKindProduct.setName("cmbKindProduct");
        productPanel.add(cmbKindProduct);

        btnAddProduct.setText("Agregar");
        btnAddProduct.setName("btnAddProduct");
        btnAddProduct.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnAddProductMouseClicked(evt);
            }
        });
        btnAddProduct.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnAddProductKeyPressed(evt);
            }
        });
        productPanel.add(btnAddProduct);

        add(productPanel);

        productFiller2.setName("productFiller2");
        add(productFiller2);

        existingProductsPanel.setBorder(BorderFactory.createTitledBorder("Productos existentes"));
        existingProductsPanel.setMinimumSize(new Dimension(750, 350));
        existingProductsPanel.setName("existingProductsPanel");
        existingProductsPanel.setOpaque(false);
        existingProductsPanel.setPreferredSize(new Dimension(750, 350));
        existingProductsPanel.setLayout(new GridBagLayout());

        existingProductsScroll.setMinimumSize(new Dimension(400, 300));
        existingProductsScroll.setMaximumSize(new Dimension(400, 300));
        existingProductsScroll.setName("existingProductsScroll");
        existingProductsScroll.setPreferredSize(new Dimension(400, 300));

        existingProductsTable.setModel(new DefaultTableModel(new Object [][] {}, new String [] {"Id", "Nombre", "Tipo"}) {
            Class[] types = new Class[] {Integer.class, String.class, Integer.class};
            boolean[] canEdit = new boolean[] {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        existingProductsTable.setFillsViewportHeight(true);
        existingProductsTable.setMaximumSize(new Dimension(400, 300));
        existingProductsTable.setMinimumSize(new Dimension(400, 300));
        existingProductsTable.setName("existingProductsTable");
        existingProductsTable.setPreferredSize(new Dimension(400, 300));
        existingProductsScroll.setViewportView(existingProductsTable);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingProductsPanel.add(existingProductsScroll, gridBagConstraints);

        btnModifyProduct.setText("Modificar");
        btnModifyProduct.setName("btnModifyProduct");
        btnModifyProduct.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnModifyProductMouseClicked(evt);
            }
        });
        btnModifyProduct.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnModifyProductKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingProductsPanel.add(btnModifyProduct, gridBagConstraints);

        btnDeleteProduct.setText("Eliminar");
        btnDeleteProduct.setName("btnDeleteProduct");
        btnDeleteProduct.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnDeleteProductMouseClicked(evt);
            }
        });
        btnDeleteProduct.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnDeleteProductKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingProductsPanel.add(btnDeleteProduct, gridBagConstraints);

        add(existingProductsPanel);

        productFiller3.setName("productFiller3");
        add(productFiller3);
    }

    public void initController() {
        componentList = new ArrayList<>();
        componentList.add(txtProduct);
        componentList.add(cmbKindProduct);
        componentList.add(btnAddProduct);
        componentList.add(existingProductsTable);
        componentList.add(btnModifyProduct);
        componentList.add(btnDeleteProduct);

        controller = new ProductController(componentList);
        ((ProductController)controller).refreshKindOfProductsList();
        ((ProductController)controller).refreshExistingProductsTable();
    }

    private void btnAddProductKeyPressed(KeyEvent evt) {
        ((ProductController)controller).addProduct();
        ((ProductController)controller).refreshExistingProductsTable();

        txtProduct.setText("");
        txtProduct.requestFocusInWindow();
    }

    private void btnModifyProductKeyPressed(KeyEvent evt) {
        ((ProductController)controller).updateProduct();
        ((ProductController)controller).refreshExistingProductsTable();

        txtProduct.setText("");
        txtProduct.requestFocusInWindow();
    }

    private void btnDeleteProductKeyPressed(KeyEvent evt) {
        ((ProductController)controller).deleteProduct();
        ((ProductController)controller).refreshExistingProductsTable();

        txtProduct.setText("");
        txtProduct.requestFocusInWindow();
    }

    private void btnAddProductMouseClicked(MouseEvent evt) {
        ((ProductController)controller).addProduct();
        ((ProductController)controller).refreshExistingProductsTable();

        txtProduct.setText("");
        txtProduct.requestFocusInWindow();
    }

    private void btnModifyProductMouseClicked(MouseEvent evt) {
        ((ProductController)controller).updateProduct();
        ((ProductController)controller).refreshExistingProductsTable();

        txtProduct.setText("");
        txtProduct.requestFocusInWindow();
    }

    private void btnDeleteProductMouseClicked(MouseEvent evt) {
        ((ProductController)controller).deleteProduct();
        ((ProductController)controller).refreshExistingProductsTable();

        txtProduct.setText("");
        txtProduct.requestFocusInWindow();
    }
}