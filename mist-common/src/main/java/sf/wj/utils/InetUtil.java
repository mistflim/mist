package sf.wj.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by wangjun32 on 2019/3/20.
 */
public class InetUtil {
    /**
     * 获取本机IP，
     * 可能返回null值
     *
     * @return
     */
    public static String getLocalIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
}
