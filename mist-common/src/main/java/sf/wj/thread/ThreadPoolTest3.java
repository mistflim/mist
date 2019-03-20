package sf.wj.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangjun32 on 2019/3/16.
 */
public class ThreadPoolTest3 {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,6,5, TimeUnit.SECONDS,new SynchronousQueue<>());
        //核心线程3个，最大线程数6个，SynchronousQueue
        //当任务超过核心线程数时，创建新的临时线程来执行（超时时间5s，超过最大线程数则抛出异常），线程最后会回收
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
