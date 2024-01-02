package cn.pdteam.efc.member.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.pdteam.efc.component.ResultBase;
import cn.pdteam.efc.member.api.request.RegisterMemberRequest;
import cn.pdteam.efc.member.api.response.QueryMemberInfoResponse;
import cn.pdteam.efc.member.api.response.RegisterMemberResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * 学生相关接口
 *
 * @author dongzhang.li
 */
@RequestMapping("/api/public/member/info")
@Valid
public interface PublicMemberInfoApi {

    /**
     * 注册新成员
     *
     * @param request 注册信息
     * @return 是否注册成功
     */
    @PostMapping("/register")
    ResultBase<RegisterMemberResponse> register(@RequestBody @NotNull RegisterMemberRequest request);

}
