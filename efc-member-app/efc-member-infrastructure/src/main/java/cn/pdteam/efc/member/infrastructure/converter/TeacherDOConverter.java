package cn.pdteam.efc.member.infrastructure.converter;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;

import cn.pdteam.efc.member.domain.entity.common.ContactInfo;
import cn.pdteam.efc.member.domain.entity.student.TeacherAcademicUnit;
import cn.pdteam.efc.member.domain.entity.student.TeacherBaseInfo;
import cn.pdteam.efc.member.domain.model.Teacher;
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

    TeacherBaseInfo toBaseInfoModel(TeacherDO teacherDO);

    TeacherDO toDataObject(TeacherBaseInfo teacherBaseInfo);

    TeacherAcademicUnit toAcademicUnitModel(TeacherDO teacherDO);

    TeacherDO toDataObject(TeacherAcademicUnit teacherAcademicUnit);

    ContactInfo toContactInfoModel(TeacherDO teacherDO);

    TeacherDO toDataObject(ContactInfo contactInfo);

    @Mapping(target = "baseInfo", expression = "java(toBaseInfoModel(teacherDO))")
    @Mapping(target = "academicUnit", expression = "java(toAcademicUnitModel(teacherDO))")
    @Mapping(target = "contactInfo", expression = "java(toContactInfoModel(teacherDO))")
    Teacher toModel(TeacherDO teacherDO);


    default TeacherDO toDataObject(Teacher teacher) {
        TeacherDO teacherDO = new TeacherDO();
        if (ObjectUtils.isNotEmpty(teacher.getBaseInfo())) {
            BeanUtils.copyProperties(toDataObject(teacher.getBaseInfo()), teacherDO);
        }
        if (ObjectUtils.isNotEmpty(teacher.getAcademicUnit())) {
            BeanUtils.copyProperties(toDataObject(teacher.getAcademicUnit()), teacherDO);
        }
        if (ObjectUtils.isNotEmpty(teacher.getContactInfo())) {
            BeanUtils.copyProperties(toDataObject(teacher.getContactInfo()), teacherDO);
        }
        return teacherDO;
    }

    List<Teacher> toModelList(List<TeacherDO> teacherDOList);

    List<TeacherDO> toDataObjectList(List<Teacher> teacherList);

}
