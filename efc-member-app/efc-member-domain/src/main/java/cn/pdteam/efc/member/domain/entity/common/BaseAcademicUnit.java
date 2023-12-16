package cn.pdteam.efc.member.domain.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生年级、专业等信息
 *
 * @author dongzhang.li
 */
@Data
public abstract class BaseAcademicUnit {

    /**
     * 学院id
     */
    private Long   collegeId;

    /**
     * 学院名称
     */
    private String collegeName;

    /**
     * 专业id
     */
    private Long   majorId;

    /**
     * 专业名称
     */
    private String majorName;

}
