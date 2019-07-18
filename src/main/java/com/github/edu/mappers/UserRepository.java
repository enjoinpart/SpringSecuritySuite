package com.github.edu.mappers;

import com.github.edu.entity.UserDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDO, Long> {

    UserDO findByUsername(String username);

}
