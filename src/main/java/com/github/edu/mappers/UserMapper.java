package com.github.edu.mappers;

import com.github.edu.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ：liming
 * @date ：2019/7/18 11:24
 * @description：
 */
@Repository
public interface UserMapper  extends tk.mybatis.mapper.common.Mapper<UserDO> {
    UserDO findByUsername(String username);
}
