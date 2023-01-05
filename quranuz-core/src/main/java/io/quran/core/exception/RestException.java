package io.quran.core.exception;

import io.quran.core.response.ErrorData;
import io.quran.core.utils.RestConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RestException extends RuntimeException {

    private String userMsg;
    private HttpStatus status;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;
    private List<ErrorData> errors;
    private Integer errorCode;

    private RestException(String resourceName, String fieldName, Object fieldValue, String userMsg) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.userMsg = userMsg;
        this.status = HttpStatus.BAD_REQUEST;
        this.errorCode = RestConstants.NO_ITEMS_FOUND;
    }

    private RestException(String userMsg, HttpStatus status) {
        super(userMsg);
        this.userMsg = userMsg;
        this.status = status;
    }

    private RestException(String userMsg, int errorCode, HttpStatus status) {
        super(userMsg);
        this.errors = Collections.singletonList(new ErrorData(userMsg, errorCode));
        this.userMsg = userMsg;
        this.status = status;
    }

    public static RestException restThrow(String userMsg, HttpStatus httpStatus) {
        return new RestException(userMsg, httpStatus);
    }

    public static RestException restThrow(String resourceName, String fieldName, Object fieldValue, String userMsg) {
        return new RestException(resourceName, fieldName, fieldValue, userMsg);
    }

    public static RestException restThrow(String userMsg, int errorCode, HttpStatus httpStatus) {

        return new RestException(userMsg, errorCode, httpStatus);
    }
}
