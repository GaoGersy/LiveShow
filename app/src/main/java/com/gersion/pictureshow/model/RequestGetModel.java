package com.gersion.pictureshow.model;

import com.google.gson.Gson;

import com.gersion.pictureshow.model.bean.JokeBean;
import com.gersion.pictureshow.protocol.BaseGetProtocol;
import com.orhanobut.logger.Logger;

import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.model
 * @待完成
 * @创建时间 2016/11/22
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class RequestGetModel implements IRequestGetModel {
    private Gson gson = new Gson();

    @Override
    public void getDataFromNet(final String url, final HashMap<String,String> paramaters, final OnGetDataListener listener){
        final BaseGetProtocol baseGetProtocol = BaseGetProtocol.getInstance();
        Subscription subscribe = Observable.just("1")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return baseGetProtocol.requestGetBySyn(url,paramaters);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d(e);
                        listener.onFailed();
                    }

                    @Override
                    public void onNext(String s) {
                        listener.onSucess(s);
                    }
                });
    }

    public JokeBean handleData(String result) {
        return gson.fromJson(result, JokeBean.class);
    }
}
