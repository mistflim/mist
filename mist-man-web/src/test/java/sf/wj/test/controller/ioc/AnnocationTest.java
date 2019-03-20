package sf.wj.test.controller.ioc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import sf.wj.domain.vo.Person;
import sf.wj.web.config.MainConfig2;

/**
 * Created by wangjun32 on 2019/1/10.
 */
public class AnnocationTest {
    AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test02(){
        ConfigurableEnvironment envi = anno.getEnvironment();
        System.out.println(envi.getProperty("os.name"));
    }
    
    @Test
    public void test01() {
        String[] names = anno.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        Person pp = (Person) anno.getBean("ppp");
        Person pp2 = (Person) anno.getBean("ppp");
        System.out.println(pp);
        System.out.println(pp ==pp2);
    }
}
