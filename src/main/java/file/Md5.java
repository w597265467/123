package file;

import sun.security.provider.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class Md5 {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		System.out.println(md5("å"));
		System.out.println(md5("氓"));


	}
	public static  String md5(String s) throws NoSuchAlgorithmException {
		MessageDigest mdInst = MessageDigest.getInstance("MD5");
		byte[] digest = mdInst.digest(s.getBytes());
		StringBuilder sb = new StringBuilder(digest.length * 2);
		for (byte b : digest) {
			int v = b & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase(Locale.getDefault());
	}





}
