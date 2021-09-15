package over.view;

import over.controller.FontEditor;
import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    private JPanel aboutPanel;
    private JScrollPane aboutScroll;
    private JPanel creditsPanel;
    private JScrollPane creditsScroll;
    private JLabel lblLogo;
    private JPanel softwarePanel;
    private JTabbedPane tabbedPane;
    private JTextPane txtAbout;
    private JTextPane txtCredits;

    public About() {
        initComponents();
        setAbout();
    }
    
    public void setAbout() {
        String application = "JPasswords";
        String description = " is an open source application and is licensed under GNU General Public License v3.";
        String team = "Developer";
        String developer_name = "\tJuan-Alberto Hernández-Martínez";
        String contact = "\nContacto";
        String email = "\tjuan.alberto.hernandez.martinez@gmail.com";

        try {
            FontEditor fontEditor = new FontEditor();

            fontEditor.setBold(txtAbout, application);
            fontEditor.setSimple(txtAbout, description);
            fontEditor.setBold(txtCredits, team);
            fontEditor.setSimple(txtCredits, developer_name);
            fontEditor.setBold(txtCredits, contact);
            fontEditor.setSimple(txtCredits, email);
        }
        catch(Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acerca de");
        setMinimumSize(new Dimension(400, 400));
        setName("frmAbout");
        setResizable(false);

        lblLogo = new JLabel();
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setMaximumSize(new Dimension(400, 300));
        lblLogo.setMinimumSize(new Dimension(400, 300));
        lblLogo.setName("lblLogo");
        lblLogo.setPreferredSize(new Dimension(400, 300));

        softwarePanel = new JPanel();
        softwarePanel.setMaximumSize(new Dimension(400, 300));
        softwarePanel.setMinimumSize(new Dimension(400, 300));
        softwarePanel.setName("softwarePanel");
        softwarePanel.setPreferredSize(new Dimension(400, 300));
        softwarePanel.setLayout(new BorderLayout());
        softwarePanel.add(lblLogo, BorderLayout.CENTER);

        getContentPane().add(softwarePanel, BorderLayout.CENTER);

        txtAbout = new JTextPane();
        txtAbout.setName("txtAbout");

        aboutScroll = new JScrollPane();
        aboutScroll.setName("aboutScroll");
        aboutScroll.setViewportView(txtAbout);

        aboutPanel = new JPanel();
        aboutPanel.setMaximumSize(new Dimension(400, 100));
        aboutPanel.setMinimumSize(new Dimension(400, 100));
        aboutPanel.setName("aboutPanel");
        aboutPanel.setPreferredSize(new Dimension(400, 100));
        aboutPanel.setLayout(new BorderLayout());
        aboutPanel.add(aboutScroll, BorderLayout.CENTER);

        txtCredits = new JTextPane();
        txtCredits.setName("txtCredits");

        creditsScroll = new JScrollPane();
        creditsScroll.setName("creditsScroll");
        creditsScroll.setViewportView(txtCredits);

        creditsPanel = new JPanel();
        creditsPanel.setMaximumSize(new Dimension(400, 100));
        creditsPanel.setMinimumSize(new Dimension(400, 100));
        creditsPanel.setName("creditsPanel");
        creditsPanel.setPreferredSize(new Dimension(400, 100));
        creditsPanel.setLayout(new BorderLayout());
        creditsPanel.add(creditsScroll, BorderLayout.CENTER);

        tabbedPane = new JTabbedPane();
        tabbedPane.setName("tabbedPane");
        tabbedPane.addTab("Acerca de", aboutPanel);
        tabbedPane.addTab("Créditos", creditsPanel);

        getContentPane().add(tabbedPane, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }
}