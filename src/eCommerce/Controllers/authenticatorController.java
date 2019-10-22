package eCommerce.Controllers;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class authenticatorController {

	private String key;
	
	public authenticatorController()
	{
		key = "";
	}

	public String decryptPassword(byte[] encryptPassword)
	{
		String decrypted = "";
		
		try {
			String key = "Bar12345Bar12345"; // 128 bit key
	        // Create key and cipher
	        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
            decrypted = new String(cipher.doFinal(encryptPassword));
            System.err.println(decrypted);
		}catch(Exception e) 
        {
            e.printStackTrace();
        }
		return decrypted;
	}
	public String encryptPassword(String uPass)
	{
		byte[] encrypted = null;
		
		try 
        {
			String text = uPass;
            String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            encrypted = cipher.doFinal(text.getBytes());
            System.out.println(new String(encrypted));
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
		return new String(encrypted);
	}
	
	public String getKey()
	{
		return createKey();
	}
	
	public String createKey()
	{
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                 + "0123456789"
                 + "abcdefghijklmnopqrstuvxyz"; 
		StringBuilder sb = new StringBuilder(16); 
		  
        for (int i = 0; i < 16; i++) 
        { 
            int index = (int)(AlphaNumericString.length()* Math.random()); 
            sb.append(AlphaNumericString.charAt(index)); 
        }
        key = sb.toString();
		return key;
	}
}
