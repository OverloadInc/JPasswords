package over.controller;

import javax.swing.*;
import java.awt.event.KeyEvent;

public interface Controller {

    default String getKeySource(KeyEvent evt) {
        String keySource = evt.getSource().getClass().getSimpleName();
        String key = null;

        switch (keySource) {
            case "JTextField":
                key = ((JTextField) evt.getSource()).getName();
                break;
            case "JButton":
                key = ((JButton) evt.getSource()).getName();
                break;
            case "JPasswordField":
                key = ((JPasswordField) evt.getSource()).getName();
                break;
        }

        return key;
    }

    void selectText(String name);

    void setFocus(KeyEvent evt);
}