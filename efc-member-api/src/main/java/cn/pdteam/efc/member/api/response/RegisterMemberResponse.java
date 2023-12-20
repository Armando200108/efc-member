package cn.pdteam.efc.member.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dongzhang.li
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMemberResponse {

    /**
     * 学号/工号
     */
    private String  memberId;

    /**
     * 姓名
     */
    private String  name;

}
