package com.zqy.designpattern.pattern.create.factory;

import android.view.View;
import android.widget.TextView;

import com.zqy.designpattern.R;
import com.zqy.designpattern.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 工厂模式
 */
public class FactoryActivity extends BaseActivity {

    @BindView(R.id.tv_des)
    TextView des;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_factory;
    }

    @Override
    protected String getTitleName() {
        return "工厂模式";
    }

    @Override
    protected void initData() {
        /**
         * 意图：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行
         *
         * 主要解决：主要解决接口选择的问题
         * 何时使用：计划不同条件下创建不同实例
         * 如何解决：让其子类实现工厂接口，返回的也是一个抽象的产品
         * 关键代码：创建过程在其子类执行
         *
         * 优点：
         * 1、一个调用者想创建一个对象，只要知道其名称就可以
         * 2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以
         * 3、屏蔽产品的具体实现，调用者只关心产品的接口
         *
         * 缺点：
         * 每次增加一个产品时，都需要增加一个具体类和对象实现工厂，
         * 使得系统中类的个数成倍增加，在一定程度上增加了系统的复杂度，
         * 同时也增加了系统具体类的依赖。这并不是什么好事。
         */
        des.setText("意图：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，" +
                "工厂模式使其创建过程延迟到子类进行\n\n" +

                "主要解决：主要解决接口选择的问题\n" +
                "何时使用：计划不同条件下创建不同实例\n" +
                "如何解决：让其子类实现工厂接口，返回的也是一个抽象的产品\n" +
                "创建过程在其子类执行\n\n" +

                "优点：\n" +
                "1. 一个调用者想创建一个对象，只要知道其名称就可以\n" +
                "2. 扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以\n" +
                "3. 屏蔽产品的具体实现，调用者只关心产品的接口\n" +
                "缺点：\n" +
                "----每次增加一个产品时，都需要增加一个具体类和对象实现工厂，" +
                "使得系统中类的个数成倍增加，在一定程度上增加了系统的复杂度，" +
                "同时也增加了系统具体类的依赖。");
    }

    @OnClick({R.id.btn_run})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_run: {
                ShapeFactory shapeFactory = new ShapeFactory();

                //获取 Circle 的对象，并调用它的 draw 方法
                Shape shape1 = shapeFactory.getShape("CIRCLE");
                //调用 Circle 的 draw 方法
                shape1.draw();

                //获取 Rectangle 的对象，并调用它的 draw 方法
                Shape shape2 = shapeFactory.getShape("RECTANGLE");
                //调用 Rectangle 的 draw 方法
                shape2.draw();

                //获取 Square 的对象，并调用它的 draw 方法
                Shape shape3 = shapeFactory.getShape("SQUARE");
                //调用 Square 的 draw 方法
                shape3.draw();
                break;
            }
        }
    }
}
