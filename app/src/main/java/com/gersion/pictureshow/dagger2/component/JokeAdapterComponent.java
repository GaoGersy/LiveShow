package com.gersion.pictureshow.dagger2.component;

import com.gersion.pictureshow.dagger2.module.JokeAdapterModule;
import com.gersion.pictureshow.ui.fragment.joke.TextFragment;

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
@Component(dependencies = ContextComponent.class,modules = JokeAdapterModule.class)
public interface JokeAdapterComponent {
    void inject(TextFragment fragment);
}
