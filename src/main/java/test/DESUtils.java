package test;


import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.util.Locale;
import java.util.Map;

public class DESUtils {
	private static Cipher cipher;
	private static Key key;
	private static IvParameterSpec iv;//该类指定初始化向量 （IV）。 使用IV的实例是反馈模式中的密码，例如CBC模式下的DES和具有OAEP编码操作的RSA密码
	private static boolean userIV = false;
	private static String pwd;


	/**
	 * 16进制的字符串表示转成字节数组
	 *
	 * @param hexString 16进制格式的字符串
	 * @return 转换后的字节数组
	 **/
	private static byte[] toByteArray(String hexString) {
		hexString = hexString.toLowerCase();
		final byte[] byteArray = new byte[hexString.length() / 2];
		int k = 0;
		for (int i = 0; i < byteArray.length; i++) {//因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
			byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
			byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
			byteArray[i] = (byte) (high << 4 | low);
			k += 2;
		}
		return byteArray;
	}

	/**
	 * byte[]数组转换为16进制的字符串
	 *
	 * @param data 要转换的字节数组
	 * @return 转换后的结果
	 */
	private static String byteArrayToHexString(byte[] data) {
		StringBuilder sb = new StringBuilder(data.length * 2);
		for (byte b : data) {
			int v = b & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase(Locale.getDefault());
	}

	/**
	 * 字节数组转成16进制表示格式的字符串
	 *
	 * @param byteArray 要转换的字节数组
	 * @return 16进制表示格式的字符串
	 **/
	public static String toHexString(byte[] byteArray) {
		if (byteArray == null || byteArray.length < 1)
			throw new IllegalArgumentException("this byteArray must not be null or empty");

		final StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < byteArray.length; i++) {
			if ((byteArray[i] & 0xff) < 0x10)//0~F前面不零
				hexString.append("0");
			hexString.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return hexString.toString().toLowerCase();
	}

	public static void main(String[] args) throws Exception {
		DESUtils des = new DESUtils();
		String pwd = "********"; //加密密码

		init(pwd,"DES/CBC/PKCS5Padding");
		String encrypt = encrypt("{orderId:6229912018011116140267576168}");
		System.out.println(encrypt);
		String decrypt = decrypt(encrypt);
		System.out.println(decrypt);

	}

	/**
	 *
	 * @param pwd 密钥
	 */
	public static void init(String pwd) {
		try {
			iv = null;
			DESUtils.pwd = pwd;
			cipher = Cipher.getInstance("DES");
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			DESKeySpec keySpec = new DESKeySpec(pwd.getBytes("utf-8"));
			key = keyFactory.generateSecret(keySpec);
			byte[] encoded = key.getEncoded();
			String encode = new String(encoded);
			System.out.println(encode);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 *
	 * @param pwd 密钥
	 *                          1   2    3
	 * @param arithmetic 算法  DES/CBC/PKCS5Padding
	 *                   1.加密解密算法
	 *                   2.加密解密模式
	 *                   3.加密结果长度不足时,补位方法
	 */
	public static void init(String pwd, String arithmetic) {
		try {
			if (arithmetic == null) {
				init(pwd);
				return;
			}
			DESUtils.pwd = pwd;
			userIV = arithmetic.indexOf("ECB") <= 0;
			iv = new IvParameterSpec(pwd.getBytes());
			cipher = Cipher.getInstance(arithmetic);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			DESKeySpec keySpec = new DESKeySpec(pwd.getBytes("utf-8"));
			key = keyFactory.generateSecret(keySpec);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 *
	 * @param encode DES加密后的16进制字符串
	 * @return 解密后的数据
	 */
	public static String decrypt(String encode) {
		try {
			if (userIV) {
				cipher.init(Cipher.DECRYPT_MODE, key, iv);

			} else {
				cipher.init(Cipher.DECRYPT_MODE, key);
			}
			byte[] bytes = toByteArray(encode);
			byte[] bytes1 = cipher.doFinal(bytes);
			return new String(bytes1, "ISO-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *
	 * @param src 一个字符串
	 * @return DES加密后的数组转换为16进制字符串
	 */
	public static String encrypt(String src) {
		try {
			if (userIV) {
				cipher.init(Cipher.ENCRYPT_MODE, key, iv);

			} else {
				cipher.init(Cipher.ENCRYPT_MODE, key);
			}
			byte[] bytes = src.getBytes();
			byte[] bytes1 = cipher.doFinal(bytes);
			return byteArrayToHexString(bytes1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}





}