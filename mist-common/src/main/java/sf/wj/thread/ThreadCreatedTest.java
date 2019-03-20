package sf.wj.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by wangjun32 on 2019/3/15.
 */
public class ThreadCreatedTest {
    public static void main(String[] args) throws Exception {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(Thread.currentThread().getName() + "out:" + i);
//            MyTest my = new MyTest();
//            my.start();
//        }


//        new Thread(new MyTest2()).start();



        MyTest3 my3 = new MyTest3();
        FutureTask futureTask = new FutureTask(my3);


        new Thread(futureTask).start();
        System.out.println( futureTask.get());

    }

    static class MyTest extends Thread {
        @Override
        public void run() {
//            try {
//                TimeUnit.MILLISECONDS.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("线程跑起来了。。。");


            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    static class MyTest2 implements Runnable {

        @Override
        public void run() {
            System.out.println("我继承了runable接口...");
        }
    }

    static class MyTest3 implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "你好啊";
        }
    }
}
