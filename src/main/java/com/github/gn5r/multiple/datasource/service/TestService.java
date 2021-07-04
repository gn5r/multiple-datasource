package com.github.gn5r.multiple.datasource.service;

import com.github.gn5r.multiple.datasource.entity.TestTbl;
import com.github.gn5r.multiple.datasource.repository.TestTblDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestService {
    
    @Autowired
    private TestTblDao testTblDao;

    public TestTbl getTestData(Integer id) {
        return testTblDao.selectById(id);
    }
}
