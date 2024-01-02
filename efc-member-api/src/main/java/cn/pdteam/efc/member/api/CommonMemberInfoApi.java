package cn.pdteam.efc.member.api;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.pdteam.efc.component.ResultBase;
import cn.pdteam.efc.member.api.response.QueryMemberInfoResponse;
import jakarta.validation.Valid;

@RequestMapping("/api/common/member/info")
@Valid
public interface CommonMemberInfoApi {
    @GetMapping("/query")
    ResultBase<QueryMemberInfoResponse> querySelf(Authentication authentication);
}
