package com.zqy.designpattern.pattern.create.abstract_factory;

import com.blankj.utilcode.util.LogUtils;

/**
 * Created by zhaoqy on 2018/6/21.
 */

public class Red implements Color {

    @Override
    public void fill() {
        LogUtils.d("ZQY", "Inside Red::fill() method.");
    }
}
