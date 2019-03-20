package sf.wj.mvc.action;

/**
 * Created by wangjun32 on 2019/2/18.
 */
public class Single {
    private Single() {
    }

    private static class GetSingle {
        private static final Single single =new Single();
    }

    public static Single getIntance() {
        return GetSingle.single;
    }
}
