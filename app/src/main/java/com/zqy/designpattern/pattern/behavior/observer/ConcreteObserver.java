package com.zqy.designpattern.pattern.behavior.observer;

/**
 * Created by zhaoqy on 2018/6/20.
 * 具体 观察者
 * 实现抽象观察者定义的更新接口，以便在得到更改通知时更新自身的状态
 */
public class ConcreteObserver implements Observer {

    private String mMessage;
    private final String mName;

    public ConcreteObserver(String name) {
        mName = name;
    }

    @Override
    public void update(String message) {
        mMessage = message;
    }

    public String getMessage(){
        return mName + "收到了：" + mMessage;
    }
}
