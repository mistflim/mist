package sf.wj.fluentvalidator.annotation;

/**
 * Created by wangjun32 on 2018/9/13.
 */
import java.lang.annotation.*;

/**
 * 标记为有状态的，反义词为无状态的stateless
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Stateful {
}
