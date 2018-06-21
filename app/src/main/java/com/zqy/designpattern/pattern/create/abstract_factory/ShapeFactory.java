package com.zqy.designpattern.pattern.create.abstract_factory;

import com.zqy.designpattern.pattern.create.factory.Circle;
import com.zqy.designpattern.pattern.create.factory.Rectangle;
import com.zqy.designpattern.pattern.create.factory.Shape;
import com.zqy.designpattern.pattern.create.factory.Square;

/**
 * Created by zhaoqy on 2018/6/21.
 */

public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        switch (shapeType) {
            case "CIRCLE": {
                return new Circle();
            }
            case "RECTANGLE": {
                return new Rectangle();
            }
            case "SQUARE": {
                return new Square();
            }
            default:
                return null;
        }
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
