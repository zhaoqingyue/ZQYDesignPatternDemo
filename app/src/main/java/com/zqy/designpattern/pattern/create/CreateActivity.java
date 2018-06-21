package com.zqy.designpattern.pattern.create;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zqy.designpattern.R;
import com.zqy.designpattern.base.BaseActivity;
import com.zqy.designpattern.base.RecyclerAdapter;
import com.zqy.designpattern.pattern.create.abstract_factory.AbstractFactoryActivity;
import com.zqy.designpattern.pattern.create.factory.FactoryActivity;
import com.zqy.designpattern.pattern.create.singleton.SingletonActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者模式
 */
public class CreateActivity extends BaseActivity implements RecyclerAdapter.OnItemClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private RecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> mDatas;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_create;
    }

    @Override
    protected String getTitleName() {
        return "创建者模式";
    }

    @Override
    protected void initData() {
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mDatas = new ArrayList<>();
        mDatas.addAll(Arrays.asList(getResources().getStringArray(R.array.pattern_create)));
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
                 * 单例模式
                 */
                Intent intent = new Intent(this, SingletonActivity.class);
                startActivity(intent);
                break;
            }
            case 1: {
                /**
                 * 工厂模式
                 */
                Intent intent = new Intent(this, FactoryActivity.class);
                startActivity(intent);
                break;
            }
            case 2: {
                /**
                 * 抽象工厂模式
                 */
                Intent intent = new Intent(this, AbstractFactoryActivity.class);
                startActivity(intent);
                break;
            }
            case 3: {
                /**
                 * 建造者模式
                 */
                break;
            }
            case 4: {
                /**
                 * 原型模式
                 */
                break;
            }
        }
    }
}
