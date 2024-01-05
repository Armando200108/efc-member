package cn.pdteam.efc.member.infrastructure.dal.dataobject;

import java.io.Serial;
import java.io.Serializable;

import cn.pdteam.efc.dao.BaseDO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
public class TeacherBaseDO extends BaseDO implements Serializable {

    /**
     * 教师基本信息
     */
    private Long baseInfoId;

    /**
     * 教师学术单元等信息
     */
    private Long academicUnitId;

    /**
     * 联系方式
     */
    private Long contactInfoId;

    @Serial
    private static final long serialVersionUID = 1L;

}