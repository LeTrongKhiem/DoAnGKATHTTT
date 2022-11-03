package Model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	private String name;
	private MessageDigest md;
	
	private Hash(String name) {
		this.name = name;
		
		try {
			this.md = MessageDigest.getInstance(this.name);
		} catch (NoSuchAlgorithmException e) {
			System.exit(1);
		}
	}
	
	public static Hash getInstance(String name) {
		return new Hash(name);
	}
	
	public String hash(String data) {
		if (this.md == null) {
			return "";
		}
		
		byte[] out = this.md.digest(data.getBytes());
		
		BigInteger big = new BigInteger(1, out);
		
		return big.toString(16);
	}
	
	public String hashFile(String path) {
		if (this.md == null) {
			return "";
		}
		File file = new File(path);
		
		if (file.exists()) {
			try {
				DigestInputStream dis = new DigestInputStream(new BufferedInputStream(new FileInputStream(file)), md) ;
				int i ;
				byte[] buff = new byte[2024] ;
				do {
					i = dis.read(buff) ;
					
				}
				while (i != -1) ;
				BigInteger bi = new BigInteger(1, dis.getMessageDigest().digest()) ;
					return bi.toString(16) ;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		return "";
	}
	
	public static void main(String[] args) {
		Hash hash = new Hash("MD5");
		
		System.out.println(hash.hash("demo"));
		
		System.out.println(hash.hashFile("C:\\Users\\User\\OneDrive\\Máy tính\\ATTT\\DoAnGiuaKy\\DB\\MD5HASH.txt"));
	}
	
}
