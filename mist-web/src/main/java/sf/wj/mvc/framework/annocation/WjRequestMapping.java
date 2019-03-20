package sf.wj.mvc.framework.annocation;

import java.lang.annotation.*;

/**
 * Created by wangjun32 on 2019/2/12.
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WjRequestMapping {
    String value() default "";
}
