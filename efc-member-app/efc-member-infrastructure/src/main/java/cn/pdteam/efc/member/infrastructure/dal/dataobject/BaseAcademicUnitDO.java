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
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BaseAcademicUnitDO extends BaseDO implements Serializable {

    /**
     * 学院id
     */
    private Long collegeId;

    /**
     * 学院名称
     */
    private String collegeName;

    /**
     * 专业id
     */
    private Long majorId;

    /**
     * 专业名称
     */
    private String majorName;

    private static final long serialVersionUID = 1L;

}