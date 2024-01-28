package cn.pdteam.efc.member.infrastructure.repository.impl;

import com.alibaba.fastjson2.JSON;
import com.github.pagehelper.page.PageMethod;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.pdteam.efc.component.Page;
import cn.pdteam.efc.enums.common.ErrorCodeEnum;
import cn.pdteam.efc.exception.BizException;
import cn.pdteam.efc.member.domain.model.Student;
import cn.pdteam.efc.member.domain.repository.StudentRepository;
import cn.pdteam.efc.member.infrastructure.converter.StudentDOConverter;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.StudentDO;
import cn.pdteam.efc.member.infrastructure.dal.support.StudentDAOService;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private StudentDAOService studentDAOService;

    private final StudentDOConverter studentDOConverter = StudentDOConverter.INSTANCE;

    /**
     * 根据主键查询
     *
     * @param key 主键
     * @return 聚合根对象
     */
    @Override
    public Student findByKey(Long key) {
        long start = System.currentTimeMillis();
        log.info("infra >>> StudentRepositoryImpl.findByKey");
        StudentDO studentDO = studentDAOService.searchStudent((StudentDO) new StudentDO().setId(key))
                .stream().findFirst().orElse(null);
        Student model = studentDOConverter.toModel(studentDO);
        log.info("infra <<< StudentRepositoryImpl.findByKey, cost: {}ms, data: {}", System.currentTimeMillis() - start, JSON.toJSONString(model));
        return model;
    }

    /**
     * 保存聚合根对象
     *
     * @param data 聚合根对象
     */
    @Override
    public Student save(Student data) {
        long start = System.currentTimeMillis();
        log.info("infra >>> StudentRepositoryImpl.save start, data: {}", JSON.toJSONString(data));
        StudentDO dataObject = studentDOConverter.toDataObject(data);
        Long id = dataObject.getId();
        if (ObjectUtils.isEmpty(data.getId())) {
            id = studentDAOService.insertStudent(dataObject);
        } else {
            studentDAOService.update(dataObject);
        }
        Student student = findByKey(id);
        log.info("infra <<< StudentRepositoryImpl.save end, cost: {}ms, data: {}", System.currentTimeMillis() - start, JSON.toJSONString(student));
        return student;
    }

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @Override
    public Page<Student> page(Page<Student> page) {
        long start = System.currentTimeMillis();
        log.info("infra >>> StudentRepositoryImpl.page start, page: {}", JSON.toJSONString(page));
        StudentDO studentDO = studentDOConverter.toDataObject(page.getCondition());
        try (com.github.pagehelper.Page<StudentDO> studentDOPage = PageMethod.startPage(page.getPageNum(), page.getSize()).doSelectPage(() -> studentDAOService.searchStudent(studentDO))) {
            page.setData(studentDOConverter.toModelList(studentDOPage.getResult()));
            page.setTotal(studentDOPage.getTotal());
            page.setTotalPage(studentDOPage.getPages());
        } catch (Exception e) {
            log.error("infra >>> StudentRepositoryImpl.page error, page: {}", JSON.toJSONString(page), e);
            throw new BizException(ErrorCodeEnum.SYS_0001);
        }
        log.info("infra <<< StudentRepositoryImpl.page end, cost: {}ms, page: {}", System.currentTimeMillis() - start, JSON.toJSONString(page));
        return page;
    }

    /**
     * 根据学号查询学生List
     *
     * @param studentIdList 学号列表
     * @return 聚合根对象
     */
    @Override
    public List<Student> queryStudentInfoList(List<String> studentIdList) {
        long start = System.currentTimeMillis();
        log.info("infra >>> StudentRepositoryImpl.queryStudentInfoList start, studentIdList: {}", JSON.toJSONString(studentIdList));
        List<StudentDO> studentDOList = studentDAOService.selectByStudentIdList(studentIdList);
        List<Student> studentList = studentDOConverter.toModelList(studentDOList);
        if (CollectionUtils.isEmpty(studentList)) {
            studentList = Collections.emptyList();
        }
        log.info("infra <<< StudentRepositoryImpl.queryStudentInfoList end, cost: {}ms, studentList: {}", System.currentTimeMillis() - start, JSON.toJSONString(studentList));
        return studentList;
    }

}
