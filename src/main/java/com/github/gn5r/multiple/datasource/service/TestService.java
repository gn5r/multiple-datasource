package com.github.gn5r.multiple.datasource.service;

import com.github.gn5r.multiple.datasource.entity.Test;
import com.github.gn5r.multiple.datasource.repository.TestDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestService {
    
    @Autowired
    private TestDao testDao;

    public Test getTestData(Integer id) {
        return testDao.selectById(id);
    }
}
