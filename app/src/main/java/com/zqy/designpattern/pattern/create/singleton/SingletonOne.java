package com.zqy.designpattern.pattern.create.singleton;

/**
 * Created by zhaoqy on 2018/6/20.
 * 饿汉式
 * 初始化单例类时，创建单例，线程安全
 */
public class SingletonOne {

    // 1. 加载该类时，单例就会自动被创建
    private static  SingletonOne instance  = new  SingletonOne();

    // 2. 构造函数：设置为私有权限 （原因：禁止他人创建实例）
    private SingletonOne() {
    }

    // 3. 通过调用静态方法获得创建的单例
    public static  SingletonOne getInstance() {
        return instance;
    }

    public String getText() {
        return  "----我是饿汉式单例模式----";
    }
}
