package com.zqy.designpattern.pattern.behavior.observer;

/**
 * Created by zhaoqy on 2018/6/20.
 * 抽象 观察者
 * 观察者的抽象类，定义了一个更新的接口，使得在得到主题更改通知时，更新自己
 */

public interface Observer {

    void update(String message);
}
