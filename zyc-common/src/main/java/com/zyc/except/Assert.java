package com.zyc.except;

import com.zyc.utils.ResponseEnum;
import org.springframework.util.StringUtils;

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
public class Assert {
    /**
     * 断言对象不为空
     * obj 为空则抛异常
     * @param obj
     * @param responseEnum
     */
    public static void notNull(Object obj, ResponseEnum responseEnum){
        if(obj == null){
            throw new BusinessException(responseEnum);
        }
    }
    /**
     * 断言对象为空
     * 如果对象obj不为空，则抛出异常
     * @param object
     * @param responseEnum
     */
    public static void isNull(Object object, ResponseEnum responseEnum) {
        if (object != null) {
            throw new BusinessException(responseEnum);
        }
    }

    /**
     * 断言表达式为真
     * 如果不为真，则抛出异常
     *
     * @param expression 是否成功
     */
    public static void isTrue(boolean expression, ResponseEnum responseEnum) {
        if (!expression) {
            throw new BusinessException(responseEnum);
        }
    }

    /**
     * 断言两个对象不相等
     * 如果相等，则抛出异常
     * @param m1
     * @param m2
     * @param responseEnum
     */
    public static void notEquals(Object m1, Object m2,  ResponseEnum responseEnum) {
        if (m1.equals(m2)) {
            throw new BusinessException(responseEnum);
        }
    }

    /**
     * 断言两个对象相等
     * 如果不相等，则抛出异常
     * @param m1
     * @param m2
     * @param responseEnum
     */
    public static void equals(Object m1, Object m2,  ResponseEnum responseEnum) {
        if (!m1.equals(m2)) {
            throw new BusinessException(responseEnum);
        }
    }

    /**
     * 断言参数不为空
     * 如果为空，则抛出异常
     * @param s
     * @param responseEnum
     */
    public static void notEmpty(String s, ResponseEnum responseEnum) {
        if (StringUtils.isEmpty(s)) {
            throw new BusinessException(responseEnum);
        }
    }
}