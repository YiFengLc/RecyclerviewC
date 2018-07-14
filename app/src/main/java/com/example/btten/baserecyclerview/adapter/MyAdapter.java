package com.example.btten.baserecyclerview.adapter;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.btten.baserecyclerview.R;
import com.example.btten.baserecyclerview.bean.Model;

import java.util.List;

/**
 * Created by LC on 2018/7/14.
 */

public class MyAdapter extends BaseItemDraggableAdapter<Model> {
    private Context context;
    public MyAdapter(Context context, List<Model> data) {
        super(R.layout.item_rv,data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Model item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_content, item.getContent())
                .setImageResource(R.id.iv_img, item.getImgUrl())
                .linkify(R.id.tv_content);
        helper.setOnClickListener(R.id.tv_title, new OnItemChildClickListener())
                .setOnClickListener(R.id.tv_content, new OnItemChildClickListener());
    }
}
