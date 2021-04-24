package over.controller.ajc;

import over.controller.BackgroundImage;

import javax.swing.*;

public privileged aspect LoginAspect {

    pointcut setLookAndFeel(): execution(public static void over.view.Login.main(java.lang.String[]));

    pointcut setBackground(): execution(public over.view.Login.new());

    before(): setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(over.view.Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    before(): setBackground() {
        BackgroundImage.setName("login_white_blue01.jpg");
    }
}