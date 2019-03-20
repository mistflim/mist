package sf.wj.web.callback;

import org.springframework.stereotype.Service;

/**
 * httpclient连接池参数配置实体
 */
@Service
public class CallBackConsts {

    /**
     * 从连接池获取连接超时时间
     */
    public static final Integer CONNECTION_REQUEST_TIMEOUT = 200;
    /**
     * 与目标服务器建立连接超时时间
     */
    public static final Integer CONNECT_TIMEOUT = 2000;
    /**
     * 服务器获取响应数据超时时间
     */
    public static final Integer SOCKET_TIMEOUT = 2000;
    /**
     * 连接池最大连接数
     */
    public static final Integer MAXCONN_TOTAL = 500;
    /**
     * 每个路由最大连接数
     */
    public static final Integer MAXCONN_PERROUTE = 20;
}
