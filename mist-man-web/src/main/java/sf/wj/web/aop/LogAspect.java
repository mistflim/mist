package sf.wj.web.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by wangjun32 on 2019/1/18.
 * @Aspect 切面类
 */
@Aspect
public class LogAspect {

    //抽取公共的切入点表达式
    //1、本类引用 pointCut()
    //2、其他的切面引用
    @Pointcut("execution(public int sf.wj.web.aop.MathCalculator.*(..))")
    public void pointCut(){};

    @Before("pointCut()")
    public  void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"除法运行。。。@Before参数是：{"+args+"}");
    }
    @After("sf.wj.web.aop.LogAspect.pointCut()")
    public  void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"除法结束。。。");
    }
    @AfterReturning(value = "pointCut()",returning = "result")
    //JoinPoint 一定要出现在参数的第一位
    public  void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+"除法正常返回。。。@AfterReturning运行结果：{"+result+"}");
    }
    @AfterThrowing(value = "pointCut()",throwing = "e")
    public  void logException(JoinPoint joinPoint,Exception e){
        System.out.println(joinPoint.getSignature().getName()+"除法异常。。。@AfterThrowing异常信息：{"+e+"}");
    }
}
