package sf.wj.test.controller.ioc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sf.wj.web.aop.MathCalculator;
import sf.wj.web.config.MainConfigOfAOP;

/**
 * Created by wangjun32 on 2019/1/18.
 */
public class IOCTest_AOP {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        //1、不要自己创建对象，从容器中获取
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1,0);

        applicationContext.close();
    }

}
