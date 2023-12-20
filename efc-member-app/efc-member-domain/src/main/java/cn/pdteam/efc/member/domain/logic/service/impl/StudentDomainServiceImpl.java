package cn.pdteam.efc.member.domain.logic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pdteam.efc.member.domain.entity.student.StudentBaseInfo;
import cn.pdteam.efc.member.domain.logic.handler.RegisterStudentHandler;
import cn.pdteam.efc.member.domain.logic.service.StudentDomainService;
import cn.pdteam.efc.member.domain.model.Student;
import cn.pdteam.efc.member.domain.repository.StudentRepository;
import cn.pdteam.efc.member.domain.repository.base.Page;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentDomainServiceImpl implements StudentDomainService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RegisterStudentHandler registerStudentHandler;

    /**
     * 查询学生信息
     * 通过主键
     *
     * @param keyId 主键
     * @return 学生信息
     */
    @Override
    public Student queryStudentInfo(Long keyId) {
        long start = System.currentTimeMillis();
        log.info("Student Domain Service => Query Student Info Start!");
        Student student = studentRepository.findByKey(keyId);
        log.info("Student Domain Service => Query Student Info End! Cost {} ms.Student: {}", System.currentTimeMillis() - start, student);
        return student;
    }

    /**
     * 查询学生信息
     * 通过学号
     *
     * @param studentId 学号
     * @return 学生信息
     */
    @Override
    public Student queryStudentInfo(String studentId) {
        long start = System.currentTimeMillis();
        log.info("Student Domain Service => Query Student Info Start!");
        Page<Student> page = studentRepository.page(new Page<Student>(1, 10).mapperCondition(new Student().setBasicInfo(new StudentBaseInfo().setStudentId(studentId))));
        Student student = page.getData().getFirst();
        log.info("Student Domain Service => Query Student Info End! Cost {} ms.Student: {}", System.currentTimeMillis() - start, student);
        return student;
    }

    /**
     * 注册新学生
     *
     * @param studentId 学号
     */
    @Override
    public StudentBaseInfo registerStudent(String studentId) {
        Long id = registerStudentHandler.handle(studentId);
        return studentRepository.findByKey(id).getBasicInfo();
    }

    /**
     * 更新学生信息
     *
     * @param student 学生信息
     */
    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }


}
