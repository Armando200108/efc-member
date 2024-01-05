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
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StudentAcademicUnitDO extends BaseDO implements Serializable {

    /**
     * 通用学术单元id
     */
    private Long baseAcademicUnitId;

    /**
     * 班级id
     */
    private Long classId;

    /**
     * 班级名称
     */
    private String className;

    @Serial
    private static final long serialVersionUID = 1L;

}