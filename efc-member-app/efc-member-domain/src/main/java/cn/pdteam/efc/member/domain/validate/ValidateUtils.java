package cn.pdteam.efc.member.domain.validate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import cn.pdteam.efc.member.domain.enums.common.ErrorCodeEnum;
import cn.pdteam.efc.member.domain.exception.BizException;

public class ValidateUtils {

    private ValidateUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 同步校验
     *
     * @param t     待校验对象
     * @param rules 校验规则
     * @param <T>   待校验对象类型
     */
    public static <T> void syncCheck(T t, List<ValidateRule<T>> rules) {
        for (ValidateRule<T> rule : rules) {
            rule.syncCheck(t);
        }
    }

    /**
     * 异步校验
     *
     * @param t        待校验对象
     * @param rules    校验规则
     * @param executor 线程池
     * @param <T>      待校验对象类型
     */
    public static <T> void asyncCheck(T t, List<ValidateRule<T>> rules, Executor executor) {

        CompletableFuture<Void> futures = CompletableFuture.allOf(rules.stream().map(rule -> rule.asyncCheck(t, executor)).toArray(CompletableFuture[]::new));
        futures.exceptionally(e -> {
            if (e.getCause() instanceof BizException) {
                throw (BizException) e.getCause();
            }
            throw new BizException(ErrorCodeEnum.SYS_0001);
        });
        futures.join();
    }

    /**
     * 同步校验
     * 返回错误信息
     *
     * @param t     待校验对象
     * @param rules 校验规则
     * @param <T>   待校验对象类型
     * @return 错误码列表
     */
    public static <T> List<ErrorCodeEnum> syncCheckReturnError(T t, List<ValidateRule<T>> rules) {
        List<ErrorCodeEnum> errorCodeEnumList = new ArrayList<>(rules.size());
        for (ValidateRule<T> rule : rules) {
            if (!rule.getCheckRule().test(t)) {
                errorCodeEnumList.add(rule.getErrorCode());
            }
        }
        return errorCodeEnumList;
    }

    /**
     * 异步校验
     * 返回错误信息
     *
     * @param t        待校验对象
     * @param rules    校验规则
     * @param executor 线程池
     * @param <T>      待校验对象类型
     * @return 错误码列表
     */
    public static <T> List<ErrorCodeEnum> asyncCheckReturnError(T t, List<ValidateRule<T>> rules, Executor executor) {
        List<ErrorCodeEnum> errorCodeEnumList = new ArrayList<>(rules.size());
        rules.forEach(rule -> rule.asyncCheckReturnError(t, executor).thenAccept(errorCodeEnumList::add));
        return errorCodeEnumList;
    }


}
