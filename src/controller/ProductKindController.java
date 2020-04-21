package controller;

import model.pojo.KindOfProduct;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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

    public ArrayList<KindOfProduct> getAllKindOfProduct() {
        return new KindOfProduct().getAllKindOfProduct();
    }

    public void addKindOfProduct() {
        KindOfProduct kindOfProduct = new KindOfProduct();
        kindOfProduct.setId(0);
        kindOfProduct.setName(txtProduct.getText().trim());
        kindOfProduct.addKindOfProduct();
    }

    public void refreshExistingProductsList() {
        DefaultListModel nameListModel = new DefaultListModel();

        for(KindOfProduct current : getAllKindOfProduct())
            nameListModel.addElement(current);

        existingProductsList.setModel(nameListModel);
    }

    @Override
    public void selectText(String name) {
        switch(name) {
            case "txtProduct" : txtProduct.setSelectionStart(0); txtProduct.setSelectionEnd(txtProduct.getText().length()); break;
        }
    }

    @Override
    public void setFocus(KeyEvent evt) {
        String keySource = getKeySource(evt);
        int keyCode = evt.getKeyCode();

        if(keyCode == 37 || keyCode == 39)
            switch(keySource){
                case "txtProduct": btnAddProduct.requestFocusInWindow(); break;
                case "btnAddProduct": txtProduct.requestFocusInWindow(); selectText("txtProduct"); break;
            }
        else if(keyCode == 10) {
            switch(keySource){
                case "txtProduct": btnAddProduct.requestFocusInWindow(); break;
                case "btnAddProduct":
                    addKindOfProduct();
                    refreshExistingProductsList();
                    txtProduct.requestFocusInWindow();
                    break;
            }
        }
    }
}