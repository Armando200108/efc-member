package cn.pdteam.efc.member.business.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cn.pdteam.efc.member.api.response.RegisterMemberResponse;
import cn.pdteam.efc.member.domain.entity.student.StudentBaseInfo;
import cn.pdteam.efc.member.domain.entity.student.TeacherBaseInfo;

@Mapper
public interface TeacherConverter {

    TeacherConverter INSTANCE = Mappers.getMapper(TeacherConverter.class);

    @Mapping(source = "teacherId", target = "memberId")
    @Mapping(source = "name", target = "name")
    RegisterMemberResponse baseInfoConvert2RegisterResp(TeacherBaseInfo baseInfo);

}
