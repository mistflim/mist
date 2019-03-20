package sf.wj.test.controller.ioc;

import org.junit.Test;
import org.junit.runner.Result;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import sf.wj.web.callback.CallBackRestTemplate;

import java.util.HashMap;

/**
 * Created by wangjun32 on 2018/9/20.
 */
public class CallBackClientTest {
    @Test
    public void test(){
        RestTemplate restTemplate = CallBackRestTemplate.getInstance();
        org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        restTemplate.exchange("http://baidu.com", HttpMethod.POST,new HttpEntity<Object>(new HashMap<>(),httpHeaders), Result.class);
    }
}
