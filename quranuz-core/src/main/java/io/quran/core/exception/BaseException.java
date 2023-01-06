package io.quran.core.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException {
    private String code;
    private Object[] args;
    private HttpStatus status;
}
