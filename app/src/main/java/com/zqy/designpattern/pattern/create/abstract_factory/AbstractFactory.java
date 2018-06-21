package com.zqy.designpattern.pattern.create.abstract_factory;

import com.zqy.designpattern.pattern.create.factory.Shape;

/**
 * Created by zhaoqy on 2018/6/21.
 * 为 Color 和 Shape 对象创建抽象类来获取工厂
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
