package com.lena;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ClassName NoFoundException
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/8/28 17:20
 * @Version 1.0
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoFoundException extends RuntimeException {
    public NoFoundException() {
    }

    public NoFoundException(String message) {
        super(message);
    }

    public NoFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
