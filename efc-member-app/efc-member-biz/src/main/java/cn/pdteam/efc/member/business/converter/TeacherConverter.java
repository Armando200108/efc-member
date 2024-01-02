package cn.pdteam.efc.member.business.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cn.pdteam.efc.member.api.response.QueryMemberInfoResponse;
import cn.pdteam.efc.member.api.response.RegisterMemberResponse;

import cn.pdteam.efc.member.domain.entity.student.TeacherBaseInfo;
import cn.pdteam.efc.member.domain.model.Teacher;

@Mapper
public interface TeacherConverter {

    TeacherConverter INSTANCE = Mappers.getMapper(TeacherConverter.class);

    @Mapping(source = "teacherId", target = "memberId")
    @Mapping(source = "name", target = "name")
    @Mapping(target = "idCardLastSix", expression = "java(baseInfo.getIdCardNumber().substring(baseInfo.getIdCardNumber().length() - 6))")
    RegisterMemberResponse baseInfoConvert2RegisterResp(TeacherBaseInfo baseInfo);


    @Mapping(target = "teacherId", expression = "java(teacher.getBaseInfo().getTeacherId())")
    @Mapping(target = "name", expression = "java(teacher.getBaseInfo().getName())")
    @Mapping(target = "gender", expression = "java(teacher.getBaseInfo().getGender())")
    @Mapping(target = "ethnicity", expression = "java(teacher.getBaseInfo().getEthnicity())")
    @Mapping(target = "idCardNumber", expression = "java(teacher.getBaseInfo().getIdCardNumber())")
    @Mapping(target = "birthday", expression = "java(teacher.getBaseInfo().getBirthday())")
    @Mapping(target = "idCardPhoto", expression = "java(teacher.getBaseInfo().getIdCardPhoto())")
    @Mapping(target = "collegeId", expression = "java(teacher.getAcademicUnit().getCollegeId())")
    @Mapping(target = "collegeName", expression = "java(teacher.getAcademicUnit().getCollegeName())")
    @Mapping(target = "majorId", expression = "java(teacher.getAcademicUnit().getMajorId())")
    @Mapping(target = "majorName", expression = "java(teacher.getAcademicUnit().getMajorName())")
    @Mapping(target = "mobile", expression = "java(teacher.getContactInfo().getMobile())")
    @Mapping(target = "email", expression = "java(teacher.getContactInfo().getEmail())")
    @Mapping(target = "qq", expression = "java(teacher.getContactInfo().getQq())")
    @Mapping(target = "wechat", expression = "java(teacher.getContactInfo().getWechat())")
    QueryMemberInfoResponse teacherConvert2QueryResp(Teacher teacher);

}
