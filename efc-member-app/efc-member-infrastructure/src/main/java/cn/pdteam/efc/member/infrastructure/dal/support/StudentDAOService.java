package cn.pdteam.efc.member.infrastructure.dal.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.pdteam.efc.member.infrastructure.converter.StudentDOConverter;
import cn.pdteam.efc.member.infrastructure.dal.dao.StudentMapper;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.BaseAcademicUnitDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.BaseInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.ContactInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.StudentAcademicUnitDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.StudentBaseDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.StudentBaseInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.StudentDO;
import cn.pdteam.efc.util.snow_flake.SnowFlake;

@Service
public class StudentDAOService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SnowFlake snowFlake;

    private StudentDOConverter studentDOConverter = StudentDOConverter.INSTANCE;

    public List<StudentDO> searchStudent(StudentDO studentDO) {
        return studentMapper.select(studentDO);
    }

    @Transactional
    public void insertStudent(StudentDO studentDO) {
        BaseAcademicUnitDO baseAcademicUnitDO = studentDOConverter.toBaseAcademicUnitDO(studentDO);
        baseAcademicUnitDO.setId(snowFlake.nextId());

        BaseInfoDO baseInfoDO = studentDOConverter.toBaseInfoDO(studentDO);
        baseInfoDO.setId(snowFlake.nextId());

        ContactInfoDO contactInfoDO = studentDOConverter.toContactInfoDO(studentDO);
        contactInfoDO.setId(snowFlake.nextId());

        StudentAcademicUnitDO studentAcademicUnitDO = studentDOConverter.toStudentAcademicUnitDO(studentDO);
        studentAcademicUnitDO.setId(snowFlake.nextId());
        studentAcademicUnitDO.setBaseAcademicUnitId(baseAcademicUnitDO.getId());

        StudentBaseInfoDO studentBaseInfoDO = studentDOConverter.toStudentBaseInfoDO(studentDO);
        studentBaseInfoDO.setId(snowFlake.nextId());
        studentBaseInfoDO.setBaseInfoId(baseInfoDO.getId());

        StudentBaseDO studentBaseDO = new StudentBaseDO();
        studentBaseDO.setBaseInfoId(studentBaseInfoDO.getId())
                .setAcademicUnitId(studentAcademicUnitDO.getId())
                .setContactInfoId(contactInfoDO.getId());

        studentMapper.insertBaseAcademicUnit(baseAcademicUnitDO);
        studentMapper.insertBaseInfo(baseInfoDO);
        studentMapper.insertContactInfo(contactInfoDO);
        studentMapper.insertStudentAcademicUnit(studentAcademicUnitDO);
        studentMapper.insertStudentBaseInfo(studentBaseInfoDO);
        studentMapper.insertStudentBase(studentBaseDO);
    }
    @Transactional
    public void update(StudentDO studentDO) {
        studentMapper.updateByPrimaryKeySelective(studentDO);
    }

}
