package sf.wj.web.util;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;

import java.math.BigInteger;

/**
 * Created by wangjun32 on 2018/4/18.
 */
public class FastJsonConfigExt extends FastJsonConfig {

    public FastJsonConfigExt() {
        super();
        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
        serializeConfig.put(Long.class, ToStringSerializer.instance);
        serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
        this.setSerializeConfig(serializeConfig);
    }

}
