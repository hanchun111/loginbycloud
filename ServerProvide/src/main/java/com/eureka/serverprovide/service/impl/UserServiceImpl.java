package com.eureka.serverprovide.service.impl;

import com.eureka.serverprovide.dao.IUserDao;
import com.eureka.serverprovide.entity.User;
import com.eureka.serverprovide.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public User findUser(String UserId) {
        return userDao.findUser(UserId);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public boolean login(String userId, String password){

        User user = new User();

        user = userDao.findUser(userId);

        if(user.getUserPwd().equals(password))
            return true;
        return false;

    }
}
