package cn.pdteam.efc.member.infrastructure.repository.impl;

import com.alibaba.fastjson2.JSON;
import com.github.pagehelper.page.PageMethod;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.pdteam.efc.component.Page;
import cn.pdteam.efc.enums.common.ErrorCodeEnum;
import cn.pdteam.efc.exception.BizException;
import cn.pdteam.efc.member.domain.model.Teacher;
import cn.pdteam.efc.member.domain.repository.TeacherRepository;
import cn.pdteam.efc.member.infrastructure.converter.TeacherDOConverter;
import cn.pdteam.efc.member.infrastructure.dal.dataobject.TeacherDO;
import cn.pdteam.efc.member.infrastructure.dal.support.TeacherDAOService;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class TeacherRepositoryImpl implements TeacherRepository {

    @Autowired
    private TeacherDAOService daoService;

    private TeacherDOConverter converter = TeacherDOConverter.INSTANCE;

    /**
     * 根据主键查询
     *
     * @param key 主键
     * @return 聚合根对象
     */
    @Override
    public Teacher findByKey(Long key) {
        long start = System.currentTimeMillis();
        log.info("infra ==> TeacherRepository findByKey, key: {}", key);
        Teacher teacher = converter.toModel(daoService.searchTeacher((TeacherDO) new TeacherDO().setId(key))
                .stream().findFirst().orElse(null));
        log.info("infra ==> TeacherRepository findByKey, cost: {}ms, data: {}", System.currentTimeMillis() - start, JSON.toJSONString(teacher));
        return teacher;
    }

    /**
     * 保存聚合根对象
     *
     * @param data 聚合根对象
     */
    @Override
    public Teacher save(Teacher data) {
        long start = System.currentTimeMillis();
        log.info("infra >>> TeacherRepositoryImpl.save start, data: {}", JSON.toJSONString(data));
        TeacherDO dataObject = converter.toDataObject(data);
        Long id = dataObject.getId();
        if (ObjectUtils.isEmpty(data.getId())) {
            id = daoService.insertTeacher(dataObject);
        } else {
            daoService.update(dataObject);
        }
        Teacher teacher = findByKey(id);
        log.info("infra <<< TeacherRepositoryImpl.save end, cost: {}ms, data: {}", System.currentTimeMillis() - start, JSON.toJSONString(teacher));
        return teacher;
    }

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @Override
    public Page<Teacher> page(Page<Teacher> page) {
        long start = System.currentTimeMillis();
        log.info("infra >>> TeacherRepositoryImpl.page start, page: {}", JSON.toJSONString(page));
        TeacherDO condition = converter.toDataObject(page.getCondition());
        try (com.github.pagehelper.Page<TeacherDO> teacherDOPage = PageMethod.startPage(page.getPageNum(), page.getSize()).doSelectPage(() -> daoService.searchTeacher(condition))) {
            page.setData(converter.toModelList(teacherDOPage.getResult()));
            page.setTotal(teacherDOPage.getTotal());
            page.setTotalPage(teacherDOPage.getPages());
        } catch (Exception e) {
            log.error("infra >>> TeacherRepositoryImpl.page error, page: {}", JSON.toJSONString(page), e);
            throw new BizException(ErrorCodeEnum.SYS_0001);
        }
        log.info("infra <<< TeacherRepositoryImpl.page end, cost: {}ms, page: {}", System.currentTimeMillis() - start, JSON.toJSONString(page));
        return page;
    }

}
