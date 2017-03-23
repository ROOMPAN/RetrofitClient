package com.joaye.hixgo.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joaye.hixgo.utils.L;

/**
 * Created by xuyanjun on 15/10/22.
 */
public class BaseFragment extends Fragment {

    protected View mRootView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        L.printInVokeMethodName();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        L.printInVokeMethodName();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        L.printInVokeMethodName();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
        L.printInVokeMethodName();
    }

    @Override
    public void onResume() {
        super.onResume();
        L.printInVokeMethodName();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        L.printInVokeMethodName();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        L.printInVokeMethodName();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        L.printInVokeMethodName();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        L.printInVokeMethodName();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        L.printInVokeMethodName();
        L.d(isVisibleToUser + " !");
    }

    public String getClassTag() {
        return this.getClass().getSimpleName();
    }
}
