package cn.pdteam.efc.member.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cn.pdteam.efc.member.api.MemberInfoApi;
import cn.pdteam.efc.member.api.request.RegisterMemberRequest;
import cn.pdteam.efc.member.api.response.RegisterMemberResponse;
import cn.pdteam.efc.member.api.response.base.ResultBase;
import cn.pdteam.efc.member.business.service.StudentInfoService;
import cn.pdteam.efc.member.business.service.TeacherInfoService;
import cn.pdteam.efc.member.domain.enums.common.ErrorCodeEnum;
import cn.pdteam.efc.member.domain.exception.BizException;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MemberInfoController implements MemberInfoApi {

    @Autowired
    StudentInfoService studentInfoService;

    @Autowired
    TeacherInfoService teacherInfoService;

    /**
     * 注册新成员
     *
     * @param request 注册信息
     * @return 是否注册成功
     */
    @Override
    public ResultBase<RegisterMemberResponse> registerStudent(RegisterMemberRequest request) {
        RegisterMemberResponse response =
                switch (request.getIdentity()) {
                    case STUDENT -> studentInfoService.registerStudent(request.getMemberId());
                    case TEACHER -> teacherInfoService.registerTeacher(request.getMemberId());
                };
        return ResultBase.success(response, "注册成功");
    }

}
