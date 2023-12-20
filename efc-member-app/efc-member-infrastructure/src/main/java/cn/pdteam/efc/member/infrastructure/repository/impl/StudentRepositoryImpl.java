package cn.pdteam.efc.member.infrastructure.repository.impl;

import java.time.LocalDate;
import java.util.Collections;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.pdteam.efc.member.domain.entity.common.ContactInfo;
import cn.pdteam.efc.member.domain.entity.student.StudentAcademicUnit;
import cn.pdteam.efc.member.domain.entity.student.StudentBaseInfo;
import cn.pdteam.efc.member.domain.enums.student.ChineseEthnicityEnum;
import cn.pdteam.efc.member.domain.enums.student.GenderEnum;
import cn.pdteam.efc.member.domain.model.Student;
import cn.pdteam.efc.member.domain.repository.StudentRepository;
import cn.pdteam.efc.member.domain.repository.base.Page;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class StudentRepositoryImpl implements StudentRepository {

    /**
     * 根据主键查询
     *
     * @param key 主键
     * @return 聚合根对象
     */
    @Override
    public Student findByKey(Long key) {
        Student student = new Student();
        student.setId(key);
        student.setBasicInfo(new StudentBaseInfo().setStudentId("2020020132").setGrade(2020));
        student.getBasicInfo().setName("李东璋").setBirthday(LocalDate.of(2001, 8, 11)).setGender(GenderEnum.MALE).setEthnicity(ChineseEthnicityEnum.HAN).setIdCardNumber("230305200108110000").setIdCardPhoto("http://photo.com/ldz.png");
        student.setAcademicUnit(new StudentAcademicUnit().setClassId(1L).setClassName("软件三班"));
        student.getAcademicUnit().setCollegeId(1L).setCollegeName("计算机科学与信息工程学院").setMajorId(1L).setMajorName("软件工程");
        student.setContactInfo(new ContactInfo().setQq("1098997251").setEmail("l.dzh@163.com").setMobile("13304617651").setWechat("Armando"));
        return student;
    }

    /**
     * 保存聚合根对象
     *
     * @param data 聚合根对象
     */
    @Override
    public Student save(Student data) {
        log.info("save success!");
        return data;
    }

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @Override
    public Page<Student> page(Page<Student> page) {
        page.setData(Collections.singletonList(this.findByKey(ObjectUtils.defaultIfNull(page.getCondition(), new Student().setId(1L)).getId())));
        return page;
    }

}
