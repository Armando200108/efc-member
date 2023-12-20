package cn.pdteam.efc.member.domain.logic.service;

import cn.pdteam.efc.member.domain.entity.student.TeacherBaseInfo;
import cn.pdteam.efc.member.domain.model.Teacher;

public interface TeacherDomainService {

        /**
        * 查询教师信息
        * 通过主键
        *
        * @param keyId 主键
        * @return 教师信息
        */
        Teacher queryTeacherInfo(Long keyId);

        /**
        * 查询教师信息
        * 通过工号
        *
        * @param teacherId 工号
        * @return 教师信息
        */
        Teacher queryTeacherInfo(String teacherId);

        /**
        * 注册新教师
        *
        * @param teacherId 工号
        */
        TeacherBaseInfo registerTeacher(String teacherId);

        /**
        * 更新教师信息
        *
        * @param teacher 教师信息
        */
        void updateTeacher(Teacher teacher);
}
