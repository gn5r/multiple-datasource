package com.github.gn5r.multiple.datasource.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * TestエンティティListener
 * 
 * @author gn5r
 * @see Test
 */
public class TestListener implements EntityListener<Test> {

    @Override
    public void preInsert(Test entity, PreInsertContext<Test> context) {
    }

    @Override
    public void preUpdate(Test entity, PreUpdateContext<Test> context) {
    }

    @Override
    public void preDelete(Test entity, PreDeleteContext<Test> context) {
    }

    @Override
    public void postInsert(Test entity, PostInsertContext<Test> context) {
    }

    @Override
    public void postUpdate(Test entity, PostUpdateContext<Test> context) {
    }

    @Override
    public void postDelete(Test entity, PostDeleteContext<Test> context) {
    }
}