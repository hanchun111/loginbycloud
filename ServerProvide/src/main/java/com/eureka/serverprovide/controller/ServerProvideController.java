package com.eureka.serverprovide.controller;

import com.eureka.serverprovide.entity.User;
import com.eureka.serverprovide.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户微服务Controller。
 *
 * @author chen
 *
 * @version 0.0.1
 *
 * @date 18/8/12
 *
 */
@RestController
public class ServerProvideController {

    @Autowired
    private IUserService userService;
    @GetMapping("/select")
    public User findUser(String UserId) {
        return this.userService.findUser(UserId);
    }
    @GetMapping("/selectAll")
    public List<User> findAllUsers() {
        return this.userService.findAllUsers();
    }
    @GetMapping("/insert")
    public User insertUser(@RequestParam(value = "UserId" , required = false) String UserId , @RequestParam(value = "UserName" , required = false) String UserName , @RequestParam(value = "UserSex" , required = false) String UserSex , @RequestParam(value = "UserAdd" , required = false) String UserAdd , @RequestParam(value = "UserPwd" , required = false) String UserPwd) {
        User user = new User();
        user.setUserId(UserId);
        user.setUserName(UserName);
        user.setUserSex(UserSex);
        user.setUserAdd(UserAdd);
        user.setUserPwd(UserPwd);
        int res = userService.insertUser(user);
        if(res > 0) {
            return user;
        }
        user.setUserId("0000000000");
        user.setUserName(null);
        user.setUserSex(null);
        user.setUserAdd(null);
        user.setUserPwd(null);
        return user;
    }
}
