package cn.pdteam.efc.member.domain.repository.base;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页对象
 *
 * @param <T> 实体类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {

    /**
     * 页码
     */
    private int     page;

    /**
     * 每页大小
     */
    private int     size;

    /**
     * 总记录数
     */
    private int     total;

    /**
     * 总页数
     */
    private int     totalPage;

    /**
     * 查询条件
     */
    private T       condition;

    /**
     * 查询结果
     */
    private List<T> data;

}
