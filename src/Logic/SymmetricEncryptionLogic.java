package Logic;

import java.math.BigInteger;
import java.util.Random;

public class SymmetricEncryptionLogic {
	public String CeasarEncode(String data, int k) {
		String result = "";
		data = data.toUpperCase();
		for (int i = 0; i < data.length(); i++) {
			result += (char) ('A' + (data.charAt(i) - 'A' + k) % 26);
		}
		return result;
	}

	public String CeasarDecode(String data, int k) {
		String result = "";
		for (int i = 0; i < data.length(); i++) {
			result += (char) ('A' + (data.charAt(i) - 'A' + (26 - k)) % 26);
		}
		return result;
	}

	public String subtitutionEnCode(String data, String keyStr) {
		String text = "";
		String[] keySpace = new String[keyStr.length()];
		for (int i = 0; i < keyStr.length(); i++)
			keySpace[i] = String.valueOf(keyStr.charAt(i));

		for (int i = 0; i < text.length(); i++) {
			int index = text.charAt(i) - 65;
			if (index > keySpace.length || index < 0) {
				text += String.valueOf(text.charAt(i));
			} else {
				text += keySpace[index];
			}
		}

		return text;
	}

	public String affineEncode(String data, long slope, long intercept) {
		int module = 26;
		StringBuilder builder = new StringBuilder();
		for (int in = 0; in < data.length(); in++) {
			char character = data.charAt(in);
			if (Character.isLetter(character)) {
				character = (char) ((slope * (character - 'a') + intercept) % module + 'a');
			}
			builder.append(character);
		}
		return builder.toString();
	}

	public String affineDecode(String data, int slope, int intercept) {
		int module = 26;
		StringBuilder builder = new StringBuilder();
		BigInteger inverse = BigInteger.valueOf(slope).modInverse(BigInteger.valueOf(module));
		for (int in = 0; in < data.length(); in++) {
			char character = data.charAt(in);
			if (Character.isLetter(character)) {
				int decoded = inverse.intValue() * (character - 'a' - intercept + module);
				character = (char) (decoded % module + 'a');
			}
			builder.append(character);
		}
		return builder.toString();
	}

	public String subtitutionDecode(String data, String keyStr) {
//		data = data.toLowerCase();
//		String plaint = "";
//		for (int i = 0; i < data.length(); i++) {
//			int charpos = keyStr.indexOf(data.charAt(i));
//			int keyval = (charpos - key) % 26;
//			if (keyval < 0) {
//				keyval = keyStr.length() + keyval;
//			}
//			char replaceval = keyStr.charAt(keyval);
//			plaint = plaint + replaceval;
//		}
//		return plaint;
		return null;
	}

	public String vigenereEncode(String data, String key) {
//		char[] msg = data.toCharArray();
//		int lenght = msg.length;
//		int i, j;
//		char[] key = new char[lenght];
//		char[] encrypt = new char[lenght];
//
//		for (i = 0, j = 0; i < lenght; ++i, ++j) {
//			if (j == keyword.length()) {
//				j = 0;
//			}
//			key[i] = keyword.charAt(j);
//		}
//		
//		 for(i = 0; i < lenght; ++i)
//			 encrypt[i] = (char) (((msg[i] + key[i]) % 26) + 'A');
//		 return encrypt;
		String encrypt = "";
		data = data.toUpperCase();
		key = key.toUpperCase();
		for (int i = 0, j = 0; i < data.length(); i++) {
			char letter = data.charAt(i);
			encrypt += (char) ((letter + key.charAt(j) - 2 * 'A') % 26 + 'A');//(char)(((letter - 65) + (key.charAt(j)-65)) % 26 + 65);
			j = ++j % key.length();
		}
		return encrypt;
	}
	
	public String vigenereDecode(String data, String key) {
		String decode = "";
		data = data.toUpperCase();
		for (int i = 0, j = 0; i < data.length(); i++) {
			char letter = data.charAt(i);
			decode += (char)((letter - key.charAt(j) + 26) % 26 + 65);
			j = ++j % key.length();
		}
		return decode;
	}

	public String randomKey() {
		String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 26) { // length of the random string.
			int index = (int) (rnd.nextFloat() * string.length());
			salt.append(string.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public int randomNumber() {
		Random rnd = new Random();
		int number = rnd.nextInt(50);
		return number;
	}

	public static void main(String[] args) {
		SymmetricEncryptionLogic logic = new SymmetricEncryptionLogic();
//		System.out.println(logic.affineDecode("khiem", 2, 2).toString());
//		System.out.println(logic.randomNumber());
		System.out.println(logic.vigenereEncode("khiem", "test"));
	}
}
