package over.view.cards;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CredentialsPanel extends JPanel {

    public void CredentialsPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    public void initComponents() {
        GridBagConstraints gridBagConstraints;

        setBackground(new Color(255, 255, 255));
        setBorder(BorderFactory.createTitledBorder(null, "Credenciales", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        setMinimumSize(new Dimension(800, 600));
        setName("credentialsPanel");
        setOpaque(false);
        setPreferredSize(new Dimension(800, 600));
    }
}