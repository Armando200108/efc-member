package cn.pdteam.efc.member.business.converter;

import cn.pdteam.efc.member.api.response.RegisterMemberResponse;
import cn.pdteam.efc.member.domain.entity.student.TeacherBaseInfo;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-26T18:47:34+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Amazon.com Inc.)"
)
public class TeacherConverterImpl implements TeacherConverter {

    @Override
    public RegisterMemberResponse baseInfoConvert2RegisterResp(TeacherBaseInfo baseInfo) {
        if ( baseInfo == null ) {
            return null;
        }

        RegisterMemberResponse registerMemberResponse = new RegisterMemberResponse();

        registerMemberResponse.setMemberId( baseInfo.getTeacherId() );
        registerMemberResponse.setName( baseInfo.getName() );

        return registerMemberResponse;
    }
}
