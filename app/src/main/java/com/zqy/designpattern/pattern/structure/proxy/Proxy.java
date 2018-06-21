package com.zqy.designpattern.pattern.structure.proxy;

import com.blankj.utilcode.util.LogUtils;

/**
 * Created by zhaoqy on 2018/6/21.
 * 步骤3：创建代理对象类（Proxy），并通过代理类创建真实对象实例并访问其方法
 */

public class Proxy implements Subject {

    @Override
    public void buyMac() {
        // 引用并创建真实对象实例
        RealSubject realSubject = new RealSubject();
        // 调用真实对象的方法，进行代理购买Mac
        realSubject.buyMac();

        // 代理对象额外做的操作
        this.WrapMac();
    }

//    private RealSubject realSubject;
//
//    @Override
//    public void buyMac() {
//        if (realSubject == null) {
//            // 引用并创建真实对象实例
//            realSubject = new RealSubject();
//        }
//
//        // 调用真实对象的方法，进行代理购买Mac
//        realSubject.buyMac();
//
//        // 代理对象额外做的操作
//        this.WrapMac();
//    }

    public void WrapMac(){
        LogUtils.d("ZQY", "用盒子包装好Mac");
    }
}
