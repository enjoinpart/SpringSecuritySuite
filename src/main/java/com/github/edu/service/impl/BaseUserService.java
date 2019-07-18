package com.github.edu.service.impl;

import com.github.edu.entity.UserDO;
import com.github.edu.mappers.UserRepository;
import com.github.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BaseUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public BaseUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void insert(UserDO userDO) {
        String username = userDO.getUsername();
        if (exist(username)){
            throw new RuntimeException("用户名已存在！");
        }
      userDO.setPassword(new BCryptPasswordEncoder().encode(userDO.getPassword()));
       userRepository.save(userDO);
    }

    @Override
    public UserDO getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * 判断用户是否存在
     */
    private boolean exist(String username){
        UserDO userDO = userRepository.findByUsername(username);
        return (userDO != null);
    }

}
