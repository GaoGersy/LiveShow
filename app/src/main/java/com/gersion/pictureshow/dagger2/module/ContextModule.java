package com.gersion.pictureshow.dagger2.module;

import android.content.Context;

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
public class ContextModule {
    private Context mContext;

    public ContextModule(Context context){

        mContext = context;
    }
    @Provides
    public Context providerContext(){
        return mContext;
    }
}
