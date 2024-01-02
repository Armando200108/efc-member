package cn.pdteam.efc.member.api.response;

import java.time.LocalDate;

import cn.pdteam.efc.enums.member.ChineseEthnicityEnum;
import cn.pdteam.efc.enums.member.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryMemberInfoResponse {

    private Long    id;

    /**
     * 年级
     */
    private Integer grade;

    /**
     * 学号
     */
    private String studentId;

    /**
     * 工号
     */
    private String teacherId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private GenderEnum gender;

    /**
     * 民族
     */
    private ChineseEthnicityEnum ethnicity;

    /**
     * 身份证号
     */
    private String idCardNumber;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 证件照
     */
    private String idCardPhoto;


    /**
     * 班级id
     */
    private Long classId;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 学院id
     */
    private Long collegeId;

    /**
     * 学院名称
     */
    private String collegeName;

    /**
     * 专业id
     */
    private Long majorId;

    /**
     * 专业名称
     */
    private String majorName;


    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * QQ
     */
    private String qq;


}
