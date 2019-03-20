package sf.wj.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangjun32 on 2018/9/21.
 */
public class TestHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestHandler.class);
    /**
     * 重入锁
     */
    private final ReentrantLock lock = new ReentrantLock();
    /**
     * 线程池
     */
    private ThreadPoolTaskExecutor threadPool;

    public void excute() {
        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                threadPool.execute(() -> {
                   while (true){
                       System.out.println("1111");
                   }
                });
            }else{
                //如果没有获取到锁，退出
                return;
            }
        } catch (InterruptedException e) {
            LOGGER.info("线程被中断，e:{}", e.getMessage());
        }finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }


    public void setThreadPool(ThreadPoolTaskExecutor threadPool) {
        this.threadPool = threadPool;
    }
}
