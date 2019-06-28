package com.zl.spbm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.regex.Pattern;

/**
 * 加密解密类，DES算法。支持8字节密钥长度和8字节向量。 输入参数strKey必须至少16个字符，前8个字符用于“密钥”，
 * 后8个字符用于“向量”。若strKey超出16个字符，则后面的 字符忽略；若少于16个字符，则本算法出错。 本算法是为了和.NET平台兼容而编写的。
 */
public class EnDecrypt {
	private static Logger logger = LoggerFactory.getLogger(EnDecrypt.class.getName());

	private static byte[] DESIV;

	// private static final byte[] DESIV = { (byte) 0x12, (byte) 0x34,
	// (byte) 0x56, (byte) 0x78, (byte) 0x90, (byte) 0xAB, (byte) 0xCD,
	// (byte) 0xEF };// 设置向量

	private static AlgorithmParameterSpec iv = null;// 加密算法的参数接口，IvParameterSpec是它的一个实现

	private static Key key = null;

	private static void init(String strKey) {

		try {
			DESIV = strKey.substring(8, 16).getBytes();

			// 设置密钥参数
			DESKeySpec keySpec = new DESKeySpec(strKey.substring(0, 8).getBytes());
			iv = new IvParameterSpec(DESIV);// 设置向量
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂
			key = keyFactory.generateSecret(keySpec);// 得到密钥对象
		} catch (Exception e) {
			logger.error("初始化密钥出错！密钥=[" + strKey + "]" + e);
		}

	}

	public static String encode(String data, String strKey) {
		Cipher enCipher;
		byte[] pasByte = null;
		String encodedData = "";

		init(strKey);

		try {
			enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");// 得到加密对象Cipher
			enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// 设置工作模式为加密模式，给出密钥和向量
			pasByte = enCipher.doFinal(data.getBytes("utf-8"));
			// 将加密后的字节转换成大写的16进制。
			encodedData = byteArrayToHexString(pasByte);
		} catch (Exception e) {
			logger.error("调用加密方法encode出错！data=[" + data + "] 密钥=[" + strKey + "]加密后数据=[" + encodedData + "]" + e);
		}
		return toCapital(encodedData);
	}

	public static String decode(String data, String strKey) {
		Cipher deCipher;
		byte[] pasByte = null;
		byte[] b = new byte[data.length() / 2];
		String originalData = "";

		init(strKey);

		try {
			deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			deCipher.init(Cipher.DECRYPT_MODE, key, iv);

			for (int x = 0; x < (data.length() / 2); x++) {
				int i = Integer.parseInt(data.substring(x * 2, x * 2 + 2), 16);
				b[x] = (byte) i;
			}
			pasByte = deCipher.doFinal(b);
			originalData = new String(pasByte, "UTF-8");
		} catch (Exception e) {
			logger.error("调用解密方法decode出错！data=[" + data + "] 密钥=[" + strKey + "]解密后数据=[" + originalData + "]" + e);
		}
		return originalData;
	}

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer sb = new StringBuffer(b.length * 2);

		for (int i = 0; i < b.length; i++) {
			int j = (b[i] & 0xff);

			if (j < 16) {
				sb.append('0');
			}

			sb.append(Integer.toHexString(j));
		}

		return sb.toString();
	}

	private static String toCapital(String data) {
		StringBuffer ret = new StringBuffer();
		String mid = "";
		String cap = "";
		int len = data.length();

		for (int i = 0; i < len; i++) {
			if (i == len - 1) {
				mid = data.substring(i);
			} else {
				mid = data.substring(i, i + 1);
			}

			Pattern pattern = Pattern.compile("[0-9]*");
			boolean dd = pattern.matcher(mid).matches();
			if (!dd) {
				cap = mid.toUpperCase();

				ret.append(cap);
			} else {
				ret.append(mid);
			}
		}

		return ret.toString();
	}
	public static String idEncrypt(String data) {
		StringBuffer sb = new StringBuffer();
		String mid = "";
		int len = data.length();
		for(int i = 0;i<len;i++){
			if (i == len - 1) {
				mid = data.substring(i);
			} else {
				mid = data.substring(i, i + 1);
			}
			char a = (char) (Integer.valueOf(mid)+97);
            sb.append(a);
        }
		return sb.toString();
	}
 
	public static Integer idDecrypt(String data) {
		StringBuffer sb = new StringBuffer();
		int len = data.length();
		for(int i = 0;i<len;i++){
			int a =  (data.charAt(i)-97);
            sb.append(a);
        }
		return Integer.valueOf(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		String KEY0 = "@roomseach_qk365";
		System.out.println("加密：" + EnDecrypt.encode("code=37E4341FDFC0AD05&cburl=http://192.168.103.244:8080/iframeExec&divshows=div_fgyList&btnshows=btn_addUserWill|需求录入",KEY0));
		System.out.println("解密:" + EnDecrypt.decode("A8B20E3A2ABE76B2936811AF0BA8143BE9081CC0A45999D0AB5C509F6960DD9DE3ADE66578DBCC2ED37D60C46F45B0E1489AF019D06C8D8F88A5C0B72D0C48689F62427C8BEC1672ABFE61ACC27A2681A757BCCCA4BA8B6FCC00B84910624C0D7ADA4F2B37AA7017933519D314B4FDDC9565F73432B4AD6A2AECBFF52DC5EF8B",KEY0));
	}

}

