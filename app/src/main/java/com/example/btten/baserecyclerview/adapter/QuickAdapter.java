package com.example.btten.baserecyclerview.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.btten.baserecyclerview.R;
import com.example.btten.baserecyclerview.bean.Model;

import java.util.ArrayList;
import java.util.List;

//public class QuickAdapter extends BaseQuickAdapter<Model> {
//    public QuickAdapter(Context context,ArrayList<Model> data) {
//        super(context, R.layout.item_rv, data);
//    }
//
//    @Override
//    protected void convert(BaseViewHolder helper, Model item) {
//        helper.setText(R.id.tv_title, item.getContent())
//                .setText(R.id.tv_content, item.getContent())
//                .setImageResource(R.id.iv_img, item.getImgUrl())
//                .linkify(R.id.tv_content);
//    }
//}
public class QuickAdapter extends BaseQuickAdapter<Model> {
    private Context context;
    public QuickAdapter(Context context , ArrayList<Model> data) {
        super(R.layout.item_rv, data);
        this.context = context;
    }
    @Override
    protected void convert(BaseViewHolder helper, Model item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_content, item.getContent())
                .setImageResource(R.id.iv_img, item.getImgUrl())
                .linkify(R.id.tv_content);
        helper.setOnClickListener(R.id.tv_title, new OnItemChildClickListener())
                .setOnClickListener(R.id.tv_content, new OnItemChildClickListener())
                .setOnClickListener(R.id.content,new OnItemChildClickListener())
                .setOnClickListener(R.id.right,new OnItemChildClickListener());


    }
}