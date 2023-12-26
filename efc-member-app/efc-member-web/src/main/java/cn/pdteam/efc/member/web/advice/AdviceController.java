package cn.pdteam.efc.member.web.advice;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.pdteam.efc.exception.IllegalRequestException;
import cn.pdteam.efc.member.api.response.base.ResultBase;
import cn.pdteam.efc.member.domain.enums.common.ErrorCodeEnum;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class AdviceController {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultBase handleHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletResponse response) {
        AtomicReference<ResultBase> resultBase = new AtomicReference<>();
        Optional.ofNullable(e.getCause())
                .map(Throwable::getCause)
                .filter(IllegalRequestException.class::isInstance)
                .map(IllegalRequestException.class::cast)
                .ifPresentOrElse(
                        illegalRequestException -> resultBase.set(handleIllegalRequestException(illegalRequestException, response)),
                        () -> resultBase.set(handleException(e, response))
                );
        return resultBase.get();
    }

    @ExceptionHandler(IllegalRequestException.class)
    public ResultBase handleIllegalRequestException(IllegalRequestException e, HttpServletResponse response) {
        log.error("请求参数", e);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResultBase.fail(e.getErrorCode().getErrorCode(), e.getErrorCode().getErrorMessage(), e.getErrorCode().getField());
    }

    @ExceptionHandler(Exception.class)
    public ResultBase handleException(Exception e, HttpServletResponse response) {
        log.error("系统异常", e);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResultBase.fail(ErrorCodeEnum.SYS_0001.getErrorCode(), e.getMessage());
    }

}
