package com.github.edu.mappers;

import com.github.edu.entity.UserDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserRepository extends Mapper<UserDO> {

    UserDO findByUsername(String username);

}
