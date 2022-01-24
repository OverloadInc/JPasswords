package over.controller;

import over.model.pojo.Privilege;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * <code>PrivilegeController</code> class.
 * @author Overload Inc.
 * @version %I%, %G%
 */
public class PrivilegeController implements Controller {
    JTextField txtPrivilege;
    JButton btnAddPrivilege, btnModifyPrivilege, btnDeletePrivilege;
    JList existingPrivilegesList;

    public PrivilegeController(List components) {
        txtPrivilege = (JTextField)components.get(0);
        btnAddPrivilege = (JButton)components.get(1);
        btnModifyPrivilege = (JButton)components.get(2);
        btnDeletePrivilege = (JButton)components.get(3);
        existingPrivilegesList = (JList)components.get(4);
    }

    public void addPrivilege() {
        String privilegeName = txtPrivilege.getText().trim();

        if(!privilegeName.isEmpty()) {
            Privilege privilege = new Privilege();
            privilege.setId(0);
            privilege.setName(privilegeName);

            privilege.addPrivilege();
        }
        else
            JOptionPane.showMessageDialog(null, "Introduce un nombre válido");
    }

    public void updatePrivilege() {
        Privilege privilege = (Privilege)existingPrivilegesList.getSelectedValue();

        if(privilege != null) {
            String newPrivilegeName = txtPrivilege.getText().trim();

            if(!newPrivilegeName.isEmpty()) {
                privilege.setName(newPrivilegeName);

                privilege.updatePrivilege();
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Selecciona un privilegio");
    }

    public void deletePrivilege() {
        Privilege privilege = (Privilege)existingPrivilegesList.getSelectedValue();

        if(privilege != null)
            privilege.deletePrivilege();
        else
            JOptionPane.showMessageDialog(null, "Selecciona un privilegio");
    }

    public void setPrivilegeInformation() {
        String name = ((Privilege) existingPrivilegesList.getSelectedValue()).getName();

        txtPrivilege.setText(name);
    }

    public void refreshExistingPrivilegeList() {
        DefaultListModel nameListModel = new DefaultListModel();

        for(Privilege current : new Privilege().getAllPrivileges())
            nameListModel.addElement(current);

        existingPrivilegesList.setModel(nameListModel);
    }

    @Override
    public void selectText(String name) {
        switch(name) {
            case "txtPrivilege" :
                txtPrivilege.setSelectionStart(0);
                txtPrivilege.setSelectionEnd(txtPrivilege.getText().length());
                break;
        }
    }

    @Override
    public void setFocus(KeyEvent evt) {
        String keySource = getKeySource(evt);
        int keyCode = evt.getKeyCode();

        if(keyCode == 37 || keyCode == 39)
            switch(keySource){
                case "txtPrivilege":
                    btnAddPrivilege.requestFocusInWindow();
                    break;
                case "btnAddPrivilege":
                    txtPrivilege.requestFocusInWindow();
                    selectText("txtPrivilege");
                    break;
            }
        else if(keyCode == 10) {
            switch(keySource){
                case "btnAddPrivilege":
                    addPrivilege();
                    break;
                case "btnModifyPrivilege":
                    updatePrivilege();
                    break;
                case "btnDeletePrivilege":
                    deletePrivilege();
                    break;
            }

            refreshExistingPrivilegeList();

            txtPrivilege.setText("");
            txtPrivilege.requestFocusInWindow();
        }
    }
}