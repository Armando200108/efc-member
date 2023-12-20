package cn.pdteam.efc.member.domain.logic.handler.base;

import java.util.function.Supplier;

public abstract class BaseHandler<T,R> {

    /**
     * 处理
     *
     * @param supplier 提供的参数
     */
    protected abstract R doHandle(Supplier<T> supplier);

}
