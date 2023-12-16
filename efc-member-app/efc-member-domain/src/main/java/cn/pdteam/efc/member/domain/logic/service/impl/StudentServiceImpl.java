package cn.pdteam.efc.member.domain.logic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pdteam.efc.member.domain.logic.service.StudentService;
import cn.pdteam.efc.member.domain.model.Student;
import cn.pdteam.efc.member.domain.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    /**
     * 根据学生ID获取学生信息
     *
     * @param studentId 学生ID
     * @return 学生信息
     */
    @Override
    public Student getStudentById(long studentId) {
        return null;
    }

    /**
     * 根据学号查询学生信息
     *
     * @param studentId 学号
     * @return 学生信息
     */
    @Override
    public List<Student> getStudentsByStudentId(String studentId) {
        return null;
    }

    /**
     * 注册新学生
     *
     * @param student 学生信息
     */
    @Override
    public void registerStudent(Student student) {

    }

    /**
     * 更新学生信息
     *
     * @param student 学生信息
     */
    @Override
    public void updateStudent(Student student) {

    }

    /**
     * 删除学生信息
     *
     * @param studentId 学号
     */
    @Override
    public void deleteStudent(long studentId) {

    }

}
