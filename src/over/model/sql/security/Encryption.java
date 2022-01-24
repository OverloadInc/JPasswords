package over.model.sql.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * <code>Encryption</code> class.
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
public class Encryption {
    private static final String PRIVATE_KEY = "9186";
    private static final String ENCRYPTION_TECHNIQUE = "Blowfish";
    
    public static String encrypt(String clearPassword) throws Exception{
        String encryptedPassword = "";

        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(PRIVATE_KEY.getBytes(), ENCRYPTION_TECHNIQUE);

            Cipher cipher = Cipher.getInstance(ENCRYPTION_TECHNIQUE);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] encrypted = cipher.doFinal(clearPassword.getBytes());

            encryptedPassword = new String(Base64.getEncoder().encode(encrypted));
        }
        catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw new Exception(e);
        }

        return encryptedPassword;
    }
    
    public static String decrypt(String encryptedPassword) throws Exception{
	    String decryptedPassword = "";
	
	    try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(PRIVATE_KEY.getBytes(), ENCRYPTION_TECHNIQUE);
            
            Cipher cipher = Cipher.getInstance(ENCRYPTION_TECHNIQUE);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
            
            decryptedPassword = new String(decrypted);		
	    }
        catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw new Exception(e);
        }

        return decryptedPassword;
    }
}