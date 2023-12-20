package cn.pdteam.efc.member.domain.entity.student;

import cn.pdteam.efc.member.domain.entity.common.BaseAcademicUnit;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TeacherAcademicUnit extends BaseAcademicUnit {

    public TeacherAcademicUnit(Long collegeId, String collegeName, Long majorId, String majorName) {
        super(collegeId, collegeName, majorId, majorName);
    }

    public TeacherAcademicUnit() {
    }

}
