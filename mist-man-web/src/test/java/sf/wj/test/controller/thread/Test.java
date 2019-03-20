package sf.wj.test.controller.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangjun32 on 2018/11/20.
 */
public class Test {
    private static boolean is = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (is) {
                    i++;
                }
                System.out.println("i=" + i);
            }
        }).start();
        System.out.println("11111");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        is = false;
        System.out.println("dsadsadsadas");
    }
}
