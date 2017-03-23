package com.joaye.hixgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joaye.hixgo.R;

/**
 * Created by xuyanjun on 15/10/22.
 */
public class FragmentUserInfo extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_userinfo, null);
        return v;
    }

}
