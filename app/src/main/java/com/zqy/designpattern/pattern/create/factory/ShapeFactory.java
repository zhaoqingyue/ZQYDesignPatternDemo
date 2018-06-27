package com.zqy.designpattern.pattern.create.factory;

/**
 * Created by zhaoqy on 2018/6/21.
 * 步骤3：创建一个工厂，生成基于给定信息的实体类的对象
 */
public class ShapeFactory {

    // 使用 getShape 方法获取形状类型的对象
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
}
