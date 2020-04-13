package controller;

import model.sql.security.Encryption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public abstract class Controller {

    protected List<Component> componentList;

    protected Controller(List<Component> componentList) {
        this.componentList = componentList;
    }

    protected String getPassword(char[] userPassword) {
        String clearPassword = "";

        for(char character : userPassword)
            clearPassword += character;

        return clearPassword;
    }

    protected String getKeySource(KeyEvent evt) {
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

    public String encryptPassword(char[] userPassword) throws Exception {
        return Encryption.encrypt(getPassword(userPassword));
    }

    public abstract void selectText(String name);

    public abstract void setFocus(KeyEvent evt);
}