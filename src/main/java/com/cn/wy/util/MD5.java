package com.cn.wy.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 说明：MD5处理
 * 创建人：FH Q313596790
 * 修改时间：2014年9月20日
 * @version
 */
public class MD5 {
	private final static String[] hexDigits = {
			"0", "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "a", "b", "c", "d", "e", "f"};
	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return str;
	}
	public static byte[] md5(byte[] in) {
		MessageDigest md = null;
//	  	byte[] out = new byte[16];
		byte[] out = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(in);
			out = md.digest();
		} catch (NoSuchAlgorithmException ex) {
//	   		System.out.println(ex.toString());
		}
		return out;
	}
	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	private static String byteToHexString(int b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	public static void main(String[] args) {
		System.out.println(md5("31119@qq.com"+"123456"));
		System.out.println(md5("mj1"));
	}
}
