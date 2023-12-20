package cn.pdteam.efc.member.api.response.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBase<T> {

    /**
     * 消息
     */
    private String      message;

    /**
     * 返回值
     */
    private T           data;

    /**
     * 是否成功
     */
    private Boolean     success;

    /**
     * 是否失败
     */
    private Boolean     failed;

    /**
     * 失败结果
     */
    private ErrorResult errorResult;

    public static <T> ResultBase<T> success(T data, String message) {
        ResultBase<T> resultBase = new ResultBase<>();
        resultBase.success = true;
        resultBase.setMessage(message);
        resultBase.failed = false;
        resultBase.data = data;
        return resultBase;
    }

    public static <T> ResultBase<T> fail(String code, String message, String field) {
        ResultBase<T> resultBase = new ResultBase<>();
        resultBase.success = false;
        resultBase.failed = true;
        resultBase.errorResult = new ErrorResult(code, message, field);
        return resultBase;
    }

    public static <T> ResultBase<T> fail(String code, String message) {
        ResultBase<T> resultBase = new ResultBase<>();
        resultBase.success = false;
        resultBase.failed = true;
        resultBase.errorResult = new ErrorResult(code, message, null);
        return resultBase;
    }

    public static <T> ResultBase<T> fail(String code) {
        ResultBase<T> resultBase = new ResultBase<>();
        resultBase.success = false;
        resultBase.failed = true;
        resultBase.errorResult = new ErrorResult(code, null, null);
        return resultBase;
    }

    /**
     * 错误结果
     *
     * @author dongzhang.li
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    static class ErrorResult {

        /**
         * 错误码
         */
        private String code;

        /**
         * 错误信息
         */
        private String message;

        /**
         * 错误字段
         */
        private String field;

    }

}
