package com.eureka.serverprovide.controller;

import com.eureka.serverprovide.entity.User;
import com.eureka.serverprovide.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
@Controller
public class ServerProvideController {

    @Autowired
    private IUserService userService;
    @GetMapping("/select")
    public User findUser(String UserId) {
        return this.userService.findUser(UserId);
    }
    @GetMapping("/selectAll")
    public ModelAndView findAllUsers() {

        ModelAndView modelAndView = new ModelAndView("/user_list");

        List<User> users  = this.userService.findAllUsers();
        modelAndView.addObject("users",users);
        return  modelAndView;

    }
    @GetMapping("/insert")
    public String insertUser(@RequestParam(value = "UserId" , required = false) String UserId , @RequestParam(value = "UserName" , required = false) String UserName , @RequestParam(value = "UserSex" , required = false) String UserSex , @RequestParam(value = "UserAdd" , required = false) String UserAdd , @RequestParam(value = "UserPwd" , required = false) String UserPwd) {
        User user = new User();
        user.setUserId(UserId);
        user.setUserName(UserName);
        user.setUserSex(UserSex);
        user.setUserAdd(UserAdd);
        user.setUserPwd(UserPwd);
        int res = userService.insertUser(user);
        if(res > 0) {
            return "redirect:index";
        }
        user.setUserId("0000000000");
        user.setUserName(null);
        user.setUserSex(null);
        user.setUserAdd(null);
        user.setUserPwd(null);
        return "redirect:register";
    }
    @PostMapping("/login")
    public String login(@RequestParam("UserId") String userId, @RequestParam("Password") String password){
        if(userService.login(userId, password))
            return "redirect:selectAll";
        return "redirect:index";

    }

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/index");
    }

    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("/register");

    }
}
