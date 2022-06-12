package com.common;


import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private Integer code; // 200是正常，非200表示异常
    private String msg;
    private Object data;

    public static Result success(Object data) {
        return success(200, "操作成功", data);
    }
    public static Result success(Object data,String msg) {
        return success(200, msg, data);
    }

    public static Result success(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result fail() {
        return fail(400, null, "操作失败");
    }
    public static Result fail(String msg) {
        return fail(400, msg, null);
    }

    public static Result fail(Object data,String msg) {
        return fail(400, data,msg );
    }

    public static Result fail(int code,Object data,String msg) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

}
