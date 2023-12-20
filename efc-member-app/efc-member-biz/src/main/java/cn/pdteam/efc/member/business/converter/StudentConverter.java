package cn.pdteam.efc.member.business.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import cn.pdteam.efc.member.api.response.RegisterMemberResponse;
import cn.pdteam.efc.member.domain.entity.common.BaseInfo;
import cn.pdteam.efc.member.domain.entity.student.StudentBaseInfo;

@Mapper
public interface StudentConverter {

    StudentConverter INSTANCE = Mappers.getMapper(StudentConverter.class);

    @Mapping(source = "studentId", target = "memberId")
    @Mapping(source = "name", target = "name")
    RegisterMemberResponse baseInfoConvert2RegisterResp(StudentBaseInfo baseInfo);

}
