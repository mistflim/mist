package sf.wj.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangjun32 on 2019/3/16.
 */
public class ThreadPoolTest2 {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,4,5, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1));
        //核心线程3个，最大线程数6个，LinkedBlockingDeque
        //当任务超过核心线程数时，会将超出的任务放入队列中，只会创建3个线程重复使用
        //LinkedBlockingDeque不受最大线程数影响，但当LinkedBlockingDeque有大小限制时就会受到最大线程影响了
        Thread1 thread1 = new Thread1();
        threadPoolExecutor.execute(thread1);
        threadPoolExecutor.execute(thread1);
        threadPoolExecutor.execute(thread1);
        System.out.println("---先开三个---");
        System.out.println("核心线程数："+threadPoolExecutor.getCorePoolSize());
        System.out.println("线程池数："+threadPoolExecutor.getPoolSize());
        System.out.println("队列任务数："+threadPoolExecutor.getQueue().size());
        threadPoolExecutor.execute(thread1);
        threadPoolExecutor.execute(thread1);
        threadPoolExecutor.execute(thread1);
        System.out.println("---再开三个---");
        System.out.println("核心线程数："+threadPoolExecutor.getCorePoolSize());
        System.out.println("线程池数："+threadPoolExecutor.getPoolSize());
        System.out.println("队列任务数："+threadPoolExecutor.getQueue().size());
        Thread.sleep(8000);
        System.out.println("---睡眠8s后---");
        System.out.println("核心线程数："+threadPoolExecutor.getCorePoolSize());
        System.out.println("线程池数："+threadPoolExecutor.getPoolSize());
        System.out.println("队列任务数："+threadPoolExecutor.getQueue().size());
    }

    static class Thread1 implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
