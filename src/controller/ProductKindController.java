package controller;

import model.pojo.KindOfProduct;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class ProductKindController implements Controller {

    private JTextField txtProduct;
    private JButton btnAddProduct;

    public ProductKindController(List components) {
        txtProduct = (JTextField)components.get(0);
        btnAddProduct = (JButton)components.get(1);
    }

    public ArrayList<KindOfProduct> getAllKindOfProduct() {
        return new KindOfProduct().getAllKindOfProduct();
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

        if(keyCode == 10 || keyCode == 38 || keyCode == 40)
            switch(keySource){
                case "txtProduct": btnAddProduct.requestFocusInWindow(); break;
                case "btnAddProduct": txtProduct.requestFocusInWindow(); selectText("txtProduct"); break;
            }
    }
}