package com.gersion.pictureshow.dagger2.component;

import android.content.Context;

import com.gersion.pictureshow.dagger2.module.ContextModule;
import com.gersion.pictureshow.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.dagger2.component
 * @待完成
 * @创建时间 2016/11/22
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
@Component(modules = ContextModule.class)
public interface ContextComponent {
    Context providerContext();
}
