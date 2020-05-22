package com.github.xiaohu409.wanandroid.mvc.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.xiaohu409.wanandroid.R;
import com.github.xiaohu409.wanandroid.mvc.model.bean.IndexBean;

import java.util.List;

/**
 * 首页文章列表适配器
 */
public class IndexRecycleAdapter extends BaseRecycleAdapter<IndexBean.DataBean.DatasBean, IndexRecycleAdapter.Holder> {

    public IndexRecycleAdapter(Context context, List list) {
        super(context, list);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.index_recycle_item, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        IndexBean.DataBean.DatasBean dataBean = getItem(position);
        holder.titleView.setText(dataBean.getTitle());
        holder.shareView.setText(String.format("分享人:%s", TextUtils.isEmpty(dataBean.getShareUser()) ? dataBean.getAuthor() : dataBean.getShareUser()));
        holder.dateView.setText(String.format("时间:%s", dataBean.getNiceShareDate()));
    }

    public static class Holder extends RecyclerView.ViewHolder {

        private TextView titleView;
        private TextView shareView;
        private TextView dateView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.title_tv_id);
            shareView = itemView.findViewById(R.id.share_tv_id);
            dateView = itemView.findViewById(R.id.date_tv_id);
        }
    }
}
