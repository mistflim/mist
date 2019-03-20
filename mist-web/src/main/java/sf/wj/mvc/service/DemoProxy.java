package sf.wj.mvc.service;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by wangjun32 on 2019/2/15.
 */
public class DemoProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(final Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("查询全校");
        Object result = methodProxy.invokeSuper(o, args);
        System.out.println("这个人是你未来另一半");
        return null;
    }
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("查询全校");
//        Object result = method.invoke(target, args);
//        System.out.println("这个人是你未来另一半");
//        return result;
//    }

//
//    @Override
//    public void query(String name) {
//        target.query(name);
//    }
}
