package com.zl.spbm.enums;

/**
 *
 */
public enum ResultEnums {
    //
    OK(0, "成功！"),
    //
    FAIL(1, "失败");
    private Integer result;
    private String message;

    ResultEnums(Integer result, String message) {
        this.result = result;
        this.message = message;
    }

    public Integer getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
