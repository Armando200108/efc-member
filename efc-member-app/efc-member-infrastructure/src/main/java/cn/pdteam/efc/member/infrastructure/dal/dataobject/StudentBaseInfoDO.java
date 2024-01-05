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
public class StudentBaseInfoDO extends BaseDO implements Serializable {

    /**
     * 通用基础信息id
     */
    private Long baseInfoId;

    /**
     * 年级
     */
    private Integer grade;

    /**
     * 学号
     */
    private String studentId;

    @Serial
    private static final long serialVersionUID = 1L;

}