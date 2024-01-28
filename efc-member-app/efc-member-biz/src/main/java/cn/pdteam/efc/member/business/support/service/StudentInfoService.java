package cn.pdteam.efc.member.business.support.service;

import java.util.List;

import cn.pdteam.efc.member.api.response.QueryMemberInfoResponse;
import cn.pdteam.efc.member.api.response.RegisterMemberResponse;

public interface StudentInfoService {

    /**
     * 注册新学生
     *
     * @param studentId 学号
     * @return 是否注册成功
     */
    RegisterMemberResponse registerStudent(String studentId);

    /**
     * 查询学生信息
     *
     * @param primaryCondition 唯一条件
     * @return 学生信息
     */
    QueryMemberInfoResponse queryStudent(Object primaryCondition);

    /**
     * 批量查询学生信息
     *
     * @param studentIdList 学号列表
     * @return 学生信息
     */
    List<QueryMemberInfoResponse> batchQueryStudent(List<String> studentIdList);

}
