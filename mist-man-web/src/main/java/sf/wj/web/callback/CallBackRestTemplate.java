package sf.wj.web.callback;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * \回调
 */
public class CallBackRestTemplate {
    private static volatile RestTemplate restTemplate;

    private CallBackRestTemplate() {
    }

    static{
        CloseableHttpClient httpClient = HttpClients.custom()
                //Connection管理器
                .setConnectionManager(new PoolingHttpClientConnectionManager())
                //最大HttpConnection连接数
                .setMaxConnTotal(CallBackConsts.MAXCONN_TOTAL)
                //每个路由最大连接数
                .setMaxConnPerRoute(CallBackConsts.MAXCONN_PERROUTE)
                //Request配置
                .setDefaultRequestConfig(RequestConfig.custom()
                        //从连接池获取连接超时时间
                        .setConnectionRequestTimeout(CallBackConsts.CONNECTION_REQUEST_TIMEOUT)
                        //与目标服务器建立连接超时时间
                        .setConnectTimeout(CallBackConsts.CONNECT_TIMEOUT)
                        //服务器获取响应数据超时时间
                        .setSocketTimeout(CallBackConsts.SOCKET_TIMEOUT)
                        .build())
                //默认重试策略重试策略
                .setRetryHandler(DefaultHttpRequestRetryHandler.INSTANCE)
                //Connection存活策略
                .setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
                //Connection默认消息头
                .setDefaultHeaders(Arrays.asList(
                        new BasicHeader("Accept-Encoding", "gzip,deflate"),
                        new BasicHeader("Accept","application/json")
                ))
                .build();
        //请求工厂
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        restTemplate = new RestTemplate(factory);
        //使用fastjson转换器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        restTemplate.getMessageConverters().add(fastJsonHttpMessageConverter);
    }
    public static RestTemplate getInstance(){
        return restTemplate;
    }
}
