package com.github.edu.entity;

import com.alibaba.fastjson.JSONObject;
import com.github.edu.base.entity.AbstractEntity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Map;

/**
 * @author ：liming
 * @date ：2019/7/18 14:41
 * @description：
 */
//@Table(name="mybatis_json")
@Data
public class MybatisJson extends AbstractEntity {

//    @Column(name = "msg")
    private String  msg;

//    @Column(name = "info")
    private JSONObject info;



}
