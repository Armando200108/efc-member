package cn.pdteam.efc.member.domain.repository.base;

import java.util.List;
import java.util.Map;

/**
 * 通用的Repository接口
 *
 * @param <T> 实体类型
 * @param <K> 主键类型
 */
public interface Repository<T, K> {

    /**
     * 根据主键查询
     *
     * @param key 主键
     * @return 聚合根对象
     */
    default T findByKey(K key) {
        throw new UnsupportedOperationException("findByKey not implemented");
    }

    /**
     * 保存聚合根对象
     *
     * @param data 聚合根对象
     */
    default void save(T data) {
        throw new UnsupportedOperationException("save not implemented");
    }

    /**
     * 删除聚合根对象
     *
     * @param data 聚合根对象
     */
    default void delete(T data) {
        throw new UnsupportedOperationException("delete not implemented");
    }

    /**
     * 查询所有聚合根对象
     *
     * @return 聚合根对象列表
     */
    default List<T> findAll2List() {
        throw new UnsupportedOperationException("findAll not implemented");
    }

    /**
     * 查询所有聚合根对象
     *
     * @return 聚合根对象Map
     */
    default Map<K, T> findAll2Map() {
        throw new UnsupportedOperationException("findAll not implemented");
    }

    /**
     * 分页查询
     * @param page 分页对象
     * @return 分页对象
     */
    default Page<T> page(Page<T> page) {
        throw new UnsupportedOperationException("page not implemented");
    }

}
