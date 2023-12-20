package cn.pdteam.efc.member.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import cn.pdteam.efc.member.api.enums.common.ErrorCodeEnum;
import cn.pdteam.efc.member.api.exception.IllegalRequestException;
import lombok.Getter;

@Getter
public enum IdentityEnum {
    TEACHER("01", "TEACHER", "教师"),
    STUDENT("02", "STUDENT", "学生");

    @JsonValue
    private String code;

    private String name;

    private String description;

    IdentityEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    @JsonCreator
    public static IdentityEnum getByCode(String code) {
        for (IdentityEnum item : IdentityEnum.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        throw new IllegalRequestException(ErrorCodeEnum.MEM_WEB_0002);
    }

}
