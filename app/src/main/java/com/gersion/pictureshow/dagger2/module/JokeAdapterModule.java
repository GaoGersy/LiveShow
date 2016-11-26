package com.gersion.pictureshow.dagger2.module;

import android.content.Context;

import com.gersion.pictureshow.model.bean.DataBean;
import com.gersion.pictureshow.model.bean.JokeBean;
import com.gersion.pictureshow.ui.adapter.JokeAdapter;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.dagger2.module
 * @待完成
 * @创建时间 2016/11/22
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
@Module
public class JokeAdapterModule {
    private List<DataBean> mList;

    public JokeAdapterModule(List<DataBean> list){

        mList = list;
    }
    @Provides
    public JokeAdapter providerJokeAdapter(){
        return new JokeAdapter(mList);
    }
}
