package cn.pdteam.efc.member.infrastructure.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

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
public class BaseInfoDO extends BaseDO implements Serializable {

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 民族
     */
    private String ethnicity;

    /**
     * 身份证号
     */
    private String idCardNumber;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 证件照
     */
    private String idCardPhoto;

    private static final long serialVersionUID = 1L;

}