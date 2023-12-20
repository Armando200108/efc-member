package cn.pdteam.efc.member.domain.entity.student;

import java.time.LocalDate;

import cn.pdteam.efc.member.domain.entity.common.BaseInfo;
import cn.pdteam.efc.member.domain.enums.student.ChineseEthnicityEnum;
import cn.pdteam.efc.member.domain.enums.student.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author dongzhang.li
 */
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TeacherBaseInfo extends BaseInfo {

    /**
     * 工号
     */
    private String teacherId;

    public TeacherBaseInfo(String name, GenderEnum gender, ChineseEthnicityEnum ethnicity, String idCardNumber, LocalDate birthday, String idCardPhoto, String teacherId) {
        super(name, gender, ethnicity, idCardNumber, birthday, idCardPhoto);
        this.teacherId = teacherId;
    }

}
