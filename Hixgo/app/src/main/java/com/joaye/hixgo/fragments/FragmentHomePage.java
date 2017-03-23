package com.joaye.hixgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.joaye.hixgo.R;
import com.joaye.hixgo.models.AliBean;
import com.joaye.hixgo.network.HttpClient;
import com.joaye.hixgo.network.NetworkSubscriber;

import static android.content.ContentValues.TAG;

/**
 * Created by xuyanjun on 15/10/22.
 */
public class FragmentHomePage extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_homepage, null);
        Button bt_okhttp = (Button) v.findViewById(R.id.bt_okhttp);
        TextView tv = (TextView) v.findViewById(R.id.tv_text);
        EditText editText= (EditText) v.findViewById(R.id.et_text);

        bt_okhttp.setOnClickListener(new View.OnClickListener() {
            // scope=103&format=json&appid=379020&bk_key=%E5%85%B3%E9%94%AE%E5%AD%97&bk_length=600

            @Override
            public void onClick(View v) {
                String et=editText.getText().toString();
                HttpClient.getInstance().getList(new NetworkSubscriber<AliBean>() {
                    @Override
                    public void onNext(AliBean data) {
                        super.onNext(data);
                        Toast.makeText(getActivity(), data.get_$1().getTitle(), Toast.LENGTH_SHORT).show();
                        Log.e(TAG, data.get_$1().getTitle());
                    }
                });
            }
        });
        return v;
    }
}
