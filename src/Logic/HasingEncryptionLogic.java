package Logic;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HasingEncryptionLogic {
	public String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}

//	public String SHA256Encode(String data) {
//		try {
//			String message = "the message to hash here";
//
//			MessageDigest digest = MessageDigest.getInstance("SHA-256");
//
//			byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
//
//			// to lowercase hexits
//			DatatypeConverter.printHexBinary(hash);
//
//			// to base64
//			DatatypeConverter.printBase64Binary(hash);
//		} catch (NoSuchAlgorithmException e) {
//		}
//	}
//
//	public String SHA256Decode(String code) {
//
//	}

	public static void main(String[] args) {
		HasingEncryptionLogic logic = new HasingEncryptionLogic();
		System.out.println(logic.MD5("123123123"));
		;
	}
}
