package cn.pdteam.efc.member.infrastructure.repository.impl;

import com.alibaba.fastjson2.JSON;

import java.time.LocalDate;
import java.util.Collections;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.pdteam.efc.component.Page;
import cn.pdteam.efc.enums.member.ChineseEthnicityEnum;
import cn.pdteam.efc.enums.member.GenderEnum;
import cn.pdteam.efc.member.domain.entity.common.ContactInfo;
import cn.pdteam.efc.member.domain.entity.student.TeacherAcademicUnit;
import cn.pdteam.efc.member.domain.entity.student.TeacherBaseInfo;
import cn.pdteam.efc.member.domain.model.Teacher;
import cn.pdteam.efc.member.domain.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class TeacherRepositoryImpl implements TeacherRepository {

    /**
     * 根据主键查询
     *
     * @param key 主键
     * @return 聚合根对象
     */
    @Override
    public Teacher findByKey(Long key) {
        log.info("infra ==> TeacherRepository findByKey, key: {}", key);
        Teacher teacher = new Teacher();
        teacher.setId(key)
                .setBaseInfo((TeacherBaseInfo) new TeacherBaseInfo("001234")
                        .setName("张三")
                        .setBirthday(LocalDate.of(1975, 6, 29))
                        .setGender(GenderEnum.MALE)
                        .setEthnicity(ChineseEthnicityEnum.OTHER)
                        .setIdCardNumber("23010119760629401X")
                        .setIdCardPhoto("https://www.baidu.com/1.jpg"))
                .setAcademicUnit((TeacherAcademicUnit) new TeacherAcademicUnit()
                        .setCollegeId(1L)
                        .setCollegeName("计算机科学与信息工程学院")
                        .setMajorId(1L)
                        .setMajorName("软件工程"))
                .setContactInfo(new ContactInfo()
                        .setWechat("wechat")
                        .setEmail("email@email.com")
                        .setMobile("18888888888")
                        .setQq("12345"));
        log.info("infra ==> TeacherRepository findByKey, teacher: {}", JSON.toJSONString(teacher));
        return teacher;
    }

    /**
     * 保存聚合根对象
     *
     * @param data 聚合根对象
     */
    @Override
    public Teacher save(Teacher data) {
        log.info("infra ==> TeacherRepository save, data: {}", JSON.toJSONString(data));
        // TODO 调用DAO

        log.info("infra ==> TeacherRepository save success!");
        return data;
    }

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @Override
    public Page<Teacher> page(Page<Teacher> page) {
        log.info("infra ==> TeacherRepository page, page: {}", JSON.toJSONString(page));
        page.setData(Collections.singletonList(this.findByKey(ObjectUtils.defaultIfNull(page.getCondition(), new Teacher().setId(1L)).getId())));
        log.info("infra ==> TeacherRepository page, page: {}", JSON.toJSONString(page));
        return page;
    }

}
