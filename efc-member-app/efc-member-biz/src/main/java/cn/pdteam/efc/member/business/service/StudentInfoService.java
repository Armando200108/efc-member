package cn.pdteam.efc.member.business.service;

import cn.pdteam.efc.member.api.response.RegisterMemberResponse;

public interface StudentInfoService {

    /**
     * 注册新学生
     *
     * @param studentId 学号
     * @return 是否注册成功
     */
    RegisterMemberResponse registerStudent(String studentId);

}
