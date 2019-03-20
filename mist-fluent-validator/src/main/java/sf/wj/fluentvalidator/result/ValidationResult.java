package sf.wj.fluentvalidator.result;

import org.springframework.util.CollectionUtils;
import sf.wj.fluentvalidator.ValidationError;
import sf.wj.fluentvalidator.annotation.NotThreadSafe;
import sf.wj.fluentvalidator.util.CollectionUtil;

import java.util.List;

/**
 * Created by wangjun32 on 2018/9/13.
 */
@NotThreadSafe
public class ValidationResult {
    /**
     * 是否成功，一旦发生错误，即置为false，默认为{@value}
     */
    private boolean isSuccess = true;

    /**
     * 验证错误
     */
    private List<ValidationError> errors;

    /**
     * 验证总体耗时，指通过<code>FluentValidator.doValidate(..)</code>真正“及时求值”过程中的耗时
     */
    private int timeElapsed;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     * 添加错误
     *
     * @param error 错误
     */
    public void addError(ValidationError error) {
        if (CollectionUtils.isEmpty(errors)) {
            errors = CollectionUtil.createArrayList();
        }
        errors.add(error);
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(int timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}
