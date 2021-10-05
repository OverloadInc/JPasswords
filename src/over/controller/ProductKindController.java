package over.controller;

import over.model.pojo.KindOfProduct;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ProductKindController implements Controller {
    private JTextField txtKindProduct;
    private JButton btnAddKindProduct;
    private JList existingKindProductsList;

    public ProductKindController(List components) {
        txtKindProduct = (JTextField)components.get(0);
        btnAddKindProduct = (JButton)components.get(1);
        existingKindProductsList = (JList)components.get(2);
    }

    public void addKindOfProduct() {
        String productName = txtKindProduct.getText().trim();

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
        KindOfProduct kindOfProduct = (KindOfProduct) existingKindProductsList.getSelectedValue();

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
        KindOfProduct kindOfProduct = (KindOfProduct) existingKindProductsList.getSelectedValue();

        if(kindOfProduct != null)
            kindOfProduct.deleteKindOfProduct();
        else
            JOptionPane.showMessageDialog(null, "Selecciona un tipo de producto");
    }

    public void refreshExistingKindProductsList() {
        DefaultListModel nameListModel = new DefaultListModel();

        for(KindOfProduct current : new KindOfProduct().getAllKindOfProduct())
            nameListModel.addElement(current);

        existingKindProductsList.setModel(nameListModel);
    }

    @Override
    public void selectText(String name) {
        switch(name) {
            case "txtProduct" :
                txtKindProduct.setSelectionStart(0);
                txtKindProduct.setSelectionEnd(txtKindProduct.getText().length());
                break;
        }
    }

    @Override
    public void setFocus(KeyEvent evt) {
        String keySource = getKeySource(evt);
        int keyCode = evt.getKeyCode();

        if(keyCode == 37 || keyCode == 39)
            switch(keySource){
                case "txtKindProduct":
                    btnAddKindProduct.requestFocusInWindow();
                    break;
                case "btnAddKindProduct":
                    txtKindProduct.requestFocusInWindow();
                    selectText("txtKindProduct");
                    break;
            }
        else if(keyCode == 10) {
            switch(keySource){
                case "btnAddKindProduct":
                    addKindOfProduct();
                    refreshExistingKindProductsList();
                    break;
                case "btnModifyKindProduct":
                    updateKindOfProduct();
                    refreshExistingKindProductsList();
                    break;
                case "btnDeleteKindProduct":
                    deleteKindOfProduct();
                    refreshExistingKindProductsList();
                    break;
            }

            txtKindProduct.setText("");
            txtKindProduct.requestFocusInWindow();
        }
    }
}