package sf.wj.fluentvalidator.annotation;

/**
 * Created by wangjun32 on 2018/9/13.
 */
import java.lang.annotation.*;

/**
 * 标记为非线程安全的注解，标示类或者方法不是必须线程安全实现的
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotThreadSafe {
}
