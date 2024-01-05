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
public class StudentBaseDO extends BaseDO implements Serializable {

    /**
     * 学生基本信息
     */
    private Long baseInfoId;

    /**
     * 学生年级、专业等信息
     */
    private Long academicUnitId;

    /**
     * 联系方式
     */
    private Long contactInfoId;

    private static final long serialVersionUID = 1L;

}