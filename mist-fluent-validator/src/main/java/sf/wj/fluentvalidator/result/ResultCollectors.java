package sf.wj.fluentvalidator.result;

import sf.wj.fluentvalidator.util.CollectionUtil;
import sf.wj.fluentvalidator.util.Supplier;

public class ResultCollectors {
    /**
     * 框架提供的一个简单结果收集器
     */
    static class SimpleResultCollectorImpl implements ResultCollector<SimpleResult> {

        @Override
        public SimpleResult toResult(ValidationResult result) {
            SimpleResult ret = new SimpleResult();
            if (result.isSuccess()) {
                ret.setIsSuccess(true);
            } else {
                ret.setIsSuccess(false);
                ret.setErrors(CollectionUtil.transform(result.getErrors(), input -> input.getErrorMsg()));
            }

            return ret;
        }
    }

    /**
     * 静态方法返回一个简单结果收集器
     *
     * @return 简单的结果收集器<code>ResultCollectorImpl</code>
     */
    public static ResultCollector<SimpleResult> simpleCollector() {
        return new SimpleResultCollectorImpl();
    }

    /**
     * @param supplier 供给模板
     * @param result   内部用验证结果
     * @param <T>      结果的泛型
     * @return 结果
     */
    static <T extends ComplexResult> T newComplexResult(Supplier<T> supplier, ValidationResult result) {
        T ret = supplier.get();
        if (result.isSuccess()) {
            ret.setIsSuccess(true);
        } else {
            ret.setIsSuccess(false);
            ret.setErrors(result.getErrors());
        }

        ret.setTimeElapsed(result.getTimeElapsed());
        return ret;
    }

    /**
     * 框架提供的一个复杂结果收集器
     */
    static class ComplexResultCollectorImpl implements ResultCollector<ComplexResult> {

        @Override
        public ComplexResult toResult(ValidationResult result) {
            return newComplexResult(new Supplier<ComplexResult>() {
                public ComplexResult get() {
                    return new ComplexResult();
                }
            }, result);
        }
    }
    /**
     * 静态方法返回一个复杂结果收集器
     *
     * @return 简单的结果收集器<code>ComplexResultCollectorImpl</code>
     */
    public static ResultCollector<ComplexResult> complexCollector() {
        return new ComplexResultCollectorImpl();
    }
}
