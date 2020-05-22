package com.github.xiaohu409.wanandroid.mvc.adapter;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * 项目名称：
 * 文件名称：BaseRecycleAdapter
 * 文件描述：
 * 创建作者：hutao
 * 创建日期：2020/5/18
 * 文件版本：1.0
 */
public abstract class BaseRecycleAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected Context context;
    protected List<T> list;
    protected LayoutInflater inflater;
    
    public BaseRecycleAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
