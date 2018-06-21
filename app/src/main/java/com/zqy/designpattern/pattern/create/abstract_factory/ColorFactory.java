package com.zqy.designpattern.pattern.create.abstract_factory;

import com.zqy.designpattern.pattern.create.factory.Shape;

/**
 * Created by zhaoqy on 2018/6/21.
 */

public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    public Color getColor(String color) {
        switch (color) {
            case "RED": {
                return new Red();
            }
            case "GREEN": {
                return new Green();
            }
            case "BLUE": {
                return new Blue();
            }
            default:
                return null;
        }
    }
}
