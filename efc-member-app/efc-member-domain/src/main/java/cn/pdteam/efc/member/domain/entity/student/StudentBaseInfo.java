package cn.pdteam.efc.member.domain.entity.student;

import java.time.LocalDate;

import cn.pdteam.efc.member.domain.entity.common.BaseInfo;
import cn.pdteam.efc.member.domain.enums.student.ChineseEthnicityEnum;
import cn.pdteam.efc.member.domain.enums.student.GenderEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Accessors(chain = true)
public class StudentBaseInfo extends BaseInfo {

    /**
     * 年级
     */
    private Integer grade;

    /**
     * 学号
     */
    private String  studentId;

    public StudentBaseInfo(String name, GenderEnum gender, ChineseEthnicityEnum ethnicity, String idCardNumber, LocalDate birthday, String idCardPhoto, Integer grade, String studentId) {
        super(name, gender, ethnicity, idCardNumber, birthday, idCardPhoto);
        this.grade = grade;
        this.studentId = studentId;
    }

}
