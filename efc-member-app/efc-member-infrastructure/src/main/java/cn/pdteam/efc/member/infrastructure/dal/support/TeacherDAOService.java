package cn.pdteam.efc.member.infrastructure.dal.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.pdteam.efc.member.infrastructure.converter.TeacherDOConverter;
import cn.pdteam.efc.member.infrastructure.dal.dao.TeacherMapper;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.BaseAcademicUnitDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.BaseInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.ContactInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.TeacherAcademicUnitDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.TeacherBaseDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.TeacherBaseInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.TeacherDO;
import cn.pdteam.efc.util.snow_flake.SnowFlake;

@Service
public class TeacherDAOService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private SnowFlake snowFlake;

    private TeacherDOConverter teacherDOConverter = TeacherDOConverter.INSTANCE;

    public List<TeacherDO> searchTeacher(TeacherDO teacherDO) {
        return teacherMapper.select(teacherDO);
    }

    @Transactional
    public Long insertTeacher(TeacherDO teacherDO) {
        BaseAcademicUnitDO baseAcademicUnitDO = teacherDOConverter.toBaseAcademicUnitDO(teacherDO);
        baseAcademicUnitDO.setId(snowFlake.nextId());

        BaseInfoDO baseInfoDO = teacherDOConverter.toBaseInfoDO(teacherDO);
        baseInfoDO.setId(snowFlake.nextId());

        ContactInfoDO contactInfoDO = teacherDOConverter.toContactInfoDO(teacherDO);
        contactInfoDO.setId(snowFlake.nextId());

        TeacherAcademicUnitDO teacherAcademicUnitDO = teacherDOConverter.toTeacherAcademicUnitDO(teacherDO);
        teacherAcademicUnitDO.setId(snowFlake.nextId());
        teacherAcademicUnitDO.setBaseAcademicUnitId(baseAcademicUnitDO.getId());

        TeacherBaseInfoDO teacherBaseInfoDO = teacherDOConverter.toTeacherBaseInfoDO(teacherDO);
        teacherBaseInfoDO.setId(snowFlake.nextId());
        teacherBaseInfoDO.setBaseInfoId(baseInfoDO.getId());

        TeacherBaseDO teacherBaseDO = new TeacherBaseDO();
        teacherBaseDO.setBaseInfoId(teacherBaseInfoDO.getId())
                .setAcademicUnitId(teacherAcademicUnitDO.getId())
                .setContactInfoId(contactInfoDO.getId());

        teacherMapper.insertBaseAcademicUnit(baseAcademicUnitDO);
        teacherMapper.insertBaseInfo(baseInfoDO);
        teacherMapper.insertContactInfo(contactInfoDO);
        teacherMapper.insertTeacherAcademicUnit(teacherAcademicUnitDO);
        teacherMapper.insertTeacherBaseInfo(teacherBaseInfoDO);
        teacherMapper.insertTeacherBase(teacherBaseDO);

        return teacherBaseDO.getId();
    }
    @Transactional
    public void update(TeacherDO teacherDO) {
        teacherMapper.updateByPrimaryKeySelective(teacherDO);
    }

}
