package cn.pdteam.efc.member.infrastructure.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cn.pdteam.efc.member.infrastructure.dal.dataobject.BaseAcademicUnitDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.BaseInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.ContactInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.StudentAcademicUnitDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.StudentBaseInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.StudentDO;

@Mapper
public interface StudentDOConverter {

    StudentDOConverter INSTANCE = Mappers.getMapper(StudentDOConverter.class);

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "creator", expression = "java(null)")
    @Mapping(target = "modifier", expression = "java(null)")
    @Mapping(target = "gmtCreate", expression = "java(null)")
    @Mapping(target = "gmtModified", expression = "java(null)")
    @Mapping(target = "deleted", expression = "java(null)")
    @Mapping(target = "version", expression = "java(null)")
    StudentDO toStudentDO(StudentAcademicUnitDO studentAcademicUnitDO);

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "creator", expression = "java(null)")
    @Mapping(target = "modifier", expression = "java(null)")
    @Mapping(target = "gmtCreate", expression = "java(null)")
    @Mapping(target = "gmtModified", expression = "java(null)")
    @Mapping(target = "deleted", expression = "java(null)")
    @Mapping(target = "version", expression = "java(null)")
    StudentDO toStudentDO(BaseAcademicUnitDO baseAcademicUnitDO);

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "creator", expression = "java(null)")
    @Mapping(target = "modifier", expression = "java(null)")
    @Mapping(target = "gmtCreate", expression = "java(null)")
    @Mapping(target = "gmtModified", expression = "java(null)")
    @Mapping(target = "deleted", expression = "java(null)")
    @Mapping(target = "version", expression = "java(null)")
    StudentDO toStudentDO(BaseInfoDO baseInfoDO);

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "creator", expression = "java(null)")
    @Mapping(target = "modifier", expression = "java(null)")
    @Mapping(target = "gmtCreate", expression = "java(null)")
    @Mapping(target = "gmtModified", expression = "java(null)")
    @Mapping(target = "deleted", expression = "java(null)")
    @Mapping(target = "version", expression = "java(null)")
    StudentDO toStudentDO(ContactInfoDO contactInfoDO);

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "creator", expression = "java(null)")
    @Mapping(target = "modifier", expression = "java(null)")
    @Mapping(target = "gmtCreate", expression = "java(null)")
    @Mapping(target = "gmtModified", expression = "java(null)")
    @Mapping(target = "deleted", expression = "java(null)")
    @Mapping(target = "version", expression = "java(null)")
    StudentDO toStudentDO(StudentBaseInfoDO studentBaseInfoDO);

    @Mapping(target = "id", expression = "java(null)")
    BaseAcademicUnitDO toBaseAcademicUnitDO(StudentDO studentDO);

    @Mapping(target = "id", expression = "java(null)")
    BaseInfoDO toBaseInfoDO(StudentDO studentDO);

    @Mapping(target = "id", expression = "java(null)")
    ContactInfoDO toContactInfoDO(StudentDO studentDO);

    @Mapping(target = "id", expression = "java(null)")
    StudentBaseInfoDO toStudentBaseInfoDO(StudentDO studentDO);

    @Mapping(target = "id", expression = "java(null)")
    StudentAcademicUnitDO toStudentAcademicUnitDO(StudentDO studentDO);

}
