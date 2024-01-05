package cn.pdteam.efc.member.infrastructure.dal.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.pdteam.efc.dao.BaseDAO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.BaseAcademicUnitDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.BaseInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.ContactInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.TeacherAcademicUnitDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.TeacherBaseDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.TeacherBaseInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.TeacherDO;

@Mapper
public interface TeacherMapper extends BaseDAO<TeacherDO> {

    int insertTeacherBase(TeacherBaseDO teacherBaseDO);

    int insertBaseInfo(BaseInfoDO baseInfoDO);

    int insertTeacherBaseInfo(TeacherBaseInfoDO teacherBaseInfoDO);

    int insertTeacherAcademicUnit(TeacherAcademicUnitDO teacherAcademicUnitDO);

    int insertBaseAcademicUnit(BaseAcademicUnitDO baseAcademicUnitDO);

    int insertContactInfo(ContactInfoDO contactInfoDO);

}
