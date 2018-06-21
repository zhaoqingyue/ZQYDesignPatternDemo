package com.zqy.designpattern.pattern.behavior.observer;

/**
 * Created by zhaoqy on 2018/6/20.
 * 抽象 被观察者
 */
public interface Subject {
    /**
     * 增加订阅者
     */
    void  attach(Observer observer);

    /**
     * 删除订阅者
     */
    void detach(Observer observer);

    /**
     * 通知订阅者更新消息
     */
    void notifyMessage(String message);

}
