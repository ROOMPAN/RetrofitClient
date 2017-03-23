package com.joaye.hixgo.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joaye.hixgo.R;
import com.joaye.hixgo.models.VirtualList;

/**
 * Created by xuyanjun on 15/11/1.
 */
public class FirstCategoryAdapter extends RecyclerView.Adapter<FirstCategoryAdapter.ViewHolder> {

    private VirtualList mVirtualList;

    public void setVirtualList(VirtualList mVirtualList) {
        this.mVirtualList = mVirtualList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_first_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        VirtualList.VirtualListData data = mVirtualList.data.get(position);
        holder.mTv_category.setText(data.name);
    }

    @Override
    public int getItemCount() {
        return mVirtualList == null ? 0 : mVirtualList.data.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTv_category;

        public ViewHolder(View itemView) {
            super(itemView);
            mTv_category = (TextView) itemView.findViewById(R.id.item_recycler_text_first_category);
        }
    }

}
