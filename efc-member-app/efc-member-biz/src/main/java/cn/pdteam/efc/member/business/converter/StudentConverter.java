package cn.pdteam.efc.member.business.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cn.pdteam.efc.member.api.response.QueryMemberInfoResponse;
import cn.pdteam.efc.member.api.response.RegisterMemberResponse;
import cn.pdteam.efc.member.domain.entity.student.StudentBaseInfo;
import cn.pdteam.efc.member.domain.model.Student;

@Mapper
public interface StudentConverter {

    StudentConverter INSTANCE = Mappers.getMapper(StudentConverter.class);

    @Mapping(source = "studentId", target = "memberId")
    @Mapping(source = "name", target = "name")
    @Mapping(target = "idCardLastSix", expression = "java(baseInfo.getIdCardNumber().substring(baseInfo.getIdCardNumber().length() - 6))")
    RegisterMemberResponse baseInfoConvert2RegisterResp(StudentBaseInfo baseInfo);

    @Mapping(target = "grade", expression = "java(student.getBasicInfo().getGrade())")
    @Mapping(target = "studentId", expression = "java(student.getBasicInfo().getStudentId())")
    @Mapping(target = "name", expression = "java(student.getBasicInfo().getName())")
    @Mapping(target = "gender", expression = "java(student.getBasicInfo().getGender())")
    @Mapping(target = "ethnicity", expression = "java(student.getBasicInfo().getEthnicity())")
    @Mapping(target = "idCardNumber", expression = "java(student.getBasicInfo().getIdCardNumber())")
    @Mapping(target = "birthday", expression = "java(student.getBasicInfo().getBirthday())")
    @Mapping(target = "idCardPhoto", expression = "java(student.getBasicInfo().getIdCardPhoto())")
    @Mapping(target = "classId", expression = "java(student.getAcademicUnit().getClassId())")
    @Mapping(target = "className", expression = "java(student.getAcademicUnit().getClassName())")
    @Mapping(target = "collegeId", expression = "java(student.getAcademicUnit().getCollegeId())")
    @Mapping(target = "collegeName", expression = "java(student.getAcademicUnit().getCollegeName())")
    @Mapping(target = "majorId", expression = "java(student.getAcademicUnit().getMajorId())")
    @Mapping(target = "majorName", expression = "java(student.getAcademicUnit().getMajorName())")
    @Mapping(target = "mobile", expression = "java(student.getContactInfo().getMobile())")
    @Mapping(target = "email", expression = "java(student.getContactInfo().getEmail())")
    @Mapping(target = "qq", expression = "java(student.getContactInfo().getQq())")
    @Mapping(target = "wechat", expression = "java(student.getContactInfo().getWechat())")
    QueryMemberInfoResponse studentConvert2QueryResp(Student student);

}
