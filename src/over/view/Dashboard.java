package over.view;

import over.controller.*;
import over.model.pojo.Privilege;
import over.model.pojo.User;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends JFrame {
    private JMenuItem aboutItem;
    private JCheckBox accessesCheck;
    private JPanel accessesPanel;
    private JButton btnAddDepartment;
    private JButton btnAddKindProduct;
    private JButton btnAddPrivilege;
    private JButton btnAddProduct;
    private JButton btnBack;
    private JButton btnDeleteDepartment;
    private JButton btnDeleteHierarchy;
    private JButton btnDeleteKindProduct;
    private JButton btnDeletePrivilege;
    private JButton btnDeleteProduct;
    private JButton btnHierarchy;
    private JButton btnHome;
    private JButton btnModifyDepartment;
    private JButton btnModifyHierarchy;
    private JButton btnModifyKindProduct;
    private JButton btnModifyPrivilege;
    private JButton btnModifyProduct;
    private JButton btnNext;
    private JComboBox<String> cmbKindProduct;
    private JCheckBox credentialsCheck;
    private JPanel credentialsPanel;
    private JPanel dashboardPanel;
    private JPanel departmentPanel;
    private JCheckBox departmentsCheck;
    private Box.Filler departmentsFiller1;
    private Box.Filler departmentsFiller2;
    private Box.Filler departmentsFiller3;
    private JPanel departmentsPanel;
    private JCheckBox employeesCheck;
    private JList<String> existingDepartmentsList;
    private JPanel existingDepartmentsPanel;
    private JScrollPane existingDepartmentsScroll;
    private JPanel existingHierarchiesPanel;
    private JScrollPane existingHierarchiesScroll;
    private JTable existingHierarchiesTable;
    private JList<String> existingKindProductsList;
    private JPanel existingKindProductsPanel;
    private JScrollPane existingKindProductsScroll;
    private JList<String> existingPrivilegesList;
    private JPanel existingPrivilegesPanel;
    private JScrollPane existingPrivilegesScroll;
    private JPanel existingProductsPanel;
    private JScrollPane existingProductsScroll;
    private JTable existingProductsTable;
    private JMenuItem exitItem;
    private JPanel exployeesPanel;
    private JMenuItem exportItem;
    private JMenu fileMenu;
    private JMenu helpMenu;
    private JCheckBox hierarchiesCheck;
    private Box.Filler hierarchiesFiller1;
    private Box.Filler hierarchiesFiller2;
    private Box.Filler hierarchiesFiller3;
    private JPanel hierarchiesPanel;
    private JPanel hierarchyPanel;
    private JPanel kindProductPanel;
    private JCheckBox kindProductsCheck;
    private JPanel kindProductsPanel;
    private JLabel lblAccessLogo;
    private JLabel lblCredentialsLogo;
    private JLabel lblDepartment;
    private JLabel lblDepartmentsLogo;
    private JLabel lblEmployees;
    private JLabel lblHierarchy;
    private JLabel lblHierarchyLogo;
    private JLabel lblKind;
    private JLabel lblKindProduct;
    private JLabel lblKindProductLogo;
    private JLabel lblPrivilege;
    private JLabel lblPrivilegesLogo;
    private JLabel lblProduct;
    private JLabel lblProductLogo;
    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JMenuItem printItem;
    private JPanel privilegePanel;
    private JCheckBox privilegesCheck;
    private Box.Filler privilegesFiller1;
    private Box.Filler privilegesFiller2;
    private Box.Filler privilegesFiller3;
    private JPanel privilegesPanel;
    private Box.Filler productFiller1;
    private Box.Filler productFiller2;
    private Box.Filler productFiller3;
    private JPanel productPanel;
    private JCheckBox productsCheck;
    private Box.Filler productsFiller1;
    private Box.Filler productsFiller2;
    private Box.Filler productsFiller3;
    private JPanel productsPanel;
    private JToolBar.Separator separator;
    private JToolBar toolBar;
    private JTextField txtDepartment;
    private JTextField txtHierarchy;
    private JTextField txtKindProduct;
    private JTextField txtPrivilege;
    private JTextField txtProduct;
    private final CardLayout cardLayout;
    private final Image backgroundImage;
    private List<Component> componentList;
    private Controller controller;
    private User user;

    public Dashboard(User user) {
        this.user = user;
        BackgroundImage.setName("dashboard_white_blue01.jpg");
        backgroundImage = BackgroundImage.request();

        initComponents();
        setDashboard();

        cardLayout = (CardLayout)(mainPanel.getLayout());
    }

    public void setDashboard() {
        switch (new Privilege().getPrivilege(user)) {
            case "Supervisor": break;
            case "Administrador": administratorUser(); break;
            case "Estándar": standardUser(); break;
            default: break;
        }
    }

    public void administratorUser() {
        /*lblCredentialsLogo.setVisible(true);
        lblAccessLogo.setVisible(true);
        lblDepartmentsLogo.setVisible(true);
        lblEmployees.setVisible(true);*/
        lblHierarchyLogo.setVisible(false);
        /*lblKindProductLogo.setVisible(true);
        lblPrivilegesLogo.setVisible(true);
        lblProductLogo.setVisible(true);*/
    }

    public void standardUser() {
        /*lblCredentialsLogo.setVisible(true);
        lblAccessLogo.setVisible(true);*/
        lblDepartmentsLogo.setVisible(false);
        lblEmployees.setVisible(false);
        lblHierarchyLogo.setVisible(false);
        lblKindProductLogo.setVisible(false);
        lblPrivilegesLogo.setVisible(false);
        lblProductLogo.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        toolBar = new JToolBar();
        btnHome = new JButton();
        separator = new JToolBar.Separator();
        btnBack = new JButton();
        btnNext = new JButton();
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, null);
            }
        };
        dashboardPanel = new JPanel();
        lblKindProductLogo = new JLabel();
        lblProductLogo = new JLabel();
        lblCredentialsLogo = new JLabel();
        lblEmployees = new JLabel();
        lblDepartmentsLogo = new JLabel();
        lblHierarchyLogo = new JLabel();
        lblPrivilegesLogo = new JLabel();
        lblAccessLogo = new JLabel();
        kindProductsPanel = new JPanel();
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
        productsPanel = new JPanel();
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
        credentialsPanel = new JPanel();
        exployeesPanel = new JPanel();
        departmentsPanel = new JPanel();
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
        hierarchiesPanel = new JPanel();
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
        privilegesPanel = new JPanel();
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
        accessesPanel = new JPanel();
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        exportItem = new JMenuItem();
        printItem = new JMenuItem();
        exitItem = new JMenuItem();
        helpMenu = new JMenu();
        aboutItem = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Holiwallet v0.1 - Dashboard");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800, 600));
        setName("frmDashboard"); 
        setPreferredSize(new Dimension(800, 600));

        toolBar.setRollover(true);
        toolBar.setName("toolBar"); 

        btnHome.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/toolbar/home.png")));
        btnHome.setToolTipText("Inicio");
        btnHome.setFocusable(false);
        btnHome.setHorizontalTextPosition(SwingConstants.CENTER);
        btnHome.setName("btnHome"); 
        btnHome.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        toolBar.add(btnHome);

        separator.setName("separator"); 
        toolBar.add(separator);

        btnBack.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/toolbar/back.png"))); 
        btnBack.setToolTipText("Atras");
        btnBack.setFocusable(false);
        btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
        btnBack.setName("btnBack"); 
        btnBack.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        toolBar.add(btnBack);

        btnNext.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/toolbar/next.png"))); 
        btnNext.setToolTipText("Adelante");
        btnNext.setFocusable(false);
        btnNext.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNext.setName("btnNext"); 
        btnNext.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        toolBar.add(btnNext);

        getContentPane().add(toolBar, BorderLayout.NORTH);

        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setMinimumSize(new Dimension(800, 600));
        mainPanel.setName("mainPanel"); 
        mainPanel.setPreferredSize(new Dimension(800, 600));
        mainPanel.setLayout(new CardLayout());

        dashboardPanel.setBackground(new Color(255, 255, 255));
        dashboardPanel.setMinimumSize(new Dimension(800, 600));
        dashboardPanel.setName("dashboardPanel"); 
        dashboardPanel.setOpaque(false);
        dashboardPanel.setPreferredSize(new Dimension(800, 600));
        dashboardPanel.setLayout(new GridBagLayout());

        lblKindProductLogo.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/kind_of_product.png"))); 
        lblKindProductLogo.setText("Tipo de productos");
        lblKindProductLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblKindProductLogo.setName("lblKindProductLogo"); 
        lblKindProductLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
        lblKindProductLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblKindProductLogoMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.weightx = 1.0;
        dashboardPanel.add(lblKindProductLogo, gridBagConstraints);

        lblProductLogo.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/products.png"))); 
        lblProductLogo.setText("Productos");
        lblProductLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblProductLogo.setName("lblProductLogo"); 
        lblProductLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
        lblProductLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblProductLogoMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.weightx = 1.0;
        dashboardPanel.add(lblProductLogo, gridBagConstraints);

        lblCredentialsLogo.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/credentials.png"))); 
        lblCredentialsLogo.setText("Credenciales");
        lblCredentialsLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblCredentialsLogo.setName("lblCredentialsLogo"); 
        lblCredentialsLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
        lblCredentialsLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblCredentialsLogoMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.weightx = 1.0;
        dashboardPanel.add(lblCredentialsLogo, gridBagConstraints);

        lblEmployees.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/users.png"))); 
        lblEmployees.setText("Empleados");
        lblEmployees.setHorizontalTextPosition(SwingConstants.CENTER);
        lblEmployees.setName("lblEmployees"); 
        lblEmployees.setVerticalTextPosition(SwingConstants.BOTTOM);
        lblEmployees.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblEmployeesMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.weightx = 1.0;
        dashboardPanel.add(lblEmployees, gridBagConstraints);

        lblDepartmentsLogo.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/departments.png"))); 
        lblDepartmentsLogo.setText("Departamentos");
        lblDepartmentsLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblDepartmentsLogo.setName("lblDepartmentsLogo"); 
        lblDepartmentsLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
        lblDepartmentsLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblDepartmentsLogoMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.weightx = 1.0;
        dashboardPanel.add(lblDepartmentsLogo, gridBagConstraints);

        lblHierarchyLogo.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/hierarchy.png"))); 
        lblHierarchyLogo.setText("Jerarquías");
        lblHierarchyLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblHierarchyLogo.setName("lblHierarchyLogo"); 
        lblHierarchyLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
        lblHierarchyLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblHierarchyLogoMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.weightx = 1.0;
        dashboardPanel.add(lblHierarchyLogo, gridBagConstraints);

        lblPrivilegesLogo.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/privileges.png"))); 
        lblPrivilegesLogo.setText("Privilegios");
        lblPrivilegesLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblPrivilegesLogo.setName("lblPrivilegesLogo"); 
        lblPrivilegesLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
        lblPrivilegesLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblPrivilegesLogoMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.weightx = 1.0;
        dashboardPanel.add(lblPrivilegesLogo, gridBagConstraints);

        lblAccessLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblAccessLogo.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/access.png"))); 
        lblAccessLogo.setText("Accesos");
        lblAccessLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblAccessLogo.setName("lblAccessLogo"); 
        lblAccessLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
        lblAccessLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblAccessLogoMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.weightx = 1.0;
        dashboardPanel.add(lblAccessLogo, gridBagConstraints);

        mainPanel.add(dashboardPanel, "dashboardPanel");

        kindProductsPanel.setBackground(new Color(255, 255, 255));
        kindProductsPanel.setBorder(BorderFactory.createTitledBorder(null, "Tipos de productos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        kindProductsPanel.setMinimumSize(new Dimension(800, 600));
        kindProductsPanel.setName("kindProductsPanel"); 
        kindProductsPanel.setOpaque(false);
        kindProductsPanel.setPreferredSize(new Dimension(800, 600));
        kindProductsPanel.setLayout(new BoxLayout(kindProductsPanel, BoxLayout.Y_AXIS));

        productsFiller1.setName("productsFiller1"); 
        kindProductsPanel.add(productsFiller1);

        kindProductPanel.setBorder(BorderFactory.createTitledBorder("Agregar tipo de producto"));
        kindProductPanel.setMinimumSize(new Dimension(300, 60));
        kindProductPanel.setName("kindProductPanel"); 
        kindProductPanel.setOpaque(false);
        kindProductPanel.setPreferredSize(new Dimension(300, 60));

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

        kindProductsPanel.add(kindProductPanel);

        productsFiller2.setName("productsFiller2"); 
        kindProductsPanel.add(productsFiller2);

        existingKindProductsPanel.setBorder(BorderFactory.createTitledBorder("Tipos de productos existentes"));
        existingKindProductsPanel.setName("existingKindProductsPanel"); 
        existingKindProductsPanel.setOpaque(false);
        existingKindProductsPanel.setPreferredSize(new Dimension(300, 180));
        existingKindProductsPanel.setLayout(new GridBagLayout());

        existingKindProductsScroll.setMinimumSize(new Dimension(319, 162));
        existingKindProductsScroll.setName("existingKindProductsScroll"); 

        existingKindProductsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        existingKindProductsList.setMaximumSize(new Dimension(300, 300));
        existingKindProductsList.setMinimumSize(new Dimension(300, 300));
        existingKindProductsList.setName("existingKindProductsList"); 
        existingKindProductsList.setPreferredSize(new Dimension(300, 300));
        existingKindProductsList.setVisibleRowCount(10);
        existingKindProductsList.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                existingKindProductsListKeyPressed(evt);
            }
        });
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

        kindProductsPanel.add(existingKindProductsPanel);

        productsFiller3.setName("productsFiller3"); 
        kindProductsPanel.add(productsFiller3);

        mainPanel.add(kindProductsPanel, "kindProductsPanel");

        productsPanel.setBackground(new Color(255, 255, 255));
        productsPanel.setBorder(BorderFactory.createTitledBorder(null, "Productos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        productsPanel.setMinimumSize(new Dimension(800, 600));
        productsPanel.setName("productsPanel"); 
        productsPanel.setOpaque(false);
        productsPanel.setPreferredSize(new Dimension(800, 600));
        productsPanel.setLayout(new BoxLayout(productsPanel, BoxLayout.Y_AXIS));

        productFiller1.setName("productFiller1"); 
        productsPanel.add(productFiller1);

        productPanel.setBorder(BorderFactory.createTitledBorder("Agregar producto"));
        productPanel.setName("productPanel"); 
        productPanel.setOpaque(false);

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

        productsPanel.add(productPanel);

        productFiller2.setName("productFiller2"); 
        productsPanel.add(productFiller2);

        existingProductsPanel.setBorder(BorderFactory.createTitledBorder("Productos existentes"));
        existingProductsPanel.setName("existingProductsPanel"); 
        existingProductsPanel.setOpaque(false);
        existingProductsPanel.setLayout(new GridBagLayout());

        existingProductsScroll.setName("existingProductsScroll"); 

        existingProductsTable.setModel(new DefaultTableModel(new Object [][] {}, new String [] {"Id", "Nombre", "Tipo"}) {
            Class[] types = new Class [] {
                    Integer.class, String.class, Integer.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        existingProductsTable.setFillsViewportHeight(true);
        existingProductsTable.setMaximumSize(new Dimension(300, 300));
        existingProductsTable.setMinimumSize(new Dimension(300, 300));
        existingProductsTable.setName("existingProductsTable"); 
        existingProductsTable.setPreferredSize(new Dimension(300, 300));
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

        productsPanel.add(existingProductsPanel);

        productFiller3.setName("productFiller3"); 
        productsPanel.add(productFiller3);

        mainPanel.add(productsPanel, "productsPanel");

        credentialsPanel.setBackground(new Color(255, 255, 255));
        credentialsPanel.setBorder(BorderFactory.createTitledBorder(null, "Credenciales", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        credentialsPanel.setMinimumSize(new Dimension(800, 600));
        credentialsPanel.setName("credentialsPanel"); 
        credentialsPanel.setOpaque(false);
        credentialsPanel.setPreferredSize(new Dimension(800, 600));
        mainPanel.add(credentialsPanel, "credentialsPanel");

        exployeesPanel.setBackground(new Color(255, 255, 255));
        exployeesPanel.setBorder(BorderFactory.createTitledBorder(null, "Empleados", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        exployeesPanel.setMinimumSize(new Dimension(800, 600));
        exployeesPanel.setName("employeesPanel"); 
        exployeesPanel.setOpaque(false);
        exployeesPanel.setPreferredSize(new Dimension(800, 600));
        mainPanel.add(exployeesPanel, "employeesPanel");

        departmentsPanel.setBackground(new Color(255, 255, 255));
        departmentsPanel.setBorder(BorderFactory.createTitledBorder(null, "Departamentos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        departmentsPanel.setMinimumSize(new Dimension(800, 600));
        departmentsPanel.setName("departmentsPanel"); 
        departmentsPanel.setOpaque(false);
        departmentsPanel.setPreferredSize(new Dimension(800, 600));
        departmentsPanel.setLayout(new BoxLayout(departmentsPanel, BoxLayout.Y_AXIS));

        departmentsFiller1.setName("departmentsFiller1"); 
        departmentsPanel.add(departmentsFiller1);

        departmentPanel.setBorder(BorderFactory.createTitledBorder("Agregar departamento"));
        departmentPanel.setMinimumSize(new Dimension(300, 60));
        departmentPanel.setName("departmentPanel"); 
        departmentPanel.setOpaque(false);
        departmentPanel.setPreferredSize(new Dimension(300, 60));

        lblDepartment.setText("Nombre");
        lblDepartment.setName("lblDepartment"); 
        departmentPanel.add(lblDepartment);

        txtDepartment.setMinimumSize(new Dimension(200, 30));
        txtDepartment.setName("txtDepartment"); 
        txtDepartment.setPreferredSize(new Dimension(200, 30));
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

        departmentsPanel.add(departmentPanel);

        departmentsFiller2.setName("departmentsFiller2"); 
        departmentsPanel.add(departmentsFiller2);

        existingDepartmentsPanel.setBorder(BorderFactory.createTitledBorder("Departamentos existentes"));
        existingDepartmentsPanel.setName("existingDepartmentsPanel"); 
        existingDepartmentsPanel.setOpaque(false);
        existingDepartmentsPanel.setPreferredSize(new Dimension(300, 180));
        existingDepartmentsPanel.setLayout(new GridBagLayout());

        existingDepartmentsScroll.setName("existingDepartmentsScroll"); 

        existingDepartmentsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        existingDepartmentsList.setMaximumSize(new Dimension(300, 300));
        existingDepartmentsList.setMinimumSize(new Dimension(300, 300));
        existingDepartmentsList.setName("existingDepartmentsList"); 
        existingDepartmentsList.setPreferredSize(new Dimension(300, 300));
        existingDepartmentsList.setVisibleRowCount(10);
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

        departmentsPanel.add(existingDepartmentsPanel);

        departmentsFiller3.setName("departmentsFiller3"); 
        departmentsPanel.add(departmentsFiller3);

        mainPanel.add(departmentsPanel, "departmentsPanel");

        hierarchiesPanel.setBackground(new Color(255, 255, 255));
        hierarchiesPanel.setBorder(BorderFactory.createTitledBorder(null, "Jerarquías", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        hierarchiesPanel.setMinimumSize(new Dimension(800, 600));
        hierarchiesPanel.setName("hierarchiesPanel"); 
        hierarchiesPanel.setOpaque(false);
        hierarchiesPanel.setPreferredSize(new Dimension(800, 600));
        hierarchiesPanel.setLayout(new BoxLayout(hierarchiesPanel, BoxLayout.Y_AXIS));

        hierarchiesFiller1.setName("hierarchiesFiller1"); 
        hierarchiesPanel.add(hierarchiesFiller1);

        hierarchyPanel.setBorder(BorderFactory.createTitledBorder(null, "Agregar jerarquía", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
        hierarchyPanel.setName("hierarchyPanel"); 
        hierarchyPanel.setOpaque(false);

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

        hierarchiesPanel.add(hierarchyPanel);

        hierarchiesFiller2.setName("hierarchiesFiller2"); 
        hierarchiesPanel.add(hierarchiesFiller2);

        existingHierarchiesPanel.setBorder(BorderFactory.createTitledBorder(null, "Jerarquías existentes", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
        existingHierarchiesPanel.setName("existingHierarchiesPanel"); 
        existingHierarchiesPanel.setOpaque(false);
        existingHierarchiesPanel.setLayout(new GridBagLayout());

        existingHierarchiesScroll.setMinimumSize(new Dimension(300, 200));
        existingHierarchiesScroll.setName("existingHierarchiesScroll"); 
        existingHierarchiesScroll.setPreferredSize(new Dimension(300, 200));

        existingHierarchiesTable.setModel(new DefaultTableModel(new Object [][] {}, new String [] {"Nombre", "Tipo"}) {
            Class[] types = new Class [] {
                    String.class, Integer.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        existingHierarchiesTable.setFillsViewportHeight(true);
        existingHierarchiesTable.setMinimumSize(new Dimension(300, 200));
        existingHierarchiesTable.setName("existingHierarchiesTable"); 
        existingHierarchiesTable.setPreferredSize(new Dimension(300, 200));
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

        hierarchiesPanel.add(existingHierarchiesPanel);

        hierarchiesFiller3.setName("hierarchiesFiller3"); 
        hierarchiesPanel.add(hierarchiesFiller3);

        mainPanel.add(hierarchiesPanel, "hierarchiesPanel");

        privilegesPanel.setBackground(new Color(255, 255, 255));
        privilegesPanel.setBorder(BorderFactory.createTitledBorder(null, "Privilegios", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        privilegesPanel.setMinimumSize(new Dimension(800, 600));
        privilegesPanel.setName("privilegesPanel"); 
        privilegesPanel.setOpaque(false);
        privilegesPanel.setPreferredSize(new Dimension(800, 600));
        privilegesPanel.setLayout(new BoxLayout(privilegesPanel, BoxLayout.Y_AXIS));

        privilegesFiller1.setName("privilegesFiller1"); 
        privilegesPanel.add(privilegesFiller1);

        privilegePanel.setBorder(BorderFactory.createTitledBorder(null, "Agregar privilegio", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
        privilegePanel.setName("privilegePanel"); 
        privilegePanel.setOpaque(false);

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

        privilegesPanel.add(privilegePanel);

        privilegesFiller2.setName("privilegesFiller2"); 
        privilegesPanel.add(privilegesFiller2);

        existingPrivilegesPanel.setBorder(BorderFactory.createTitledBorder(null, "Privilegios existentes", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
        existingPrivilegesPanel.setName("existingPrivilegesPanel"); 
        existingPrivilegesPanel.setOpaque(false);
        existingPrivilegesPanel.setLayout(new GridBagLayout());

        existingPrivilegesScroll.setName("existingPrivilegesScroll"); 

        existingPrivilegesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        existingPrivilegesList.setName("existingPrivilegesList"); 
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
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        existingPrivilegesPanel.add(accessesCheck, gridBagConstraints);

        privilegesPanel.add(existingPrivilegesPanel);

        privilegesFiller3.setName("privilegesFiller3"); 
        privilegesPanel.add(privilegesFiller3);

        mainPanel.add(privilegesPanel, "privilegesPanel");

        accessesPanel.setBackground(new Color(255, 255, 255));
        accessesPanel.setBorder(BorderFactory.createTitledBorder(null, "Accesos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        accessesPanel.setMinimumSize(new Dimension(800, 600));
        accessesPanel.setName("accessesPanel"); 
        accessesPanel.setOpaque(false);
        accessesPanel.setPreferredSize(new Dimension(800, 600));
        mainPanel.add(accessesPanel, "accessesPanel");

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        menuBar.setName("menuBar"); 

        fileMenu.setMnemonic('A');
        fileMenu.setText("Archivo");
        fileMenu.setName("fileMenu"); 

        exportItem.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/menubar/export.png"))); 
        exportItem.setText("Exportar");
        exportItem.setName("exportItem"); 
        exportItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exportItemActionPerformed(evt);
            }
        });
        fileMenu.add(exportItem);

        printItem.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/menubar/print.png"))); 
        printItem.setText("Imprimir");
        printItem.setName("printItem"); 
        printItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                printItemActionPerformed(evt);
            }
        });
        fileMenu.add(printItem);

        exitItem.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/menubar/logout.png"))); 
        exitItem.setText("Salir");
        exitItem.setName("exitItem"); 
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        helpMenu.setMnemonic('y');
        helpMenu.setText("Ayuda");
        helpMenu.setName("helpMenu"); 

        aboutItem.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/menubar/about.png"))); 
        aboutItem.setText("Acerca de...");
        aboutItem.setName("aboutItem"); 
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aboutItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
    }

    private void lblKindProductLogoMouseClicked(MouseEvent evt) {
        componentList = new ArrayList<>();
        componentList.add(txtKindProduct);
        componentList.add(btnAddKindProduct);
        componentList.add(existingKindProductsList);

        controller = new ProductKindController(componentList);
        ((ProductKindController)controller).refreshExistingProductsList();

        cardLayout.show(this.mainPanel, "kindProductsPanel");
    }

    private void lblProductLogoMouseClicked(MouseEvent evt) {
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

        cardLayout.show(this.mainPanel, "productsPanel");
    }

    private void lblCredentialsLogoMouseClicked(MouseEvent evt) {
        cardLayout.show(this.mainPanel, "credentialsPanel");
    }

    private void lblEmployeesMouseClicked(MouseEvent evt) {
        cardLayout.show(this.mainPanel, "employeesPanel");
    }

    private void lblDepartmentsLogoMouseClicked(MouseEvent evt) {
        componentList = new ArrayList<>();
        componentList.add(txtDepartment);
        componentList.add(btnAddDepartment);
        componentList.add(btnModifyDepartment);
        componentList.add(btnDeleteDepartment);
        componentList.add(existingDepartmentsList);

        controller = new DepartmentController(componentList);
        ((DepartmentController)controller).refreshExistingDepartmentList();

        cardLayout.show(this.mainPanel, "departmentsPanel");
    }

    private void lblHierarchyLogoMouseClicked(MouseEvent evt) {
        componentList = new ArrayList<>();
        componentList.add(txtHierarchy);
        componentList.add(btnHierarchy);
        componentList.add(btnModifyHierarchy);
        componentList.add(btnDeleteHierarchy);
        componentList.add(existingHierarchiesTable);

        controller = new HierarchyController(componentList);
        ((HierarchyController)controller).refreshExistingHierarchiesTable();

        cardLayout.show(this.mainPanel, "hierarchiesPanel");
    }

    private void lblPrivilegesLogoMouseClicked(MouseEvent evt) {
        componentList = new ArrayList<>();
        componentList.add(txtPrivilege);
        componentList.add(btnAddPrivilege);
        componentList.add(btnModifyPrivilege);
        componentList.add(btnDeletePrivilege);
        componentList.add(existingPrivilegesList);

        controller = new PrivilegeController(componentList);
        ((PrivilegeController)controller).refreshExistingPrivilegeList();

        cardLayout.show(this.mainPanel, "privilegesPanel");
    }

    private void lblAccessLogoMouseClicked(MouseEvent evt) {
        cardLayout.show(this.mainPanel, "accessesPanel");
    }

    private void exportItemActionPerformed(ActionEvent evt) {

    }

    private void printItemActionPerformed(ActionEvent evt) {

    }

    private void exitItemActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void aboutItemActionPerformed(ActionEvent evt) {
        new About().setVisible(true);
    }

    private void btnHomeActionPerformed(ActionEvent evt) {
        cardLayout.show(this.mainPanel, "dashboardPanel");
    }

    private void btnBackActionPerformed(ActionEvent evt) {
        cardLayout.show(this.mainPanel, Carousel.back(Carousel.getActivePanel(mainPanel)));
    }

    private void btnNextActionPerformed(ActionEvent evt) {
        cardLayout.show(this.mainPanel, Carousel.next(Carousel.getActivePanel(mainPanel)));
    }

    private void txtKindProductKeyPressed(KeyEvent evt) {
        controller.setFocus(evt);
    }

    private void existingKindProductsListKeyPressed(KeyEvent evt) {

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
        ((ProductKindController)controller).refreshExistingProductsList();

        txtKindProduct.setText("");
        txtKindProduct.requestFocusInWindow();
    }

    private void btnModifyKindProductMouseClicked(MouseEvent evt) {
        ((ProductKindController)controller).updateKindOfProduct();
        ((ProductKindController)controller).refreshExistingProductsList();
    }

    private void btnDeleteKindProductMouseClicked(MouseEvent evt) {
        ((ProductKindController)controller).deleteKindOfProduct();
        ((ProductKindController)controller).refreshExistingProductsList();
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

    private void btnHierarchyMouseClicked(MouseEvent evt) {
        ((HierarchyController)controller).addHierarchy();
        ((HierarchyController)controller).refreshExistingHierarchiesTable();

        txtHierarchy.setText("");
        txtHierarchy.requestFocusInWindow();
    }

    private void btnModifyHierarchyMouseClicked(MouseEvent evt) {
        ((HierarchyController)controller).updateHierarchy();
        ((HierarchyController)controller).refreshExistingHierarchiesTable();
    }

    private void btnDeleteHierarchyMouseClicked(MouseEvent evt) {
        ((HierarchyController)controller).deleteHierarchy();
        ((HierarchyController)controller).refreshExistingHierarchiesTable();
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

        txtPrivilege.setText("");
        txtPrivilege.requestFocusInWindow();
    }

    private void btnModifyPrivilegeMouseClicked(MouseEvent evt) {
        ((PrivilegeController)controller).updatePrivilege();
        ((PrivilegeController)controller).refreshExistingPrivilegeList();
    }

    private void btnDeletePrivilegeMouseClicked(MouseEvent evt) {
        ((PrivilegeController)controller).deletePrivilege();
        ((PrivilegeController)controller).refreshExistingPrivilegeList();
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