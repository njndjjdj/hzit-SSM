package com.zyc.controller;

import com.zyc.except.Assert;
import com.zyc.service.UserService;
import com.zyc.utils.ResponseEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 作者:ZYC
 * DATE:2024/8/14
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session){
        // if(!"admin".equals(username) || !"123".equals(password)){
        // session.setAttribute("message","你的用户名或密码输入有误！");
        // throw new BusinessException(ResponseEnum.USERNAME_PASSWORD_ERROR);
        // return "redirect:/login.jsp";       // 使用重定向登录页面
        // }
        // 使用断言机制代替传统的异常处理
        Assert.equals(username,"admin", ResponseEnum.USERNAME_ERROR);
        Assert.equals(password,"123",ResponseEnum.PASSWORD_ERROR);

        // 如果登录成功，将当前用户名放到session中,以备在登录拦截器中判断是否有值，从而确定是否登录
        session.setAttribute("username",username);
        return "redirect:/student/list";
    }
}
