package xyz.tom.www.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDao<T> {

    /**
     * 新增
     * @param t
     * @return
     */
    int save(T t);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    T getObjectById(int id);

    /**
     * 根据账号查询
     * @param acc
     * @return
     */
    T getObjectByAcc(String acc);

    /**
     * 更新数据
     * @param t
     * @return
     */
    int update(T t);

    /**
     * 删除
     * @param t
     * @return
     */
    int remove(T t);

    List<T> getAll();
}
