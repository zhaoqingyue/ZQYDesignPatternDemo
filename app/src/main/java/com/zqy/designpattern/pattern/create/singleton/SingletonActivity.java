package com.zqy.designpattern.pattern.create.singleton;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.zqy.designpattern.R;
import com.zqy.designpattern.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 单例模式
 */
public class SingletonActivity extends BaseActivity {

    public static int SINGLETON_ONE = 1;
    public static int SINGLETON_TWO = 2;
    public static int SINGLETON_THREE = 3;
    public static int SINGLETON_FOUR = 4;
    public static int SINGLETON_FIVE = 5;
    public static int SINGLETON_SIX = 6;

    @BindView(R.id.tv_des)
    TextView des;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_singleton;
    }

    @Override
    protected String getTitleName() {
        return "单例模式";
    }

    @Override
    protected void initData() {
        /**
         * 定义：
         * a. 实现一个类只有一个实例化对象
         * b. 提供一个全局访问点
         *
         * 作用：
         * a. 保证一个类只有一个对象
         * b. 降低对象之间的耦合度
         *
         * 适用场景：
         * a. 应用中某个实例对象需要频繁的被访问
         * b. 应用中每次启动只会存在一个实例。（如账号系统，数据库系统）
         *
         * 单例要点：
         * 1. 构造函数私有
         * 2. 含有一个该类的静态私有对象
         * 3. 有一个静态的公有的函数用于创建或获取它本身的静态私有对象
         * 4. 线程同步
         */
        des.setText("定义：\n" +
                "a. 实现一个类只有一个实例化对象\n" +
                "b. 提供一个全局访问点\n\n" +

                "作用：\n" +
                "a. 保证一个类只有一个对象\n" +
                "b. 降低对象之间的耦合度\n\n" +

                "适用场景：\n" +
                "a. 应用中某个实例对象需要频繁的被访问\n" +
                "b. 应用中每次启动只会存在一个实例。（如账号系统，数据库系统）\n\n" +

                "单例要点：\n" +
                "1. 构造函数私有\n" +
                "2. 含有一个该类的静态私有对象\n" +
                "3. 有一个静态的公有的函数用于创建或获取它本身的静态私有对象\n" +
                "4. 线程同步"
        );
    }

    @OnClick({R.id.singleton_one, R.id.singleton_two, R.id.singleton_three,
              R.id.singleton_four, R.id.singleton_five, R.id.singleton_six})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.singleton_one: {
                // 饿汉式
                Intent intent = new Intent(this, SingletonDesActivity.class);
                intent.putExtra("singleton", SINGLETON_ONE);
                startActivity(intent);
                break;
            }
            case R.id.singleton_two: {
                // 枚举类型
                Intent intent = new Intent(this, SingletonDesActivity.class);
                intent.putExtra("singleton", SINGLETON_TWO);
                startActivity(intent);
                break;
            }
            case R.id.singleton_three: {
                // 懒汉式
                Intent intent = new Intent(this, SingletonDesActivity.class);
                intent.putExtra("singleton", SINGLETON_THREE);
                startActivity(intent);
                break;
            }
            case R.id.singleton_four: {
                // 同步锁
                Intent intent = new Intent(this, SingletonDesActivity.class);
                intent.putExtra("singleton", SINGLETON_FOUR);
                startActivity(intent);
                break;
            }
            case R.id.singleton_five: {
                // 双重检验锁
                Intent intent = new Intent(this, SingletonDesActivity.class);
                intent.putExtra("singleton", SINGLETON_FIVE);
                startActivity(intent);
                break;
            }
            case R.id.singleton_six: {
                // 静态内部类
                Intent intent = new Intent(this, SingletonDesActivity.class);
                intent.putExtra("singleton", SINGLETON_SIX);
                startActivity(intent);
                break;
            }
        }
    }
}
