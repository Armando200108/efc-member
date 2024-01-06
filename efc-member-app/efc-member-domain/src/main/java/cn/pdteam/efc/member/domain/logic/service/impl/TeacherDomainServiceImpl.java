package cn.pdteam.efc.member.domain.logic.service.impl;

import com.alibaba.fastjson2.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pdteam.efc.component.Page;
import cn.pdteam.efc.member.domain.entity.result.RegisterResult;
import cn.pdteam.efc.member.domain.entity.student.TeacherBaseInfo;
import cn.pdteam.efc.member.domain.logic.handler.RegisterTeacherHandler;
import cn.pdteam.efc.member.domain.logic.service.TeacherDomainService;
import cn.pdteam.efc.member.domain.model.Teacher;
import cn.pdteam.efc.member.domain.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TeacherDomainServiceImpl implements TeacherDomainService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private RegisterTeacherHandler registerTeacherHandler;

    /**
     * 查询教师信息
     * 通过主键
     *
     * @param keyId 主键
     * @return 教师信息
     */
    @Override
    public Teacher queryTeacherInfo(Long keyId) {
        log.info("domain ==> TeacherDomainServiceImpl.queryTeacherInfo, keyId: {}", keyId);
        Teacher teacher = teacherRepository.findByKey(keyId);
        log.info("domain ==> TeacherDomainServiceImpl.queryTeacherInfo, teacher: {}", JSON.toJSONString(teacher));
        return teacher;
    }

    /**
     * 查询教师信息
     * 通过工号
     *
     * @param teacherId 工号
     * @return 教师信息
     */
    @Override
    public Teacher queryTeacherInfo(String teacherId) {
        log.info("domain ==> TeacherDomainServiceImpl.queryTeacherInfo, teacherId: {}", teacherId);
        Teacher teacher = teacherRepository.page(new Page<Teacher>(1, 10)
                        .mapperCondition(new Teacher().setBaseInfo(new TeacherBaseInfo().setTeacherId(teacherId)))).getData()
                .stream().findFirst().orElse(null);
        log.info("domain ==> TeacherDomainServiceImpl.queryTeacherInfo, teacher: {}", JSON.toJSONString(teacher));
        return teacher;
    }

    /**
     * 注册新教师
     *
     * @param teacherId 工号
     */
    @Override
    public RegisterResult<TeacherBaseInfo> registerTeacher(String teacherId) {
        log.info("domain ==> TeacherDomainServiceImpl.registerTeacher, teacherId: {}", teacherId);
        Long id = registerTeacherHandler.handle(teacherId);
        Teacher teacher = teacherRepository.findByKey(id);
        log.info("domain ==> TeacherDomainServiceImpl.registerTeacher, teacher: {}", teacher);
        return new RegisterResult<>(id, teacher.getBaseInfo());
    }

    /**
     * 更新教师信息
     *
     * @param teacher 教师信息
     */
    @Override
    public void updateTeacher(Teacher teacher) {
        log.info("domain ==> TeacherDomainServiceImpl.updateTeacher, teacher: {}", JSON.toJSONString(teacher));
        teacherRepository.save(teacher);
        log.info("domain ==> TeacherDomainServiceImpl.updateTeacher success!");
    }

}
