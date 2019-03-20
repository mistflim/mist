package sf.wj.validator;

import sf.wj.fluentvalidator.ValidationError;
import sf.wj.fluentvalidator.Validator;
import sf.wj.fluentvalidator.ValidatorContext;
import sf.wj.vo.User;

/**
 * Created by wangjun32 on 2018/9/13.
 */
public class UserValidator implements Validator<User> {
    @Override
    public boolean validate(ValidatorContext context, User user) {
        if (user.getName() == null) {
            context.addError(ValidationError.create("name不能为NULL！").
                    setErrorCode(10001).
                    setField("name").
                    setInvalidValue(user));
            return false;
        }
        return false;
    }
}
