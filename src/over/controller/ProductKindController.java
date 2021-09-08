package over.controller;

import over.model.pojo.KindOfProduct;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ProductKindController implements Controller {
    private JTextField txtProduct;
    private JButton btnAddProduct;
    private JList existingProductsList;

    public ProductKindController(List components) {
        txtProduct = (JTextField)components.get(0);
        btnAddProduct = (JButton)components.get(1);
        existingProductsList = (JList)components.get(2);
    }

    public void addKindOfProduct() {
        String productName = txtProduct.getText().trim();

        if(!productName.isEmpty()) {
            KindOfProduct kindOfProduct = new KindOfProduct();
            kindOfProduct.setId(0);
            kindOfProduct.setName(productName);

            kindOfProduct.addKindOfProduct();
        }
        else
            JOptionPane.showMessageDialog(null, "Introduce un nombre válido");
    }

    public void updateKindOfProduct() {
        KindOfProduct kindOfProduct = (KindOfProduct)existingProductsList.getSelectedValue();

        if(kindOfProduct != null) {
            String newProductName = JOptionPane.showInputDialog("Introduce el tipo de producto deseado");

            if(!newProductName.isEmpty()) {
                kindOfProduct.setName(newProductName);

                kindOfProduct.updateKindOfProduct();
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Selecciona un tipo de producto");
    }

    public void deleteKindOfProduct() {
        KindOfProduct kindOfProduct = (KindOfProduct)existingProductsList.getSelectedValue();

        if(kindOfProduct != null)
            kindOfProduct.deleteKindOfProduct();
        else
            JOptionPane.showMessageDialog(null, "Selecciona un tipo de producto");
    }

    public void refreshExistingProductsList() {
        DefaultListModel nameListModel = new DefaultListModel();

        for(KindOfProduct current : new KindOfProduct().getAllKindOfProduct())
            nameListModel.addElement(current);

        existingProductsList.setModel(nameListModel);
    }

    @Override
    public void selectText(String name) {
        switch(name) {
            case "txtProduct" :
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
                    addKindOfProduct();
                    refreshExistingProductsList();
                    txtProduct.setText("");
                    txtProduct.requestFocusInWindow();
                    break;
            }
        }
    }
}