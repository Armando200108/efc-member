package cn.pdteam.efc.member.web.controller;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import cn.pdteam.efc.component.ResultBase;
import cn.pdteam.efc.enums.common.ErrorCodeEnum;
import cn.pdteam.efc.enums.member.IdentityEnum;
import cn.pdteam.efc.member.api.CommonMemberInfoApi;
import cn.pdteam.efc.member.api.response.QueryMemberInfoResponse;
import cn.pdteam.efc.member.business.support.service.StudentInfoService;
import cn.pdteam.efc.member.business.support.service.TeacherInfoService;
import cn.pdteam.efc.user_auth.model.EfcUserDetails;

@RestController
public class CommonMemberInfoController implements CommonMemberInfoApi {

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private TeacherInfoService teacherInfoService;

    @Override
    public ResultBase<QueryMemberInfoResponse> querySelf(Authentication authentication) {
        if (ObjectUtils.isNotEmpty(authentication) && authentication.getPrincipal() instanceof EfcUserDetails userDetails) {
            String username = userDetails.getUsername();
            IdentityEnum identity = IdentityEnum.getIdentity(username);
            QueryMemberInfoResponse queryMemberInfoResponse =
                    switch (identity) {
                        case STUDENT -> studentInfoService.queryStudent(username);
                        case TEACHER -> teacherInfoService.queryTeacher(username);
                    };
            return ResultBase.success(queryMemberInfoResponse, "查询成功");
        } else {
            return ResultBase.fail(ErrorCodeEnum.MEM_WEB_0002);
        }
    }

}
