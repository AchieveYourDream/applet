package com.kute.appletcore.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAUtil {

	/**
	 * String to hold name of the encryption algorithm.
	 */
	public static final String ALGORITHM = "RSA";
	
	
	
	/**
	 * Size of the key.
	 */
	public static final int KEY_SIZE = 1024;

	/**
	 * Generate key which contains a pair of private and public key using 1024 bytes.
	 */
	public static void generateKey() throws Exception {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
		keyGen.initialize(KEY_SIZE, new SecureRandom());
		
		KeyPair keyPair = keyGen.generateKeyPair();
		
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		
		String publicKeyStr = new Base64().encodeToString((publicKey.getEncoded()));
		String privateKeyStr = new Base64().encodeToString((privateKey.getEncoded()));
		
		System.out.println("PublicKey:");
		System.out.println(publicKeyStr);
		System.out.println("--------------------------------------------------");
		System.out.println("PrivateKey:");
		System.out.println(privateKeyStr);
		System.out.println("--------------------------------------------------");
	}

	/**
	 * 使用公钥进行加密
	 * @param text 原文
	 * @param key  公钥
	 */
	public static String encrypt(String text, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, getPublicKeyObject(key));
		return new Base64().encodeToString(cipher.doFinal(text.getBytes()));
	}

	/**
	 * 使用私钥进行解密
	 * @param text 原文
	 * @param key  私钥
	 */
	public static String decrypt(String text, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");  
		cipher.init(Cipher.DECRYPT_MODE, getPrivateKeyObject(key));
		return new String(cipher.doFinal(new Base64().decode(text)));
	}

	/**
	 * 实例化公钥
	 */
	private static PublicKey getPublicKeyObject(String key) throws Exception {
		byte[] keyByteArr = new Base64().decode(key);
		X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(keyByteArr);
		KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
		return keyFactory.generatePublic(bobPubKeySpec);
	}
	
	/**
	 * 实例化私钥
	 */
	private static PrivateKey getPrivateKeyObject(String key) throws Exception {
		byte[] keyByteArr = new Base64().decode(key);
		PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(keyByteArr);
		KeyFactory keyf = KeyFactory.getInstance(ALGORITHM);
		return keyf.generatePrivate(priPKCS8);
	} 
	
//	public static void main(String[] args) throws Exception {
//		generateKey();
//
//		String text = String.valueOf(System.currentTimeMillis());
//		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCaRK5+eYawMv4PdumYSeHf3YZdSQ9e9o4NFY7N+GyfsRu/P0vCOB8ZSLyQUzyaTLHAeT9IBK2nmhGjSMgqKfqPskdvjUi4CuvIr3lmJgmeDtrsCVoo1khMrn7p2tiaG5fiZTMf78Nl5gsPrXXFRRSGUnPe1RC8MHZyE5JMluAn+wIDAQAB";
//		String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJpErn55hrAy/g926ZhJ4d/dhl1JD172jg0Vjs34bJ+xG78/S8I4HxlIvJBTPJpMscB5P0gEraeaEaNIyCop+o+yR2+NSLgK68iveWYmCZ4O2uwJWijWSEyufuna2Jobl+JlMx/vw2XmCw+tdcVFFIZSc97VELwwdnITkkyW4Cf7AgMBAAECgYEAgtGRQ1EcxVhIl6aYCntEnslFAuBMt5PO/At28PUkb/sJc5FiVg2vWYqT1LOxJYu6BGUNI65L8F+3a0bx7sdwYI9VN471/PhLgZvNnsJyZl7CoJD+mxEQ75/hS0c6v8BXR60b6CAz//h73qHn/QSFp5LAAQ2EttftsiKGDe38PKECQQDO6YR4bhGBorS5C1D8ftMJqPM4ySjjCtTwzx/supvw3AS/xVQKmASX4ybrIZBIIGIh84UBRbLkcQ2H8lfFyCIrAkEAvt3rzJrhSOsP4nEcb3nBPqtLIMR2S1w8N9NO053R992IqBRZOlYc3a/jpaRgfQyzwm3X5HzcEYgBr8xEhoi5cQJAOwOXaNHb5GGHsg9sNdfmUScC1/tn0fnQ6i3pKRfASl42bIvXgH4DMV70RrP39tplotFV6hr6/vTPqyqPpjWCqQJAGawh3khqyvMLFOsf5wKacoJ5vXOPcb17QAsFDEOrDUrX6buq8MTKZysUVKBSdh9yQlGh+1KsCxOfHnU8NlhHkQJBAL8WQxYvsiMh5ER1WHi3fCjPghL4AYWoFrsoBpQ5C95ZPjlzD3QFUXU1G7eddDJdpBo20EZxW0cpD1Mp1GwCEqA=";
//
//		String encryptText = encrypt(text, publicKey);
//		String decryptText = decrypt(encryptText, privateKey);
//
//		System.out.println("原文：" + text);
//		System.out.println("加密：" + encryptText);
//		System.out.println("解密：" + decryptText);
//	}
	
}