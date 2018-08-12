package com.eureka.serverprovide.service;

import com.eureka.serverprovide.entity.User;

import java.util.List;

/**
 * 简单用户链接Mysql数据库微服务(通过@Service注解标注该类为持久化操作对象)。
 *
 * @author chen
 *
 * @version 0.0.1
 *
 * @date 18/8/12
 *
 */
public interface IUserService {

    User findUser(String UserId);

    List<User> findAllUsers();

    int insertUser(User user);
}
