package com.github.edu.config.handles;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ：liming
 * @date ：2019/7/18 15:24
 * @description： mybatis json处理
 */
@MappedTypes(JSONObject.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class JsonHandler extends BaseTypeHandler<JSONObject> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, JSONObject jsonObject, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, String.valueOf(jsonObject.toJSONString()));
    }

    @Override
    public JSONObject getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String rs = resultSet.getString(s);
        if (rs != null) {
            return JSONObject.parseObject(rs);
        }
        return null;
    }

    @Override
    public JSONObject getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String rs = resultSet.getString(i);
        if (rs != null) {
            return JSONObject.parseObject(rs);
        }
        return null;
    }

    @Override
    public JSONObject getNullableResult(CallableStatement callableStatement, int i) throws SQLException {

        String rs = callableStatement.getString(i);
        if (rs != null) {
            return JSONObject.parseObject(rs);
        }
        return null;
    }
}
