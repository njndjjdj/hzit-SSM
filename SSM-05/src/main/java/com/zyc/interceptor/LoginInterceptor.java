package com.zyc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@Component("loginInter")
public class LoginInterceptor implements HandlerInterceptor {
    //1. 调用控制器方法（处理器）时执行,
    //返回值：true: 代表放行 false：代表拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.1 得到session对象
        HttpSession session = request.getSession();
        // 1.2 取出session中的username的值
        Object username = session.getAttribute("username");
        // 1.3 如果有值，证明代表用户登录过，此时放行,反之未登录，跳转到登录页面
        if(username == null){
            session.setAttribute("message","对不起，你未登录！");
            response.sendRedirect("/login.jsp");
            return false;
        }
        return true;
    }
    //2. 控制器方法完成后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor--》postHandle（）");
    }
    //3. 视图渲染前
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginInterceptor--》afterCompletion（）");
    }
}
