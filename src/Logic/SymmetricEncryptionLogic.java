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

	public String substitutionEnCode(String data, String keyStr) {
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

	public String substitutionDecode(String data, String keyStr) {
		String plaintext = "";
		for (int i = 0; i < keyStr.length(); i++) {
			char character = keyStr.charAt(i);
			int index = data.indexOf(character);
			int ascii = index + 65;
			if (ascii < 65 || ascii > 90) {
				plaintext += String.valueOf(character);
			} else {
				plaintext += String.valueOf((char) ascii);
			}
		}

		return plaintext;
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

	public String vigenereEncode(String data, String key) {
		String encrypt = "";
		data = data.toUpperCase();
		key = key.toUpperCase();
		for (int i = 0, j = 0; i < data.length(); i++) {
			char letter = data.charAt(i);
			encrypt += (char) ((letter + key.charAt(j) - 2 * 'A') % 26 + 'A');// (char)(((letter - 65) +
																				// (key.charAt(j)-65)) % 26 + 65);
			j = ++j % key.length();
		}
		return encrypt;
	}

	public String vigenereDecode(String data, String key) {
		String decode = "";
		data = data.toUpperCase();
		for (int i = 0, j = 0; i < data.length(); i++) {
			char letter = data.charAt(i);
			decode += (char) ((letter - key.charAt(j) + 26) % 26 + 65);
			j = ++j % key.length();
		}
		return decode;
	}

	private int[][] getKeyMatrix(String key) {
		double sq = Math.sqrt(key.length());

		if (sq != (long) sq) {
			return null;
		}

		int len = (int) sq;
		int[][] keyMatrix = new int[len][len];
		int k = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				keyMatrix[i][j] = ((int) key.charAt(k)) - 97;
				k++;
			}
		}
		return keyMatrix;
	}

	private static void isValidMatrix(int[][] keyMatrix) {
		int det = keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0];
		// If det=0, throw exception and terminate
		if (det == 0) {
			throw new java.lang.Error("Det equals to zero, invalid key matrix!");
		}
	}

	private static void isValidReverseMatrix(int[][] keyMatrix, int[][] reverseMatrix) {
		int[][] product = new int[2][2];
		// Find the product matrix of key matrix times reverse key matrix
		product[0][0] = (keyMatrix[0][0] * reverseMatrix[0][0] + keyMatrix[0][1] * reverseMatrix[1][0]) % 26;
		product[0][1] = (keyMatrix[0][0] * reverseMatrix[0][1] + keyMatrix[0][1] * reverseMatrix[1][1]) % 26;
		product[1][0] = (keyMatrix[1][0] * reverseMatrix[0][0] + keyMatrix[1][1] * reverseMatrix[1][0]) % 26;
		product[1][1] = (keyMatrix[1][0] * reverseMatrix[0][1] + keyMatrix[1][1] * reverseMatrix[1][1]) % 26;
		// Check if a=1 and b=0 and c=0 and d=1
		// If not, throw exception and terminate
		if (product[0][0] != 1 || product[0][1] != 0 || product[1][0] != 0 || product[1][1] != 1) {
			throw new java.lang.Error("Invalid reverse matrix found!");
		}
	}

	private static int[][] reverseMatrix(int[][] keyMatrix) {
		int detmod26 = (keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0]) % 26; // Calc det
		int factor;
		int[][] reverseMatrix = new int[2][2];
		// Find the factor for which is true that
		// factor*det = 1 mod 26
		for (factor = 1; factor < 26; factor++) {
			if ((detmod26 * factor) % 26 == 1) {
				break;
			}
		}
		// Calculate the reverse key matrix elements using the factor found
		reverseMatrix[0][0] = keyMatrix[1][1] * factor % 26;
		reverseMatrix[0][1] = (26 - keyMatrix[0][1]) * factor % 26;
		reverseMatrix[1][0] = (26 - keyMatrix[1][0]) * factor % 26;
		reverseMatrix[1][1] = keyMatrix[0][0] * factor % 26;
		return reverseMatrix;
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
