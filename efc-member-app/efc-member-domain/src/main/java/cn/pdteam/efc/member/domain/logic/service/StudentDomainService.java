package cn.pdteam.efc.member.domain.logic.service;

import cn.pdteam.efc.member.domain.entity.result.RegisterResult;
import cn.pdteam.efc.member.domain.entity.student.StudentBaseInfo;
import cn.pdteam.efc.member.domain.model.Student;

/**
 * 学生信息服务
 *
 * @author dongzhang.li
 */
public interface StudentDomainService {

    /**
     * 查询学生信息
     * 通过主键
     *
     * @param keyId 主键
     * @return 学生信息
     */
    Student queryStudentInfo(Long keyId);

    /**
     * 查询学生信息
     * 通过学号
     *
     * @param studentId 学号
     * @return 学生信息
     */
    Student queryStudentInfo(String studentId);

    /**
     * 注册新学生
     *
     * @param studentId 学号
     */
    RegisterResult<StudentBaseInfo> registerStudent(String studentId);

    /**
     * 更新学生信息
     *
     * @param student 学生信息
     */
    void updateStudent(Student student);


}
