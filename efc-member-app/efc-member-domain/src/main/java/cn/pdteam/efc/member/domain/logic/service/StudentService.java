package cn.pdteam.efc.member.domain.logic.service;

import java.util.List;

import cn.pdteam.efc.member.domain.model.Student;

/**
 * 学生信息服务
 *
 * @author dongzhang.li
 */
public interface StudentService {

    /**
     * 根据学生ID获取学生信息
     *
     * @param studentId 学生ID
     * @return 学生信息
     */
    Student getStudentById(long studentId);

    /**
     * 根据学号查询学生信息
     *
     * @param studentId 学号
     * @return 学生信息
     */
    List<Student> getStudentsByStudentId(String studentId);

    /**
     * 注册新学生
     *
     * @param student 学生信息
     */
    void registerStudent(Student student);

    /**
     * 更新学生信息
     *
     * @param student 学生信息
     */
    void updateStudent(Student student);

    /**
     * 删除学生信息
     *
     * @param studentId 学号
     */
    void deleteStudent(long studentId);

}
