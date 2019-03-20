package sf.wj.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import sf.wj.web.aop.LogAspect;
import sf.wj.web.aop.MathCalculator;

/**
 * Created by wangjun32 on 2019/1/18.
 * AOP【动态代理】:
 *      指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运维的编程方式
 *      1、导入aop模块：Spring aop：（spring-aspects）
 *      2、定义一个业务逻辑类（MathCalculator）；在业务逻辑运行的时候讲日志打出来（前、后，异常等）
 *      3、定义一个日志切面类（LogAspect）；切面类里面的方法需要动态感知运行到哪里了
 *          通知方法：
 *              前置通知(@Before)：logStart():在目标方法（div）运行之前
 *              后置通知(@After)：logEnd
 *              返回通知(@AfterReturning)：logReturn
 *              异常通知(@AfterException：logException
 *              环绕通知(@Around)：动态代理；手动推进方法运行（joinPoint.proced()）
 *      4、给切面类的目标方法标注何时何地运行（通知注解）
 *      5、将切面类和业务逻辑类（目标方法所在类）都加入到容器中
 *      6、必须告诉spring哪个类是切面类（给切面类上加一个注解：@Aspect）
 *     *7、给配置类中加@@EnableAspectJAutoProxy【开启基于注解的aop模式】
 *
 *     三步：
 *          1、将业务逻辑中间和切面类都加入到容器中，并且告诉哪个是切面类（@Aspect）
 *          2、将切面类上的每一个通知方法标注通知注解，告诉spring何时切入
 *          3、开启基于注解的aop模式：EnableAspectJAutoProxy
 *
 *     AOP原理：【看给容器中注册了什么组件，这个组件什么时候工作，这个组件的功能是什么】
 *          @EnableAspectJAutoProxy
 *     1、@EnableAspectJAutoProxy 是什么
 *          @Import(AspectJAutoProxyRegistrar.class)：给容器中导入AspectJAutoProxyRegistrar
 *              利用AspectJAutoProxyRegistrar自定义给容器中注册bean；
 *              internalAutoProxyCreator = AnnotationAwareAspectJAutoProxyCreator
 *          给容器中注册一个AnnotationAwareAspectJAutoProxyCreator；
 *
 *     2、AnnotationAwareAspectJAutoProxyCreator；
 *          AnnotationAwareAspectJAutoProxyCreator
 *              ->AspectJAwareAdvisorAutoProxyCreator
 *                  ->AbstractAdvisorAutoProxyCreator
 *                      ->AbstractAutoProxyCreator
 *                          implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *                       关注后置（*BeanPostProcessor）处理器（在bean初始化完成前后做的事情）、自动装配BeanFactory
 *
 *   AbstractAutoProxyCreator.setBeanFactory()
 *   AbstractAutoProxyCreator.postProcessBeforeInstantiation()
 *
 *   AbstractAdvisorAutoProxyCreator.setBeanFactory()->initBeanFactory()
 *
 *   AnnotationAwareAspectJAutoProxyCreator.initBeanFactory()
 *
 *   流程：
 *      1、传入配置类、创建ioc容器
 *      2、注册配置类，调用refresh（）刷新容器
 *
 *
 */

/**
 * @Configuration 这是个配置类
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    //业务逻辑类加入容器中
    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }
    //切面类加入容器中
    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }


}
