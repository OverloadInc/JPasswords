package over.controller;

import over.model.pojo.KindOfProduct;
import over.model.pojo.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ProductController implements Controller {
    private JTextField txtProduct;
    private JComboBox cmbKindProduct;
    private JButton btnAddProduct;
    private JTable existingProductsTable;
    private JButton btnModifyProduct;
    private JButton btnDeleteProduct;
    private JComboBox cmbType;
    private JTextField txtName;

    public ProductController(List components) {
        txtProduct = (JTextField) components.get(0);
        cmbKindProduct = (JComboBox) components.get(1);
        btnAddProduct = (JButton) components.get(2);
        existingProductsTable = (JTable) components.get(3);
        btnModifyProduct = (JButton) components.get(4);
        btnDeleteProduct = (JButton) components.get(5);
    }

    public void addProduct() {
        String name = txtProduct.getText().trim();
        KindOfProduct kind = (KindOfProduct) cmbKindProduct.getSelectedItem();

        if (!name.isEmpty() && kind != null) {
            Product product = new Product();

            product.setId(0);
            product.setName(name);
            product.setKindOfProduct(kind);

            product.addProduct();
        }
        else
            JOptionPane.showMessageDialog(null, "Introduce un nombre válido");
    }

    public void updateProduct() {
        int row = existingProductsTable.getSelectedRow();
        int idProduct = Integer.parseInt(existingProductsTable.getValueAt(row, 0).toString());

        if(row >= 0) {
            int result = JOptionPane.showConfirmDialog(null, getUpdateProductPanel(), "Actualización de producto", JOptionPane.OK_CANCEL_OPTION);
            String name = txtName.getText().trim();

            if(result == JOptionPane.OK_OPTION && !name.isEmpty()) {
                Product product = new Product();

                product.setId(idProduct);
                product.setName(name);
                product.setKindOfProduct((KindOfProduct)cmbType.getSelectedItem());

                product.updateProduct();
            }
            else
                JOptionPane.showMessageDialog(null, "Introduce un nombre válido");
        }
        else
            JOptionPane.showMessageDialog(null, "Selecciona un producto");
    }

    public void deleteProduct() {
        int row = existingProductsTable.getSelectedRow();

        if(row >= 0) {
            int idProduct = Integer.parseInt(existingProductsTable.getValueAt(row, 0).toString());

            Product product = new Product();
            product.setId(idProduct);

            product.deleteProduct();
        }
        else
            JOptionPane.showMessageDialog(null, "Selecciona un producto");
    }

    public void refreshExistingProductsTable() {
        DefaultTableModel tableModel = new DefaultTableModel(0, 0);
        tableModel.setColumnIdentifiers(new String[]{"Id", "Nombre", "Tipo"});

        existingProductsTable.setModel(tableModel);

        for(Product current : new Product().getAllProducts()) {
            tableModel.addRow(new String[]{current.getId() + "", current.getName(), current.getKindOfProduct() + ""});
        }
    }

    public void refreshKindOfProductsList() {
        cmbKindProduct.removeAllItems();

        for (KindOfProduct kindOfProduct : new KindOfProduct().getAllKindOfProduct()) {
            cmbKindProduct.addItem(kindOfProduct);
        }
    }

    private void updateKindOfProductsList() {
        cmbType.removeAllItems();

        for (KindOfProduct kindOfProduct : new KindOfProduct().getAllKindOfProduct()) {
            cmbType.addItem(kindOfProduct);
        }
    }

    private JPanel getUpdateProductPanel() {
        cmbType = new JComboBox<>();
        JLabel lblName = new JLabel();
        JLabel lblType = new JLabel();
        txtName = new JTextField();
        Box.Filler southFiller = new Box.Filler(new Dimension(0, 0), new Dimension(0, 30), new Dimension(0, 32767));
        JPanel updatePanel = new JPanel();

        updateKindOfProductsList();

        GridBagConstraints gridBagConstraints;

        updatePanel.setBackground(new Color(240, 240, 240));
        updatePanel.setMaximumSize(new Dimension(400, 300));
        updatePanel.setMinimumSize(new Dimension(400, 300));
        updatePanel.setName("updatePanel");
        updatePanel.setLayout(new GridBagLayout());

        lblName.setText("Nuevo nombre");
        lblName.setName("lblName");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 10);
        updatePanel.add(lblName, gridBagConstraints);

        txtName.setMaximumSize(new Dimension(200, 30));
        txtName.setMinimumSize(new Dimension(200, 30));
        txtName.setName("txtName");
        txtName.setPreferredSize(new Dimension(200, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(0, 10, 10, 0);
        updatePanel.add(txtName, gridBagConstraints);

        lblType.setText("Tipo de producto");
        lblType.setName("lblType");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 0, 0, 10);
        updatePanel.add(lblType, gridBagConstraints);

        cmbType.setName("cmbType");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        updatePanel.add(cmbType, gridBagConstraints);

        southFiller.setName("southFiller");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        updatePanel.add(southFiller, gridBagConstraints);
        
        return updatePanel;
    }

    @Override
    public void selectText(String name) {
        switch (name) {
            case "txtProduct":
                txtProduct.setSelectionStart(0);
                txtProduct.setSelectionEnd(txtProduct.getText().length());
                break;
        }
    }

    @Override
    public void setFocus(KeyEvent evt) {
        String keySource = getKeySource(evt);
        int keyCode = evt.getKeyCode();

        if(keyCode == 37 || keyCode == 39)
            switch(keySource){
                case "txtProduct":
                    btnAddProduct.requestFocusInWindow();
                    break;
                case "btnAddProduct":
                    txtProduct.requestFocusInWindow();
                    selectText("txtProduct");
                    break;
            }
        else if(keyCode == 10) {
            switch(keySource){
                case "btnAddProduct":
                    addProduct();
                    refreshExistingProductsTable();
                    break;
                case "btnModifyProduct":
                    updateProduct();
                    refreshExistingProductsTable();
                    break;
                case "btnDeleteProduct":
                    deleteProduct();
                    refreshExistingProductsTable();
                    break;
            }

            txtProduct.setText("");
            txtProduct.requestFocusInWindow();
        }
    }
}