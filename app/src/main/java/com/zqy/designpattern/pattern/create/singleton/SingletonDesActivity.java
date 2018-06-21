package com.zqy.designpattern.pattern.create.singleton;

import android.widget.TextView;

import com.zqy.designpattern.R;
import com.zqy.designpattern.base.BaseActivity;

import butterknife.BindView;

public class SingletonDesActivity extends BaseActivity {

    @BindView(R.id.tv_text)
    TextView text;

    @BindView(R.id.tv_des)
    TextView des;

    private int singletonType;
    private String desStr;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_singleton_des;
    }

    @Override
    protected String getTitleName() {
        String name = "";
        singletonType = getIntent().getIntExtra("singleton", 1);
        switch (singletonType) {
            case 1:{
                name = "饿汉式";
                break;
            }
            case 2:{
                name = "枚举类型";
                break;
            }
            case 3:{
                name = "懒汉式";
                break;
            }
            case 4:{
                name = "同步锁";
                break;
            }
            case 5:{
                name = "双重检验锁";
                break;
            }
            case 6:{
                name = "静态内部类";
                break;
            }
        }
        return name;
    }

    @Override
    protected void initData() {
        switch (singletonType) {
            case 1:{
                text.setText(SingletonOne.getInstance().getText());
                /**
                 * 饿汉式
                 * ----初始化单例类时，创建单例，线程安全
                 *
                 * 原理：依赖 JVM类加载机制，保证单例只会被创建1次，即线程安全
                 * a. JVM在类的初始化阶段(即 在Class被加载后、被线程使用前)，会执行类的初始化
                 * b. 在执行类的初始化期间，JVM会去获取一个锁。这个锁可以同步多个线程对同一个类的初始化
                 *
                 * 优点：没有加锁，执行效率会提高
                 * 缺点：类加载时就初始化，浪费内存
                 */
                desStr = "----初始化单例类时，创建单例，线程安全\n\n" +
                        "原理：依赖 JVM类加载机制，保证单例只会被创建1次，即线程安全\n" +
                        "a. JVM在类的初始化阶段(即 在Class被加载后、被线程使用前)，会执行类的初始化\n" +
                        "b. 在执行类的初始化期间，JVM会去获取一个锁。这个锁可以同步多个线程对同一个类的初始化\n\n" +
                        "优点：没有加锁，执行效率会提高\n" +
                        "缺点：类加载时就初始化，浪费内存";
                break;
            }
            case 2:{
                text.setText("我是枚举类型：" + SingletonTwo.INSTANCE);
                /**
                 * 枚举类型
                 * ----初始化单例类时，创建单例，线程安全
                 *
                 * 特点：
                 * a. 不可被继承
                 * b. 每个枚举元素 = 类静态常量 = 1个实例
                 * c. 构造方法默认 = 私有（private）
                 * d. 每一个枚举变量在JVM中都是唯一的
                 */
                desStr = "----初始化单例类时，创建单例，线程安全\n\n" +
                        "特点：\n" +
                        "a. 不可被继承\n" +
                        "b. 每个枚举元素 = 类静态常量 = 1个实例\n" +
                        "c. 构造方法默认 = 私有（private）\n" +
                        "d. 每一个枚举变量在JVM中都是唯一的";
                break;
            }
            case 3:{
                text.setText(SingletonThree.getInstance().getText());
                /**
                 * 懒汉式
                 * ----按需、延迟创建单例，Lazy 初始化，线程不安全
                 *
                 * 缺点：
                 * a. 不支持多线程（没有加锁 synchronized）
                 * b. 线程不安全
                 */
                desStr = "----按需、延迟创建单例，Lazy 初始化，线程不安全\n\n" +
                        "缺点：\n" +
                        "a. 不支持多线程（没有加锁 synchronized）\n" +
                        "b. 线程不安全";
                break;
            }
            case 4:{
                text.setText(SingletonFour.getInstance().getText());
                /**
                 * 同步锁（懒汉式的改进）
                 * ----按需、延迟创建单例，Lazy 初始化，线程安全
                 *
                 * 原理：
                 * 使用同步锁 synchronized锁住 创建单例的方法 ，防止多个线程同时调用，从而避免造成单例被多次创建
                 *
                 * 优点：第一次调用才初始化，避免内存浪费
                 * 缺点：
                 * a. 必须加锁 synchronized 才能保证单例，但加锁会影响效率
                 * b. 每次访问都要进行线程同步（即 调用synchronized锁)，造成过多的同步开销（加锁 = 耗时、耗能）
                 */
                desStr = "----按需、延迟创建单例，Lazy 初始化，线程安全（懒汉式的改进）\n\n" +
                        "原理：\n" +
                        "使用同步锁 synchronized锁住创建单例的方法 ，防止多个线程同时调用，" +
                        "从而避免造成单例被多次创建\n\n" +
                        "优点：第一次调用才初始化，避免内存浪费\n" +
                        "缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率";
                break;
            }
            case 5:{
                text.setText(SingletonFive.getInstance().getText());
                /**
                 * 双重校验锁（懒汉式的改进）
                 * ----按需、延迟创建单例，Lazy 初始化，线程安全
                 *
                 * 原理：
                 * 在同步锁的基础上，添加1层 if判断：若单例已创建，则不需再执行加锁操作就可获取实例，从而提高性能
                 *
                 * 优点：安全且在多线程情况下能保持高性能
                 * 缺点：实现复杂 = 多种判断，易出错
                 */
                desStr = "----按需、延迟创建单例，Lazy 初始化，线程安全（懒汉式的改进）\n\n" +
                        "原理：\n" +
                        "在同步锁的基础上，添加1层 if判断：若单例已创建，则不需再执行加锁操作就可获取实例，" +
                        "从而提高性能\n\n" +
                        "优点：安全且在多线程情况下能保持高性能\n" +
                        "缺点：实现复杂 = 多种判断，易出错";
                break;
            }
            case 6:{
                text.setText(SingletonSix.getInstance().getText());
                /**
                 * 静态内部类
                 * ----按需、延迟创建单例，Lazy 初始化，线程安全
                 *
                 * 原理：
                 * 根据静态内部类的特性，同时解决了按需加载、线程安全的问题，同时实现简洁
                 *
                 * 1. 在静态内部类里创建单例，在装载该内部类时才会去创建单例
                 * 2. 线程安全：类是由 JVM加载，而JVM只会加载1遍，保证只有1个单例
                 */
                desStr = "----按需、延迟创建单例，Lazy 初始化，线程安全（懒汉式的改进）\n\n" +
                        "原理：\n" +
                        "根据静态内部类的特性，同时解决了按需加载、线程安全的问题，同时实现简洁\n" +
                        "1. 在静态内部类里创建单例，在装载该内部类时才会去创建单例\n" +
                        "2. 线程安全：类是由 JVM加载，而JVM只会加载1遍，保证只有1个单例";
                break;
            }
        }
        des.setText(desStr);
    }
}

