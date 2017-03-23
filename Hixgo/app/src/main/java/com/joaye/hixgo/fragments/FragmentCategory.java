package com.joaye.hixgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joaye.hixgo.R;
import com.joaye.hixgo.models.VirtualList;
import com.joaye.hixgo.network.HttpClient;
import com.joaye.hixgo.network.NetworkSubscriber;
import com.joaye.hixgo.views.adapters.CategoryAdapterEx;
import com.joaye.hixgo.views.adapters.FirstCategoryAdapter;
import com.joaye.hixgo.views.adapters.ItemClickSupport;

/**
 * Created by xuyanjun on 15/10/22.
 */
public class FragmentCategory extends BaseFragment {

    private RecyclerView mRecycler_firstCategory;
    private RecyclerView mRecycler_category;
    private LinearLayoutManager mLayoutManager;
    private CategoryAdapterEx mAdapter;
    private FirstCategoryAdapter mFirstCategoryAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_category, null);
        findViews();
        return mRootView;
    }

    void findViews() {
        mRecycler_firstCategory = (RecyclerView) mRootView.findViewById(R.id.category_recycler_first_category);
        mRecycler_category = (RecyclerView) mRootView.findViewById(R.id.category_recycler_view);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecycler_category.setLayoutManager(mLayoutManager);
        mRecycler_firstCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new CategoryAdapterEx(getActivity());
        mFirstCategoryAdapter = new FirstCategoryAdapter();

        mRecycler_firstCategory.setAdapter(mFirstCategoryAdapter);
        mRecycler_category.setAdapter(mAdapter);

        HttpClient.getInstance().getVirtualList(new NetworkSubscriber<VirtualList>() {
            @Override
            public void onNext(final VirtualList data) {
                super.onNext(data);
//                data = new Gson().fromJson("{\"code\":1,\"data\":[{\"id\":176,\"name\":\"膳食营养\",\"code\":\"101\",\"logo\":\"http://images.xuanzejia.com/images/hixgo/dfa44e0a-12e0-40a6-be43-44e8bf49cd481446174824032.jpg\",\"banner\":\"http://images.xuanzejia.com/images/hixgo/9a3c818d-c926-4557-b510-f4e4fa62a9131446174827071.jpg\",\"children\":[{\"id\":180,\"name\":\"海洋生物\",\"code\":\"101102\",\"logo\":\"http://images.xuanzejia.com/images/hixgo/ef6ecb20-8098-49d6-b11d-1be63ccc09581446174893160.jpg\",\"banner\":\"http://images.xuanzejia.com/images/hixgo/01c4b6b8-b7b1-44e4-8939-e8c5f45df3ee1446174898500.jpg\",\"children\":[{\"id\":182,\"name\":\"蛋白质\",\"code\":\"101102101\",\"logo\":\"http://images.xuanzejia.com/images/hixgo/0ede4e74-794e-4c09-9da7-f901e519ec261446174926868.jpg\",\"banner\":\"http://images.xuanzejia.com/images/hixgo/e3dbd5e8-d17b-4062-beca-46069b36a8c21446174938663.jpg\",\"children\":[]},{\"id\":182,\"name\":\"蛋白质1\",\"code\":\"101102101\",\"logo\":\"b\",\"banner\":\"啊\",\"children\":[]},{\"id\":182,\"name\":\"蛋白质2\",\"code\":\"101102101\",\"logo\":\"b\",\"banner\":\"啊\",\"children\":[]},{\"id\":182,\"name\":\"蛋白质3\",\"code\":\"101102101\",\"logo\":\"b\",\"banner\":\"啊\",\"children\":[]},{\"id\":182,\"name\":\"蛋白质4\",\"code\":\"101102101\",\"logo\":\"b\",\"banner\":\"啊\",\"children\":[]},{\"id\":182,\"name\":\"蛋白质5\",\"code\":\"101102101\",\"logo\":\"b\",\"banner\":\"啊\",\"children\":[]},{\"id\":182,\"name\":\"蛋白质6\",\"code\":\"101102101\",\"logo\":\"b\",\"banner\":\"啊\",\"children\":[]},{\"id\":182,\"name\":\"蛋白质7\",\"code\":\"101102101\",\"logo\":\"b\",\"banner\":\"啊\",\"children\":[]},{\"id\":182,\"name\":\"蛋白质8\",\"code\":\"101102101\",\"logo\":\"b\",\"banner\":\"啊\",\"children\":[]},{\"id\":182,\"name\":\"蛋白质9\",\"code\":\"101102101\",\"logo\":\"b\",\"banner\":\"啊\",\"children\":[]},{\"id\":182,\"name\":\"蛋白质10\",\"code\":\"101102101\",\"logo\":\"b\",\"banner\":\"啊\",\"children\":[]},{\"id\":182,\"name\":\"蛋白质11\",\"code\":\"101102101\",\"logo\":\"b\",\"banner\":\"啊\",\"children\":[]},{\"id\":182,\"name\":\"蛋白质12\",\"code\":\"101102101\",\"logo\":\"b\",\"banner\":\"啊\",\"children\":[]}]},{\"id\":178,\"name\":\"氨基酸\",\"code\":\"101101\",\"logo\":\"http://images.xuanzejia.com/images/hixgo/4ece6bc1-ef45-496e-8827-f18be26243811446174854849.jpg\",\"banner\":\"http://images.xuanzejia.com/images/hixgo/7971e234-ae33-4aa8-8975-7edf4fc47fa21446174858794.jpg\",\"children\":[]},{\"id\":184,\"name\":\"维生素c\",\"code\":\"101103\",\"logo\":\"http://images.xuanzejia.com/\",\"banner\":\"http://images.xuanzejia.com/\",\"children\":[]}]},{\"id\":166,\"name\":\"健康人群\",\"code\":\"100\",\"logo\":\"http://images.xuanzejia.com/images/hixgo/5f97d534-74ff-46f7-b188-74e3fc0789a51446775765121.jpg\",\"banner\":\"http://images.xuanzejia.com/images/hixgo/68c69c57-e86c-4d99-901e-4de2cc87b5f51446536162579.jpg\",\"children\":[{\"id\":168,\"name\":\"孕妈\",\"code\":\"100101\",\"logo\":\"http://images.xuanzejia.com/images/hixgo/f7f304fc-c5fb-436f-a731-335da81cd68b1446172927573.jpg\",\"banner\":\"http://images.xuanzejia.com/images/hixgo/76ad351f-fbf0-4d0f-93c3-13451e04e8131446174707388.jpg\",\"children\":[{\"id\":174,\"name\":\"中龄\",\"code\":\"100101102\",\"logo\":\"http://images.xuanzejia.com/images/hixgo/8c0f0d2e-997d-455d-9332-32664e272b4d1446173165039.jpg\",\"banner\":\"http://images.xuanzejia.com/images/hixgo/305e472b-17f8-44db-8925-68c7a085ff4e1446173169261.jpg\",\"children\":[]},{\"id\":172,\"name\":\"大龄\",\"code\":\"100101101\",\"logo\":\"http://images.xuanzejia.com/images/hixgo/b3037840-6905-48ec-a151-8101284a673f1446536364731.jpg,images/hixgo/5ceca4f4-1b30-46a7-87d3-17d7bf8ccded1446536371552.jpg\",\"banner\":\"http://images.xuanzejia.com/images/hixgo/e9e5ebb7-7023-42fe-89aa-f1da75878f011446173106018.jpg\",\"children\":[{\"id\":192,\"name\":\"小龄\",\"code\":\"100101101101\",\"logo\":\"http://images.xuanzejia.com/images/hixgo/e6004d74-bab4-4e38-8762-6e04560c37761446605153365.jpg\",\"banner\":\"http://images.xuanzejia.com/\",\"children\":[{\"id\":194,\"name\":\"年龄\",\"code\":\"100101101101101\",\"logo\":\"http://images.xuanzejia.com/images/hixgo/5c71d78b-b425-485e-8fc2-78e010c344781446605192138.jpg\",\"banner\":\"http://images.xuanzejia.com/images/hixgo/dd30d858-9e41-44e7-a92e-b1d042bfba161446605230851.jpg\",\"children\":[]}]}]}]},{\"id\":170,\"name\":\"三高人群\",\"code\":\"100102\",\"logo\":\"http://images.xuanzejia.com/images/hixgo/693cbb7c-7767-4cb3-b0fa-003653c1ee9d1446173018007.jpg\",\"banner\":\"http://images.xuanzejia.com/images/hixgo/fb4a8a62-4fbe-4dc2-b03d-de2cadcc1e351446173022608.jpg\",\"children\":[{\"id\":186,\"name\":\"奶粉类\",\"code\":\"100102101\",\"logo\":\"http://images.xuanzejia.com/\",\"banner\":\"http://images.xuanzejia.com/\",\"children\":[]}]}]},{\"id\":188,\"name\":\"撒旦法撒旦法\",\"code\":\"102\",\"logo\":\"http://images.xuanzejia.com/images/hixgo/18a8a31d-e3e6-4268-ae69-fce65ccb23661446535152448.jpg\",\"banner\":\"http://images.xuanzejia.com/\",\"children\":[{\"id\":190,\"name\":\"sadf \",\"code\":\"102101\",\"logo\":\"http://images.xuanzejia.com/\",\"banner\":\"http://images.xuanzejia.com/\",\"children\":[]}]}],\"msg\":\"\",\"field\":null}", VirtualList.class);
                if (data != null && data.isOKCode()) {
                    mFirstCategoryAdapter.setVirtualList(data);
                    mFirstCategoryAdapter.notifyDataSetChanged();
                    if (data.data != null && data.data.size() > 1) {
                        mAdapter.setCategory(data.data.get(0).children);
                        mAdapter.notifyDataSetChanged();
                        ItemClickSupport.addTo(mRecycler_firstCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                            @Override
                            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
//                                System.out.println(position);
                                mAdapter.setCategory(data.data.get(position).children);
                                mAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                }
            }
        });

    }

}
