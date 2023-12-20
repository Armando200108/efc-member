package cn.pdteam.efc.member.api.enums.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {
    STU_BIZ_0001("STU_BIZ_0001", "学生姓名不为空", "学生姓名不为空", "学生姓名不为空"),
    STU_BIZ_0002("STU_BIZ_0002", "学生性别不为空", "学生性别不为空", "学生性别不为空"),
    STU_BIZ_0003("STU_BIZ_0003", "学生民族不为空", "学生民族不为空", "学生民族不为空"),
    STU_BIZ_0004("STU_BIZ_0004", "学生身份证号不为空", "学生身份证号不为空", "学生身份证号不为空"),
    STU_BIZ_0005("STU_BIZ_0005", "学生出生日期不为空", "学生出生日期不为空", "学生出生日期不为空"),
    STU_BIZ_0006("STU_BIZ_0006", "学生身份证照片不为空", "学生身份证照片不为空", "学生身份证照片不为空"),
    STU_BIZ_0007("STU_BIZ_0007", "学生年级不为空", "学生年级不为空", "学生年级不为空"),
    STU_BIZ_0008("STU_BIZ_0008", "学生学号不为空", "学生学号不为空", "学生学号不为空"),
    STU_BIZ_0009("STU_BIZ_0009", "学生姓名长度不超过20", "学生姓名长度不超过20", "学生姓名长度不超过20"),
    STU_BIZ_0010("STU_BIZ_0010", "学生身份证号长度不超过18", "学生身份证号长度不超过18", "学生身份证号长度不超过18"),
    STU_BIZ_0011("STU_BIZ_0011", "学生身份证照片长度不超过200", "学生身份证照片长度不超过200", "学生身份证照片长度不超过200"),
    STU_BIZ_0012("STU_BIZ_0012", "学生学号长度不超过10", "学生学号长度不超过10", "学生学号长度不超过10"),
    STU_BIZ_0013("STU_BIZ_0013", "学生年级长度不超过4", "学生年级长度不超过4", "学生年级长度不超过4"),
    STU_BIZ_0014("STU_BIZ_0014", "学生姓名格式不正确", "学生姓名格式不正确", "学生姓名格式不正确"),
    STU_BIZ_0015("STU_BIZ_0015", "学生身份证号格式不正确", "学生身份证号格式不正确", "学生身份证号格式不正确"),
    STU_BIZ_0016("STU_BIZ_0016", "学生身份证照片格式不正确", "学生身份证照片格式不正确", "学生身份证照片格式不正确"),
    STU_BIZ_0017("STU_BIZ_0017", "学生学号格式不正确", "学生学号格式不正确", "学生学号格式不正确"),
    STU_BIZ_0018("STU_BIZ_0018", "学生年级格式不正确", "学生年级格式不正确", "学生年级格式不正确"),
    STU_BIZ_9999("STU_BIZ_9999", "学生信息校验失败", "学生信息校验失败", "学生信息校验失败"),

    TEA_BIZ_0001("TEA_BIZ_0001", "教师姓名不为空", "教师姓名不为空", "教师姓名不为空"),
    TEA_BIZ_0002("TEA_BIZ_0002", "教师性别不为空", "教师性别不为空", "教师性别不为空"),
    TEA_BIZ_0003("TEA_BIZ_0003", "教师民族不为空", "教师民族不为空", "教师民族不为空"),
    TEA_BIZ_0004("TEA_BIZ_0004", "教师身份证号不为空", "教师身份证号不为空", "教师身份证号不为空"),
    TEA_BIZ_0005("TEA_BIZ_0005", "教师出生日期不为空", "教师出生日期不为空", "教师出生日期不为空"),
    TEA_BIZ_0006("TEA_BIZ_0006", "教师身份证照片不为空", "教师身份证照片不为空", "教师身份证照片不为空"),
    TEA_BIZ_0007("TEA_BIZ_0007", "教师工号不为空", "教师工号不为空", "教师工号不为空"),
    TEA_BIZ_0008("TEA_BIZ_0008", "教师姓名长度不超过20", "教师姓名长度不超过20", "教师姓名长度不超过20"),
    TEA_BIZ_0009("TEA_BIZ_0009", "教师身份证号长度不超过18", "教师身份证号长度不超过18", "教师身份证号长度不超过18"),
    TEA_BIZ_0010("TEA_BIZ_0010", "教师身份证照片长度不超过200", "教师身份证照片长度不超过200", "教师身份证照片长度不超过200"),
    TEA_BIZ_0011("TEA_BIZ_0011", "教师工号长度不超过10", "教师工号长度不超过10", "教师工号长度不超过10"),
    TEA_BIZ_0012("TEA_BIZ_0012", "教师姓名格式不正确", "教师姓名格式不正确", "教师姓名格式不正确"),
    TEA_BIZ_0013("TEA_BIZ_0013", "教师身份证号格式不正确", "教师身份证号格式不正确", "教师身份证号格式不正确"),
    TEA_BIZ_0014("TEA_BIZ_0014", "教师身份证照片格式不正确", "教师身份证照片格式不正确", "教师身份证照片格式不正确"),
    TEA_BIZ_0015("TEA_BIZ_0015", "教师工号格式不正确", "教师工号格式不正确", "教师工号格式不正确"),
    TEA_BIZ_9999("TEA_BIZ_9999", "教师信息校验失败", "教师信息校验失败", "教师信息校验失败"),

    MEM_WEB_0001("MEM_WEB_0001", "身份为空", "identity", "身份不为空"),
    MEM_WEB_0002("MEM_WEB_0002", "身份无匹配值", "identity", "未定义的身份被传入"),

    SYS_0001("SYS_0001", "系统异常", "系统异常", "系统异常");

    @JsonValue
    private final String errorCode;

    private final String errorMessage;

    private final String field;

    private final String errorSolution;


    ErrorCodeEnum(String errorCode, String errorMessage, String field, String errorSolution) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorSolution = errorSolution;
        this.field = field;
    }

    /**
     * 根据错误码获取枚举
     *
     * @param errorCode 错误码
     * @return 枚举
     */
    @JsonCreator
    public static ErrorCodeEnum getByErrorCode(String errorCode) {
        for (ErrorCodeEnum errorCodeEnum : ErrorCodeEnum.values()) {
            if (errorCodeEnum.getErrorCode().equals(errorCode)) {
                return errorCodeEnum;
            }
        }
        return null;
    }
}
