package sf.wj.test;

import org.junit.Test;
import org.springframework.util.CollectionUtils;
import sf.wj.fluentvalidator.FluentValidator;
import sf.wj.fluentvalidator.ValidationError;
import sf.wj.fluentvalidator.result.ComplexResult;
import sf.wj.fluentvalidator.result.ResultCollectors;
import sf.wj.validator.UserValidator;
import sf.wj.vo.User;

import java.util.List;

/**
 * Created by wangjun32 on 2018/9/13.
 */
public class FluentValidatorTest {

    @Test
    public void test(){
        User user = new User("wj","m");
        ComplexResult ret = FluentValidator.checkAll()
                .on(user, new UserValidator())
                .doValidate().result(ResultCollectors.complexCollector());
        List<ValidationError> errors = ret.getErrors();
        if (CollectionUtils.isEmpty(errors)) {
            ret.isSuccess();
        }
        ret.isSuccess();
    }
}
