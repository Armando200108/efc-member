package cn.pdteam.efc.member.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pdteam.efc.member.api.response.RegisterMemberResponse;
import cn.pdteam.efc.member.business.converter.StudentConverter;
import cn.pdteam.efc.member.business.service.StudentInfoService;
import cn.pdteam.efc.member.domain.entity.student.StudentBaseInfo;
import cn.pdteam.efc.member.domain.logic.service.StudentDomainService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentInfoService {

    @Autowired
    private StudentDomainService studentDomainService;

    private StudentConverter studentConverter = StudentConverter.INSTANCE;

    /**
     * 注册新学生
     *
     * @param studentId 学号
     * @return 是否注册成功
     */
    @Override
    public RegisterMemberResponse registerStudent(String studentId) {
        log.info("register student business start!");
        StudentBaseInfo studentBaseInfo = studentDomainService.registerStudent(studentId);
        RegisterMemberResponse studentResponse = studentConverter.baseInfoConvert2RegisterResp(studentBaseInfo);
        log.info("register student business end!");
        return studentResponse;
    }

}
