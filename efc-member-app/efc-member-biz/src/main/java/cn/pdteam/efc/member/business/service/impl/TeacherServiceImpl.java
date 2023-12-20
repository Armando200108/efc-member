package cn.pdteam.efc.member.business.service.impl;

import com.alibaba.fastjson2.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pdteam.efc.member.api.response.RegisterMemberResponse;
import cn.pdteam.efc.member.business.converter.TeacherConverter;
import cn.pdteam.efc.member.business.service.TeacherInfoService;
import cn.pdteam.efc.member.domain.entity.student.TeacherBaseInfo;
import cn.pdteam.efc.member.domain.logic.service.TeacherDomainService;
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

}
