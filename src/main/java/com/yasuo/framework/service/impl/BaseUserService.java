package com.yasuo.framework.service.impl;

import com.yasuo.framework.entity.UserDO;
import com.yasuo.framework.repository.UserRepository;
import com.yasuo.framework.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BaseUserService implements UserService {

    private final UserRepository userRepository;

    public BaseUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void insert(UserDO userDO) {
        String username = userDO.getUsername();
        if (exist(username)){
            throw new RuntimeException("用户名已存在！");
        }
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
