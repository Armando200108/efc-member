package cn.pdteam.efc.member.domain.entity.common;

import java.time.LocalDate;

import cn.pdteam.efc.member.domain.enums.student.ChineseEthnicityEnum;
import cn.pdteam.efc.member.domain.enums.student.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 学生基本信息
 *
 * @author dongzhang.li
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseInfo {

    /**
     * 姓名
     */
    private String               name;

    /**
     * 性别
     */
    private GenderEnum           gender;

    /**
     * 民族
     */
    private ChineseEthnicityEnum ethnicity;

    /**
     * 身份证号
     */
    private String               idCardNumber;

    /**
     * 生日
     */
    private LocalDate            birthday;

    /**
     * 证件照
     */
    private String               idCardPhoto;

}
