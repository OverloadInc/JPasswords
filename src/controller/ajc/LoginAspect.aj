package controller.ajc;

import controller.BackgroundImage;
import model.pojo.User;
import view.Dashboard;

import javax.swing.*;

public privileged aspect LoginAspect {

    pointcut setLookAndFeel(): execution(public static void view.Login.main(java.lang.String[]));

    pointcut setBackground(): execution(public view.Login.new());

    pointcut login(User user): call(private void view.Login.login(User)) && args(user);

    before(): setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    before(): setBackground() {
        BackgroundImage.setName("login_white_blue01.jpg");
    }

    void around(User user): login(user) {
        try {
            if(user.find()){
                JOptionPane.showMessageDialog(null, "Bienvenido " + user.getName());

                new Dashboard().setVisible(true);

                view.Login.flag = false;
            }
            else {
                JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta");

                view.Login.flag = true;
            }

            proceed(user);
        }
        catch(Exception e) {
        }
    }
}