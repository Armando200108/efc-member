package cn.pdteam.efc.member.infrastructure.dal.dataobject;

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
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TeacherAcademicUnitDO extends BaseDO implements Serializable {

    /**
     * 通用学术单元id
     */
    private Long baseAcademicUnitId;

    private static final long serialVersionUID = 1L;

}