package com.zqy.designpattern.pattern.create.singleton;

/**
 * Created by zhaoqy on 2018/6/20.
 * 双重校验锁
 * 按需、延迟创建单例，Lazy 初始化，线程安全
 */
public class SingletonFive {

    // 1. 类加载时，先不自动创建单例（将单例的引用先赋值为 Null）
    private static  SingletonFive instance  = null;

    // 2. 构造函数 设置为 私有权限（原因：禁止他人创建实例）
    private SingletonFive() {
    }

    //3. 需要时才手动调用 getInstance（） 创建单例
    public static  SingletonFive getInstance() {
        // 加入双重校验锁
        // 校验锁1：第1个if
        if( instance == null){  // ①
            synchronized (SingletonFive.class){ // ②
                // 校验锁2：第2个 if
                if( instance == null){
                    instance = new SingletonFive();
                }
            }
        }
        return instance;
    }

    // 说明
    // 校验锁1：第1个if
    // 作用：若单例已创建，则直接返回已创建的单例，无需再执行加锁操作
    // 即直接跳到执行 return instance

    // 校验锁2：第2个 if
    // 作用：防止多次创建单例问题
    // 原理
    // 1. 线程A调用getInstance()，当运行到②位置时，此时线程B也调用了getInstance()
    // 2. 因线程A并没有执行instance = new SingletonFive();，此时instance仍为空，因此线程B能突破第1层 if 判断，运行到①位置等待synchronized中的A线程执行完毕
    // 3. 当线程A释放同步锁时，单例已创建，即instance已非空
    // 4. 此时线程B 从①开始执行到位置②。此时第2层 if 判断 = 为空（单例已创建），因此也不会创建多余的实例

    public String getText() {
        return  "----我是双重校验锁单例模式----";
    }
}
