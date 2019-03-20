package sf.wj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wangjun32 on 2017/9/8.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DeCsrf {
    /**
     * 是否需要拦截csrf <br/>
     * true 需要 <br/>
     * false 不需要 <br/>
     */
    boolean required();
}

