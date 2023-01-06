package io.quran.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorData {
    //USERGA BORADIGAN XABAR
    private String errorMsg;

    //QAYSI FIELD XATO EKANLIGI
    private String fieldName;

    //XATOLIK KODI
    private Integer errorCode;


    public ErrorData(String errorMsg, Integer errorCode) {
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }
}
