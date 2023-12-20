package cn.pdteam.efc.member.api.exception;

import cn.pdteam.efc.member.api.enums.common.ErrorCodeEnum;
import lombok.Getter;

@Getter
public class IllegalRequestException extends RuntimeException {

    /**
     * 错误码
     */
    private final ErrorCodeEnum errorCode;

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public IllegalRequestException(ErrorCodeEnum errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

}
