package sf.wj.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import sf.wj.domain.vo.Person;
import sf.wj.web.conditional.WindowsConditional;

/**
 * Created by wangjun32 on 2019/1/10.
 */
@Configuration
@ComponentScan(value = "sf.wj", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
})
@PropertySource(value = {"classpath:common.properties","classpath:aaa.properties"})
public class MainConfig2 {
    @Value("${person.name}")
    private String name;

    @Value("${person.sex}")
    private String sex;

    @Bean("ppp")
    @Lazy
    @Conditional(WindowsConditional.class)
//    @Scope("prototype")
    public Person getPerson(){
        System.out.println("给容器添加bean...");
        return new Person(name,sex);
    }
}
