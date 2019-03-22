package sf.wj.utils;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;

public class AESUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(AESUtil.class);
    /**
     * 算法名称
     */
    private static final String KEY_ALGORITHM = "AES";
    /**
     * 加解密算法/模式/填充方式
     */
    private static final String AES_CBC_PKCS7_PADDING = "AES/CBC/PKCS7Padding";
    /**
     *加密
     * @param contentBytes 需要加密数据的byte数组
     * @param keyBytes 密钥byte数组
     * @param ivBytes 偏移量byte数组
     * @return 加密后数据的byte数组
     * @throws Exception
     */
    private static byte[] encrypt(byte[] contentBytes, byte[] keyBytes, byte[] ivBytes) throws Exception {
        //初始化
        Security.addProvider(new BouncyCastleProvider());
        // 转化成JAVA的密钥格式
        Key key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
        // 初始化cipher
        Cipher cipher = Cipher.getInstance(AES_CBC_PKCS7_PADDING, "BC");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(ivBytes));
        return cipher.doFinal(contentBytes);
    }
    /**
     *
     * @param encryptedData 需要解密数据的byte数组
     * @param keyBytes 密钥byte数组
     * @param ivBytes 偏移量byte数组
     * @return 解密后数据的byte数组
     * @throws Exception
     */
    private static byte[] decrypt(byte[] encryptedData, byte[] keyBytes, byte[] ivBytes) throws Exception {
        // 初始化
        Security.addProvider(new BouncyCastleProvider());
        // 转化成JAVA的密钥格式
        Key key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
        // 初始化cipher
        Cipher cipher = Cipher.getInstance(AES_CBC_PKCS7_PADDING, "BC");
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(ivBytes));
        return cipher.doFinal(encryptedData);
    }

    /**
     * 加密
     *
     * @param content 要加密的数据
     * @param key     加密密钥
     * @param iv      偏移量
     * @return 加密后的Base64字符串
     */
    public static String encrypt(String content, String key, String iv) {
        try {
            byte[] contentBytes = content.getBytes("utf-8");
            byte[] keyBytes = key.getBytes();
            byte[] ivBytes = iv.getBytes();
            byte[] encryptBytes = encrypt(contentBytes, keyBytes, ivBytes);
            return Base64.encodeBase64(encryptBytes).toString().replace("/", "_").replace("+","-").replace("=","*");
        } catch (Exception e) {
            LOGGER.error("AES加密出现异常--",e);
        }
        return null;
    }

    /**
     * 解密
     *
     * @param content 要解密的数据
     * @param key     解密密钥
     * @param iv      偏移量
     * @return 解密后明文字符串
     */
    public static String decrypt(String content, String key, String iv) {
        try {
            byte[] contentBytes = Base64.decodeBase64(content.replace("_", "/").replace("-","+").replace("*","=").getBytes());
            byte[] keyBytes = key.getBytes();
            byte[] ivBytes = iv.getBytes();
            byte[] decryptBytes = decrypt(contentBytes, keyBytes, ivBytes);
            return new String(decryptBytes,"utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("AES解密出现异常--",e);
        }
        return null;
    }

    public static void main(String[] args) {
        //密钥16字节
        String key = "cd49c34d7e0aoahz";
        //偏移量 16字节
        String iv = "cd49c34d7e0a4971";
        //明文
        String data = "中华人民共和国中华人民共和国’火fjwqpeojerwp;iosapfjdsl;f";
        System.out.println("明文:" + data);
        String encrypt = encrypt(data, key, iv);
        System.out.println("加密后:" + encrypt);
        String decrypt = decrypt(encrypt, key, iv);
        System.out.println("解密后：" + decrypt);
    }

}