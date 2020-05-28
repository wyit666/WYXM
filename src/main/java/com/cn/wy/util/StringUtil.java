package com.cn.wy.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

/**
 * 字符串相关方法
 *
 */
public class StringUtil {

	/**
	 * 将以逗号分隔的字符串转换成字符串数组
	 * @param valStr
	 * @return String[]
	 */
	public static String[] StrList(String valStr){
	    int i = 0;
	    String TempStr = valStr;
	    String[] returnStr = new String[valStr.length() + 1 - TempStr.replace(",", "").length()];
	    valStr = valStr + ",";
	    while (valStr.indexOf(',') > 0)
	    {
	        returnStr[i] = valStr.substring(0, valStr.indexOf(','));
	        valStr = valStr.substring(valStr.indexOf(',')+1 , valStr.length());
	        
	        i++;
	    }
	    return returnStr;
	}
	/**
	 * 判断给定字符串是否为空 或者为空字符串
	 * @param str
	 * @return true表示空， false表示不为空
	 */
	public static boolean isEmpty(String str) {
		return (str == null || "".equals(str) || "null".equals(str) || "(null)".equals(str));
	}

	/**
	 * 判断给定字符串是否不为空 或者不为空字符串
	 * @param str
	 * @return fasle表示空， true表示不为空
	 */
	public static boolean isNotEmpty(String str) {
		return (str != null && !"".equals(str) && !"null".equals(str) && !"(null)".equals(str));
	}

	/**
	 * 判断给定Long是否为空 或者为0
	 * @param str
	 * @return true表示空， false表示不为空
	 */
	public static boolean isEmpty(Long str) {
		return (str == null || str.longValue() == 0);
	}

	/**
	 * 判断给定Long是否不为空 或者不为0
	 * @param str
	 * @return fasle表示空， true表示不为空
	 */
	public static boolean isNotEmpty(Long str) {
		return (str != null && str.longValue() != 0);
	}

	/**
	 * 判断给定Integer是否为空 或者为0
	 * @param str
	 * @return true表示空， false表示不为空
	 */
	public static boolean isEmpty(Integer str) {
		return (str == null || str.intValue() == 0);
	}
	/**
	 * 判断给定Integer是否为空 或者为0
	 * @param str
	 * @return true表示空， false表示不为空
	 */
	public static boolean isEmpty(Short str) {
		return (str == null || str.intValue() == 0);
	}

	/**
	 * 判断给定Integer是否不为空 或者不为0
	 * @param str
	 * @return fasle表示空， true表示不为空
	 */
	public static boolean isNotEmpty(Integer str) {
		return (str != null && str.intValue() != 0);
	}
	/**获取字符串编码
	 * @param str
	 * @return
	 */
	public static String getEncoding(String str) {      
	       String encode = "GB2312";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s = encode;      
	              return s;      
	           }      
	       } catch (Exception exception) {      
	       }      
	       encode = "ISO-8859-1";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s1 = encode;      
	              return s1;      
	           }      
	       } catch (Exception exception1) {      
	       }      
	       encode = "UTF-8";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s2 = encode;      
	              return s2;      
	           }      
	       } catch (Exception exception2) {      
	       }      
	       encode = "GBK";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s3 = encode;      
	              return s3;      
	           }      
	       } catch (Exception exception3) {      
	       }      
	      return "";      
	   }

	//clob转string
	public static String ClobToString(Clob clob) throws SQLException, IOException {

		String reString = "";
		Reader is = clob.getCharacterStream();// 得到流
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();
		return reString;
	}
}
