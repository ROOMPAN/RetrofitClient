package com.joaye.hixgo.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joaye.hixgo.R;
import com.joaye.hixgo.models.VirtualList;

import java.util.ArrayList;

/**
 * Created by xuyanjun on 15/11/1.
 */
public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_TYPE_SEC_CATEGORY = 1;   //二级分类
    private static final int ITEM_TYPE_THIRD_CATEGORY = 2; //三级分类

    private static final int LINE_ITEMS_COUNT = 3;         //每一行的数量

    private int mLineCount;


    private ArrayList<VirtualList.VirtualListData.Child> mCategory;

    public CategoryAdapter() {

    }

    public void setCategory(ArrayList<VirtualList.VirtualListData.Child> mCategory) {
        this.mCategory = mCategory;
        countLine();
    }

    public CategoryAdapter(ArrayList<VirtualList.VirtualListData.Child> category) {
        this.mCategory = category;
        countLine();
    }

    public VirtualList.VirtualListData.Child getItem(int position) {
        if (mCategory == null) {
            return null;
        }
        int i = 0;
        for (VirtualList.VirtualListData.Child child : mCategory) {
            i++;
            if (position == i) {
                return child;
            } else {
                for (VirtualList.VirtualListData.Child sChild : mCategory.get(i).children) {
                    i++;
                    if (position == i) {
                        return sChild;
                    }
                }
            }
        }
        return null;
    }

    private void countLine() {
        if (mCategory == null) {
            return;
        }

        for (int i = 0; i < mCategory.size(); i++) {
            mLineCount++;
            int size = mCategory.get(i).children.size();
            mLineCount += size % LINE_ITEMS_COUNT == 0 ? size / LINE_ITEMS_COUNT : size / LINE_ITEMS_COUNT + 1;
        }
    }

    @Override
    public int getItemViewType(int position) {

        int currentLine = 0;
        for (int i = 0; i < mCategory.size(); i++) {
            if (position == currentLine) {
                return ITEM_TYPE_SEC_CATEGORY;
            } else {
                currentLine++;
                int thirdCategorySize = mCategory.get(i).children.size();
                currentLine += thirdCategorySize % LINE_ITEMS_COUNT == 0 ? thirdCategorySize / LINE_ITEMS_COUNT : thirdCategorySize / LINE_ITEMS_COUNT + 1;
                if (position < currentLine) {
                    return ITEM_TYPE_THIRD_CATEGORY;
                }
            }
        }

        return ITEM_TYPE_SEC_CATEGORY;

//        VirtualList.VirtualListData.Child child = getItem(position);
//        if (child != null) {
//            if (child.children == null || child.children.size() <= 0) {
//                return ITEM_TYPE_THIRD_CATEGORY;
//            } else {
//                return ITEM_TYPE_SEC_CATEGORY;
//            }
//        } else {
//            return ITEM_TYPE_SEC_CATEGORY;
//        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_SEC_CATEGORY) {
            return new SecondCategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
        } else {
            return new ThirdCategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_third_category, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int realPosition = getRealPosition(position); // 二级分类在List中的位置

        if (holder instanceof SecondCategoryViewHolder) {
            ((SecondCategoryViewHolder) holder).mTextView.setText(mCategory.get(realPosition).name);
        } else if (holder instanceof ThirdCategoryViewHolder) {
            //ArrayList<VirtualList.VirtualListData.Child> currentLine = mCategory.get(realPosition).children;
            ((ThirdCategoryViewHolder) holder).mTextView1.setText("haha1");
            ((ThirdCategoryViewHolder) holder).mTextView2.setText("haha2");
            ((ThirdCategoryViewHolder) holder).mTextView3.setText("haha3");
        }
    }

    private int getRealPosition(int position) {

        int lineCount = 0;
        for (int i = 0; i < mCategory.size(); i++) {
            lineCount++;
            if (lineCount > position) {
                return i;
            }
            int size = mCategory.get(i).children.size();
            for (int j = 0; j < (size % LINE_ITEMS_COUNT == 0 ? size / LINE_ITEMS_COUNT : size / LINE_ITEMS_COUNT + 1); j++) {
                lineCount++;
                if (lineCount > position) {
                    return i;
                } else {
//                    lineCount--;
                }
            }
        }

        return position;
    }


    @Override
    public int getItemCount() {
        if (mCategory == null) {
            return 0;
        } else {
            return mLineCount;
        }
    }

    public static class SecondCategoryViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public SecondCategoryViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text);
        }
    }

    public static class ThirdCategoryViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;

        public ThirdCategoryViewHolder(View itemView) {
            super(itemView);
            mTextView1 = (TextView) itemView.findViewById(R.id.tv1);
            mTextView2 = (TextView) itemView.findViewById(R.id.tv2);
            mTextView3 = (TextView) itemView.findViewById(R.id.tv3);
        }
    }

}
