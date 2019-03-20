package sf.wj.common.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Date: 2015/11/19
 * Time: 21:13
 * To change this template use File | Settings | File Templates.
 */
public class WorkUtil {
    private final static Logger log = LoggerFactory.getLogger(WorkUtil.class);
    private static String ipAddress = "127.0.0.1";

    static {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            log.info("操作系统：" + os);
            Enumeration<NetworkInterface> interfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            while (interfaceEnumeration.hasMoreElements()) {
                NetworkInterface networkInterface = interfaceEnumeration.nextElement();
                String interfaceName = networkInterface.getDisplayName().toLowerCase();
                if (os.indexOf("windows") >= 0) {
                    if (interfaceName.indexOf("lan") >= 0) {
                        String address = getIP4(networkInterface);
                        if (address != null) {
                            ipAddress = address;
                            break;
                        }
                    }
                } else {
                    // 注意：添加新机器如果服务器的网卡不是 eth or bond 将拿不到IP，新网卡需要添加判断条件
                    if (interfaceName.indexOf("eth") >= 0 || interfaceName.indexOf("bond") >= 0) {
                        String address = getIP4(networkInterface);
                        if (address != null) {
                            ipAddress = address;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("获取本机ip地址失败", e);
            log.error("interfaceName.indexOf(eth)============", e);
        }

        if ("127.0.0.1".equals(ipAddress)) {
            try {
                ipAddress = InetAddress.getLocalHost().getHostAddress();
            } catch (Exception e) {
                //ignore
                log.error("interfaceName.ignore ============", e);
            }
        }

//        log.info("获取的本机ip为：" + ipAddress);
    }

    private static String getIP4(NetworkInterface networkInterface) {
        for (Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses(); inetAddressEnumeration.hasMoreElements(); ) {
            InetAddress addr = inetAddressEnumeration.nextElement();
//            log.info(" InetAddress addr = inetAddressEnumeration.nextElement()=" + addr.getHostAddress() + "=====" + addr.isLoopbackAddress());
            if (!addr.isLoopbackAddress()) {

//                log.info(" InetAddress addr = " + addr.getHostAddress() + "===============" + (addr instanceof Inet4Address));
                if (addr instanceof Inet4Address) {
                    return addr.getHostAddress();
                }
            }
        }
        return null;
    }

    public static String getLocalIpAddress() {
        return ipAddress;
    }

    /**
     * 将一个 JavaBean 对象转化为一个  Map
     *
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     * @throws IntrospectionException    如果分析类属性失败
     * @throws IllegalAccessException    如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static Map<String,String> convertBean(Object bean)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Class type = bean.getClass();
        Map<String,String> returnMap = new HashMap();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean);
                if (result != null) {
                    returnMap.put(propertyName, result.toString());
                }
            }
        }
        return returnMap;
    }
}
