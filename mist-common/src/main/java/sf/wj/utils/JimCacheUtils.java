package sf.wj.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 缓存工具类
 */
@Component
public class JimCacheUtils {
    private final static Logger logger = LoggerFactory.getLogger(JimCacheUtils.class);

//    @Resource(name = "lifeCacheUtil")
//    private LifeCacheUtil lifeCacheUtil;
    public Long incr(String key) {
//        try {
//            return lifeCacheUtil.incr(key);
//        } catch (Exception e) {
//            logger.error(String.format("incr error,key:%s", key), e);
//        }
        return 0L;
    }

    public Long incr(String key, long exp) {
//        try {
//            return lifeCacheUtil.incrByEx(key, 1, (int) exp);
//        } catch (Exception e) {
//            logger.error(String.format("incr error,key:%s", key), e);
//        }
        return 0L;
    }

    /**
     * 传入每次原子加的数量
     * @param key
     * @param num
     * @return
     */
    public Long incrByNum(String key, long num) {
//        try {
//            return lifeCacheUtil.incrBy(key,num);
//        } catch (Exception e) {
//            logger.error(String.format("incr error,key:%s", key), e);
//        }
        return 0L;
    }

    public Long incrByEx(String key, long by, int exp) {
//        try {
//            return this.lifeCacheUtil.incrByEx(key, by, exp);
//        } catch (Exception var6) {
//            logger.error("incrByEx error!key is:" + key, var6);
//            return null;
//        }
        return null;
    }

    public Long del(String key) {
//        try {
//            return lifeCacheUtil.del(key);
//        } catch (Exception e) {
//            logger.error(String.format("del error,key:%s", key), e);
//        }
        return 0L;
    }

    /**
     * 设置Object 缓存
     *
     * @param key   缓存key
     * @param value 值
     */
//    public void setObject(String key, Object value) {
//        lifeCacheUtil.setObject(key, value);
//    }

    /**
     * 设置Object 缓存，传入缓存时间
     *
     * @param key   缓存key
     * @param value 值
     * @param exp   过期时间 单位：秒
     */
    public void setObject(String key, Object value, long exp) {
//        try {
//            lifeCacheUtil.setObjectEx(key, (int) exp, value);
//        } catch (Exception e) {
//            logger.error(String.format("setObject error,key:%s,value:%s,exp:%d", key, value, exp), e);
//        }
    }

    public Object getObject(String key) {
//        try {
//            return lifeCacheUtil.getObject(key);
//        } catch (Exception e) {
//            logger.error(String.format("getObject error,key:%s", key), e);
//        }
        return null;
    }

    public String get(String key) {
//        try {
//            return this.lifeCacheUtil.get(key);
//        } catch (Exception var3) {
//            logger.error("get error!key is:" + key, var3);
//            return null;
//        }
        return null;
    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    public boolean isExists(String key) {
//        try {
//            return lifeCacheUtil.exists(key);
//        } catch (Exception e) {
//            logger.error("isExists error! key is: {}, errorMsg: {}", key, e);
//            return false;
//        }
        return false;
    }

    /**
     * 存入一个或多个值到集合，并设置有效期
     *
     * @param key    缓存key
     * @param values 值
     * @param exp    过期时间 单位：秒
     * @return 成功存放数据个数
     */
//    public Long lPush(String key, int exp, String... values) {
//        return lifeCacheUtil.lpushEx(key, exp, values);
//    }

    /**
     * 存入一个或多个值到集合，并设置有效期
     *
     * @param key    缓存key
     * @param values 值
     * @return 成功存放数据个数
     */
//    public Long lPush(String key, String... values) {
//        return lifeCacheUtil.lpush(key, values);
//    }

    /**
     * 截取集合，只保留指定数据元素
     *
     * @param key   缓存key
     * @param start 开始位置
     * @param end   结束位置
     */
//    public void lTrim(String key, int start, int end) {
//        lifeCacheUtil.ltrim(key, start, end);
//    }

    /**
     * 返回有序集 key 中，指定区间内的成员
     *
     * @param key   缓存key
     * @param start 开始位置
     * @param end   结束位置
     * @return 指定集合大小数据
     */
//    public List<String> lRange(String key, int start, int end) {
//        return lifeCacheUtil.lrange(key, start, end);
//    }

    /**
     * 为有序集 key 的成员 member 的 score 值加上增量 increment
     *
     * @param key       缓存key
     * @param increment 增量
     * @param member    member
     * @return 缓存KEY的新值
     */
//    public Double zIncrby(String key, double increment, String member) {
//        return lifeCacheUtil.getCacheClient().zIncrBy(key, increment, member);
//    }

    /**
     * 返回有序集 key 中，指定区间内的成员
     *
     * @param key   缓存key
     * @param start 开始位置
     * @param end   结束位置
     * @return 指定区间内的成员
     */
//    public Set<String> zRevRange(String key, int start, int end) {
//        return lifeCacheUtil.getCacheClient().zRevRange(key, start, end);
//    }

    /**
     * 返回有序集 key 中，指定区间内的成员和值
     * @param key
     * @param start
     * @param end
     * @return
     */
//    public Set<StringTuple> zRevRangeWithScores(String key, int start, int end) {
//        return lifeCacheUtil.getCacheClient().zRevRangeWithScores(key,start,end);
//    }


    /**
     * 设置KEY的有效期
     *
     * @param key 缓存key
     */
    public void expire(String key, int exp) {
//        lifeCacheUtil.expire(key, exp);
    }
}
