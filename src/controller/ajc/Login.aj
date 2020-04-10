import controller.BackgroundImage;

public aspect Login {

    pointcut setBackground(): call(* Login.new());

    after(): setBackground() {
        BackgroundImage.setName("login_white_blue01.jpg");
    }
}