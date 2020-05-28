package com.cn.wy.data.impl;

import com.cn.wy.data.BaseAppDAO;
import com.cn.wy.util.PageTion;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param
 * @date 2018/3/30 11:03
 * @return
 * @Descripte 封装dao
 */
@Repository
public class BaseAppDAOimpl<T, ID extends Serializable> implements BaseAppDAO<T, ID> {

    @PersistenceContext
    private EntityManager entityManager;
    protected Class<T> entityClass;

    protected Class getEntityClass() {
        if (entityClass == null) {

            entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return entityClass;
    }

    /**
     * @param entity
     * @return T
     * @date 2018/3/30 11:03
     * @Descripte 保存
     */
    @Override
    public T save(T entity) {
        boolean flag = false;
        try {
            entityManager.persist(entity);
            flag = true;
        } catch (Exception e) {
            System.out.println("---------------保存出错---------------");
            throw e;
        }
        return entityManager.merge(entity);
    }

    /**
     * @param id
     * @return T
     * @author scn
     * @date 2018/3/30 11:04
     * @Descripte 根据id获取对象
     */
    @Override
    public T findById(String id) {
        return (T) entityManager.find(getEntityClass(), id);
    }

    /**
     * @param hqlString, values
     * @return java.util.List<T>
     * @author scn
     * @date 2018/3/30 11:04
     * @Descripte 根据自定义hql语句获取对象列表
     */
    @Override
    public List<T> findListByHQL(String hqlString, Object... values) {
        Query query = entityManager.createQuery(hqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        // entityManager.close();
        return (List<T>) query.getResultList();
    }

    /**
     * @param hql, start, pageNumber, values
     * @return cn.rails.tms.tool.PageTion<T>
     * @author scn
     * @date 2018/3/30 11:04
     * @Descripte 根据页数及自定义hql获取分页列表
     */
    @Override
    public PageTion<T> findPageByHql(String hql, int pageNumber, int pageSize, Object... values) {
        PageTion page = new PageTion();
        String conthql = "";
        if (hql.indexOf("select") != -1) {
            conthql = hql.substring(hql.indexOf("from"), hql.length());
        } else {
            conthql = hql;
        }
        String countSql = "select count(1)" + conthql;
        Query countQuery = entityManager.createQuery(countSql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                countQuery.setParameter(i, values[i]);
            }
        }
        List countResult = countQuery.getResultList();
        int count = countResult == null ? 0 : ((Long) countResult.get(0)).intValue();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        page.setTotalElements(count);
        Query query = entityManager.createQuery(hql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<T> listRe = query.getResultList();
        page.setContent(listRe);
        entityManager.close();
        return page;
    }

    @Override
    public PageTion<T> findPageBySql(String sql, int pageNumber, int pageSize, Object... values) {
        PageTion page = new PageTion();
        String countSql = "select count(1) " + sql.substring(sql.indexOf("from"));
        Query countQuery = entityManager.createNativeQuery(countSql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                countQuery.setParameter(i, values[i]);
            }
        }
        List countResult = countQuery.getResultList();
        int count = countResult == null ? 0 : ((BigDecimal) countResult.get(0)).intValue();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        page.setTotalElements(count);
        Query query = entityManager.createNativeQuery(sql, getEntityClass());
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<T> listRe = query.getResultList();
        page.setContent(listRe);
        entityManager.close();
        return page;
    }

    @Override
    public PageTion<T> findOrBypageBySql(String sql, int pageNumber, int pageSize, Object... values) {
        PageTion page = new PageTion();
        String countSql = "select count(1) " + sql.substring(sql.indexOf("from"));
        Query countQuery = entityManager.createNativeQuery(countSql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                countQuery.setParameter(i, values[i]);
            }
        }
        List countResult = countQuery.getResultList();
        int count = countResult == null ? 0 : ((BigDecimal) countResult.get(0)).intValue();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        page.setTotalElements(count);
        Query query = entityManager.createNativeQuery(sql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<T> listRe = query.getResultList();
        page.setContent(listRe);
        entityManager.close();
        return page;
    }

    /***
     * 原生SQL分页查询
     * @param sql
     * @param pageNumber
     * @param pageSize
     * @param param
     * @return
     */
    public PageTion<T> findPageByNativeSql(String sql, int pageNumber, int pageSize, Map<String, Object> param) {
        PageTion page = new PageTion();
        String countSql = "select count(1) " + sql.substring(sql.indexOf("from"));
        Query countQuery = entityManager.createNativeQuery(countSql);
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            countQuery.setParameter(entry.getKey(), entry.getValue());
        }
        List countResult = countQuery.getResultList();
        int count = countResult == null ? 0 : ((BigDecimal) countResult.get(0)).intValue();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        page.setTotalElements(count);
        Query query = entityManager.createNativeQuery(sql, getEntityClass());
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<T> listRe = query.getResultList();
        page.setContent(listRe);
        entityManager.close();
        return page;
    }

