package com.example.btten.baserecyclerview;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.btten.baserecyclerview.adapter.QuickAdapter;
import com.example.btten.baserecyclerview.bean.Model;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private QuickAdapter adapter;
    private ArrayList<Model> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new QuickAdapter(MainActivity.this,data);
        adapter.openLoadAnimation();
        adapter.isFirstOnly(false);
        recyclerView.setAdapter(adapter);

        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Toast.makeText(getApplicationContext(),i+"",Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnRecyclerViewItemChildClickListener(new BaseQuickAdapter.OnRecyclerViewItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                switch(view.getId()){
                    case R.id.content:
                        Toast.makeText(getApplicationContext(),i+"根布局",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv_content:
                        Toast.makeText(getApplicationContext(),i+"内容",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv_title:
                        Toast.makeText(getApplicationContext(),i+"标题",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.right:
                        Toast.makeText(getApplicationContext(),i+"删除",Toast.LENGTH_SHORT).show();
                        adapter.remove(i);
//                        Animator
                }
            }
        });
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {

            }
        });
    }

    private void initData() {
        data = new ArrayList<>();
        for(int i=0;i<30;i++)
        {
            Model model = new Model("标题"+i,"内容"+i,R.mipmap.ic_launcher);
            data.add(model);
        }
    }
}
