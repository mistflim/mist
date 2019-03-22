package sf.wj.base;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 8513602639307935703L;
    private int code;

    private String msg;


    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
