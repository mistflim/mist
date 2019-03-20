package sf.wj.fluentvalidator.result;

import sf.wj.fluentvalidator.ValidationError;

/**
 * 复杂返回结果
 */
public class ComplexResult extends GenericResult<ValidationError> {
    @Override
    public String toString() {
        return String.format("Result{isSuccess=%s, errors=%s, timeElapsedInMillis=%s}", isSuccess(), errors,
                timeElapsed);
    }

    private int timeElapsed;

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(int timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}
