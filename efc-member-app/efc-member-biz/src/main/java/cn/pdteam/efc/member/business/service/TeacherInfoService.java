package cn.pdteam.efc.member.business.service;

import cn.pdteam.efc.member.api.response.RegisterMemberResponse;

public interface TeacherInfoService {

    /**
     * 注册新教师
     *
     * @param teacherId 工号
     * @return 是否注册成功
     */
    RegisterMemberResponse registerTeacher(String teacherId);

}
