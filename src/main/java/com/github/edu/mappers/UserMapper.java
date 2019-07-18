package com.github.edu.mappers;

import com.github.edu.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ：liming
 * @date ：2019/7/18 11:24
 * @description：
 */
@Mapper
public interface UserMapper {
    UserDO findByUsername(String username);
}
