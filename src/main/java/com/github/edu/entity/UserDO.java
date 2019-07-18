package com.github.edu.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class UserDO{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


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
