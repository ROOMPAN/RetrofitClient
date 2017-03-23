package com.joaye.hixgo.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.joaye.hixgo.R;
import com.joaye.hixgo.models.VirtualList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by xuyanjun on 15/11/1.
 */
public class CategoryAdapterEx extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    private static final int ITEM_TYPE_SEC_CATEGORY = 1;   //二级分类
    private static final int ITEM_TYPE_THIRD_CATEGORY = 2; //三级分类

    private static final int LINE_ITEMS_COUNT = 3;         //每一行的数量

    private ArrayList<VirtualList.VirtualListData.Child> mCategory;

    private ArrayList<VirtualList.VirtualListData.Child> mDisplayCategory = new ArrayList<>();

    public CategoryAdapterEx(Context context) {
        this.mContext = context;
    }

    public void setCategory(ArrayList<VirtualList.VirtualListData.Child> mCategory) {
        this.mCategory = mCategory;
        countLine();
    }

    public CategoryAdapterEx(ArrayList<VirtualList.VirtualListData.Child> category) {
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

        mDisplayCategory.clear();

        for (int i = 0; i < mCategory.size(); i++) {
            //mDisplayCategory.add(mCategory.get(i));
            VirtualList.VirtualListData.Child category = mCategory.get(i);
            VirtualList.VirtualListData.Child secCate = new VirtualList().new VirtualListData().new Child();
            secCate.banner = category.banner;
            secCate.code = category.code;
            secCate.id = category.id;
            secCate.logo = category.logo;
            secCate.name = category.name;
            mDisplayCategory.add(secCate);

            int categorySize = category.children.size();
            int categoryLineCount = categorySize % LINE_ITEMS_COUNT == 0 ? categorySize / LINE_ITEMS_COUNT : categorySize / LINE_ITEMS_COUNT + 1;

            if (categorySize % LINE_ITEMS_COUNT == 0) {
                VirtualList.VirtualListData.Child tempCate = new VirtualList().new VirtualListData().new Child();
                for (int j = 0; j < categoryLineCount; j++) {
                    tempCate.children.addAll(new ArrayList<>(mCategory.get(i).children.subList(j * 3, LINE_ITEMS_COUNT + j * 3)));
                    mDisplayCategory.add(tempCate);
                }
            } else {
                for (int j = 0; j < categoryLineCount; j++) {
                    VirtualList.VirtualListData.Child tempCate = new VirtualList().new VirtualListData().new Child();
                    if (j == categoryLineCount - 1) {
                        tempCate.children.addAll(new ArrayList<>(mCategory.get(i).children.subList(j * 3, j * 3 + categorySize % LINE_ITEMS_COUNT)));
                    } else {
                        tempCate.children.addAll(new ArrayList<>(mCategory.get(i).children.subList(j * 3, LINE_ITEMS_COUNT + j * 3)));
                    }
                    mDisplayCategory.add(tempCate);
                }
            }
        }

    }

    @Override
    public int getItemViewType(int position) {

        if (!TextUtils.isEmpty(mDisplayCategory.get(position).name)) {
            return ITEM_TYPE_SEC_CATEGORY;
        } else {
            return ITEM_TYPE_THIRD_CATEGORY;
        }
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

        if (holder instanceof SecondCategoryViewHolder) {
            ((SecondCategoryViewHolder) holder).mTextView.setText(mDisplayCategory.get(position).name);
        } else if (holder instanceof ThirdCategoryViewHolder) {
            ((ThirdCategoryViewHolder) holder).mLayout_item1.setVisibility(View.VISIBLE);
            ((ThirdCategoryViewHolder) holder).mLayout_item2.setVisibility(View.INVISIBLE);
            ((ThirdCategoryViewHolder) holder).mLayout_item3.setVisibility(View.INVISIBLE);
            for (int i = 0; i < mDisplayCategory.get(position).children.size(); i ++) {
                if (i == 0) {
                    ((ThirdCategoryViewHolder) holder).mLayout_item1.setVisibility(View.VISIBLE);
                    Picasso.with(mContext).load("http://images.xuanzejia.com/images/hixgo/9a3c818d-c926-4557-b510-f4e4fa62a9131446174827071.jpg").into(((ThirdCategoryViewHolder) holder).mImage_1);
                    ((ThirdCategoryViewHolder) holder).mTextView1.setText(mDisplayCategory.get(position).children.get(i).name);
                } else if (i == 1) {
                    ((ThirdCategoryViewHolder) holder).mLayout_item2.setVisibility(View.VISIBLE);
                    Picasso.with(mContext).load("http://images.xuanzejia.com/images/hixgo/9a3c818d-c926-4557-b510-f4e4fa62a9131446174827071.jpg").into(((ThirdCategoryViewHolder) holder).mImage_2);
                    ((ThirdCategoryViewHolder) holder).mTextView2.setText(mDisplayCategory.get(position).children.get(i).name);
                } else if (i == 2) {
                    ((ThirdCategoryViewHolder) holder).mLayout_item3.setVisibility(View.VISIBLE);
                    Picasso.with(mContext).load("http://images.xuanzejia.com/images/hixgo/9a3c818d-c926-4557-b510-f4e4fa62a9131446174827071.jpg").into(((ThirdCategoryViewHolder) holder).mImage_3);
                    ((ThirdCategoryViewHolder) holder).mTextView3.setText(mDisplayCategory.get(position).children.get(i).name);
                }
            }
        }
    }


    @Override
    public int getItemCount() {
        if (mDisplayCategory == null) {
            return 0;
        } else {
            return mDisplayCategory.size();
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

        public RelativeLayout mLayout_item1;
        public RelativeLayout mLayout_item2;
        public RelativeLayout mLayout_item3;

        public ImageView mImage_1;
        public ImageView mImage_2;
        public ImageView mImage_3;

        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;

        public ThirdCategoryViewHolder(View itemView) {
            super(itemView);
            mLayout_item1 = (RelativeLayout) itemView.findViewById(R.id.item_recycler_third_category_layout1);
            mLayout_item2 = (RelativeLayout) itemView.findViewById(R.id.item_recycler_third_category_layout2);
            mLayout_item3 = (RelativeLayout) itemView.findViewById(R.id.item_recycler_third_category_layout3);

            mImage_1 = (ImageView) itemView.findViewById(R.id.iv1);
            mImage_2 = (ImageView) itemView.findViewById(R.id.iv2);
            mImage_3 = (ImageView) itemView.findViewById(R.id.iv3);

            mTextView1 = (TextView) itemView.findViewById(R.id.tv1);
            mTextView2 = (TextView) itemView.findViewById(R.id.tv2);
            mTextView3 = (TextView) itemView.findViewById(R.id.tv3);
        }
    }

}
