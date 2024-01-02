package cn.pdteam.efc.member.business.support.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pdteam.efc.enums.common.ErrorCodeEnum;
import cn.pdteam.efc.exception.BizException;
import cn.pdteam.efc.member.api.response.QueryMemberInfoResponse;
import cn.pdteam.efc.member.api.response.RegisterMemberResponse;
import cn.pdteam.efc.member.business.converter.StudentConverter;
import cn.pdteam.efc.member.business.support.service.StudentInfoService;
import cn.pdteam.efc.member.domain.entity.student.StudentBaseInfo;
import cn.pdteam.efc.member.domain.logic.service.StudentDomainService;
import cn.pdteam.efc.member.domain.model.Student;
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

    /**
     * 查询学生信息
     *
     * @param primaryCondition 唯一条件
     * @return 学生信息
     */
    @Override
    public QueryMemberInfoResponse queryStudent(Object primaryCondition) {
        if (primaryCondition instanceof String studentId) {
            log.info("query student start!");
            Student student = studentDomainService.queryStudentInfo(studentId);
            QueryMemberInfoResponse studentResponse = studentConverter.studentConvert2QueryResp(student);
            log.info("query student end!");
            return studentResponse;
        } else if (primaryCondition instanceof Long memberId) {
            log.info("query student start!");
            Student student = studentDomainService.queryStudentInfo(memberId);
            QueryMemberInfoResponse studentResponse = studentConverter.studentConvert2QueryResp(student);
            log.info("query student end!");
            return studentResponse;
        } else {
            throw new BizException(ErrorCodeEnum.SYS_0001);
        }

    }

}
