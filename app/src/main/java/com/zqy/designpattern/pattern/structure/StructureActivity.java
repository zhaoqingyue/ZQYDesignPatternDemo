package com.zqy.designpattern.pattern.structure;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zqy.designpattern.R;
import com.zqy.designpattern.base.BaseActivity;
import com.zqy.designpattern.base.RecyclerAdapter;
import com.zqy.designpattern.pattern.structure.proxy.ProxyActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * 结构型模式
 */
public class StructureActivity extends BaseActivity implements RecyclerAdapter.OnItemClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private RecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> mDatas;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_structure;
    }

    @Override
    protected String getTitleName() {
        return "结构型模式";
    }

    @Override
    protected void initData() {
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mDatas = new ArrayList<>();
        mDatas.addAll(Arrays.asList(getResources().getStringArray(R.array.pattern_structure)));
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
                 * 适配器模式
                 */
                break;
            }
            case 1: {
                /**
                 * 桥梁模式
                 */
                break;
            }
            case 2: {
                /**
                 * 装饰模式
                 */
                break;
            }
            case 3: {
                /**
                 * 外观模式
                 */
                break;
            }
            case 4: {
                /**
                 * 组合模式
                 */
                break;
            }
            case 5: {
                /**
                 * 享元模式
                 */
                break;
            }
            case 6: {
                /**
                 * 代理模式
                 */
                Intent intent = new Intent(this, ProxyActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
