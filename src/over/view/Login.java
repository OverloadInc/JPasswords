package over.view;

import over.controller.BackgroundImage;
import over.controller.LoginController;
import over.model.pojo.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Login extends JFrame {
    private JButton btnLogin;
    private JLabel lblLogo;
    private JLabel lblPassword;
    private JLabel lblUser;
    private JPanel loginPanel;
    private Box.Filler northFiller;
    private Box.Filler southFiller;
    private JPasswordField txtPassword;
    private JTextField txtUser;
    private final Image backgroundImage;
    private List<Component> componentList;
    private LoginController loginController;
    
    public Login() {                
        backgroundImage = BackgroundImage.request();
        
        initComponents();

        componentList = new ArrayList<>();
        componentList.add(txtUser);
        componentList.add(txtPassword);
        componentList.add(btnLogin);

        loginController = new LoginController(componentList);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, null);
            }
        };
        northFiller = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(0, 0));
        lblLogo = new JLabel();
        lblUser = new JLabel();
        txtUser = new JTextField();
        lblPassword = new JLabel();
        txtPassword = new JPasswordField();
        btnLogin = new JButton();
        southFiller = new Box.Filler(new Dimension(0, 15), new Dimension(0, 15), new Dimension(0, 15));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Holiwallet v0.1 - Inicio de sesión");
        setMinimumSize(new Dimension(300, 450));
        setName("frmLogin"); 
        setResizable(false);

        loginPanel.setBackground(new Color(255, 255, 255));
        loginPanel.setMinimumSize(new Dimension(300, 450));
        loginPanel.setName("loginPanel"); 
        loginPanel.setPreferredSize(new Dimension(300, 450));
        loginPanel.setLayout(new GridBagLayout());

        northFiller.setName("northFiller"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        loginPanel.add(northFiller, gridBagConstraints);

        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/login/holiday_shield.png"))); 
        lblLogo.setName("lblLogo"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        loginPanel.add(lblLogo, gridBagConstraints);

        lblUser.setText("Usuario");
        lblUser.setName("lblUser"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        loginPanel.add(lblUser, gridBagConstraints);

        txtUser.setMinimumSize(new Dimension(200, 30));
        txtUser.setName("txtUser"); 
        txtUser.setPreferredSize(new Dimension(200, 30));
        txtUser.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        loginPanel.add(txtUser, gridBagConstraints);

        lblPassword.setText("Clave");
        lblPassword.setName("lblPassword"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        loginPanel.add(lblPassword, gridBagConstraints);

        txtPassword.setMinimumSize(new Dimension(200, 30));
        txtPassword.setName("txtPassword"); 
        txtPassword.setPreferredSize(new Dimension(200, 30));
        txtPassword.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        loginPanel.add(txtPassword, gridBagConstraints);

        btnLogin.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/login/login.png"))); 
        btnLogin.setText("Entrar");
        btnLogin.setHorizontalTextPosition(SwingConstants.LEFT);
        btnLogin.setName("btnLogin"); 
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        loginPanel.add(btnLogin, gridBagConstraints);

        southFiller.setName("southFiller"); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        loginPanel.add(southFiller, gridBagConstraints);

        getContentPane().add(loginPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private void btnLoginActionPerformed(ActionEvent evt) {
        try {
            String userName = txtUser.getText();
            String userPassword = loginController.encryptPassword(txtPassword.getPassword());

            User user = new User(userName, userPassword);

            if (loginController.login(user)) {
                new Dashboard(user).setVisible(true);
                this.setVisible(false);
            }
            else
                JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta");
        }
        catch(Exception e) {            
        }
    }

    private void txtUserKeyPressed(KeyEvent evt) {
        loginController.setFocus(evt);
    }

    private void txtPasswordKeyPressed(KeyEvent evt) {
        loginController.setFocus(evt);
    }

    private void btnLoginKeyPressed(KeyEvent evt) {
        loginController.setFocus(evt);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}