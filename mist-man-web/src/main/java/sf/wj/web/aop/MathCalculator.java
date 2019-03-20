package sf.wj.web.aop;

/**
 * Created by wangjun32 on 2019/1/18.
 */
public class MathCalculator {

    public int div(int i, int j) {
        System.out.println("除法被调用。。。");
        return i / j;
    }
}
