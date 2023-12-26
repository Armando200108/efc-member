package cn.pdteam.efc.member.domain.repository;

import cn.pdteam.efc.component.Page;
import cn.pdteam.efc.component.Repository;
import cn.pdteam.efc.member.domain.model.Student;

/**
 * 学生Repository接口
 *
 * @author dongzhang.li
 */
public interface StudentRepository extends Repository<Student, Long> {

    /**
     * 根据主键查询
     *
     * @param key 主键
     * @return 聚合根对象
     */
    @Override
    default Student findByKey(Long key) {
        return Repository.super.findByKey(key);
    }

    /**
     * 保存聚合根对象
     *
     * @param data 聚合根对象
     */
    @Override
    default Student save(Student data) {
        return Repository.super.save(data);
    }

    /**
     * 删除聚合根对象
     *
     * @param data 聚合根对象
     */
    @Override
    default void delete(Student data) {
        Repository.super.delete(data);
    }

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @Override
    default Page<Student> page(Page<Student> page) {
        return Repository.super.page(page);
    }

}
