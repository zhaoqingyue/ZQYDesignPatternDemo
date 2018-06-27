package com.zqy.designpattern.pattern.create.singleton;

/**
 * Created by zhaoqy on 2018/6/20.
 * 枚举类型
 * 初始化单例类时，创建单例，线程安全
 */
public enum  SingletonTwo {

    //定义1个枚举的元素，即为单例类的1个实例
    INSTANCE;

    // 隐藏了1个空的、私有的 构造方法
    // private Singleton () {}

    // 获取单例的方式：
    // SingletonTwo singleton = SingletonTwo.INSTANCE;
}
