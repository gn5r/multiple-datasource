package com.github.gn5r.multiple.datasource.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * TestTblエンティティListener
 * 
 * @author gn5r
 * @see TestTbl
 */
public class TestTblListener implements EntityListener<TestTbl> {

    @Override
    public void preInsert(TestTbl entity, PreInsertContext<TestTbl> context) {
    }

    @Override
    public void preUpdate(TestTbl entity, PreUpdateContext<TestTbl> context) {
    }

    @Override
    public void preDelete(TestTbl entity, PreDeleteContext<TestTbl> context) {
    }

    @Override
    public void postInsert(TestTbl entity, PostInsertContext<TestTbl> context) {
    }

    @Override
    public void postUpdate(TestTbl entity, PostUpdateContext<TestTbl> context) {
    }

    @Override
    public void postDelete(TestTbl entity, PostDeleteContext<TestTbl> context) {
    }
}