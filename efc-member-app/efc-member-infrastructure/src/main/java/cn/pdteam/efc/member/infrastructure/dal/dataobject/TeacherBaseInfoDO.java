package cn.pdteam.efc.member.infrastructure.dal.dataobject;

import java.io.Serializable;

import cn.pdteam.efc.dao.BaseDO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class TeacherBaseInfoDO extends BaseDO implements Serializable {

    /**
     * 通用基础信息id
     */
    private Long baseInfoId;

    /**
     * 工号
     */
    private String teacherId;

    private static final long serialVersionUID = 1L;

}