package willian.backJava.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class CriptografiaAES {

	private static final String BLOWFISH = "Blowfish";
	private static final String UTF_8 = "UTF-8";

	public static String encrypt(String valor, String chave) throws InvalidKeyException, UnsupportedEncodingException,
			NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

		Cipher encripta = Cipher.getInstance(BLOWFISH);

		SecretKeySpec key = new SecretKeySpec(chave.getBytes(UTF_8), BLOWFISH);

		encripta.init(Cipher.ENCRYPT_MODE, key);

		return encripta.doFinal(valor.getBytes(UTF_8)).toString();
	}

	public static String decrypt(String valor, String chave) throws NoSuchAlgorithmException, NoSuchPaddingException,
			UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

		Cipher decripta = Cipher.getInstance(BLOWFISH);

		SecretKeySpec key = new SecretKeySpec(chave.getBytes(UTF_8), BLOWFISH);

		decripta.init(Cipher.DECRYPT_MODE, key);

		return new String(decripta.doFinal(valor.getBytes(UTF_8)), UTF_8);
	}

}
