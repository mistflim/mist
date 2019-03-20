package sf.wj.fluentvalidator;


import sf.wj.fluentvalidator.element.ValidatorElementList;

import java.util.List;

/**
 * 默认回调函数
 */
public class DefaultValidateCallback implements ValidateCallback {
    @Override
    public void onSuccess(ValidatorElementList validatorElementList) {

    }

    @Override
    public void onFail(ValidatorElementList validatorElementList, List<ValidationError> errors) {

    }

    @Override
    public void onUncaughtException(Validator validator, Exception e, Object target) throws Exception {

    }
}
