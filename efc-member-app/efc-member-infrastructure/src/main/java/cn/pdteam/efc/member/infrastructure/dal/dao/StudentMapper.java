package cn.pdteam.efc.member.infrastructure.dal.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.pdteam.efc.dao.BaseDAO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.BaseAcademicUnitDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.BaseInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.ContactInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.StudentAcademicUnitDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.StudentBaseDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.StudentBaseInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.StudentDO;

@Mapper
public interface StudentMapper extends BaseDAO<StudentDO> {

    int insertStudentBase(StudentBaseDO studentBaseDO);

    int insertBaseInfo(BaseInfoDO baseInfoDO);

    int insertStudentBaseInfo(StudentBaseInfoDO studentBaseInfoDO);

    int insertStudentAcademicUnit(StudentAcademicUnitDO studentAcademicUnitDO);

    int insertBaseAcademicUnit(BaseAcademicUnitDO baseAcademicUnitDO);

    int insertContactInfo(ContactInfoDO contactInfoDO);

}
