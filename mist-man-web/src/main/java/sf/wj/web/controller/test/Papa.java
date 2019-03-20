package sf.wj.web.controller.test;

/**
 * Created by wangjun32 on 2018/9/12.
 */
public class Papa {
    static int i = 1;

    static {
        System.out.println("papa1:static blocks i=" + i);
    }

    int j = 1;

    static {
        i++;
        System.out.println("papa2:static blocks i=" + i);
    }

    public Papa() {
        i++;
        j++;
        System.out.println("papa constructor i=" + i + "j=" + j);
    }

    {
        i++;
        j++;
        System.out.println("papa common blocks i=" + i + "j=" + j);
    }

    public void papDisplay() {
        i++;
        System.out.println("papa void papDisplay():i=" + i + "j=" + j);
        return;
    }

    public static void test() {
        i++;
        System.out.println("papa static void test():i=" + i);
        return;
    }
}
