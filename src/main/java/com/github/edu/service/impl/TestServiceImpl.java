package com.github.edu.service.impl;

import com.github.edu.mappers.TestMapper;
import com.github.edu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：liming
 * @date ：2019/7/18 10:16
 * @description：
 */
@Service
public class TestServiceImpl implements TestService {


    private TestMapper testMapper;

    @Autowired
    public TestServiceImpl(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    @Override
    public int test() {
        return testMapper.test();
    }
}
