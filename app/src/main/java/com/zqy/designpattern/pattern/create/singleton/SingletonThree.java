package com.zqy.designpattern.pattern.create.singleton;

/**
 * Created by zhaoqy on 2018/6/20.
 * 懒汉式（基础实现）
 * 按需、延迟创建单例，Lazy 初始化，线程不安全
 */
public class SingletonThree {

    // 1. 类加载时，先不自动创建单例（将单例的引用先赋值为 Null）
    private static  SingletonThree instance  = null;

    // 2. 构造函数 设置为 私有权限 （原因：禁止他人创建实例）
    private SingletonThree() {
    }

    // 3. 需要时才手动调用 getInstance（） 创建单例
    public static  SingletonThree getInstance() {
        // 先判断单例是否为空，以避免重复创建
        if( instance == null){
            instance = new SingletonThree();
        }
        return instance;
    }

    public String getText() {
        return  "----我是懒汉式单例模式----";
    }
}
