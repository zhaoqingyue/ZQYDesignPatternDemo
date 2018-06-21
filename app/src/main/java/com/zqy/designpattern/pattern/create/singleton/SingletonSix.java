package com.zqy.designpattern.pattern.create.singleton;

/**
 * Created by zhaoqy on 2018/6/20.
 * 静态内部类
 * 按需、延迟创建单例，Lazy 初始化，线程安全
 */
public class SingletonSix {

    // 1. 创建静态内部类
    private static class Singleton {
        // 在静态内部类里创建单例
        private static  SingletonSix instance  = new SingletonSix();
    }

    // 私有构造函数
    private SingletonSix() {
    }

    // 延迟加载、按需创建
    public static  SingletonSix getInstance() {
        return Singleton.instance;
    }

    // 调用过程说明：
    // 1. 外部调用类的getInstance()
    // 2. 自动调用Singleton.instance
    // 2.1 此时单例类Singleton得到初始化
    // 2.2 而该类在装载 & 被初始化时，会初始化它的静态域，从而创建单例；
    // 2.3 由于是静态域，因此只会JVM只会加载1遍，Java虚拟机保证了线程安全性
    // 3. 最终只创建1个单例

    public String getText() {
        return  "----我是静态内部类单例模式----";
    }
}
