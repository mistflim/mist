package sf.wj.web.controller.test;

import org.springframework.stereotype.Controller;

/**
 * Created by wangjun32 on 2018/9/12.
 */
@Controller
public class Son extends Papa{
    static int i = 1;

    static {
        System.out.println("son1:static blocks i=" + i);
    }

    int j = 1;

    static {
        i++;
        System.out.println("son2:static blocks i=" + i);
    }

    public Son() {
        super();
        i++;
        j++;
        System.out.println("son constructor i=" + i + "j=" + j);
    }

    {
        i++;
        j++;
        System.out.println("son common blocks i=" + i + "j=" + j);
    }


    public void sonDisplay() {
        i++;
        System.out.println("son void papDisplay():i=" + i + "j=" + j);
        return;
    }

    public static void test() {
        i++;
        System.out.println("son static void test():i=" + i);
        return;
    }
    
}
