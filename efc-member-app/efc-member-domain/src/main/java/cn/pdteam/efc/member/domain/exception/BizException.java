package cn.pdteam.efc.member.domain.exception;

import cn.pdteam.efc.member.domain.enums.common.ErrorCodeEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 业务异常
 *
 * @author dongzhang.li
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException {

    /**
     * 错误码
     */
    private final ErrorCodeEnum errorCode;

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public BizException(ErrorCodeEnum errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

}
