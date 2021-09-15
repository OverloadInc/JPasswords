package over.view;

import over.controller.BackgroundImage;
import over.controller.Carousel;
import over.model.pojo.Privilege;
import over.model.pojo.User;
import over.view.cards.*;
import over.view.dashboard.DashboardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends JFrame {

    private JButton btnBack;
    private JButton btnHome;
    private JButton btnNext;
    private JLabel lblKindProductLogo;
    private JLabel lblProductLogo;
    private JLabel lblCredentialsLogo;
    private JLabel lblEmployeesLogo;
    private JLabel lblDepartmentsLogo;
    private JLabel lblHierarchiesLogo;
    private JLabel lblPrivilegesLogo;
    private JLabel lblAccessesLogo;
    private JLabel lblPositionsLogo;
    private JMenu fileMenu;
    private JMenu helpMenu;
    private JMenuBar menuBar;
    private JMenuItem aboutItem;
    private JMenuItem exitItem;
    private JMenuItem exportItem;
    private JMenuItem printItem;
    private JPanel dashboardPanel;
    private JPanel mainPanel;
    private JPanel accessesPanel;
    private JPanel credentialsPanel;
    private JPanel departmentsPanel;
    private JPanel employeesPanel;
    private JPanel hierarchiesPanel;
    private JPanel kindProductsPanel;
    private JPanel privilegesPanel;
    private JPanel productsPanel;
    private JPanel positionsPanel;
    private JToolBar.Separator separator;
    private JToolBar toolBar;
    private final CardLayout cardLayout;
    private final Image backgroundImage;
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
        lblHierarchiesLogo.setVisible(false);
        /*lblKindProductLogo.setVisible(true);
        lblPrivilegesLogo.setVisible(true);
        lblProductLogo.setVisible(true);*/
    }

    public void standardUser() {
        /*lblCredentialsLogo.setVisible(true);
        lblAccessLogo.setVisible(true);*/
        lblDepartmentsLogo.setVisible(false);
        lblEmployeesLogo.setVisible(false);
        lblHierarchiesLogo.setVisible(false);
        lblKindProductLogo.setVisible(false);
        lblPrivilegesLogo.setVisible(false);
        lblProductLogo.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Holiwallet v0.1 - Dashboard");
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800, 600));
        setName("frmDashboard");
        setPreferredSize(new Dimension(800, 600));

        toolBar = new JToolBar();
        toolBar.setRollover(true);
        toolBar.setName("toolBar");

        btnHome = new JButton();
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

        separator = new JToolBar.Separator();
        separator.setName("separator");
        toolBar.add(separator);

        btnBack = new JButton();
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

        btnNext = new JButton();
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

        fileMenu = new JMenu();
        fileMenu.setMnemonic('A');
        fileMenu.setText("Archivo");
        fileMenu.setName("fileMenu");

        exportItem = new JMenuItem();
        exportItem.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/menubar/export.png")));
        exportItem.setText("Exportar");
        exportItem.setName("exportItem");
        exportItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exportItemActionPerformed(evt);
            }
        });
        fileMenu.add(exportItem);

        printItem = new JMenuItem();
        printItem.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/menubar/print.png")));
        printItem.setText("Imprimir");
        printItem.setName("printItem");
        printItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                printItemActionPerformed(evt);
            }
        });
        fileMenu.add(printItem);

        exitItem = new JMenuItem();
        exitItem.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/menubar/logout.png")));
        exitItem.setText("Salir");
        exitItem.setName("exitItem");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        helpMenu = new JMenu();
        helpMenu.setMnemonic('y');
        helpMenu.setText("Ayuda");
        helpMenu.setName("helpMenu");

        aboutItem = new JMenuItem();
        aboutItem.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/menubar/about.png")));
        aboutItem.setText("Acerca de...");
        aboutItem.setName("aboutItem");
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aboutItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutItem);

        menuBar = new JMenuBar();
        menuBar.setName("menuBar");
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        dashboardPanel = new DashboardPanel();
        kindProductsPanel = new KindProductsPanel();
        productsPanel = new ProductsPanel();
        credentialsPanel = new CredentialsPanel();
        employeesPanel = new EmployeesPanel();
        departmentsPanel = new DepartmentsPanel();
        hierarchiesPanel = new HierarchiesPanel();
        privilegesPanel = new PrivilegesPanel();
        accessesPanel = new AccessesPanel();
        positionsPanel = new PositionsPanel();

        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, null);
            }
        };
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setMinimumSize(new Dimension(800, 600));
        mainPanel.setName("mainPanel");
        mainPanel.setPreferredSize(new Dimension(800, 600));
        mainPanel.setLayout(new CardLayout());
        mainPanel.add(dashboardPanel, "dashboardPanel");
        mainPanel.add(kindProductsPanel, "kindProductsPanel");
        mainPanel.add(productsPanel, "productsPanel");
        mainPanel.add(credentialsPanel, "credentialsPanel");
        mainPanel.add(employeesPanel, "employeesPanel");
        mainPanel.add(departmentsPanel, "departmentsPanel");
        mainPanel.add(hierarchiesPanel, "hierarchiesPanel");
        mainPanel.add(privilegesPanel, "privilegesPanel");
        mainPanel.add(accessesPanel, "accessesPanel");
        mainPanel.add(positionsPanel, "positionsPanel");

        lblKindProductLogo = ((DashboardPanel) dashboardPanel).getLblKindProductLogo();
        lblKindProductLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblKindProductLogoMouseClicked(evt);
            }
        });

        lblProductLogo = ((DashboardPanel) dashboardPanel).getLblProductLogo();
        lblProductLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblProductLogoMouseClicked(evt);
            }
        });

        lblCredentialsLogo = ((DashboardPanel) dashboardPanel).getLblCredentialsLogo();
        lblCredentialsLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblCredentialsLogoMouseClicked(evt);
            }
        });

        lblEmployeesLogo = ((DashboardPanel) dashboardPanel).getLblEmployees();
        lblEmployeesLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblEmployeesMouseClicked(evt);
            }
        });

        lblDepartmentsLogo = ((DashboardPanel) dashboardPanel).getLblDepartmentsLogo();
        lblDepartmentsLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblDepartmentsLogoMouseClicked(evt);
            }
        });

        lblHierarchiesLogo = ((DashboardPanel) dashboardPanel).getLblHierarchyLogo();
        lblHierarchiesLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblHierarchyLogoMouseClicked(evt);
            }
        });

        lblPrivilegesLogo = ((DashboardPanel) dashboardPanel).getLblPrivilegesLogo();
        lblPrivilegesLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblPrivilegesLogoMouseClicked(evt);
            }
        });

        lblAccessesLogo = ((DashboardPanel) dashboardPanel).getLblAccessLogo();
        lblAccessesLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblAccessLogoMouseClicked(evt);
            }
        });

        lblPositionsLogo = ((DashboardPanel) dashboardPanel).getLblPositions();
        lblPositionsLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblPositionsMouseClicked(evt);
            }
        });

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private void lblKindProductLogoMouseClicked(MouseEvent evt) {
        cardLayout.show(this.mainPanel, "kindProductsPanel");
    }

    private void lblProductLogoMouseClicked(MouseEvent evt) {
        cardLayout.show(this.mainPanel, "productsPanel");
    }

    private void lblCredentialsLogoMouseClicked(MouseEvent evt) {
        cardLayout.show(this.mainPanel, "credentialsPanel");
    }

    private void lblEmployeesMouseClicked(MouseEvent evt) {
        cardLayout.show(this.mainPanel, "employeesPanel");
    }

    private void lblDepartmentsLogoMouseClicked(MouseEvent evt) {
        cardLayout.show(this.mainPanel, "departmentsPanel");
    }

    private void lblHierarchyLogoMouseClicked(MouseEvent evt) {
        cardLayout.show(this.mainPanel, "hierarchiesPanel");
    }

    private void lblPrivilegesLogoMouseClicked(MouseEvent evt) {
        cardLayout.show(this.mainPanel, "privilegesPanel");
    }

    private void lblAccessLogoMouseClicked(MouseEvent evt) {
        cardLayout.show(this.mainPanel, "accessesPanel");
    }

    private void lblPositionsMouseClicked(MouseEvent evt) {
        cardLayout.show(this.mainPanel, "positionsPanel");
    }

    private void exportItemActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "En construcción");
    }

    private void printItemActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "En construcción");
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
        String panel = Carousel.back(Carousel.getActivePanel(mainPanel));
        System.out.println(panel);
        cardLayout.show(this.mainPanel, panel);
    }

    private void btnNextActionPerformed(ActionEvent evt) {
        String panel = Carousel.next(Carousel.getActivePanel(mainPanel));
        System.out.println(panel);
        cardLayout.show(this.mainPanel, panel);
    }
}