package controller.login;

import model.sql.security.Encryption;

public class LoginController {

    private static String getPassword(char[] userPassword) {
        String clearPassword = "";

        for(char character : userPassword)
            clearPassword = clearPassword + character;

        return clearPassword;
    }

    public static String encryptPassword(char[] userPassword) throws Exception {
        return Encryption.encrypt(getPassword(userPassword));
    }
}