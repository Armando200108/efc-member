package cn.pdteam.efc.member.domain.enums.student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;

@Getter
public enum GenderEnum {
    /**
     * 男
     */
    MALE("01", "MALE", "男"),
    /**
     * 女
     */
    FEMALE("02", "FEMALE", "女"),
    /**
     * 性别不明
     */
    UNKNOWN("03", "UNKNOWN", "性别不明");

    /**
     * 代码
     */
    @JsonValue
    private final String code;

    /**
     * 名称
     */
    private final String name;

    /**
     * 描述
     */
    private final String description;

    GenderEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    @JsonCreator
    public static GenderEnum getByCode(String code) {
        for (GenderEnum genderEnum : GenderEnum.values()) {
            if (genderEnum.getCode().equals(code)) {
                return genderEnum;
            }
        }
        return null;
    }
}
