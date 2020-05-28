package com.cn.wy.data;




import com.cn.wy.util.PageTion;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseAppDAO<T, ID extends Serializable> {
    /**
     * 保存数据对象
     *
     * @param entity
     * @return
     */
    T save(T entity);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    T findById(String id);

    /**
     * @param hqlString 自定义hql语句
     * @param values    参数列表
     * @return java.util.List<T>
     * @author scn
     * @date 2018/3/30 9:04
     * @Descripte 自定义查询对象列表
     */
    List<T> findListByHQL(String hqlString, Object... values);

    /**
     * @param hql, values
     * @return T
     * @author scn
     * @date 2018/3/30 9:05
     * @Descripte 自定义查询对象
     */
    T findByHql(String hql, Object... values);

    /**
     * @param sql, values
     * @return T
     * @author scn
     * @date 2018/3/30 9:05
     * @Descripte 自定义查询对象
     */
    T findBySql(String sql, Object... values);

    /**
     * 根据表名，字段，参数查询，拼接sql语句
     *
     * @param sql    自定义sql语句
     * @param values 参数列表
     * @return
     */
    List<T> findListBySql(String sql, Object... values);

    List<Map<String, Object>> findListMapBySql(String sql, Object... values);

    Map<String,Object> findPageListMapBySql(String sql, int pageNumber, int pageSize, Map<String, Object> param);

    Integer updateByHql(String hql, Object... values);

    List<T> findAll();

    /**
     * 多字段查询分页
     *
     * @param hql        hql语句
     * @param values     不定参数
     * @param start      第几页
     * @param pageNumber 一个页面的条数
     * @return
     */
    PageTion<T> findPageByHql(String hql, int start, int pageNumber, Object... values);

    PageTion<T> findPageByNativeSql(String sql, int pageNumber, int pageSize, Map<String, Object> param);

    PageTion<T> findPageBySql(String sql, int start, int pageNumber, Object... values);

    PageTion findOrBypageBySql(String sql, int start, int pageNumber, Object... values);

    List<T> saveAll(Iterable<T> entities);

    /**
     * 根据表的id删除数据
     *
     * @param entity
     */
    boolean delete(T entity);

    /***
     * 批量删除
     * @param entityList
     * @return
     */
    boolean deleteBatch(List<T> entityList);

    /**
     * 更新对象
     *
     * @param e
     * @return
     */
    boolean update(T e);

}