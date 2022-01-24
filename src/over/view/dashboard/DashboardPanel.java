package over.view.dashboard;

import javax.swing.*;
import java.awt.*;

/**
 * <code>DashboardPanel</code> class.
 * @author Overload Inc.
 * @version %I%, %G%
 */
public class DashboardPanel extends JPanel {

    private JLabel lblAccessLogo;
    private JLabel lblCredentialsLogo;
    private JLabel lblDepartmentsLogo;
    private JLabel lblEmployees;
    private JLabel lblHierarchyLogo;
    private JLabel lblKindProductLogo;
    private JLabel lblPrivilegesLogo;
    private JLabel lblProductLogo;
    private JLabel lblPositions;

    public DashboardPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    public void initComponents() {
        GridBagConstraints gridBagConstraints;

        lblKindProductLogo = new JLabel();
        lblProductLogo = new JLabel();
        lblCredentialsLogo = new JLabel();
        lblEmployees = new JLabel();
        lblDepartmentsLogo = new JLabel();
        lblHierarchyLogo = new JLabel();
        lblPrivilegesLogo = new JLabel();
        lblAccessLogo = new JLabel();
        lblPositions = new JLabel();


        setBackground(new Color(255, 255, 255));
        setMinimumSize(new Dimension(800, 600));
        setName("dashboardPanel");
        setOpaque(false);
        setPreferredSize(new Dimension(800, 600));
        setLayout(new GridBagLayout());

        lblKindProductLogo.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/kind_of_product.png")));
        lblKindProductLogo.setText("Tipo de productos");
        lblKindProductLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblKindProductLogo.setName("lblKindProductLogo");
        lblKindProductLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 1.0;
        add(lblKindProductLogo, gridBagConstraints);

        lblProductLogo.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/products.png")));
        lblProductLogo.setText("Productos");
        lblProductLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblProductLogo.setName("lblProductLogo");
        lblProductLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 1.0;
        add(lblProductLogo, gridBagConstraints);

        lblCredentialsLogo.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/credentials.png")));
        lblCredentialsLogo.setText("Credenciales");
        lblCredentialsLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblCredentialsLogo.setName("lblCredentialsLogo");
        lblCredentialsLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 1.0;
        add(lblCredentialsLogo, gridBagConstraints);

        lblEmployees.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/users.png")));
        lblEmployees.setText("Empleados");
        lblEmployees.setHorizontalTextPosition(SwingConstants.CENTER);
        lblEmployees.setName("lblEmployees");
        lblEmployees.setVerticalTextPosition(SwingConstants.BOTTOM);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 1.0;
        add(lblEmployees, gridBagConstraints);

        lblDepartmentsLogo.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/departments.png")));
        lblDepartmentsLogo.setText("Departamentos");
        lblDepartmentsLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblDepartmentsLogo.setName("lblDepartmentsLogo");
        lblDepartmentsLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 1.0;
        add(lblDepartmentsLogo, gridBagConstraints);

        lblHierarchyLogo.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/hierarchy.png")));
        lblHierarchyLogo.setText("Jerarquías");
        lblHierarchyLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblHierarchyLogo.setName("lblHierarchyLogo");
        lblHierarchyLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 1.0;
        add(lblHierarchyLogo, gridBagConstraints);

        lblPrivilegesLogo.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/privileges.png")));
        lblPrivilegesLogo.setText("Privilegios");
        lblPrivilegesLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblPrivilegesLogo.setName("lblPrivilegesLogo");
        lblPrivilegesLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 1.0;
        add(lblPrivilegesLogo, gridBagConstraints);

        lblAccessLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblAccessLogo.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/access.png")));
        lblAccessLogo.setText("Accesos");
        lblAccessLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblAccessLogo.setName("lblAccessLogo");
        lblAccessLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 1.0;
        add(lblAccessLogo, gridBagConstraints);

        lblPositions.setHorizontalAlignment(SwingConstants.CENTER);
        lblPositions.setIcon(new ImageIcon(getClass().getResource("/over/resources/img/dashboard/positions.png")));
        lblPositions.setText("Puestos de trabajo");
        lblPositions.setHorizontalTextPosition(SwingConstants.CENTER);
        lblPositions.setName("lblPositions");
        lblPositions.setVerticalTextPosition(SwingConstants.BOTTOM);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 1.0;
        add(lblPositions, gridBagConstraints);
    }

    public JLabel getLblKindProductLogo() {
        return lblKindProductLogo;
    }

    public JLabel getLblProductLogo() {
        return lblProductLogo;
    }

    public JLabel getLblCredentialsLogo() {
        return lblCredentialsLogo;
    }

    public JLabel getLblEmployees() {
        return lblEmployees;
    }

    public JLabel getLblDepartmentsLogo() {
        return lblDepartmentsLogo;
    }

    public JLabel getLblHierarchyLogo() {
        return lblHierarchyLogo;
    }

    public JLabel getLblPrivilegesLogo() {
        return lblPrivilegesLogo;
    }

    public JLabel getLblAccessLogo() {
        return lblAccessLogo;
    }

    public JLabel getLblPositions() {
        return lblPositions;
    }
}