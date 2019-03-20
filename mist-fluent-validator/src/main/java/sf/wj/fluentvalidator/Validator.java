package sf.wj.fluentvalidator;

/**
 * 验证器接口
 */
public interface Validator<T> {
    /**
     * 验证接口
     *
     * @param context 校验上下文
     * @param t       待校验对象
     * @return 校验是否成功
     */
    boolean validate(ValidatorContext context, T t);
}
