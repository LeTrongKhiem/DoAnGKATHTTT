package Logic;

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
		for(int i = 0; i < keyStr.length(); i++) keySpace[i] = String.valueOf(keyStr.charAt(i));

		for(int i = 0; i < text.length(); i++)
		{
			int index = text.charAt(i) - 65;
			if( index > keySpace.length || index < 0)
			{
				text += String.valueOf(text.charAt(i));
			}
			else
			{
				text += keySpace[index];
			}
		}

		return text;
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

	public static void main(String[] args) {
		SymmetricEncryptionLogic logic = new SymmetricEncryptionLogic();
		System.out.println(logic.subtitutionEnCode("khiem", "dsadascxc").toString());
	}
}
