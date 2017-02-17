package com.flyhero.flyapi.utils;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 密匙工具类(包含des加密与md5加密)
 * @author mingge
 *
 */
public class KeysUtil {

        private final static String DES = "DES";
        
        private final static String MD5 = "MD5";
        
        private final static String KEY="jxtec0727";
     
        /**
         * MD5加密算法
         * @param data
         * @return
         */
        public static String md5Encrypt(String data) {
            String resultString = null;
            try {
                resultString = new String(data);
                MessageDigest md = MessageDigest.getInstance(MD5);
                resultString =byte2hexString(md.digest(resultString.getBytes()));
            } catch (Exception ex) {
            }
            return resultString;
        }
        

        private  static String byte2hexString(byte[] bytes) {
            StringBuffer bf = new StringBuffer(bytes.length * 2);
            for (int i = 0; i < bytes.length; i++) {
                if ((bytes[i] & 0xff) < 0x10) {
                    bf.append("T0");
                }
                bf.append(Long.toString(bytes[i] & 0xff, 16));
            }
            return bf.toString();
        }
        
        /**
         * Description 根据键值进行加密
         * @param data 
         * @param key  加密键byte数组
         * @return
         * @throws Exception
         */
        public static String desEncrypt(String data, String key) throws Exception {
            if (key==null) {
                key=KEY;
            }
            byte[] bt = encrypt(data.getBytes(), key.getBytes());
            String strs = new BASE64Encoder().encode(bt);
            return strs;
        }
     
        /**
         * Description 根据键值进行解密
         * @param data
         * @param key  加密键byte数组
         * @return
         * @throws IOException
         * @throws Exception
         */
        public static String desDecrypt(String data, String key) throws IOException,
                Exception {
            if (data == null){
                return null;
            }
            if (key==null) {
                key=KEY;
            }
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] buf = decoder.decodeBuffer(data);
            byte[] bt = decrypt(buf,key.getBytes());
            return new String(bt);
        }
     
        /**
         * Description 根据键值进行加密
         * @param data
         * @param key  加密键byte数组
         * @return
         * @throws Exception
         */
        private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
            // 生成一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            // 从原始密钥数据创建DESKeySpec对象
            DESKeySpec dks = new DESKeySpec(key);
            // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            SecretKey securekey = keyFactory.generateSecret(dks);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(DES);
            // 用密钥初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
            return cipher.doFinal(data);
        }
         
         
        /**
         * Description 根据键值进行解密
         * @param data
         * @param key  加密键byte数组
         * @return
         * @throws Exception
         */
        private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
            // 生成一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            // 从原始密钥数据创建DESKeySpec对象
            DESKeySpec dks = new DESKeySpec(key);
            // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            SecretKey securekey = keyFactory.generateSecret(dks);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance(DES);
            // 用密钥初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
            return cipher.doFinal(data);
        }
        
        public static void main(String[] args) {
        	try {
				String string=desEncrypt("wang","jxtec123");
				System.out.println(string);
				String string2=desDecrypt(string, "jxtec123");
				System.out.println(string2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}