package io.quran.core.exception;
import io.quran.core.dto.ErrorResponse;
import io.quran.core.service.MessageResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
public class RuntimeExceptionHandler extends ResponseEntityExceptionHandler {
    private final MessageResolver messageResolver;

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<Object> handleBadRequestException(BadRequestException exception) {
        return handleBaseException(exception);
    }

    @ExceptionHandler(BaseException.class)
    public final ResponseEntity<Object> handleBaseException(BaseException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(ErrorResponse.builder()
                        .code(ex.getCode())
                        .message(messageResolver.getMessage(ex.getCode(), ex.getArgs()))
                        .build());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<ErrorResponse> errorList = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> ErrorResponse.builder()
                        .code(fieldError.getField())
                        .message(messageResolver.getMessage(fieldError.getDefaultMessage()))
                        .build())
                .collect(Collectors.toList());
        return handleExceptionInternal(ex, errorList, headers, HttpStatus.BAD_REQUEST, request);
    }
}
