package over.view.cards;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * <code>AccessesPanel</code> class.
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
public class AccessesPanel extends JPanel {

    public AccessesPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    public void initComponents() {
        GridBagConstraints gridBagConstraints;

        setBackground(new Color(255, 255, 255));
        setBorder(BorderFactory.createTitledBorder(null, "Accesos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        setMinimumSize(new Dimension(800, 600));
        setName("accessesPanel");
        setOpaque(false);
        setPreferredSize(new Dimension(800, 600));

    }
}