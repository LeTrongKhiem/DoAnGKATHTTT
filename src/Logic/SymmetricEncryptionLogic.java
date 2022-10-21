package Logic;

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
			result += (char) ('A' + (data.charAt(i) - 'A' + (26-k)) % 26);
		}
		return result;
	}
	public static void main(String[] args) {
		SymmetricEncryptionLogic logic = new SymmetricEncryptionLogic();
		System.out.println(logic.CeasarDecode("PMNJR", 5));
	}
}
