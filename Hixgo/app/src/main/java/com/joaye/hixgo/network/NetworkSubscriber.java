package com.joaye.hixgo.network;

import com.joaye.hixgo.models.BaseEntity;
import com.joaye.hixgo.utils.L;

import rx.Subscriber;

/**
 * Created by xuyanjun on 15/10/31.
 */
public class NetworkSubscriber<T extends BaseEntity>  extends Subscriber<T> {

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        L.d(e.toString());
    }

    @Override
    public void onNext(T data) {
    }
}
