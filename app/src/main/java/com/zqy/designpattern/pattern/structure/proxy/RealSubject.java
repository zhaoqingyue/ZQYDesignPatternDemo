package com.zqy.designpattern.pattern.structure.proxy;

import com.blankj.utilcode.util.LogUtils;

/**
 * Created by zhaoqy on 2018/6/21.
 * 步骤2： 创建真实对象类（RealSubject）
 */
public class RealSubject implements Subject {

    @Override
    public void buyMac() {
        LogUtils.d("ZQY", "买一台Mac");
    }
}
