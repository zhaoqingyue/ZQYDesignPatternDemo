package com.zqy.designpattern.pattern.create.factory;

import com.blankj.utilcode.util.LogUtils;

/**
 * Created by zhaoqy on 2018/6/21.
 */

public class Circle implements Shape {

    @Override
    public void draw() {
        LogUtils.d("ZQY", "Inside Circle::draw() method.");
    }
}
