package com.github.gn5r.multiple.datasource.repository;

import com.github.gn5r.multiple.datasource.config.AppConfig;
import com.github.gn5r.multiple.datasource.entity.Test;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import org.seasar.doma.boot.ConfigAutowireable;

/**
 * @author gn5r
 */
@ConfigAutowireable
@Dao(config = AppConfig.class)
public interface TestDao {

    /**
     * @param id
     * @return the Test entity
     */
    @Select
    Test selectById(Integer id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Test entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Test entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Test entity);
}