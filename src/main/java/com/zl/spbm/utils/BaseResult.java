package com.zl.spbm.utils;

import com.zl.spbm.enums.ResultEnums;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @param <T>
 */
@Data
public class BaseResult<T> implements Serializable {
    private static final long serialVersionUID = -3656148728060714908L;
    private int result;
    private String message;
    private T data;

    private BaseResult(int result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public static <T> BaseResult<T> ok(@NotNull(message = "返回对象不能为空！") T t) {
        return new BaseResult<>(ResultEnums.OK.getResult(), ResultEnums.OK.getMessage(), t);
    }

    public static <T> BaseResult<T> ok() {
        return new BaseResult<>(ResultEnums.OK.getResult(), ResultEnums.OK.getMessage(), null);
    }

    public static <T> BaseResult<T> fail() {
        return new BaseResult<>(ResultEnums.FAIL.getResult(), ResultEnums.FAIL.getMessage(), null);
    }

    public static <T> BaseResult<T> fail(String message) {
        if(message != null) {
            return new BaseResult<>(ResultEnums.FAIL.getResult(), message, null);
        }
        return fail();
    }
}
