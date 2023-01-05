package io.quran.core.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException {
    public BadRequestException(String code, Object... args) {
        super(code, args, HttpStatus.BAD_REQUEST);
    }
}
