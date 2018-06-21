package com.zqy.designpattern.pattern.behavior.observer;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zqy.designpattern.R;
import com.zqy.designpattern.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 观察者模式
 */
public class ObserverActivity extends BaseActivity {

    @BindView(R.id.tv_des)
    TextView des;

    private ConcreteObserver a, b, c, d;
    ConcreteSubject concreteSubject;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_observer;
    }

    @Override
    protected String getTitleName() {
        return "观察者模式";
    }

    @Override
    protected void initData() {
        /**
         * 定义：
         * 在对象之间定义了一对多的依赖，当一个对象改变状态，依赖它的对象会收到通知并自动更新。
         *
         * 4个角色：
         * 1. Subject：抽象被观察者，也就是一个抽象主题，它把所有对观察者对象的引用保存在一个集合中，
         * 每个主题都可以有任意数量的观察者。抽象主题提供一个接口，可以增加和删除观察者角色。
         * 一般用一个抽象类和接口来实现。
         * 2. Observer：抽象观察者，为所有的具体观察者定义一个接口，在得到主题通知时更新自己。
         * 3. ConcreteSubject：具体被观察者，也就是一个具体的主题，将有关状态存入具体观察者，在具体主题内部状态发生改变时，给所有注册过的观察者发送通知。
         * 4. ConcreteObserver：具体观察者，实现抽象观察者定义的更新接口，以便在得到更改通知时更新自身的状态。
         */
        des.setText("定义：\n" +
                "----在对象之间定义一对多的依赖，当一个对象改变状态，依赖它的对象会收到通知并自动更新。\n\n" +
                "4个角色：\n" +
                "1. Subject：抽象被观察者，也就是一个抽象主题，它把所有对观察者对象的引用保存在一个集合中，" +
                "每个主题都可以有任意数量的观察者。抽象主题提供一个接口，可以增加和删除观察者角色。\n" +
                "2. Observer：抽象观察者，为所有的具体观察者定义一个接口，在得到主题通知时更新自己。\n" +
                "3. ConcreteSubject：具体被观察者，也就是一个具体的主题，将有关状态存入具体观察者，在具体主题内部状态发生改变时，给所有注册过的观察者发送通知。\n" +
                "4. ConcreteObserver：具体观察者，实现抽象观察者定义的更新接口，以便在得到更改通知时更新自身的状态。");

        a = new ConcreteObserver("A");
        b = new ConcreteObserver("B");
        c = new ConcreteObserver("C");
        d = new ConcreteObserver("D");

        concreteSubject = new ConcreteSubject();
        concreteSubject.attach(a);
        concreteSubject.attach(b);
        concreteSubject.attach(c);
        concreteSubject.attach(d);
    }

    @OnClick({R.id.btn})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn: {
                concreteSubject.notifyMessage("我是观察者发送过来的消息 ");

                String messageA = a.getMessage();
                String messageB = b.getMessage();
                String messageC = c.getMessage();
                String messageD = d.getMessage();

                String info = messageA + messageB + messageC + messageD;
                Toast.makeText(this, info, Toast.LENGTH_LONG).show();
                break;
            }
        }
    }
}
