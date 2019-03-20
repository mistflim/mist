package sf.wj.mvc.service.impl;


import sf.wj.mvc.framework.annocation.WjService;
import sf.wj.mvc.service.DemoService;

/**
 * Created by wangjun32 on 2019/2/12.
 */
@WjService
public class DemoServiceImpl implements DemoService {


    @Override
    public void query(String name) {
        System.out.println("当前查询的名字为：" + name);
    }
}
