package com.zyc.porxy.dynamic;

import com.zyc.service.UserServiceDao;

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
 * use:动态代理方式一：JDK实现
 */
public class UserDaoDynamicProxyDemo1 implements InvocationHandler {

    private UserServiceDao userServiceDao;

    public UserDaoDynamicProxyDemo1(UserServiceDao userServiceDao) {
        this.userServiceDao = userServiceDao;
    }

    /**
     * 生成代理对象
     * @return
     */
    public UserServiceDao createUserServiceDao() {
        /**
         * 参数一：classLoader ：目标对象的类加载器
         * 参数二：目标对象实现的接口数组类型
         * 参数三：代表实现了InvocationHandler接口的对象
         */
        Object o = Proxy.newProxyInstance(userServiceDao.getClass().getClassLoader(), userServiceDao.getClass().getInterfaces(), this);
        return (UserServiceDao) o;
    }

    /**
     * 调用目标对西昂方法时，此方法会自动调用
     * @param proxy 代表代理对象
     *
     * @param method 要调用的方法
     *
     * @param args 调用方法传递的参数
     *
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("query")) {
            checkSecurity();
        }
        Object result = method.invoke(userServiceDao, args);
        return result;
    }
    private void checkSecurity(){
        System.out.println("[JDK动态代理]正在进行安全性检查。。。");
    }

}
