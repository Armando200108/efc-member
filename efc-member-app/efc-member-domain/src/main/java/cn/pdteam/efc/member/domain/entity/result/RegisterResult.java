package cn.pdteam.efc.member.domain.entity.result;

import cn.pdteam.efc.member.domain.entity.common.BaseInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterResult<T extends BaseInfo> {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 个人基本信息
     */
    private T personInfo;

}
