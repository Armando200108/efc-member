package cn.pdteam.efc.member.domain.model;

import cn.pdteam.efc.member.domain.entity.common.ContactInfo;
import cn.pdteam.efc.member.domain.entity.student.StudentAcademicUnit;
import cn.pdteam.efc.member.domain.entity.student.StudentBaseInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Student {

    /**
     * 唯一标识符
     */
    private Long                id;

    /**
     * 学生基本信息
     */
    private StudentBaseInfo     basicInfo;

    /**
     * 学生年级、专业等信息
     */
    private StudentAcademicUnit academicUnit;

    /**
     * 联系方式
     */
    private ContactInfo         contactInfo;
}
