package cn.pdteam.efc.member.business.support.service.impl;

import com.alibaba.fastjson2.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pdteam.efc.enums.common.ErrorCodeEnum;
import cn.pdteam.efc.exception.BizException;
import cn.pdteam.efc.member.api.response.QueryMemberInfoResponse;
import cn.pdteam.efc.member.api.response.RegisterMemberResponse;
import cn.pdteam.efc.member.business.converter.TeacherConverter;
import cn.pdteam.efc.member.business.support.service.TeacherInfoService;
import cn.pdteam.efc.member.domain.entity.student.TeacherBaseInfo;
import cn.pdteam.efc.member.domain.logic.service.TeacherDomainService;
import cn.pdteam.efc.member.domain.model.Teacher;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherInfoService {

    @Autowired
    private TeacherDomainService teacherDomainService;

    private TeacherConverter teacherConverter = TeacherConverter.INSTANCE;

    /**
     * 注册新教师
     *
     * @param teacherId 工号
     * @return 是否注册成功
     */
    @Override
    public RegisterMemberResponse registerTeacher(String teacherId) {
        log.info("biz ==> TeacherServiceImpl.registerTeacher, teacherId: {}", teacherId);
        TeacherBaseInfo teacherBaseInfo = teacherDomainService.registerTeacher(teacherId);
        log.info("biz ==> TeacherServiceImpl.registerTeacher, teacherBaseInfo: {}", JSON.toJSONString(teacherBaseInfo));
        return teacherConverter.baseInfoConvert2RegisterResp(teacherBaseInfo);
    }

    /**
     * 查询教师信息
     *
     * @param primaryCondition 唯一条件
     * @return 学生信息
     */
    @Override
    public QueryMemberInfoResponse queryTeacher(Object primaryCondition) {
        if (primaryCondition instanceof String teacherId) {
            log.info("biz ==> TeacherServiceImpl.queryTeacher, teacherId: {}", teacherId);
            Teacher teacher = teacherDomainService.queryTeacherInfo(teacherId);
            log.info("biz ==> TeacherServiceImpl.queryTeacher, teacherBaseInfo: {}", JSON.toJSONString(teacher));
            return teacherConverter.teacherConvert2QueryResp(teacher);
        } else if (primaryCondition instanceof Long memberId) {
            log.info("biz ==> TeacherServiceImpl.queryTeacher, memberId: {}", memberId);
            Teacher teacher = teacherDomainService.queryTeacherInfo(memberId);
            log.info("biz ==> TeacherServiceImpl.queryTeacher, teacherBaseInfo: {}", JSON.toJSONString(teacher));
            return teacherConverter.teacherConvert2QueryResp(teacher);
        } else {
            throw new BizException(ErrorCodeEnum.SYS_0001);
        }
    }

}
