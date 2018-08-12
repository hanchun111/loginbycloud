package com.eureka.serverprovide.dao.impl;


import com.eureka.serverprovide.dao.IUserDao;
import com.eureka.serverprovide.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 简单用户链接Mysql数据库微服务(通过@Repository注解标注该类为持久化操作对象)
 *
 * @author chen
 *
 * @version 0.0.1
 *
 * @date 18/8/12
 *
 */
@Repository
public class UserDaoImpl implements IUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public User findUser(String UserId) {
        // 1.定义SQL语句
        String querySQL = "select * from user where UserId = " + UserId;
        // 2.定义RowMapper
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        // 3.执行查询方法
        User user = jdbcTemplate.queryForObject(querySQL , rowMapper);

        return user;
    }

    @Override
    public List<User> findAllUsers() {
        // 1.定义SQL语句
        String querySQL = "select * from user";
        // 2.定义RowMapper
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        // 3.执行查询方法
        List<User> users = jdbcTemplate.query(querySQL , rowMapper);

        return users;
    }

    @Override
    public int insertUser(User user) {
        // 1.定义SQL语句
        String execSQL = "insert into user values (?,?,?,?,?)";
        // 2.执行查询方法
        return jdbcTemplate.update(execSQL , new Object[]{user.getUserId(),user.getUserName(),user.getUserSex(),user.getUserAdd(),user.getUserPwd()});
    }



}
