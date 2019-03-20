package sf.wj.interceptor;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sf.wj.annotation.DeCsrf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjun32 on 2017/9/8.
 */
public class ComInterceptor implements HandlerInterceptor {

    private final static Log LOGGER = LogFactory.getLog(ComInterceptor.class);

    @Value("${host.csrf}")
    private String host;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            DeCsrf annotation = method.getMethodAnnotation(DeCsrf.class);
            if (annotation != null) {
                if (annotation.required()) {
                    String referer = request.getHeader("referer");
                    LOGGER.info("ComInterceptor referer: " + referer);
                    if (StringUtils.isEmpty(referer)) {
                        toResult(response);
                        return false;
                    }
                    if (referer.indexOf("http://") != 0 && referer.indexOf("https://") != 0) {
                        toResult(response);
                        return false;
                    }
                    if (referer.contains("?")) {
                        referer = referer.substring(0, referer.indexOf("?"));
                    }
                    URI uri = new URI(referer);
                    LOGGER.info("ComInterceptor uri: " + uri);
                    String refer = uri.getHost().toLowerCase();
                    if (!refer.endsWith(host)) {
                        toResult(response);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void toResult(HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<>(16);
        map.put("code", "333");
        map.put("msg", "你走开！");
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(map));
        writer.flush();
        writer.close();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}