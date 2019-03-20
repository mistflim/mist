package sf.wj.web.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

/**
 * Created by wangjun32 on 2018/4/17.
 */
public class JsonHttpMessageConverter  extends FastJsonHttpMessageConverter {

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        // TODO Auto-generated method stub
//        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH";
        JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteNullStringAsEmpty);
        super.writeInternal(obj, outputMessage);

    }

}
