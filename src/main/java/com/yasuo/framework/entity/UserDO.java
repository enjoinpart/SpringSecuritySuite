package com.yasuo.framework.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class UserDO {

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;


}