    /**
     * @param hql, values
     * @return T
     * @author scn
     * @date 2018/3/30 11:05
     * @Descripte 根据自定义hql获取对象
     */
    @Override
    public T findByHql(String hql, Object... values) {
        Query query = entityManager.createQuery(hql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        try {
            entityManager.close();
            return (T) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param sql, values
     * @return T
     * @author scn
     * @date 2018/3/30 11:05
     * @Descripte 根据自定义hql获取对象
     */
    @Override
    public T findBySql(String sql, Object... values) {
        Query query = entityManager.createNativeQuery(sql, getEntityClass());
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        try {
            entityManager.close();
            return (T) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param sql, values
     * @return java.util.List<T>
     * @author scn
     * @date 2018/3/30 11:05
     * @Descripte 根据原生sql获取对象列表
     */
    @Override
    public List<T> findListBySql(String sql, Object... values) {
        System.out.println(sql + "--------sql语句-------------");
        Query query = entityManager.createNativeQuery(sql, getEntityClass());
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        List<T> list = query.getResultList();
        entityManager.close();
        return list;
    }

    /**
     * @param sql, values
     * @return java.util.List<T>
     * @author scn
     * @date 2018/3/30 11:05
     * @Descripte 根据原生sql获取List
     */
    @Override
    public List<Map<String, Object>> findListMapBySql(String sql, Object... values) {
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(org.hibernate.SQLQuery.class)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        entityManager.close();
        return query.getResultList();
    }

    /***
     *通过原生sql获取Map分页
     * @param sql
     * @param param
     * @return
     */
    @Override
    public Map<String, Object> findPageListMapBySql(String sql, int pageNumber, int pageSize, Map<String, Object> param) {
        String countSql = "select count(1) " + sql.substring(sql.indexOf("from"));
        Query countQuery = entityManager.createNativeQuery(countSql);
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(org.hibernate.SQLQuery.class)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            countQuery.setParameter(entry.getKey(), entry.getValue());
            query.setParameter(entry.getKey(), entry.getValue());
        }
        BigDecimal count = (BigDecimal) countQuery.getSingleResult();
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        //返回数据
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("count", count.intValue());
        returnMap.put("content", query.getResultList());
        if((int)returnMap.get("count")%pageSize==0){
            returnMap.put("totalPages", (int)returnMap.get("count")/pageSize); //总页数
        }else{
            returnMap.put("totalPages", (int)returnMap.get("count")/pageSize+1); //总页数
        }
        entityManager.close();
        return returnMap;
    }

    /**
     * @param hql, values
     * @return java.lang.Integer
     * @author scn
     * @date 2018/3/30 11:06
     * @Descripte 自定义update、delete语句
     */
    @Transactional
    @Override
    public Integer updateByHql(String hql, Object... values) {
        Integer resurlt = 0;
        try {
            Query query = entityManager.createQuery(hql);
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    query.setParameter(i, values[i]);
                }
            }
            resurlt = query.executeUpdate();
        } catch (Exception e) {
            System.out.println("更新出错-----------------------");
            e.printStackTrace();

        }
        return resurlt;
    }

    /**
     * @return java.util.List<T>
     * @author scn
     * @date 2018/3/30 11:06
     * @Descripte 获取全部对象
     */
    @Override
    public List<T> findAll() {
        String hql = "from " + getEntityClass().getName();
        Query query = entityManager.createQuery(hql);
        entityManager.close();
        return (List<T>) query.getResultList();
    }

    /**
     * @param entity
     * @return boolean
     * @author scn
     * @date 2018/3/30 11:06
     * @Descripte 更新对象
     */
    @Override
    public boolean update(T entity) {
        boolean flag = false;
        try {
            entityManager.merge(entity);
            flag = true;
        } catch (Exception e) {
            System.out.println("---------------更新出错---------------");
        }
        return flag;
    }

    /**
     * @param entities
     * @return java.util.List<T>
     * @author scn
     * @date 2018/3/30 11:06
     * @Descripte 批量插入
     */
    @Override
    public List<T> saveAll(Iterable<T> entities) {

        Assert.notNull(entities, "The given Iterable of entities not be null!");

        List<T> result = new ArrayList<T>();

        for (T entity : entities) {
            result.add(save(entity));
        }

        return result;
    }

    /**
     * @param entity
     * @return boolean
     * @author scn
     * @date 2018/3/30 11:07
     * @Descripte 删除
     */
    @Override
    public boolean delete(T entity) {
        boolean flag = false;
        try {
            entityManager.remove(entityManager.merge(entity));
            flag = true;
        } catch (Exception e) {
            System.out.println("---------------删除出错---------------");
        }
        return flag;
    }

    /**
     * @param entityList
     * @return boolean
     * @author qinencheng
     * @date 20180802
     * @Descripte 批量删除删除
     */
    @Override
    public boolean deleteBatch(List<T> entityList) {
        boolean flag = false;
        try {
            if (!entityList.isEmpty() && entityList.size() > 0) {
                for (T entity : entityList) {
                    entityManager.remove(entityManager.merge(entity));
                }
            }
            flag = true;
        } catch (Exception e) {
            System.out.println("---------------删除出错---------------");
        }
        return flag;
    }
}