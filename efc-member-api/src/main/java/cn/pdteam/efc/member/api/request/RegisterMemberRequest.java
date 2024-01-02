package cn.pdteam.efc.member.api.request;

import cn.pdteam.efc.enums.member.IdentityEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMemberRequest {

    /**
     * 身份
     */
    @NotNull
    private IdentityEnum identity;

    /**
     * 学号/工号
     */
    @NotNull
    private String       memberId;

}
