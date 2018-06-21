package com.zqy.designpattern.pattern.create.abstract_factory;

import android.view.View;
import android.widget.TextView;

import com.zqy.designpattern.R;
import com.zqy.designpattern.base.BaseActivity;
import com.zqy.designpattern.pattern.create.factory.Shape;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 抽象工厂模式
 */
public class AbstractFactoryActivity extends BaseActivity {

    @BindView(R.id.tv_des)
    TextView des;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_abstract_factory;
    }

    @Override
    protected String getTitleName() {
        return "抽象工厂模式";
    }

    @Override
    protected void initData() {
        /**
         * 意图：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类
         *
         * 主要解决：主要解决接口选择的问题
         * 何时使用：系统的产品有多于一个的产品族，而系统只消费其中某一族的产品
         * 如何解决：在一个产品族里面，定义多个产品
         * 关键代码：在一个工厂里聚合多个同类产品
         *
         * 优点：当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象
         * 缺点：产品族扩展非常困难，要增加一个系列的某一产品，既要在抽象的 Creator 里加代码，又要在具体的里面加代码
         */
        des.setText("意图：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类\n\n" +

                "主要解决：主要解决接口选择的问题\n" +
                "何时使用：系统的产品有多于一个的产品族，而系统只消费其中某一族的产品。\n" +
                "如何解决：在一个产品族里面，定义多个产品\n" +
                "关键代码：在一个工厂里聚合多个同类产品\n\n" +

                "优点：\n" +
                "----当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象\n" +
                "缺点：\n" +
                "----产品族扩展非常困难，要增加一个系列的某一产品，" +
                "既要在抽象的 Creator 里加代码，又要在具体的里面加代码");
    }

    @OnClick({R.id.btn_run})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_run: {
                // 使用 FactoryProducer获取 AbstractFactory，通过传递类型信息来获取实体类的对象

                //获取形状工厂
                AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

                //获取形状为 Circle 的对象
                Shape shape1 = shapeFactory.getShape("CIRCLE");
                //调用 Circle 的 draw 方法
                shape1.draw();

                //获取形状为 Rectangle 的对象
                Shape shape2 = shapeFactory.getShape("RECTANGLE");
                //调用 Rectangle 的 draw 方法
                shape2.draw();

                //获取形状为 Square 的对象
                Shape shape3 = shapeFactory.getShape("SQUARE");
                //调用 Square 的 draw 方法
                shape3.draw();

                //获取颜色工厂
                AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

                //获取颜色为 Red 的对象
                Color color1 = colorFactory.getColor("RED");
                //调用 Red 的 fill 方法
                color1.fill();

                //获取颜色为 Green 的对象
                Color color2 = colorFactory.getColor("GREEN");
                //调用 Green 的 fill 方法
                color2.fill();

                //获取颜色为 Blue 的对象
                Color color3 = colorFactory.getColor("BLUE");
                //调用 Blue 的 fill 方法
                color3.fill();
                break;
            }
        }
    }
}
