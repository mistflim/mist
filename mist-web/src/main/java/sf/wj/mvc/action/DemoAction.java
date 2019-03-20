package sf.wj.mvc.action;

import sf.wj.mvc.framework.annocation.WjAutowired;
import sf.wj.mvc.framework.annocation.WjController;
import sf.wj.mvc.framework.annocation.WjRequestMapping;
import sf.wj.mvc.framework.annocation.WjRequestParam;
import sf.wj.mvc.service.DemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangjun32 on 2019/2/12.
 */
@WjController
@WjRequestMapping("/test")
public class DemoAction {

    @WjAutowired
    private DemoService ddservice;

    @WjRequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response,@WjRequestParam("name") String name) {
        ddservice.query(name);
    }

}
