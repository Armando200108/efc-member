package cn.pdteam.efc.member.domain.model;

import cn.pdteam.efc.member.domain.entity.common.BaseAcademicUnit;
import cn.pdteam.efc.member.domain.entity.common.ContactInfo;
import cn.pdteam.efc.member.domain.entity.student.TeacherAcademicUnit;
import cn.pdteam.efc.member.domain.entity.student.TeacherBaseInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Teacher {

    private Long             id;

    private TeacherBaseInfo  baseInfo;

    private TeacherAcademicUnit academicUnit;

    private ContactInfo      contactInfo;

}
