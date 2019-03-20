package sf.wj.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by wangjun32 on 2018/9/7.
 */
public class DateUtil {
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String YYYYMMDD = "yyyyMMdd";
    /**
     * 日期转换为字符串
     * @param time
     * @param format 日期格式 YYYY-MM-DD
     * @return
     */
    public static String formatDate(LocalDateTime time, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return time.format(formatter);
    }
}
