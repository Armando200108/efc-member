package cn.pdteam.efc.member.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.pdteam.efc.member.api.request.RegisterMemberRequest;
import cn.pdteam.efc.member.api.response.RegisterMemberResponse;
import cn.pdteam.efc.member.api.response.base.ResultBase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * 学生相关接口
 *
 * @author dongzhang.li
 */
@RequestMapping("/api/member/info")
@Valid
public interface MemberInfoApi {

    /**
     * 注册新成员
     *
     * @param request 注册信息
     * @return 是否注册成功
     */
    @PostMapping("/register")
    ResultBase<RegisterMemberResponse> registerStudent(@RequestBody @NotNull RegisterMemberRequest request);

}
