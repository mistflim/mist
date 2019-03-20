package sf.wj.web.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by wangjun32 on 2019/1/10.
 */
public class WindowsConditional implements Condition{


    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
       if( conditionContext.getEnvironment().getProperty("os.name").contains("Windows")){
           System.out.println("当前系统是windows。。。");
           return true;
       }
        return false;
    }
}
