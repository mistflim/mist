package sf.wj.common.utils;

import io.leopard.javahost.JavaHost;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * Created by wangjun32 on 2019/3/19.
 */
@Component
public class HostUtil {

    private static Properties properties = new Properties();

    @PostConstruct
    public void excute() {
        System.out.println("---------------------HostUtil------------------------");
        properties.setProperty("baidu.com","127.0.0.1");
        JavaHost.updateVirtualDns(properties);
    }
}
