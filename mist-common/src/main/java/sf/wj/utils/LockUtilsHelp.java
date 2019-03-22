package sf.wj.utils;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class LockUtilsHelp {
    @Resource
    private JimCacheUtils jimCacheUtils;

    /**
     * 使用场景
     * 1. 该场景适用有N个并发执行某个业务
     * 只要有一个执行成功lock后面的业务，N-1个并发就不用再次执行那后面的业务，防止锁超时
     * 2. 该锁内置一个备用并发锁 用于检查是否获取锁 类似double-check
     *
     * @param key
     * @param exp
     * @param timeout
     * @return
     */
    public boolean lockWithInnerCheck(String key, int exp, int timeout) {
        long timeWait = System.currentTimeMillis() + timeout * 1000;
        while (System.currentTimeMillis() < timeWait) {
            if (jimCacheUtils.isExists(key + "_bak")) {//设置备用钥匙 表示已处理成功
                return false;  //默认获取锁失败
            }
            Long resut = jimCacheUtils.incrByNum(key, 1);
            if (null != resut && resut.intValue() == 1) {
                jimCacheUtils.expire(key, exp);
                //double-check
                return !jimCacheUtils.isExists(key + "_bak");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (Exception e) {
            }
        }
        throw new RuntimeException("lock time out ");
    }

    public void unLockWithInnerCheck(String key) {
        try {
            jimCacheUtils.incrByEx(key + "_bak", 1, 5);//设置备用钥匙 表示已处理成功
            jimCacheUtils.del(key);
        } catch (Exception e) {
        }
    }
    public JimCacheUtils getLifeCacheUtil(){
        return jimCacheUtils;
    }
}
