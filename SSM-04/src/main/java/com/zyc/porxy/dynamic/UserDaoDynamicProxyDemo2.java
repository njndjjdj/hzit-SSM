package com.zyc.porxy.dynamic;

import com.zyc.service.UserServiceDao;
import com.zyc.service.impl.UserDaoServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 作者:ZYC
 * DATE:2024/8/13
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:动态代理方式一：CGLIB实现
 */
public class UserDaoDynamicProxyDemo2 implements MethodInterceptor {


    public UserDaoServiceImpl createUserServiceDao() {
        // 构造代理对象
        Enhancer enhancer = new Enhancer();
        // 传递实现了callback接口对象，而MethodInterceptor继承自callback接口
        enhancer.setCallback(this);
        // 指定父类,父类能被继承，不能是由final修饰的
        enhancer.setSuperclass(UserDaoServiceImpl.class);
        return (UserDaoServiceImpl) enhancer.create();
    }
    private void checkSecurity(){
        System.out.println("[JDK动态代理]正在进行安全性检查。。。");
    }

    /**
     * 2. 对目标对象方法的调用
     * @param o 代理对象的父类，即目标对象
     * @param method 要调用的方法
     * @param objects 方法的参数
     * @param methodProxy 代理对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("query")) {
            checkSecurity();
        }
        Object result = methodProxy.invokeSuper(o, objects);
        return result;
    }
}
