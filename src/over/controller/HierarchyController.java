package over.controller;

import over.model.pojo.Hierarchy;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * <code>HierarchyController</code> class.
 * @author Overload Inc.
 * @version %I%, %G%
 */
public class HierarchyController implements Controller {
    private JTextField txtHierarchy;
    private JButton btnHierarchy, btnModifyHierarchy, btnDeleteHierarchy;
    private JTable existingHierarchiesTable;

    public HierarchyController(List components) {
        txtHierarchy = (JTextField)components.get(0);
        btnHierarchy = (JButton)components.get(1);
        btnModifyHierarchy = (JButton)components.get(2);
        btnDeleteHierarchy = (JButton)components.get(3);
        existingHierarchiesTable = (JTable)components.get(4);
    }

    public void addHierarchy() {
        String hierarchyName = txtHierarchy.getText().trim();

        if(!hierarchyName.isEmpty()) {
            Hierarchy hierarchy = new Hierarchy();
            hierarchy.setId(0);
            hierarchy.setName(hierarchyName);

            hierarchy.addHierarchy();
        }
        else
            JOptionPane.showMessageDialog(null, "Introduce un nombre válido");
    }

    public void updateHierarchy() {
        int row = existingHierarchiesTable.getSelectedRow();

        if(row >= 0) {
            String newHierarchyName = txtHierarchy.getText().trim();
            int newHierarchyId = Integer.parseInt(existingHierarchiesTable.getValueAt(row, 0).toString());

            if(!newHierarchyName.isEmpty()) {
                Hierarchy hierarchy = new Hierarchy();
                hierarchy.setName(newHierarchyName);
                hierarchy.setId(newHierarchyId);

                hierarchy.updateHierarchy();
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Selecciona un tipo de jerarquía");
    }

    public void deleteHierarchy() {
        int row = existingHierarchiesTable.getSelectedRow();

        if(row >= 0) {
            int hierarchyId = Integer.parseInt(existingHierarchiesTable.getValueAt(row, 0).toString());

            Hierarchy hierarchy = new Hierarchy();
            hierarchy.setId(hierarchyId);

            hierarchy.deleteHierarchy();
        }
        else
            JOptionPane.showMessageDialog(null, "Selecciona un tipo de jerarquía");
    }

    public void setHierarchyInformation() {
        int row = existingHierarchiesTable.getSelectedRow();

        txtHierarchy.setText(existingHierarchiesTable.getValueAt(row, 1).toString());
    }

    public void refreshExistingHierarchiesTable() {
        ArrayList<Hierarchy> hierarchies = new Hierarchy().getAllHierarchies();

        DefaultTableModel tableModel = new DefaultTableModel(0, 0);
        tableModel.setColumnIdentifiers(new Object[]{"Tipo", "Nombre"});

        existingHierarchiesTable.setModel(tableModel);

        for(Hierarchy current : hierarchies)
            tableModel.addRow(new Object[]{current.getId(), current.getName()});
    }

    @Override
    public void selectText(String name) {
        switch(name) {
            case "txtHierarchy" :
                txtHierarchy.setSelectionStart(0);
                txtHierarchy.setSelectionEnd(txtHierarchy.getText().length());
                break;
        }
    }

    @Override
    public void setFocus(KeyEvent evt) {
        String keySource = getKeySource(evt);
        int keyCode = evt.getKeyCode();

        if(keyCode == 37 || keyCode == 39)
            switch(keySource){
                case "txtHierarchy":
                    btnHierarchy.requestFocusInWindow();
                    break;
                case "btnHierarchy":
                    txtHierarchy.requestFocusInWindow();
                    selectText("txtHierarchy");
                    break;
            }
        else if(keyCode == 10) {
            switch(keySource){
                case "btnHierarchy":
                    addHierarchy();
                    break;
                case "btnModifyHierarchy":
                    updateHierarchy();
                    break;
                case "btnDeleteHierarchy":
                    deleteHierarchy();
                    break;
            }

            refreshExistingHierarchiesTable();

            txtHierarchy.setText("");
            txtHierarchy.requestFocusInWindow();
        }
    }
}