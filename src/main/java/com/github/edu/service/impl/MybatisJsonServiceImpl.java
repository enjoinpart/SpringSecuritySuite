package com.github.edu.service.impl;

import com.github.edu.entity.MybatisJson;
import com.github.edu.mappers.MybatisJsonMapper;
import com.github.edu.service.MybatisJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：liming
 * @date ：2019/7/18 14:46
 * @description：
 */
@Service
public class MybatisJsonServiceImpl implements MybatisJsonService {


    private MybatisJsonMapper mybatisJsonMapper;

    @Autowired
    public MybatisJsonServiceImpl(MybatisJsonMapper mybatisJsonMapper) {
        this.mybatisJsonMapper = mybatisJsonMapper;
    }

    @Override
    public MybatisJson getJson(Long id) {
        return mybatisJsonMapper.selectByPrimaryKey(id);
    }
}
