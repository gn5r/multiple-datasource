package com.github.gn5r.multiple.datasource.controller;

import com.github.gn5r.multiple.datasource.entity.Test;
import com.github.gn5r.multiple.datasource.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("get/{id}")
    public ResponseEntity<?> getTest(@PathVariable String id) {
        Test test = testService.getTestData(Integer.parseInt(id));
        return new ResponseEntity<Test>(test, HttpStatus.OK);
    }
}
