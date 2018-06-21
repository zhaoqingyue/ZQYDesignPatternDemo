package com.zqy.designpattern.pattern.behavior;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zqy.designpattern.R;
import com.zqy.designpattern.base.BaseActivity;
import com.zqy.designpattern.base.RecyclerAdapter;
import com.zqy.designpattern.pattern.behavior.observer.ObserverActivity;
import com.zqy.designpattern.pattern.create.singleton.SingletonActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * 行为型模式
 */
public class BehaviorActivity extends BaseActivity implements RecyclerAdapter.OnItemClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private RecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> mDatas;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_behavior;
    }

    @Override
    protected String getTitleName() {
        return "行为型模式";
    }

    @Override
    protected void initData() {
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mDatas = new ArrayList<>();
        mDatas.addAll(Arrays.asList(getResources().getStringArray(R.array.pattern_behavior)));
        mAdapter = new RecyclerAdapter(mDatas);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        switch (position) {
            case 0: {
                /**
                 * 模板方法模式
                 */
                Intent intent = new Intent(this, SingletonActivity.class);
                startActivity(intent);
                break;
            }
            case 1: {
                /**
                 * 命令模式
                 */
                break;
            }
            case 2: {
                /**
                 * 迭代器模式
                 */
                break;
            }
            case 3: {
                /**
                 * 观察者模式
                 */
                Intent intent = new Intent(this, ObserverActivity.class);
                startActivity(intent);
                break;
            }
            case 4: {
                /**
                 * 调停者模式
                 */
                break;
            }
            case 5: {
                /**
                 * 状态模式
                 */
                break;
            }
            case 6: {
                /**
                 * 策略模式
                 */
                break;
            }
            case 7: {
                /**
                 * 责任链模式
                 */
                break;
            }
            case 8: {
                /**
                 * 访问者模式
                 */
                break;
            }
            case 9: {
                /**
                 * 备忘录模式
                 */
                break;
            }
            case 10: {
                /**
                 * 解释器模式
                 */
                break;
            }
        }
    }
}
