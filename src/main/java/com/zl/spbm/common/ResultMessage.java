package com.zl.spbm.common;

import java.util.HashMap;

/**
 * @Author: lzhang
 * @Date: 2019/6/17 18:09
 */
public class ResultMessage {
    private static final long serialVersionUID = 1111789298461357651L;
    private int result;
    private String message;
    private Object data;

    public ResultMessage(){}

    public ResultMessage(int result, String message, Object data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultMessage ok(Object t) {
        return new ResultMessage(0, "成功！", t);
    }
    public static ResultMessage fail(String measage) {
        return new ResultMessage(1, measage, new HashMap(0));
    }

    public static ResultMessage fail(int result, String measage) {
        return new ResultMessage(result, measage, new HashMap(0));
    }
}
