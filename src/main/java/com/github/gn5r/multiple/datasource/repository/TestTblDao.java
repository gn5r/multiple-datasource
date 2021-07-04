package com.github.gn5r.multiple.datasource.repository;

import com.github.gn5r.multiple.datasource.entity.TestTbl;
import com.github.gn5r.multiple.datasource.jdbc.DomaConfig;
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
@Dao(config = DomaConfig.class)
public interface TestTblDao {

    /**
     * @param id
     * @return the TestTbl entity
     */
    @Select
    TestTbl selectById(Integer id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TestTbl entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TestTbl entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TestTbl entity);
}