package sf.wj.fluentvalidator.util;

/**
 * Created by wangjun32 on 2018/9/13.
 */
public interface Function<F,T> {
    /**
     * Returns the result of applying this function to {@code input}.
     */
    T apply(F input);
}
