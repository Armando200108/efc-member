package cn.pdteam.efc.member.domain.validate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Predicate;

import cn.pdteam.efc.member.domain.enums.common.ErrorCodeEnum;
import cn.pdteam.efc.member.domain.exception.BizException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 校验规则
 *
 * @param <T> 待校验对象类型
 * @author dongzhang.li
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidateRule<T> {

    /**
     * 错误码
     */
    private ErrorCodeEnum errorCode;

    /**
     * 校验规则
     */
    private Predicate<T> checkRule;

    /**
     * 同步校验
     *
     * @param t 待校验对象
     */
    public void syncCheck(T t) {
        if (!checkRule.test(t)) {
            throw new BizException(errorCode);
        }
    }

    /**
     * 异步校验
     *
     * @param t        待校验对象
     * @param executor 线程池
     * @return 异步结果
     */
    public CompletableFuture<Void> asyncCheck(T t, Executor executor) {
        return CompletableFuture.runAsync(() -> {
            if (!checkRule.test(t)) {
                throw new BizException(errorCode);
            }
        }, executor);
    }

    /**
     * 同步校验，返回错误码
     *
     * @param t 待校验对象
     * @return 错误码
     */
    public ErrorCodeEnum syncCheckReturnError(T t) {
        if (!checkRule.test(t)) {
            return errorCode;
        }
        return null;
    }

    /**
     * 异步校验，返回错误码
     *
     * @param t        待校验对象
     * @param executor 线程池
     * @return 异步结果
     */
    public CompletableFuture<ErrorCodeEnum> asyncCheckReturnError(T t, Executor executor) {
        return CompletableFuture.supplyAsync(() -> {
            if (!checkRule.test(t)) {
                return errorCode;
            }
            return null;
        }, executor);
    }


}
