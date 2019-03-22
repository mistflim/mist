package sf.wj.mvc.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import sf.wj.base.BaseResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求头校验
 */
public class HeadInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(HeadInterceptor.class);

    private static final String VERSION = "1.0.0";

//    @Autowired
//    private CacheUtils cacheUtils;
//    @Resource
//    private CouponHelper couponHelper;

    /**
     * 对请求消息头解析 鉴权验证
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //版本号
//        String version = request.getHeader(CouponHeader.VERSION);
//        //暂未使用
//        String acceptEncoding = request.getHeader("Accept-Encoding");
//        //商户id
//        String channel = request.getHeader(CouponHeader.CHANNEL);
//        //随机数
//        String nonce = request.getHeader(CouponHeader.NONCE);
//        //时间戳 yyyyMMddHHmmss
//        String timestamp = request.getHeader(CouponHeader.TIMESTAMP);
//        //签名
//        String signature = request.getHeader(CouponHeader.SIGNATURE);
//        LOGGER.info("拦截器----接口收请求,version:{},channel:{},nonce:{},timestamp:{},signature:{}", version, channel, nonce, timestamp, signature);
//        BaseResponse result = checkHeaderParams(version, channel, nonce, timestamp, signature, acceptEncoding);
//        if (result.getCode() != RpcResultEnum.SUCCESS.getCode()) {
//            LOGGER.info("拦截器---参数校验失败,timestamp:{},code:{},msg:{}", timestamp, result.getCode(), result.getMsg());
//            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//            response.setCharacterEncoding("UTF-8");
//            response.setStatus(HttpStatus.OK.value());
//            PrintWriter writer = response.getWriter();
//            //校验不通过，以JSON形式返回
//            writer.write(JSON.toJSONString(result));
//            writer.flush();
//            writer.close();
//            return false;
//        }
        return true;
    }

    /**
     * 证请求头信息
     *
     * @param version
     * @param channel
     * @param nonce
     * @param timestamp
     * @param signature
     * @param acceptEncoding
     * @return
     */

    private BaseResponse checkHeaderParams(String version, String channel, String nonce, String timestamp, String signature, String acceptEncoding) {
        BaseResponse result = new BaseResponse();
        //先对各参数做非空校验
        //version
//        if (StringUtils.isEmpty(version)) {
//            result.setCode(RpcResultEnum.PARAM_ERROR.getCode());
//            result.setMsg(String.format("参数错误：%s不能为空", "version"));
//            return result;
//        }
//        //channel
//        if (StringUtils.isEmpty(channel)) {
//            result.setCode(RpcResultEnum.PARAM_ERROR.getCode());
//            result.setMsg(MessageFormat.format("参数错误：{0}不能为空", "channel"));
//            return result;
//        }
//        //nonce
//        if (StringUtils.isEmpty(nonce)) {
//            result.setCode(RpcResultEnum.PARAM_ERROR.getCode());
//            result.setMsg(MessageFormat.format("参数错误：{0}不能为空", "nonce"));
//            return result;
//        }
//        //timestamp 非空，格式，长度校验
//        try {
//            if (StringUtils.isEmpty(timestamp) || timestamp.length() != 14) {
//                throw new Exception("timestamp长度错误");
//            }
//            DateTimeFormat.forPattern(CouponHeader.PATTERN).parseDateTime(timestamp);
//        } catch (Exception e) {
//            result.setCode(RpcResultEnum.PARAM_ERROR.getCode());
//            result.setMsg(String.format("timestamp:%s 格式错误", timestamp));
//            return result;
//        }
//        Duration duration = Duration.between(DateUtil.parseLocalDateStr(timestamp, DateUtil.YYYYMMDDHHMMSS), LocalDateTime.now());
////        if (duration.toMillis() > 15000) {
////            result.setCode(RpcResultEnum.PARAM_ERROR.getCode());
////            result.setMsg(String.format("timestamp:%s 超时", timestamp));
////            return result;
////        }
//        if (!nonce.startsWith(channel) || nonce.split(channel)[1].length() != 28) {
//            result.setCode(RpcResultEnum.CHANNEL_ERROR.getCode());
//            result.setMsg(MessageFormat.format("参数错误：nonce:{0},格式错误", nonce));
//            return result;
//        }
        //请求去重
//        if (cacheUtils.isExists(CacheKeyEnum.ORDER_REPEAT.format(nonce))) {
//            result.setCode(RpcResultEnum.REQUEST_REPET.getCode());
//            result.setMsg(RpcResultEnum.REQUEST_REPET.getMsg());
//            return result;
//        }
//        cacheUtils.setObjectEx(CacheKeyEnum.ORDER_REPEAT.format(nonce), CacheKeyEnum.ORDER_REPEAT.getExp(), nonce);

        //普通格式校验通过后，商户id校验
//        Vender vender = couponHelper.getVenderInfo(Long.parseLong(channel));
//        if (Objects.equals(vender, null) || null == vender.getId() || vender.getVStatus() != 1) {
//            result.setCode(RpcResultEnum.CHANNEL_ERROR.getCode());
//            result.setMsg(MessageFormat.format("参数错误：channel:{0},不存在", channel));
//            return result;
//        }
//        if (!Objects.equals(version, this.VERSION)) {
//            result.setCode(RpcResultEnum.PARAM_ERROR.getCode());
//            result.setMsg(MessageFormat.format("参数错误：版本号:{0}错误", version));
//            return result;
//        }
//        result.setCode(RpcResultEnum.SUCCESS.getCode());
        return result;
    }
}
