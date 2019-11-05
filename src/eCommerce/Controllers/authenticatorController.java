package eCommerce.Controllers;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class authenticatorController {

	private String key;
	private static byte[] Key;

	public authenticatorController()
	{
		key = "Bar12345Bar12345"; // 128 bit key
		try {
			Key = key.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Key = MessageDigest.getInstance("SHA-1").digest(Key);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Key = Arrays.copyOf(Key, 16);
	}

	public String decryptString(String str) {
		byte[] strb = str.getBytes();
		String decrypted = "";

		try {
			// Create key and cipher
			Key aesKey = new SecretKeySpec(Key, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(str)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decrypted;
	}

	public String encryptString(String uPass) {
		String en = "";
		try {
			String text = uPass;
			// Create key and cipher
			Key aesKey = new SecretKeySpec(Key, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			// encrypt the text
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			en = Base64.getEncoder().encodeToString(cipher.doFinal(text.getBytes("UTF-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return en;
	}

	public String getKey() {
		return createKey();
	}

	public String createKey() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(16);

		for (int i = 0; i < 16; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		key = sb.toString();
		return key;
	}
	public String getCardEnding(String cardNumber)
	{
		if(decryptString(cardNumber).length() > 4)
		{
		    String end = decryptString(cardNumber);
		    return end.substring(end.length()-4, end.length());
		}else
		{
    		return "";
		}
	}
}
