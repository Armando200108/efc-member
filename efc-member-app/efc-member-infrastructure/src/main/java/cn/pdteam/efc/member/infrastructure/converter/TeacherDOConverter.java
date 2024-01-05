package cn.pdteam.efc.member.infrastructure.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cn.pdteam.efc.member.infrastructure.dal.dataobject.BaseAcademicUnitDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.BaseInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.ContactInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.TeacherAcademicUnitDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.TeacherBaseInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.TeacherDO;

@Mapper
public interface TeacherDOConverter {

    TeacherDOConverter INSTANCE = Mappers.getMapper(TeacherDOConverter.class);

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "creator", expression = "java(null)")
    @Mapping(target = "modifier", expression = "java(null)")
    @Mapping(target = "gmtCreate", expression = "java(null)")
    @Mapping(target = "gmtModified", expression = "java(null)")
    @Mapping(target = "deleted", expression = "java(null)")
    @Mapping(target = "version", expression = "java(null)")
    TeacherDO toTeacherDO(TeacherAcademicUnitDO teacherAcademicUnitDO);

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "creator", expression = "java(null)")
    @Mapping(target = "modifier", expression = "java(null)")
    @Mapping(target = "gmtCreate", expression = "java(null)")
    @Mapping(target = "gmtModified", expression = "java(null)")
    @Mapping(target = "deleted", expression = "java(null)")
    @Mapping(target = "version", expression = "java(null)")
    TeacherDO toTeacherDO(BaseAcademicUnitDO baseAcademicUnitDO);

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "creator", expression = "java(null)")
    @Mapping(target = "modifier", expression = "java(null)")
    @Mapping(target = "gmtCreate", expression = "java(null)")
    @Mapping(target = "gmtModified", expression = "java(null)")
    @Mapping(target = "deleted", expression = "java(null)")
    @Mapping(target = "version", expression = "java(null)")
    TeacherDO toTeacherDO(BaseInfoDO baseInfoDO);

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "creator", expression = "java(null)")
    @Mapping(target = "modifier", expression = "java(null)")
    @Mapping(target = "gmtCreate", expression = "java(null)")
    @Mapping(target = "gmtModified", expression = "java(null)")
    @Mapping(target = "deleted", expression = "java(null)")
    @Mapping(target = "version", expression = "java(null)")
    TeacherDO toTeacherDO(ContactInfoDO contactInfoDO);

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "creator", expression = "java(null)")
    @Mapping(target = "modifier", expression = "java(null)")
    @Mapping(target = "gmtCreate", expression = "java(null)")
    @Mapping(target = "gmtModified", expression = "java(null)")
    @Mapping(target = "deleted", expression = "java(null)")
    @Mapping(target = "version", expression = "java(null)")
    TeacherDO toTeacherDO(TeacherBaseInfoDO teacherBaseInfoDO);

    @Mapping(target = "id", expression = "java(null)")
    BaseAcademicUnitDO toBaseAcademicUnitDO(TeacherDO teacherDO);

    @Mapping(target = "id", expression = "java(null)")
    BaseInfoDO toBaseInfoDO(TeacherDO teacherDO);

    @Mapping(target = "id", expression = "java(null)")
    ContactInfoDO toContactInfoDO(TeacherDO teacherDO);

    @Mapping(target = "id", expression = "java(null)")
    TeacherBaseInfoDO toTeacherBaseInfoDO(TeacherDO teacherDO);

    @Mapping(target = "id", expression = "java(null)")
    TeacherAcademicUnitDO toTeacherAcademicUnitDO(TeacherDO teacherDO);

}
