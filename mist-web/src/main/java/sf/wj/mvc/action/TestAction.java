package sf.wj.mvc.action;

import sf.wj.mvc.service.DemoProxy;
import sf.wj.mvc.service.DemoService;
import sf.wj.mvc.service.impl.DemoServiceImpl;

/**
 * Created by wangjun32 on 2019/2/12.
 */
public class TestAction {
    
    public static void main(String[] args){
        DemoService service = new DemoServiceImpl();
        DemoProxy cglibProxy = new DemoProxy();
        DemoServiceImpl aa = (DemoServiceImpl) cglibProxy.getInstance(service);
        aa.query("2b");
//        DemoProxy proxy = new DemoProxy(service);
//        proxy.query("wj");

//        DemoService aa = (DemoService)Proxy.newProxyInstance(DemoService.class.getClassLoader(),
//                new Class[]{DemoService.class}, new DemoProxy(service));
//        aa.query("aaa");

        Single single = Single.getIntance();
    }
}
