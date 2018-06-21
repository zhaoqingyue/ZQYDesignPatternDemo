package com.zqy.designpattern.pattern.structure.proxy;

import android.view.View;
import android.widget.TextView;

import com.zqy.designpattern.R;
import com.zqy.designpattern.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ProxyActivity extends BaseActivity {

    @BindView(R.id.tv_des)
    TextView des;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_proxy;
    }

    @Override
    protected String getTitleName() {
        return "代理模式";
    }

    @Override
    protected void initData() {
        /**
         * 定义：给目标对象提供一个代理对象，并由代理对象控制对目标对象的引用
         * 作用：通过引入代理对象的方式来间接访问目标对象
         * 解决的问题：防止直接访问目标对象给系统带来的不必要复杂性
         *
         * 使用步骤：
         * 步骤1： 创建抽象对象接口（Subject）
         * 步骤2： 创建真实对象类（RealSubject）
         * 步骤3：创建代理对象类（Proxy），并通过代理类创建真实对象实例并访问其方法
         * 步骤4：客户端调用
         *
         * 优点：
         * a. 协调调用者和被调用者，降低了系统的耦合度
         * b. 代理对象作为客户端和目标对象之间的中介，起到了保护目标对象的作用
         * 缺点：
         * a. 由于在客户端和真实主题之间增加了代理对象，因此会造成请求的处理速度变慢
         * b. 实现代理模式需要额外的工作，从而增加了系统实现的复杂度
         */
        des.setText("定义：给目标对象提供一个代理对象，并由代理对象控制对目标对象的引用\n" +
                "作用：通过引入代理对象的方式来间接访问目标对象\n" +
                "解决的问题：防止直接访问目标对象给系统带来的不必要复杂性\n\n" +
                "使用步骤：\n" +
                "步骤1： 创建抽象对象接口（Subject）\n" +
                "步骤2： 创建真实对象类（RealSubject）\n" +
                "步骤3：创建代理对象类（Proxy），并通过代理类创建真实对象实例并访问其方法\n" +
                "步骤4：客户端调用\n\n" +
                "优点：\n" +
                "a. 协调调用者和被调用者，降低了系统的耦合度\n" +
                "b. 代理对象作为客户端和目标对象之间的中介，起到了保护目标对象的作用\n" +
                "缺点：\n" +
                "a. 由于在客户端和真实主题之间增加了代理对象，因此会造成请求的处理速度变慢\n" +
                "b. 实现代理模式需要额外的工作，从而增加了系统实现的复杂度");
    }

    @OnClick({R.id.btn_buy})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_buy: {
                // 步骤4：客户端调用
                Subject proxy = new Proxy();
                proxy.buyMac();
                break;
            }
        }
    }
}
