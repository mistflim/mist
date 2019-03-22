package sf.wj.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HmacUtil {
    private static final String HMAC_SHA256 = "HmacSHA256";//HmacSHA1
    /**
     *
     * @param data 待加密的数据
     * @param key 加密使用的key
     * @return 生成签名数据
     * @throws Exception
     */
    public static String getSignature(String data,String key){
        byte[] keyBytes = key.getBytes();
        SecretKeySpec signingKey = new SecretKeySpec(keyBytes, HMAC_SHA256);
        Mac mac = null;
        try {
            mac = Mac.getInstance(HMAC_SHA256);
            mac.init(signingKey);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            return null;
        }
        byte[] rawHmac = mac.doFinal(data.getBytes());
        StringBuilder sb=new StringBuilder();
        for(byte b:rawHmac){
            sb.append(byteToHexString(b));
        }
        return sb.toString();
    }

    private static String byteToHexString(byte ib){
        char[] Digit={
                '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'
        };
        char[] ob=new char[2];
        ob[0]=Digit[(ib>>>4)& 0X0f];
        ob[1]=Digit[ib & 0X0F];
        String s=new String(ob);
        return s;
    }
}

