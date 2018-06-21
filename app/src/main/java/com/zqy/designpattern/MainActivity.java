package com.zqy.designpattern;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zqy.designpattern.base.BaseActivity;
import com.zqy.designpattern.pattern.behavior.BehaviorActivity;
import com.zqy.designpattern.pattern.create.CreateActivity;
import com.zqy.designpattern.pattern.structure.StructureActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    public static final String TAG = "ZQY";

    @BindView(R.id.tv_des)
    TextView des;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected String getTitleName() {
        return getResources().getString(R.string.app_name);
    }

    @Override
    protected void initData() {
        /**
         * 定义：
         * a. 某类特定问题的代码设计解决方案
         * b. 是一套代码设计的经验总结
         *
         * 作用：
         * a. 提高代码复用率，降低开发成本和周期
         * b. 提高代码可维护性、可拓展性
         * c. 使代码更加优雅
         * d. 让代码更容易被他人理解
         */
        des.setText("定义：\n" +
                "a. 某类特定问题的代码设计解决方案\n" +
                "b. 是一套代码设计的经验总结\n\n" +

                "作用：\n" +
                "a. 提高代码复用率，降低开发成本和周期\n" +
                "b. 提高代码可维护性、可拓展性\n" +
                "c. 使代码更加优雅\n" +
                "d. 让代码更容易被他人理解");
    }

    @Override
    protected boolean isHasNaviIcon() {
        return false;
    }

    @OnClick({R.id.btn_create, R.id.btn_structure, R.id.btn_behavior})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create: {
                // 创建者模式
                Intent intent = new Intent(this, CreateActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_structure: {
                // 结构型模式
                Intent intent = new Intent(this, StructureActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_behavior: {
                // 行为型模式
                Intent intent = new Intent(this, BehaviorActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (System.currentTimeMillis() - mExitTime > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    // 声明一个long类型变量：用于存放上一点击“返回键”的时刻
    private long mExitTime;

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        // 判断用户是否点击了“返回键”
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            // 与上次点击返回键时刻作差
//            if ((System.currentTimeMillis() - mExitTime) > 2000) {
//                // 大于2000ms则认为是误操作，使用Toast进行提示
//                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
//                // 并记录下本次点击“返回键”的时刻，以便下次进行判断
//                mExitTime = System.currentTimeMillis();
//            } else {
//                // 小于2000ms则认为是用户确实希望退出程序-调用System.exit()方法进行退出
//                System.exit(0);
//            }
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
