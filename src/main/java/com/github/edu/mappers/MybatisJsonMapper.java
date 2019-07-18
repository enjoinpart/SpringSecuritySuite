package com.github.edu.mappers;


import com.github.edu.entity.MybatisJson;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author ：liming
 * @date ：2019/7/18 14:48
 * @description：
 */
@Repository
public interface MybatisJsonMapper extends Mapper<MybatisJson> {


    MybatisJson getById(Long id);
}
