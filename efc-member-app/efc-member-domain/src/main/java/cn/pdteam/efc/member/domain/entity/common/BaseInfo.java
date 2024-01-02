package cn.pdteam.efc.member.domain.entity.common;

import java.time.LocalDate;

import cn.pdteam.efc.enums.member.ChineseEthnicityEnum;
import cn.pdteam.efc.enums.member.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 学生基本信息
 *
 * @author dongzhang.li
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BaseInfo {

    /**
     * 姓名
     */
    private String               name;

    /**
     * 性别
     */
    private GenderEnum gender;

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
