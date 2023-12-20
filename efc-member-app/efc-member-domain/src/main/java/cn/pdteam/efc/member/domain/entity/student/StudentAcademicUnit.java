package cn.pdteam.efc.member.domain.entity.student;

import cn.pdteam.efc.member.domain.entity.common.BaseAcademicUnit;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 学生年级、专业等信息
 *
 * @author dongzhang.li
 */
@Accessors(chain = true)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StudentAcademicUnit extends BaseAcademicUnit {

    /**
     * 班级id
     */
    private Long   classId;

    /**
     * 班级名称
     */
    private String className;

}
