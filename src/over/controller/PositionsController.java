package over.controller;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class PositionsController implements Controller {
    private JTextField txtPositionName;
    private JComboBox<String> cmbDepartments;
    private JComboBox<String> cmbHierarchies;
    private JButton btnAddPosition;
    private JTable existingPositionsTable;

    public PositionsController(List components) {
        txtPositionName = (JTextField) components.get(0);
        cmbDepartments = (JComboBox) components.get(1);
        cmbHierarchies = (JComboBox) components.get(2);
        btnAddPosition = (JButton) components.get(3);
        existingPositionsTable = (JTable) components.get(4);
    }

    public void addPosition() {

    }

    public void updatePosition() {

    }

    public void deletePosition() {

    }

    public void refreshExistingPositionsTable() {

    }

    @Override
    public void selectText(String name) {
        switch(name) {
            case "txtPositionName" :
                txtPositionName.setSelectionStart(0);
                txtPositionName.setSelectionEnd(txtPositionName.getText().length());
                break;
        }
    }

    @Override
    public void setFocus(KeyEvent evt) {
        String keySource = getKeySource(evt);
        int keyCode = evt.getKeyCode();

        if(keyCode == 37 || keyCode == 39)
            switch(keySource){
                case "txtPositionName":
                    btnAddPosition.requestFocusInWindow();
                    break;
                case "btnAddPosition":
                    txtPositionName.requestFocusInWindow();
                    selectText("txtPositionName");
                    break;

            }
        else if(keyCode == 10) {
            switch(keySource){
                case "btnAddPosition":
                    addPosition();
                    refreshExistingPositionsTable();
                    break;
                case "btnModifyPosition":
                    updatePosition();
                    refreshExistingPositionsTable();
                    break;
                case "btnDeletePosition":
                    deletePosition();
                    refreshExistingPositionsTable();
                    break;
            }

            txtPositionName.setText("");
            txtPositionName.requestFocusInWindow();
        }
    }
}