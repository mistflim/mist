package sf.wj.fluentvalidator.element;

import sf.wj.fluentvalidator.Validator;

/**
 * Created by wangjun32 on 2018/9/13.
 */
public class ValidatorElement {
    /**
     * 验证器
     */
    private Validator validator;

    /**
     * 待验证对象
     */
    private Object target;


    /**
     * create
     *
     * @param target    待验证对象
     * @param validator 验证器
     */
    public ValidatorElement(Object target, Validator validator) {
        this.target = target;
        this.validator = validator;
    }


    public Object getTarget() {
        return target;
    }

    public Validator getValidator() {
        return validator;
    }

    @Override
    public String toString() {
        return String.format("%s@%s", target == null ? "null" : target.getClass().getSimpleName(), validator);
    }
}
