package over.controller;

import over.model.pojo.KindOfProduct;
import over.model.pojo.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class ProductController implements Controller {
    private JTextField txtProduct;
    private JComboBox cmbKindProduct;
    private JButton btnAddProduct;
    private JTable existingProductsTable;
    private JButton btnModifyProduct;
    private JButton btnDeleteProduct;

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

        if(row >= 0) {
            int idProduct = Integer.parseInt(existingProductsTable.getValueAt(row, 0).toString());
            String name = txtProduct.getText().trim();

            if(!name.isEmpty()) {
                Product product = new Product();

                product.setId(idProduct);
                product.setName(name);
                product.setKindOfProduct((KindOfProduct)cmbKindProduct.getSelectedItem());

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
        ArrayList<Product> products = new Product().getAllProducts();

        DefaultTableModel tableModel = new DefaultTableModel(0, 0);
        tableModel.setColumnIdentifiers(new Object[]{"Id", "Nombre", "Tipo"});

        existingProductsTable.setModel(tableModel);

        for(Product current : products)
            tableModel.addRow(new Object[]{current.getId(), current.getName(), current.getKindOfProduct()});
    }

    public void refreshKindOfProductsList() {
        ArrayList<KindOfProduct> kindOfProducts = new KindOfProduct().getAllKindOfProduct();

        cmbKindProduct.removeAllItems();

        for (KindOfProduct kindOfProduct : kindOfProducts)
            cmbKindProduct.addItem(kindOfProduct);
    }

    public void setProductInformation() {
        String productName = existingProductsTable.getValueAt(existingProductsTable.getSelectedRow(), 1).toString();
        int idKindProduct = ((KindOfProduct)existingProductsTable.getValueAt(existingProductsTable.getSelectedRow(), 2)).getId();

        txtProduct.setText(productName);
        cmbKindProduct.setSelectedIndex(idKindProduct - 1);
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