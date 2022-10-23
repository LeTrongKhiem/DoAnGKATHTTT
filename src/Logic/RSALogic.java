package Logic;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class RSALogic {

	KeyPair keypair;
	PrivateKey privateKey;
	PublicKey publicKey;

	public RSALogic() {

	}

	public void createKey() throws NoSuchAlgorithmException {
		KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
		gen.initialize(2048);
		keypair = gen.generateKeyPair();
		privateKey = keypair.getPrivate();
		publicKey = keypair.getPublic();
	}

	public byte[] rsaEncode(String text) throws NoSuchAlgorithmException {
		if (publicKey == null) {
			createKey();
		}
		if (text == null) {
			return null;
		}
		byte[] data = text.getBytes();
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] bytes = cipher.doFinal(data);
			return bytes;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public String rsaDecode(byte[] data) {
		if (privateKey == null) {
			return null;
		}
		if (data == null) {
			return null;
		}
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] bytes = cipher.doFinal(data);
			return new String(bytes);
 		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
