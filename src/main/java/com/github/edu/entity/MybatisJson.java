package com.github.edu.entity;

import com.github.edu.base.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author ：liming
 * @date ：2019/7/18 14:41
 * @description：
 */
@Table(name="mybatis_json")
@Data
public class MybatisJson extends AbstractEntity {

    @Column(name = "msg")
    private String  msg;

    @Column(name = "info")
    private String  info;

}
