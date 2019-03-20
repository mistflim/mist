package sf.wj.fluentvalidator.result;

/**
 * Created by wangjun32 on 2018/9/13.
 */
public interface ResultCollector<T> {
    /**
     * 转换为对外结果
     *
     * @param result 框架内部验证结果
     *
     * @return 对外验证结果对象
     */
    T toResult(ValidationResult result);
}
