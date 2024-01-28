package cn.pdteam.efc.member.infrastructure.converter;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;

import cn.pdteam.efc.member.domain.entity.common.ContactInfo;
import cn.pdteam.efc.member.domain.entity.student.StudentAcademicUnit;
import cn.pdteam.efc.member.domain.entity.student.StudentBaseInfo;
import cn.pdteam.efc.member.domain.model.Student;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.BaseAcademicUnitDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.BaseInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.ContactInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.StudentAcademicUnitDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.StudentBaseInfoDO;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.StudentDO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
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

    @Mapping(target = "grade",expression = "java(studentDO.getGrade())")
    @Mapping(target = "studentId",expression = "java(studentDO.getStudentId())")
    StudentBaseInfo toBaseInfoModel(StudentDO studentDO);

    StudentDO toDataObject(StudentBaseInfo studentBaseInfo);

    StudentAcademicUnit toAcademicUnitModel(StudentDO studentDO);

    StudentDO toDataObject(StudentAcademicUnit studentAcademicUnit);

    ContactInfo toContactInfoModel(StudentDO studentDO);

    StudentDO toDataObject(ContactInfo contactInfo);

    @Mapping(target = "basicInfo", expression = "java(toBaseInfoModel(studentDO))")
    @Mapping(target = "academicUnit", expression = "java(toAcademicUnitModel(studentDO))")
    @Mapping(target = "contactInfo", expression = "java(toContactInfoModel(studentDO))")
    Student toModel(StudentDO studentDO);


    default StudentDO toDataObject(Student student) {
        StudentDO studentDO = new StudentDO();
        if (ObjectUtils.isNotEmpty(student.getBasicInfo())) {
            BeanUtils.copyProperties(toDataObject(student.getBasicInfo()), studentDO);
        }
        if (ObjectUtils.isNotEmpty(student.getAcademicUnit())) {
            BeanUtils.copyProperties(toDataObject(student.getAcademicUnit()), studentDO);
        }
        if (ObjectUtils.isNotEmpty(student.getContactInfo())) {
            BeanUtils.copyProperties(toDataObject(student.getContactInfo()), studentDO);
        }
        return studentDO;
    }

    List<Student> toModelList(List<StudentDO> studentDOList);

    List<StudentDO> toDataObjectList(List<Student> studentList);

}
