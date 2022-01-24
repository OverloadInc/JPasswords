package over.view.cards;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * <code>CredentialsPanel</code> class.
 * @author Overload Inc.
 * @version %I%, %G%
 */
public class CredentialsPanel extends JPanel {
    private Box.Filler credentialsFiller1;
    private Box.Filler credentialsFiller2;
    private Box.Filler credentialsFiller3;
    private JPanel credentialPanel;
    private JPanel existingCredentialsPanel;

    public CredentialsPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    public void initComponents() {
        credentialsFiller1 = new Box.Filler(new Dimension(0, 50), new Dimension(0, 50), new Dimension(0, 50));
        credentialPanel = new JPanel();
        credentialsFiller2 = new Box.Filler(new Dimension(0, 50), new Dimension(0, 50), new Dimension(0, 50));
        existingCredentialsPanel = new JPanel();
        credentialsFiller3 = new Box.Filler(new Dimension(0, 50), new Dimension(0, 50), new Dimension(0, 50));

        setBackground(new Color(255, 255, 255));
        setBorder(BorderFactory.createTitledBorder(null, "Credenciales", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        setMinimumSize(new Dimension(800, 600));
        setName("credentialsPanel");
        setOpaque(false);
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        credentialsFiller1.setName("credentialsFiller1"); 
        add(credentialsFiller1);

        credentialPanel.setBorder(BorderFactory.createTitledBorder("Agregar credencial"));
        credentialPanel.setName("credentialPanel");
        credentialPanel.setOpaque(false);
        credentialPanel.setMinimumSize(new Dimension(750, 150));
        credentialPanel.setPreferredSize(new Dimension(750, 150));

        GroupLayout credentialsPanelLayout = new GroupLayout(credentialPanel);
        credentialPanel.setLayout(credentialsPanelLayout);
        credentialsPanelLayout.setHorizontalGroup(credentialsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 800, Short.MAX_VALUE));
        credentialsPanelLayout.setVerticalGroup(credentialsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 200, Short.MAX_VALUE));

        add(credentialPanel);

        credentialsFiller2.setName("credentialsFiller2"); 
        add(credentialsFiller2);

        existingCredentialsPanel.setBorder(BorderFactory.createTitledBorder("Credenciales existentes"));
        existingCredentialsPanel.setName("existingCredentialsPanel"); 
        existingCredentialsPanel.setOpaque(false);
        existingCredentialsPanel.setMinimumSize(new Dimension(750, 300));
        existingCredentialsPanel.setPreferredSize(new Dimension(750, 300));

        GroupLayout existingCredentialsPanelLayout = new GroupLayout(existingCredentialsPanel);
        existingCredentialsPanel.setLayout(existingCredentialsPanelLayout);
        existingCredentialsPanelLayout.setHorizontalGroup(existingCredentialsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 800, Short.MAX_VALUE));
        existingCredentialsPanelLayout.setVerticalGroup(existingCredentialsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 250, Short.MAX_VALUE));

        add(existingCredentialsPanel);

        credentialsFiller3.setName("credentialsFiller3"); 
        add(credentialsFiller3);
    }
}