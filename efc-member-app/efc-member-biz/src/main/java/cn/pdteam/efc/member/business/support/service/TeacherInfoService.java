package cn.pdteam.efc.member.business.support.service;

import cn.pdteam.efc.member.api.response.QueryMemberInfoResponse;
import cn.pdteam.efc.member.api.response.RegisterMemberResponse;

public interface TeacherInfoService {

    /**
     * 注册新教师
     *
     * @param teacherId 工号
     * @return 是否注册成功
     */
    RegisterMemberResponse registerTeacher(String teacherId);

    /**
     * 查询教师信息
     *
     * @param primaryCondition 唯一条件
     * @return 学生信息
     */
    QueryMemberInfoResponse queryTeacher(Object primaryCondition);

}
