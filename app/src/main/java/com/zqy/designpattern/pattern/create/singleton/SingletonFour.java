package com.zqy.designpattern.pattern.create.singleton;

/**
 * Created by zhaoqy on 2018/6/20.
 * 同步锁（懒汉式的改进）
 * 按需、延迟创建单例，Lazy 初始化，线程安全
 */
public class SingletonFour {

    // 1. 类加载时，先不自动创建单例（将单例的引用先赋值为 Null）
    private static  SingletonFour instance  = null;

    // 2. 构造函数 设置为 私有权限（原因：禁止他人创建实例）
    private SingletonFour() {
    }

    // 3. 加入同步锁
    public static synchronized SingletonFour getInstance(){
        // 先判断单例是否为空，以避免重复创建
        if ( instance == null )
            instance = new SingletonFour();

        return instance;
    }

    public String getText() {
        return  "----我是同步锁单例模式----";
    }
}
